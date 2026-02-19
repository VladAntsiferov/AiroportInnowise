package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.service.GateService;
import by.vantsyferov.airport.service.MaintainAirplaneService;
import by.vantsyferov.airport.service.impl.DockServiceImpl;
import by.vantsyferov.airport.service.impl.GateServiceImpl;
import by.vantsyferov.airport.service.impl.MaintainAirplaneServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class AirplaneMaintainingState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  private static final GateService gateService = new GateServiceImpl();
  private static final MaintainAirplaneService maintainService = new MaintainAirplaneServiceImpl();
  private static final DockServiceImpl dockService = new DockServiceImpl();
  @Override
  public void handle(Airplane airplane) {
    try {
      logger.info("Maintaining airplane {}...", airplane.getName());
      TimeUnit.SECONDS.sleep(15);
      maintainService.maintainAirplane(airplane);
      logger.info("Airplane {} is maintained, requesting dock to board passengers...", airplane.getName());
      Gate gate = gateService.requestFreeGate();
      dockService.dockAirplane(airplane, gate);
      logger.info("Airplane {} docked to gate No. {}", airplane.getName(), airplane.getCurrentGate().getGateNumber());
      airplane.setAirplaneState(new AirplaneDockedState());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

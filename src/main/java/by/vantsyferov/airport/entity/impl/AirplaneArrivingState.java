package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.service.DockService;
import by.vantsyferov.airport.service.GateService;
import by.vantsyferov.airport.service.impl.DockServiceImpl;
import by.vantsyferov.airport.service.impl.GateServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AirplaneArrivingState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  private static final GateService gateService = new GateServiceImpl();
  private static final DockService dockService = new DockServiceImpl();

  @Override
  public void handle(Airplane airplane) {
    logger.info("Airplane {} arrived. Requesting dock...", airplane.getName());
    Gate gate = gateService.requestFreeGate();
    dockService.dockAirplane(airplane, gate);
    logger.info("Airplane {} docked to gate No. {}", airplane.getName(), airplane.getCurrentGate().getGateNumber());
    airplane.setAirplaneState(new AirplaneDockedState());
  }
}

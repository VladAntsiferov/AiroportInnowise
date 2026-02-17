package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.service.GateServiceInt;
import by.vantsyferov.airport.service.impl.GateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class AirplaneMaintainingState implements AirplaneState {
  private final static GateServiceInt service = new GateService();
  static Logger logger = LogManager.getLogger();
  @Override
  public void handle(Airplane airplane) {
    try {
      logger.info("Maintaining airplane {}...", airplane.getName());
      TimeUnit.SECONDS.sleep(15);
      service.maintainAirplane(airplane);
      logger.info("Airplane {} is maintained, requesting dock to board passengers...", airplane.getName());
      airplane.setAirplaneState(new AirplaneDockedState());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

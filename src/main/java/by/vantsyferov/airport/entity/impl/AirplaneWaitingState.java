package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AirplaneWaitingState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  @Override
  public void handle(Airplane airplane){
      logger.info("Airplane {} waiting for free gate", airplane.getName());

  }
}

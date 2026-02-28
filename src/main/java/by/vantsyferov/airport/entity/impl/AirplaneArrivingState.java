package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.entity.Gate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AirplaneArrivingState implements AirplaneState {
  static Logger logger = LogManager.getLogger();

  @Override
  public void handle(Airplane airplane, Gate gate) {
    logger.info("Airplane {} arrived. Requesting dock...", airplane.getName());
    logger.info("Airplane {} docked to gate No. {}", airplane.getName(), gate.getGateNumber());
    airplane.setAirplaneState(new AirplaneDockedState());
  }
}

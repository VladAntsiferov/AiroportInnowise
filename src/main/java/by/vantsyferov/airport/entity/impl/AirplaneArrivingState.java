package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.service.GateServiceInterface;
import by.vantsyferov.airport.service.impl.GateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AirplaneArrivingState implements AirplaneState {
  private final static GateServiceInterface service = new GateService();
  static Logger logger = LogManager.getLogger();

  @Override
  public void handle(Airplane airplane) {
    logger.info("Airplane {} arrived. Requesting dock...", airplane.getName());
    Gate gate = service.requestFreeGate();
    airplane.setCurrentGate(gate);
    logger.info("Airplane {} docked to gate No. {}", airplane.getName(), airplane.getCurrentGate().getGateNumber());
    airplane.setAirplaneState(new AirplaneDockedState());
  }
}

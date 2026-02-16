package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AirplaneArrivingState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  GateRepository gateRepository = GateRepository.getInstance();

  @Override
  public void handle(Airplane airplane) {
    logger.info("Airplane {} arrived", airplane.getName());
    for (Gate gate : gateRepository.getGateList()){
      logger.info("Airplane {} requesting dock", airplane.getName());
      if(gate.getAirplane() == null){
        logger.info("Airplane {} docked to gate {}", airplane.getName(), gate.getGateNumber());
        gate.dockAirplane(airplane);
        airplane.setAirplaneState(new AirplaneDocketState());
        return;
      }
    }
    logger.info("There are no free gate for airplane {}, ", airplane.getName());
    airplane.setAirplaneState(new AirplaneWaitingState());
  }
}

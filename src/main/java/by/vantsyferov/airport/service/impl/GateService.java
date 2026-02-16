package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.entity.Passenger;
import by.vantsyferov.airport.entity.impl.AirplaneDocketState;
import by.vantsyferov.airport.repository.GateRepository;
import by.vantsyferov.airport.service.GateServiceInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GateService implements GateServiceInt {
  GateRepository gateRepository = GateRepository.getInstance();
  static Logger logger = LogManager.getLogger();

  @Override
  public void checkPassengerDocuments(Passenger passenger) {
    if(passenger.getTicket() == null){
      logger.info("Passenger {} without ticket!", passenger.getName());
      passenger.interrupt();
    }
  }

  @Override
  public boolean tryDockAirplane(Airplane airplane){
    for(Gate gate : gateRepository.getGateList()){
      if(gate.getAirplane() == null){
        gate.dockAirplane(airplane);
        airplane.setAirplaneState(new AirplaneDocketState());
        return true;
      }
    }
    return false;
  }

  public void unboardAirplanePassenger(Airplane airplane, Gate gate){
    if(gate.getAirplane() == null){
      gate.dockAirplane(airplane);
    }
  }
}

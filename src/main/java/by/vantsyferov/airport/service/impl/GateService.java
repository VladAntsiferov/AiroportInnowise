package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.entity.Passenger;
import by.vantsyferov.airport.service.GateServiceInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GateService implements GateServiceInt {
  static Logger logger = LogManager.getLogger();
  @Override
  public void checkPassengerDocuments(Passenger passenger) {
    if(passenger.getTicket() == null){
      logger.info("Passenger {} without ticket!", passenger.getName());
      passenger.interrupt();
    }
  }

  @Override
  public void dockAirplane(Airplane airplane, Gate gate){
    if(gate.getAirplane() == null){
      gate.dockAirplane(airplane);
    }
  }
}

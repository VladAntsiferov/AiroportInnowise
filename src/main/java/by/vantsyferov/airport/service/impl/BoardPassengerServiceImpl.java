package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.service.BoardPassengerService;

public class BoardPassengerServiceImpl implements BoardPassengerService {
  @Override
  public void boardPassengers(Airplane airplane, Gate gate) {
    while ((airplane.getPassengerAmount() < airplane.getCapacity()) && (gate.getPassengerAmount() > 0)) {
      airplane.setPassengerAmount(airplane.getPassengerAmount() + 1);
      gate.setPassengerAmount(gate.getPassengerAmount() - 1);
    }
  }

  @Override
  public void unboardPassengers(Airplane airplane) {
    airplane.setPassengerAmount(0);
  }
}

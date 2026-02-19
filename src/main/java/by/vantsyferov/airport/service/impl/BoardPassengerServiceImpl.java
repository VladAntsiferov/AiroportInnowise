package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.service.BoardPassengerService;

public class BoardPassengerServiceImpl implements BoardPassengerService {
  @Override
  public void boardPassengers(Airplane airplane) {
    Gate boardingGate = airplane.getCurrentGate();
    while ((airplane.getPassengerAmount() < airplane.getCapacity()) && (boardingGate.getPassengerAmount() > 0)) {
      airplane.setPassengerAmount(airplane.getPassengerAmount() + 1);
      boardingGate.setPassengerAmount(boardingGate.getPassengerAmount() - 1);
    }
  }

  @Override
  public void unboardPassengers(Airplane airplane) {
    airplane.setPassengerAmount(0);
  }
}

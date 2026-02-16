package by.vantsyferov.airport.service;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Passenger;

public interface GateServiceInt {
  void checkPassengerDocuments(Passenger passenger);
  boolean tryDockAirplane(Airplane airplane);
}

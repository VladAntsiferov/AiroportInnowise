package by.vantsyferov.airport.service;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;

public interface BoardPassengerService {
  void boardPassengers(Airplane airplane, Gate gate);

  void unboardPassengers(Airplane airplane);
}

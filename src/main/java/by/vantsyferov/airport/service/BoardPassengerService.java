package by.vantsyferov.airport.service;

import by.vantsyferov.airport.entity.Airplane;

public interface BoardPassengerService {
  void boardPassengers(Airplane airplane);

  void unboardPassengers(Airplane airplane);
}

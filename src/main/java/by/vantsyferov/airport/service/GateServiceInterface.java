package by.vantsyferov.airport.service;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;

public interface GateServiceInterface {

  Gate requestFreeGate();

  void maintainAirplane(Airplane airplane);

  void undockAirplane(Airplane airplane);

  void boardPassengers(Airplane airplane);

  void unboardPassengers(Airplane airplane);
}

package by.vantsyferov.airport.service;

import by.vantsyferov.airport.entity.Gate;

public interface GateServiceInt {

  Gate requestFreeGate();
  void maintainAirplane();
  void undockAirplane(Gate occupiedGate);
}

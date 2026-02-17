package by.vantsyferov.airport.entity;

import by.vantsyferov.airport.service.GateServiceInt;
import by.vantsyferov.airport.service.impl.GateService;

public interface AirplaneState {
  void handle(Airplane airplane);
}

package by.vantsyferov.airport.service;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;

public interface DockService {
  void dockAirplane(Airplane airplane, Gate gate);

  void undockAirplane(Airplane airplane);
}

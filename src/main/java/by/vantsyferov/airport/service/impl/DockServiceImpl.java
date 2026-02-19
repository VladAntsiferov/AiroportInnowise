package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;
import by.vantsyferov.airport.service.DockService;

public class DockServiceImpl implements DockService {
  private static GateRepository gateRepository = GateRepository.getInstance();

  @Override
  public void dockAirplane(Airplane airplane, Gate gate) {
    airplane.setCurrentGate(gate);
  }

  @Override
  public void undockAirplane(Airplane airplane) {
    gateRepository.add(airplane.getCurrentGate());
    airplane.setCurrentGate(null);
  }
}

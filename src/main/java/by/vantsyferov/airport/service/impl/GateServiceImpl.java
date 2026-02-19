package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;
import by.vantsyferov.airport.service.GateService;

public class GateServiceImpl implements GateService {
  private static GateRepository gateRepository = GateRepository.getInstance();

  @Override
  public Gate requestFreeGate() {
    Gate freeGate = gateRepository.getFreeGate();
    while (freeGate == null) {
      freeGate = gateRepository.getFreeGate();
    }
    return freeGate;
  }

}

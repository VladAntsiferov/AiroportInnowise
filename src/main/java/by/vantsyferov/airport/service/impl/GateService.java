package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;
import by.vantsyferov.airport.service.GateServiceInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GateService implements GateServiceInt {
  private static GateRepository gateRepository = GateRepository.getInstance();
  static Logger logger = LogManager.getLogger();

  @Override
  public Gate requestFreeGate() {
    Gate freeGate = gateRepository.getFreeGate();
    while (freeGate == null) {
      freeGate = gateRepository.getFreeGate();
    }
    return freeGate;
  }

  @Override
  public void maintainAirplane() {

  }

  @Override
  public void undockAirplane(Gate occupiedGate) {
    gateRepository.add(occupiedGate);
  }
}

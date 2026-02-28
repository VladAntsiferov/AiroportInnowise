package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class AirplaneDepartedState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  private static final GateRepository gateRepository = GateRepository.getInstance();

  @Override
  public void handle(Airplane airplane, Gate gate) {
    try {
      TimeUnit.SECONDS.sleep(5);
      logger.info("Airplane {} departed!", airplane.getName());
      gateRepository.add(gate);
      airplane.interrupt();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

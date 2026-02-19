package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.service.DockService;
import by.vantsyferov.airport.service.impl.DockServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class AirplaneDepartedState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  private static final DockService service = new DockServiceImpl();

  @Override
  public void handle(Airplane airplane) {
    try {
      TimeUnit.SECONDS.sleep(5);
      service.undockAirplane(airplane);
      logger.info("Airplane {} departed!", airplane.getName());
      airplane.interrupt();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.service.GateServiceInt;
import by.vantsyferov.airport.service.impl.GateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class AirplaneDockedState implements AirplaneState {
  private final static GateServiceInt service = new GateService();
  static Logger logger = LogManager.getLogger();

  @Override
  public void handle(Airplane airplane) {
    try {

      if (airplane.getPassengerAmount() != 0) {
        logger.info("Unboarding passengers from airplane {}...", airplane.getName());
        TimeUnit.SECONDS.sleep(3);
        service.unboardPassengers(airplane);
        return;
      }
      if (!airplane.getMaintainStatus()) {
        logger.info("Airplane {} undocked to maintain", airplane.getName());
        service.undockAirplane(airplane);
        airplane.setAirplaneState(new AirplaneMaintainingState());
        return;
      }
      logger.info("Boarding passengers to airplane {}...", airplane.getName());
      service.boardPassengers(airplane);
      logger.info("Airplane {} full. Ready to depart.", airplane.getName());
      TimeUnit.SECONDS.sleep(3);
      airplane.setAirplaneState(new AirplaneDepartedState());

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}


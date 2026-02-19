package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.service.BoardPassengerService;
import by.vantsyferov.airport.service.impl.BoardPassengerServiceImpl;
import by.vantsyferov.airport.service.impl.DockServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class AirplaneDockedState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  private static final BoardPassengerService boardPassengers = new BoardPassengerServiceImpl();
  private static final DockServiceImpl dockService = new DockServiceImpl();


  @Override
  public void handle(Airplane airplane) {
    try {

      if (airplane.getPassengerAmount() != 0) {
        logger.info("Unboarding passengers from airplane {}...", airplane.getName());
        TimeUnit.SECONDS.sleep(3);
        boardPassengers.unboardPassengers(airplane);
        return;
      }
      if (!airplane.getMaintainStatus()) {
        logger.info("Airplane {} undocked to maintain", airplane.getName());
        dockService.undockAirplane(airplane);
        airplane.setAirplaneState(new AirplaneMaintainingState());
        return;
      }
      logger.info("Boarding passengers to airplane {}...", airplane.getName());
      boardPassengers.boardPassengers(airplane);
      logger.info("Airplane {} full. Ready to depart.", airplane.getName());
      TimeUnit.SECONDS.sleep(3);
      airplane.setAirplaneState(new AirplaneDepartedState());

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}


package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;
import by.vantsyferov.airport.service.BoardPassengerService;
import by.vantsyferov.airport.service.GateService;
import by.vantsyferov.airport.service.impl.BoardPassengerServiceImpl;
import by.vantsyferov.airport.service.impl.GateServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class AirplaneDockedState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  private static final BoardPassengerService boardPassengers = new BoardPassengerServiceImpl();
  private static final GateRepository gateRepository = GateRepository.getInstance();


  @Override
  public void handle(Airplane airplane, Gate gate) {
    try {
        logger.info("Unboarding passengers from airplane {}...", airplane.getName());
        TimeUnit.SECONDS.sleep(3);
        boardPassengers.unboardPassengers(airplane);
      if (!airplane.getMaintainStatus()) {
        logger.info("Airplane {} undocked from gate No. {} to maintain", airplane.getName(), gate.getGateNumber());
        airplane.setAirplaneState(new AirplaneMaintainingState());
        gateRepository.add(gate);
        return;
      }
      logger.info("Boarding passengers to airplane {}...", airplane.getName());
      boardPassengers.boardPassengers(airplane, gate);
      logger.info("Airplane {} full. Ready to depart.", airplane.getName());
      TimeUnit.SECONDS.sleep(3);
      airplane.setAirplaneState(new AirplaneDepartedState());

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}


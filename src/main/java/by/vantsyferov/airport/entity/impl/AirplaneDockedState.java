package by.vantsyferov.airport.entity.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.AirplaneState;
import by.vantsyferov.airport.service.GateServiceInt;
import by.vantsyferov.airport.service.impl.GateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.ScriptAppenderSelector;

import java.util.concurrent.TimeUnit;

public class AirplaneDockedState implements AirplaneState {
  static Logger logger = LogManager.getLogger();
  private final static GateServiceInt service = new GateService();

  @Override
  public void handle(Airplane airplane) {
    try {

      if(airplane.getPassengerAmount() == 0 && airplane.getMaintainStatus()){
        TimeUnit.SECONDS.sleep(3);
        logger.info("Boarding passengers to airplane {}... Boarded: {}", airplane.getName(), airplane.getPassengerAmount());
        service.boardPassengers(airplane);
      }
      if(airplane.getPassengerAmount() != 0 && !airplane.getMaintainStatus()){
        logger.info("");
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}


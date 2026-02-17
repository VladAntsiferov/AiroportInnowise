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
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}


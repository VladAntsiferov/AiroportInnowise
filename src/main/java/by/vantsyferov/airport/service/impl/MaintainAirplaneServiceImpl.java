package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.service.MaintainAirplaneService;

import java.util.concurrent.TimeUnit;

public class MaintainAirplaneServiceImpl implements MaintainAirplaneService {
  @Override
  public void maintainAirplane(Airplane airplane) {
    try {
      TimeUnit.SECONDS.sleep(15);
      airplane.setMaintainStatus(true);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}

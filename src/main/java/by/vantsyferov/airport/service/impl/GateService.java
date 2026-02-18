package by.vantsyferov.airport.service.impl;

import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;
import by.vantsyferov.airport.service.GateServiceInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GateService implements GateServiceInt {
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
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
  public void maintainAirplane(Airplane airplane) {
    try {
      TimeUnit.SECONDS.sleep(15);
      airplane.setMaintainStatus(true);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void undockAirplane(Airplane airplane) {
    gateRepository.add(airplane.getCurrentGate());
    airplane.setCurrentGate(null);
  }

  @Override
  public void boardPassengers(Airplane airplane){
    Gate boardingGate = airplane.getCurrentGate();
    while ((airplane.getPassengerAmount() < airplane.getCapacity()) && (boardingGate.getPassengerAmount() > 0)) {
      airplane.setPassengerAmount(airplane.getPassengerAmount() + 1);
      boardingGate.setPassengerAmount(boardingGate.getPassengerAmount() - 1);
    }
  }

  @Override
  public void unboardPassengers(Airplane airplane){
    airplane.setPassengerAmount(0);
  }

  public void startPassengerGeneration(Gate gate) {

    scheduler.scheduleAtFixedRate(() -> {

      int random = ThreadLocalRandom.current().nextInt(1, 6);
      gateRepository.addPassengers(gate, random);

    }, 0, 2, TimeUnit.SECONDS);
  }

  public void stop() {
    scheduler.shutdown();
  }

}

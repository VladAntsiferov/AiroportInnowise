package by.vantsyferov.airport.util;

import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class PassengerGeneratorUtil {
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  private static GateRepository gateRepository = GateRepository.getInstance();

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

package by.vantsyferov.airport.repository;

import by.vantsyferov.airport.entity.Gate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class GateRepository {

  static Logger logger = LogManager.getLogger();
  private static GateRepository instance;
  private static ReentrantLock lock = new ReentrantLock();
  private static AtomicBoolean isCreate = new AtomicBoolean(false);
  private LinkedList<Gate> freeGateQueue = new LinkedList<>(Arrays.
          asList(
                  new Gate(1, 100),
                  new Gate(2, 100),
                  new Gate(3, 100),
                  new Gate(4, 100)
          )) {
  };

  public static GateRepository getInstance() {
    if (!isCreate.get()) {
      try {
        lock.lock();
        if (instance == null) {
          instance = new GateRepository();
          isCreate.set(true);
        }
      } finally {
        lock.unlock();
      }
    }
    return instance;
  }

  public void add(Gate gate) {
    try {
      lock.lock();
      freeGateQueue.addLast(gate);
    } finally {
      lock.unlock();
    }
  }

  public Gate getFreeGate() {
    try {
      lock.lock();
      return freeGateQueue.pollFirst();
    } finally {
      lock.unlock();
    }
  }

  public void addPassengers(Gate gate, int amount) {
    try {
      lock.lock();
      if (gate.getPassengerAmount() < gate.getCapacity()) {
        logger.info("Arrived {} passengers to gate {}", amount, gate.getGateNumber());
        gate.setPassengerAmount(gate.getPassengerAmount() + amount);
        logger.info("Currently in gate {} are {} passengers", gate.getGateNumber(), gate.getPassengerAmount());
      }
    } finally {
      lock.unlock();
    }
  }

}

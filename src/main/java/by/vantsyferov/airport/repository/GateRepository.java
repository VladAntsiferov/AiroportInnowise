package by.vantsyferov.airport.repository;

import by.vantsyferov.airport.entity.Gate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GateRepository{

  private static GateRepository instance;
  private static ReentrantLock lock = new ReentrantLock();
  private static AtomicBoolean isCreate = new AtomicBoolean(false);
  private static LinkedList<Gate> freeGateQueue = new LinkedList<>(Arrays.
          asList(
                  new Gate(1,100),
                  new Gate(2,100),
                  new Gate(3,100),
                  new Gate(4, 100)
          )){
  };
  static Logger logger = LogManager.getLogger();

  public static GateRepository getInstance(){
    if(!isCreate.get()){
      lock.lock();
      try {
        if (instance == null){
          instance = new GateRepository();
          isCreate.set(true);
        }
      } finally {
        lock.unlock();
      }
    }
    return instance;
  }

  public void add(Gate gate){
    lock.lock();
    try {
      freeGateQueue.addLast(gate);
    } finally {
      lock.unlock();
    }
  }

  public Gate getFreeGate(){
    lock.lock();
    try {
      return freeGateQueue.pollFirst();
    }
    finally {
      lock.unlock();
    }
  }

  public LinkedList<Gate> getGateQueue(){
    return freeGateQueue;
  }

  public void addPassengers(Gate gate, int amount){
    lock.lock();
    try {
      if(gate.getPassengerAmount() < gate.getCapacity()){
        logger.info("Arrived {} passengers to gate {}", amount, gate.getGateNumber());
        gate.setPassengerAmount(gate.getPassengerAmount() + amount);
        logger.info("Currently in gate {} are {} passengers",gate.getGateNumber(), gate.getPassengerAmount());
      }
    } finally {
      lock.unlock();
    }
  }

}

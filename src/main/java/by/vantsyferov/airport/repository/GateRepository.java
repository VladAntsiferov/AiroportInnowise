package by.vantsyferov.airport.repository;

import by.vantsyferov.airport.entity.Gate;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GateRepository {

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

  public void remove(Gate gate){
    freeGateQueue.remove(gate);
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
}

package by.vantsyferov.airport.entity;

import by.vantsyferov.airport.entity.impl.AirplaneArrivingState;
import by.vantsyferov.airport.entity.impl.AirplaneDepartedState;

public class Airplane extends Thread {
  private String name;
  private int capacity;
  private int passengerAmount;
  private AirplaneState airplaneState;
  private Gate currentGate;
  private boolean isMaintained;

  public Airplane(String name, int capacity) {
    super(name);
    this.capacity = capacity;
    this.isMaintained = false;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public AirplaneState getAirplaneState() {
    return airplaneState;
  }

  public void setAirplaneState(AirplaneState airplaneState) {
    this.airplaneState = airplaneState;
  }

  public Gate getCurrentGate() {
    return currentGate;
  }

  public void setCurrentGate(Gate currentGate) {
    this.currentGate = currentGate;
  }

  public int getPassengerAmount() {
    return passengerAmount;
  }

  public void setPassengerAmount(int passengerAmount) {
    this.passengerAmount = passengerAmount;
  }


  public void setMaintainStatus(boolean maintained) {
    isMaintained = maintained;
  }

  public boolean getMaintainStatus() {
    return isMaintained;
  }


  @Override
  public void run() {
    setAirplaneState(new AirplaneArrivingState());
    while (!(airplaneState instanceof AirplaneDepartedState)) {
      airplaneState.handle(this);
    }
    airplaneState.handle(this);
  }

}

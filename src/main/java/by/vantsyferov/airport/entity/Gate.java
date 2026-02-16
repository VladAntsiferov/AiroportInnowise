package by.vantsyferov.airport.entity;

import by.vantsyferov.airport.entity.impl.AirplaneDocketState;

import java.util.List;

public class Gate {
  private int gateNumber;
  private int capacity;
  private List<Passenger> passengerList;
  private Airplane airplane;
  private static Gate instance;

  public Gate(int gateNumber,int capacity){
    this.gateNumber = gateNumber;
    this.capacity = capacity;
  }

  private Gate() {

  }

  public static Gate getInstance(){
    if (instance == null){
      instance = new Gate();
    }
    return instance;
  }

  public int getGateNumber(){
    return gateNumber;
  }

  public int getCapacity(){
    return capacity;
  }

  public Airplane getAirplane(){
    return airplane;
  }

  public void dockAirplane(Airplane airplane){
    this.airplane = airplane;
    this.airplane.setAirplaneState(new AirplaneDocketState());
  }


}

package by.vantsyferov.airport.entity;

import by.vantsyferov.airport.entity.impl.AirplaneDockedState;

public class Gate {
  private int gateNumber;
  private int capacity;

  public Gate(int gateNumber,int capacity){
    this.gateNumber = gateNumber;
    this.capacity = capacity;
  }

  private Gate() {

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

  public void dockAirplane(){
    this.airplane.setAirplaneState(new AirplaneDockedState());
  }


}

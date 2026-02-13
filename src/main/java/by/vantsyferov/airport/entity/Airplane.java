package by.vantsyferov.airport.entity;

import java.util.ArrayList;
import java.util.List;

public class Airplane extends Thread{
  private String name;
  private int capacity;
  private List<Passenger> passengerList;
  private AirplaneState airplaneState;

  public Airplane(String name, int capacity, List<Passenger> passengerList, AirplaneState airplaneState) {
    super(name);
    this.capacity = capacity;
    this.passengerList = passengerList;
    this.airplaneState = airplaneState;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public List<Passenger> getPassengerList() {
    return passengerList;
  }

  public void setPassengerList(List<Passenger> passengerList) {
    this.passengerList = passengerList;
  }

  public AirplaneState getAirplaneState() {
    return airplaneState;
  }

  public void setAirplaneState(AirplaneState airplaneState) {
    this.airplaneState = airplaneState;
  }

  public void boardPassenger(Passenger passenger){
    passengerList.add(passenger);
  }

  public List<Passenger> unboardPassenger(){
    List<Passenger> unboardPassengerList = new ArrayList<>(passengerList);
    passengerList.clear();
    return unboardPassengerList;
  }
}

package by.vantsyferov.airport.entity;

import by.vantsyferov.airport.entity.impl.AirplaneArrivingState;
import by.vantsyferov.airport.entity.impl.AirplaneDepartedState;
import by.vantsyferov.airport.entity.impl.AirplaneWaitingState;
import by.vantsyferov.airport.service.impl.GateService;

import java.util.ArrayList;
import java.util.List;

public class Airplane extends Thread{
  private String name;
  private int capacity;
  private List<Passenger> passengerList;
  private AirplaneState airplaneState;
  private static Airplane instance;


  public Airplane(String name, int capacity) {
    super(name);
    this.capacity = capacity;
  }

  public Airplane(){

  }

  public static Airplane getInstance() {
    if(instance == null){
      instance = new Airplane();
    }
    return instance;
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

  public void unboardPassenger(){
    this.passengerList.clear();
  }

  @Override
  public void run(){
    setAirplaneState(new AirplaneArrivingState());
    while (!(airplaneState instanceof AirplaneDepartedState)){
      airplaneState.handle(this);
    }
    airplaneState.handle(this);
  }
}

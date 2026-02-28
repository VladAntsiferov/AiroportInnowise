package by.vantsyferov.airport.entity;

import by.vantsyferov.airport.entity.impl.AirplaneArrivingState;
import by.vantsyferov.airport.entity.impl.AirplaneDepartedState;
import by.vantsyferov.airport.entity.impl.AirplaneDockedState;
import by.vantsyferov.airport.entity.impl.AirplaneMaintainingState;
import by.vantsyferov.airport.service.GateService;
import by.vantsyferov.airport.service.impl.GateServiceImpl;

public class Airplane extends Thread {
  private static final GateService gateService = new GateServiceImpl();
  private String name;
  private int capacity;
  private int passengerAmount;
  private AirplaneState airplaneState;
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
    Gate gate = gateService.requestFreeGate();
    while (!(airplaneState instanceof AirplaneDepartedState)){
      airplaneState.handle(this, gate);
      if(airplaneState instanceof AirplaneMaintainingState){
        gate = gateService.requestFreeGate();
        airplaneState.handle(this, gate);
      }
    }
    airplaneState.handle(this, gate);
  }

}

package by.vantsyferov.airport.entity;

public class Gate {
  private int gateNumber;
  private int capacity;
  private int passengerAmount;

  public Gate(int gateNumber,int capacity){
    this.gateNumber = gateNumber;
    this.capacity = capacity;
  }


  public int getGateNumber(){
    return gateNumber;
  }

  public int getCapacity(){
    return capacity;
  }

  public int getPassengerAmount() {
    return passengerAmount;
  }

  public void setPassengerAmount(int passengerAmount) {
    this.passengerAmount = passengerAmount;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void setGateNumber(int gateNumber) {
    this.gateNumber = gateNumber;
  }

}

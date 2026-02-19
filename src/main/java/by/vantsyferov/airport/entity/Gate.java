package by.vantsyferov.airport.entity;

public class Gate {
  private final int gateNumber;
  private final int capacity;
  private int passengerAmount;

  public Gate(int gateNumber, int capacity) {
    this.gateNumber = gateNumber;
    this.capacity = capacity;
  }


  public int getGateNumber() {
    return gateNumber;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getPassengerAmount() {
    return passengerAmount;
  }

  public void setPassengerAmount(int passengerAmount) {
    this.passengerAmount = passengerAmount;
  }

}

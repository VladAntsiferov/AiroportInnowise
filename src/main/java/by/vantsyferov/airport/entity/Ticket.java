package by.vantsyferov.airport.entity;

public class Ticket {
  final String name;
  final String passportNumber;
  final int airplaneName;

  public Ticket(String name, String passportNumber, int gateNumber) {
    this.name = name;
    this.passportNumber = passportNumber;
    this.airplaneName = gateNumber;
  }

  public String getName() {
    return name;
  }

  public String getPassportNumber(){
    return passportNumber;
  }

  public int getGateNumber(){
    return airplaneName;
  }
}

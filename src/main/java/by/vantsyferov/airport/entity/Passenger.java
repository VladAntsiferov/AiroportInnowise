package by.vantsyferov.airport.entity;

public class Passenger extends Thread{
  String name;
  String passportNumber;
  Ticket ticket;

  public Passenger(String name, String destination, String passportNumber, Ticket ticket){
    this.name = name;
    this.passportNumber = passportNumber;
    this.ticket = ticket;
  }

  public String getPassportNumber() {
    return passportNumber;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }

  public Ticket getTicket(){
    return ticket;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Passenger passenger = (Passenger) o;
    return name.equals(passenger.name)  && passportNumber.equals(passenger.passportNumber);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + passportNumber.hashCode();
    return result;
  }

  @Override
  public void run(){

  }
}

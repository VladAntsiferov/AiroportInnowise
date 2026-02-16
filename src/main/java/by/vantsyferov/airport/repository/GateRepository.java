package by.vantsyferov.airport.repository;

import by.vantsyferov.airport.entity.Gate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GateRepository {

  private static GateRepository instance;
  private List<Gate> gateList = new ArrayList<>(Arrays.
          asList(
                  new Gate(1,100),
                  new Gate(2,100),
                  new Gate(3,100)
          )){
  };


  public GateRepository(){

  }

  public static GateRepository getInstance(){
    if(instance == null){
      instance = new GateRepository();
    }
    return instance;
  }

  public void add(Gate gate){
    gateList.add(gate);
  }

  public void remove(Gate gate){
    gateList.remove(gate);
  }

  public List<Gate> getGateList(){
    return gateList;
  }
}

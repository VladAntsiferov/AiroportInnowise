
import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.repository.GateRepository;
import by.vantsyferov.airport.service.GateServiceInterface;
import by.vantsyferov.airport.service.impl.GateService;


void main() {
  GateServiceInterface service = new GateService();
  GateRepository repository = GateRepository.getInstance();
  Airplane airplane1 = new Airplane("743A31", 150);
  Airplane airplane2 = new Airplane("743A32", 100);
  Airplane airplane3 = new Airplane("743A33", 10);
  Airplane airplane4 = new Airplane("743A34", 100);
  Airplane airplane5 = new Airplane("743A35", 150);

  airplane1.setPassengerAmount(25);
  airplane2.setPassengerAmount(25);
  airplane3.setPassengerAmount(25);
  airplane4.setPassengerAmount(25);
  airplane5.setPassengerAmount(25);


  airplane1.start();
  airplane2.start();
  airplane3.start();
  airplane4.start();
  airplane5.start();

}

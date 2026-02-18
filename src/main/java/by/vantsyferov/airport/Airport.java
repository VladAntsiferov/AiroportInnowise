
import by.vantsyferov.airport.entity.Airplane;
import by.vantsyferov.airport.entity.Gate;
import by.vantsyferov.airport.repository.GateRepository;
import by.vantsyferov.airport.service.GateServiceInt;
import by.vantsyferov.airport.service.impl.GateService;


void main() {
  GateService service = new GateService();
  GateRepository repository = GateRepository.getInstance();
  Airplane airplane1 = new Airplane("743A31", 150);
  Airplane airplane2 = new Airplane("743A32", 100);
  Airplane airplane3 = new Airplane("743A33", 50);
  Airplane airplane4 = new Airplane("743A34", 100);

  airplane1.start();
  airplane2.start();
  airplane3.start();
  airplane4.start();

  for (Gate gate: repository.getGateQueue())
    service.startPassengerGeneration(gate);
}

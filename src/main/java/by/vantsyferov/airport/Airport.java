
import by.vantsyferov.airport.entity.Airplane;


static void main() {
  Airplane airplane1 = new Airplane("743A31", 100);
  Airplane airplane2 = new Airplane("743A32", 100);
  Airplane airplane3 = new Airplane("743A33", 100);
  Airplane airplane4 = new Airplane("743A34", 100);

  airplane1.run();
  airplane2.run();
  airplane3.run();
  airplane4.run();

}

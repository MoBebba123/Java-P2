package ziffernfolge;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErgebnisTest {
	@Test
	public void ergebnisTest() {
		Ergebnis ergebnis1 = new Ergebnis();
		ergebnis1.spielerName = "Test1";
		ergebnis1.spielZeit = 23;
		ergebnis1.laengeReihe = 2;

		Ergebnis ergebnis2 = null;
		int returnwert = 0;
		try {
			returnwert = ergebnis1.compareTo(ergebnis2);
		} catch (Exception e) {
		}

		// gleiches ergebnis, gleiche zeit
		ergebnis2 = new Ergebnis();
		ergebnis2.spielerName = "Adam";
		ergebnis2.spielZeit = 23;
		ergebnis2.laengeReihe = 2;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(0, returnwert);

		// gleiches ergebnis weniger Zeit
		ergebnis2 = new Ergebnis();
		ergebnis2.spielerName = "Adam";
		ergebnis2.spielZeit = 22;
		ergebnis2.laengeReihe = 2;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(-1, returnwert);

		// gleiches ergebnis mehr Zeit
		ergebnis2 = new Ergebnis();
		ergebnis2.spielerName = "Adam";
		ergebnis2.spielZeit = 25;
		ergebnis2.laengeReihe = 2;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(1, returnwert);

		// weniger zahlen
		ergebnis2 = new Ergebnis();
		ergebnis2.spielerName = "Adam";
		ergebnis2.spielZeit = 25;
		ergebnis2.laengeReihe = 1;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(-1, returnwert);

		// mehr zahlen
		ergebnis2 = new Ergebnis();
		ergebnis2.spielerName = "Adam";
		ergebnis2.spielZeit = 25;
		ergebnis2.laengeReihe = 5;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(1, returnwert);

	}
}

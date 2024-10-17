package ziffernfolge;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErgebnisTest {
	@Test
	public void ergebnisTest() {
		Ergebnis ergebnis1 = new Ergebnis();
		ergebnis1.name = "Test1";
		ergebnis1.zeit = 23;
		ergebnis1.ziffernanzahl = 2;

		Ergebnis ergebnis2 = null;
		int returnwert = 0;
		try {
			returnwert = ergebnis1.compareTo(ergebnis2);
		} catch (Exception e) {
		}

		// gleiches ergebnis, gleiche zeit
		ergebnis2 = new Ergebnis();
		ergebnis2.name = "Adam";
		ergebnis2.zeit = 23;
		ergebnis2.ziffernanzahl = 2;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(0, returnwert);

		// gleiches ergebnis weniger Zeit
		ergebnis2 = new Ergebnis();
		ergebnis2.name = "Adam";
		ergebnis2.zeit = 22;
		ergebnis2.ziffernanzahl = 2;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(-1, returnwert);

		// gleiches ergebnis mehr Zeit
		ergebnis2 = new Ergebnis();
		ergebnis2.name = "Adam";
		ergebnis2.zeit = 25;
		ergebnis2.ziffernanzahl = 2;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(1, returnwert);

		// weniger zahlen
		ergebnis2 = new Ergebnis();
		ergebnis2.name = "Adam";
		ergebnis2.zeit = 25;
		ergebnis2.ziffernanzahl = 1;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(-1, returnwert);

		// mehr zahlen
		ergebnis2 = new Ergebnis();
		ergebnis2.name = "Adam";
		ergebnis2.zeit = 25;
		ergebnis2.ziffernanzahl = 5;
		returnwert = ergebnis1.compareTo(ergebnis2);
		assertEquals(1, returnwert);

	}
}

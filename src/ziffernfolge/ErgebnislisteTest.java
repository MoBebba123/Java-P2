package ziffernfolge;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class ErgebnislisteTest {
	@Test
	public void Test() throws IOException {
		String dateiname = "Ergebnisliste.txt";

		File file = new File(dateiname);
		if (file.exists()) {
			file.delete();
		}

		Ergebnisliste liste = new Ergebnisliste();
		assertEquals(liste.ende(), true);

		Ergebnis ergebnis = new Ergebnis();
		ergebnis.name = "Adam";
		ergebnis.zeit = 25;
		ergebnis.ziffernanzahl = 20;

		liste.speichere(ergebnis);
		liste.start();

		assertEquals(ergebnis.name, liste.aktuelles_Element().name);
		assertEquals(ergebnis.zeit, liste.aktuelles_Element().zeit, 0);
		assertEquals(ergebnis.ziffernanzahl, liste.aktuelles_Element().ziffernanzahl);
		assertEquals(liste.ende(), false);

		liste.weiter();
		assertEquals(liste.ende(), true);

		// Ergebnisliste liste2 = new Ergebnisliste();
		Ergebnis[] ergebnis2 = new Ergebnis[10];

		for (int i = 0; i < 10; i++) {
			ergebnis2[i] = new Ergebnis();
			ergebnis2[i].name = "Testname" + i;
			ergebnis2[i].zeit = 20 + i;
			ergebnis2[i].ziffernanzahl = 30 + i;
			liste.speichere(ergebnis2[i]);
			assertEquals(liste.ende(), true);
		}

	}
}

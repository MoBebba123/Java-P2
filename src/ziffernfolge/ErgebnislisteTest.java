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
		ergebnis.spielerName = "Adam";
		ergebnis.spielZeit = 25;
		ergebnis.laengeReihe = 20;

		liste.speichere(ergebnis);
		liste.start();

		assertEquals(ergebnis.spielerName, liste.aktuelles_Element().spielerName);
		assertEquals(ergebnis.spielZeit, liste.aktuelles_Element().spielZeit, 0);
		assertEquals(ergebnis.laengeReihe, liste.aktuelles_Element().laengeReihe);
		assertEquals(liste.ende(), false);

		liste.weiter();
		assertEquals(liste.ende(), true);

		// Ergebnisliste liste2 = new Ergebnisliste();
		Ergebnis[] ergebnis2 = new Ergebnis[10];

		for (int i = 0; i < 10; i++) {
			ergebnis2[i] = new Ergebnis();
			ergebnis2[i].spielerName = "Testname" + i;
			ergebnis2[i].spielZeit = 20 + i;
			ergebnis2[i].laengeReihe = 30 + i;
			liste.speichere(ergebnis2[i]);
			assertEquals(liste.ende(), true);
		}

	}
}

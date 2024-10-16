package ziffernfolge;

import java.io.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class DatenspeicherTest {
	String dateiname = "Ergebnisliste.txt";

	@Test
	public void datenSpeicherTest() throws IOException {

		Datenspeicher testDatenspeicher = new Datenspeicher();

		Liste liste = new VerketteteListe();
		Liste.Iterator iterator = liste.erzeuge_Iterator();
		Ergebnis[] ergebnis = new Ergebnis[10];

		for (int i = 0; i < 10; i++) {
			ergebnis[i] = new Ergebnis();
			ergebnis[i].name = "spielerName" + i;
			ergebnis[i].zeit = 20 + i;
			ergebnis[i].ziffernanzahl = 30 + i;
			liste.setze_an_Ende(ergebnis[i]);
		}
		Ergebnis ergebnistest = new Ergebnis();
		testDatenspeicher.speichern(liste, dateiname);

		testDatenspeicher.lesen(dateiname);
		for (int i = 0; iterator.nach_ende() != true; i++) {
			ergebnistest = (Ergebnis) iterator.element();
			assertEquals(ergebnis[i].name, ergebnistest.name);
			assertEquals(ergebnis[i].zeit, ergebnistest.zeit, 0);
			assertEquals(ergebnis[i].zeit, ergebnistest.zeit);
			iterator.weiter();
		}

	}
}

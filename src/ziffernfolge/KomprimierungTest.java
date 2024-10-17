package ziffernfolge;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse testet die Implementierung der
 * {@link Komprimierung}-Schnittstelle
 * unter Verwendung der {@link Lauflaenge}-Klasse.
 * Sie stellt verschiedene Tests für die Komprimierung und Dekomprimierung von
 * Zeichenketten bereit.
 */
public class KomprimierungTest {

	private Komprimierung komprimierung;

	/**
	 * Richtet die Umgebung für jeden Testfall ein.
	 * Instanziiert eine neue {@link Lauflaenge}-Instanz, die die
	 * {@link Komprimierung} implementiert.
	 */
	@Before
	public void setUp() {
		komprimierung = new Lauflaenge();
	}

	/**
	 * Testet die Komprimierung und Dekomprimierung einer Zeichenkette.
	 * Verifiziert, dass die Dekomprimierung des komprimierten Texts zum
	 * Originaltext führt.
	 */
	@Test
	public void testKomprimierungUndDekomprimierung() {
		String originalText = "555555uuuu;;;222+++777";
		String komprimierterText = komprimierung.komprimieren(originalText);
		String dekomprimierterText = komprimierung.expandieren(komprimierterText);

		assertEquals(originalText, dekomprimierterText);
	}

	/**
	 * Testet die Komprimierung und Dekomprimierung eines leeren Strings.
	 * Verifiziert, dass ein leerer String unverändert komprimiert und dekomprimiert
	 * wird.
	 */
	@Test
	public void testKomprimierungLeererString() {
		String originalText = "";
		String komprimierterText = komprimierung.komprimieren(originalText);
		String dekomprimierterText = komprimierung.expandieren(komprimierterText);

		assertEquals("", komprimierterText);
		assertEquals("", dekomprimierterText);
	}

	/**
	 * Testet die Komprimierung und Dekomprimierung eines null-Werts.
	 * Verifiziert, dass null als Eingabe zu null als Ausgabe führt.
	 */
	@Test
	public void testKomprimierungNullString() {
		String komprimierterText = komprimierung.komprimieren(null);
		String dekomprimierterText = komprimierung.expandieren(null);

		assertNull(komprimierterText);
		assertNull(dekomprimierterText);
	}

	/**
	 * Testet die Komprimierung einer Zeichenkette mit wiederholten Zeichen.
	 * Verifiziert, dass die Zeichen korrekt zusammengefasst werden.
	 */

	@Test
	public void testKomprimierungEinerWiederholung() {
		String originalText = "aaaaabbbbcc";
		String komprimierterText = komprimierung.komprimieren(originalText);
		String erwartetesErgebnis = "|5a|4bcc";

		assertEquals(erwartetesErgebnis, komprimierterText);
	}

	@Test
	public void testExpandierungKomprimierterText() {
		String komprimierterText = "|5a|4b|2c";
		String dekomprimierterText = komprimierung.expandieren(komprimierterText);
		String erwartetesErgebnis = "aaaaabbbbcc";

		assertEquals(erwartetesErgebnis, dekomprimierterText);
	}

}

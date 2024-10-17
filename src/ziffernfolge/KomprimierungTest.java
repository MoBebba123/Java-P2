package ziffernfolge;

import static org.junit.Assert.*;
import org.junit.Test;

public class KomprimierungTest {
	@Test
	public void komprimierungTest() {
		String s = "555555uuuu;;;das+++332d";
		Komprimierung compTest = new Lauflaenge();

		String e = compTest.komprimieren(s);
		String d = compTest.expandieren(e);
		assertEquals(s, d);

	}
}

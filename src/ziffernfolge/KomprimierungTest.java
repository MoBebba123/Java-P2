package ziffernfolge;

import static org.junit.Assert.*;
import org.junit.Test;

public class KomprimierungTest {
	@Test
	public void komprimierungTest() {
		// public static void main(String[] args) {
		String s = "66666666666dddddd;;;ääää####6g6";
		Komprimierung compTest = new RunLength();

		String e = compTest.komprimieren(s);
		String d = compTest.expandieren(e);
		assertEquals(s, d);

	}
}

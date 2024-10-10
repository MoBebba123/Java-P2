package ziffernfolge;

import static org.junit.Assert.*;

import org.junit.Test;

public class KryptomethodeTest {
	@Test
	public void KryptomethodeTest() {
		// public static void main(String[] args) {

		String cryptKey = "abcde12345";
		String testtext_soll = "Java-Code";
		String testtext_ist = "Java-Code";

		StringBuffer ist = new StringBuffer(testtext_soll);
		StringBuffer soll = new StringBuffer(testtext_ist);
		Kryptomethode encrypt = new Vigenere(cryptKey);

		encrypt.verschluesseln(ist);
		Kryptomethode decrypt = new Vigenere(cryptKey);
		decrypt.entschluesseln(ist);
		assertEquals(soll.toString(), ist.toString());

		encrypt = new Vigenere();
		encrypt.Schluessel("TESTKEY");
		encrypt.verschluesseln(ist);
		encrypt.entschluesseln(ist);
		assertEquals(soll.toString(), ist.toString());

		encrypt = new Vigenere();
		encrypt.Schluessel(null);
		encrypt.verschluesseln(null);
		encrypt.entschluesseln(null);

	}
}

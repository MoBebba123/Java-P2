package ziffernfolge;

public class Lauflaenge implements Komprimierung {

	private char steuerzeichen = '|';

	/**
	 * Komprimiert die gegebene Zeichenkette nach dem Run-Length-Encoding-Verfahren.
	 * Wenn der Text null oder leer ist, wird ein leerer String zurückgegeben.
	 * Zeichen, die weniger als dreimal hintereinander vorkommen, werden nicht
	 * komprimiert.
	 * 
	 * @param text der zu komprimierende Text.
	 * @return die komprimierte Zeichenkette oder ein leerer String, wenn der
	 *         Eingabetext null oder leer ist.
	 */
	@Override
	public String komprimieren(String text) {
		if (text == null) {
			return null; // Rückgabe von null, wenn der Eingabewert null ist
		}
		if (text.isEmpty()) {
			return ""; // Rückgabe eines leeren Strings, wenn der Eingabetext leer ist
		}
		StringBuilder compressedString = new StringBuilder();
		int count = 1;

		for (int i = 0; i < text.length(); i++) {
			if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
				count++;
			} else {
				if (count >= 3) {
					compressedString.append(steuerzeichen).append(count).append(text.charAt(i));
				} else {
					compressedString.append(String.valueOf(text.charAt(i)).repeat(count));
				}
				count = 1;
			}
		}

		return compressedString.toString();
	}

	/**
	 * Expandiert die gegebene komprimierte Zeichenkette zurück in ihren
	 * Originalzustand.
	 * Wenn der Text null oder leer ist, wird ein leerer String zurückgegeben.
	 * 
	 * @param text der zu expandierende Text.
	 * @return die expandierte Zeichenkette oder ein leerer String, wenn der
	 *         Eingabetext null oder leer ist.
	 */
	@Override
	public String expandieren(String text) {
		if (text == null) {
			return null; // Rückgabe von null, wenn der Eingabewert null ist
		}
		if (text.isEmpty()) {
			return ""; // Rückgabe eines leeren Strings, wenn der Eingabetext leer ist
		}
		StringBuilder decompressedString = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == steuerzeichen && i + 2 < text.length()) {
				int count = Character.getNumericValue(text.charAt(i + 1));
				char character = text.charAt(i + 2);
				decompressedString.append(String.valueOf(character).repeat(count));
				i += 2;
			} else {
				decompressedString.append(text.charAt(i));
			}
		}

		return decompressedString.toString();
	}
}

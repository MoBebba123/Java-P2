package ziffernfolge;

public class RunLength implements Komprimierung {
	// Konstruktor fuer Implementierungen:
	/**
	 * Ein Komprimierer und ein Dekomp rimierer werden bereitgestellt.
	 */

	/**
	 * Der Text wird komprimiert. Wenn fuer den Text ein Null-Zeiger uebergeben
	 * wird, wird nicht komprimiert.
	 * 
	 * @param text der zu komprimierende Text.
	 */

	private char fluchtsymbol = '¿';

	public String komprimieren(String text) {

		if (text != null && text != "") {
			String compressedString = "";
			for (int i = 0, count = 1; i < text.length(); i++) {
				if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1) && count < 9) {
					count++;
				} else if (count < 3) {
					for (count++; count != 1; count--) {
						compressedString += text.charAt(i);
					}
				} else {
					compressedString += fluchtsymbol;
					compressedString += count;
					compressedString += text.charAt(i);
					count = 1;
				}
			}
			return compressedString;
		} else {
			return null;
		}
	}

	/**
	 * Der Text wird expandiert. Wenn fuer den Text ein Null-Zeiger uebergeben wird,
	 * wird nicht expandiert.
	 * 
	 * @param text der zu expandierende Text.
	 */

	public String expandieren(String text) {
		if (text != null && text != "") {
			String decompressedString = "";
			char[] chars = text.toCharArray();
			for (int i = 0; i < text.length(); i++) {
				if (i + 1 < text.length() && chars[i] == fluchtsymbol && chars[i + 1] != fluchtsymbol) {
					i++;
					for (char n = '1'; n < chars[i]; n++) {
						decompressedString += text.charAt(i + 1);
					}
				} else {
					decompressedString += text.charAt(i);
				}
			}
			return decompressedString;
		} else {
			return null;
		}
	}
}
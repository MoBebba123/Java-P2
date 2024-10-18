package ziffernfolge;

/**
 * Klasse, die ein Ergebnis darstellt und von Comparable erbt.
 * Ein Ergebnis besteht aus einem Namen, der benötigten Zeit und der Anzahl
 * der Ziffern. Diese Klasse ermöglicht den Vergleich von Ergebnissen basierend
 * auf der Ziffernanzahl und der Zeit.
 * 
 * @author Mohamed Bebba
 * @version 08.10.2024
 */
public class Ergebnis implements Comparable<Ergebnis> {

	public String name;
	public int zeit;
	public int ziffernanzahl;

	/**
	 * Vergleicht Ergebnis mit mitgegebenen Ergebnis.
	 * Primäres Kriterium ist die Anzahl der Ziffern.
	 * Sekundäres Kriterium ist die benötigte Zeit.
	 * 
	 * @param ergebnis Ergbnis mit dem verglichen werden soll
	 * @return Negative Ganzahl, Null or positive Ganzzahl wenn das Ergbnis
	 *         schlechter,
	 *         gleich oder besser ist als das übergebene Ergebnis.
	 */
	public int compareTo(Ergebnis ergebnis) {
		if (ergebnis != null) {
			if (ergebnis.ziffernanzahl == this.ziffernanzahl) {
				if (ergebnis.zeit < this.zeit) {
					return -1;
				} else if (ergebnis.zeit > this.zeit) {
					return 1;
				}
				return 0;
			} else if (ergebnis.ziffernanzahl > this.ziffernanzahl) {
				return 1;
			} else {
				return -1;
			}
		}
		return 2;
	}

}

package ziffernfolge;

/**
 * Klasse fuer das Ergebnis
 * @author Mohamed Bebba
 * @version 08.10.2024
 */

/**
 * Klasse soll von Comparable erben.
 */

public class Ergebnis implements Comparable<Ergebnis> {

	public String spielerName;
	public long spielZeit;
	public int laengeReihe;

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
			if (ergebnis.laengeReihe == this.laengeReihe) {
				if (ergebnis.spielZeit < this.spielZeit) {
					return -1;
				} else if (ergebnis.spielZeit > this.spielZeit) {
					return 1;
				}
				return 0;
			} else if (ergebnis.laengeReihe > this.laengeReihe) {
				return 1;
			} else {
				return -1;
			}
		}
		return 2;
	}

}

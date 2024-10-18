package ziffernfolge;

/**
 * Klasse fuer den Sortiealg. Bubbelsort
 * Diese Klasse stellt die grundlegenden Funktionen
 * fuer die Sortierung zur Verfuegung
 * 
 * @author Mohamed Bebba
 * @version 08.10.2024
 */

public class BubbleSort implements Sortierung {

	private boolean aufsteigend = true;

	/**
	 * Beim naechsten Sortieren wird aufsteigend sortiert.
	 * Voreingestellt ist aufsteigend sortieren.
	 */
	public void setze_aufsteigend() {
		aufsteigend = true;
	}

	/**
	 * Beim naechsten Sortieren wird absteigend sortiert.
	 * Voreingestellt ist aufsteigend sortieren.
	 */
	public void setze_absteigend() {
		aufsteigend = false;
	}

	private int laengeListe(Liste liste) {
		Liste.Iterator iterator = liste.erzeuge_Iterator();
		int i;
		for (i = 0; iterator.nach_ende() != true; i++) {
			iterator.weiter();
		}
		return i;
	}

	/**
	 * Die Liste wird sortiert.
	 * 
	 * @param liste Zu sortierende Liste.
	 */
	public void sortiere(Liste liste) {

		Liste.Iterator iterator_now = liste.erzeuge_Iterator();
		Liste.Iterator iterator_next = liste.erzeuge_Iterator();
		int lenList = laengeListe(liste);

		Ergebnis ergebnis_now = new Ergebnis();
		Ergebnis ergebnis_next = new Ergebnis();

		for (int i = 0; i < lenList; i++) {
			iterator_now.anfang();
			iterator_next.anfang();
			iterator_next.weiter();
			for (int j = 0; j < lenList - 1; j++) {
				ergebnis_now = (Ergebnis) iterator_now.element();
				ergebnis_next = (Ergebnis) iterator_next.element();
				if (aufsteigend) {
					if (ergebnis_now.compareTo(ergebnis_next) <= 0) {
						liste.verschiebe_nach(iterator_now, iterator_next);
						iterator_next.weiter();
					}
				} else {
					if (ergebnis_now.compareTo(ergebnis_next) >= 0) {
						liste.verschiebe_nach(iterator_now, iterator_next);
						iterator_next.weiter();
					}
				}
				iterator_now.weiter();
				iterator_next.weiter();
			}
		}
	}

}

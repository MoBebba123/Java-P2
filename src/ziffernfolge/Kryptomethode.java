package ziffernfolge;

/**
 * abstrakter Datentyp: Verschl�sseler (und Entschl�sseler) f�r beliebige
 * Zeichenketten.
 * 
 * @author Andreas Kurz
 * @version 02.09.2018
 */
public interface Kryptomethode { // Konstruktor f�r Implementierungen:
    /** Ein Verschl�sseler und ein Entschl�sseler werden bereitgestellt. */
    // public void Vigenere();

    // Konstruktor f�r Implementierungen:
    /**
     * Ein Verschl�sseler und ein Entschl�sseler werden mit zugeh�rigem
     * Schl�sselwort bereitgestellt.
     * 
     * @param schluesselwort: eine beliebige Zeichenkette
     */
    // public void Vigenere(String schluesselwort);

    /**
     * Der Schluessel fuer das Ver- und Entschluesseln wird bereitgestellt.
     * 
     * @param wert Wert des Schluessels: eine beliebige Zeichenkette.
     */
    public void Schluessel(String wert);

    /**
     * Der Text wird verschluesselt. Wenn kein Schluessel bereitgestellt ist,
     * oder f�r den Text ein Null-Zeiger uebergeben wird, wird nicht
     * verschluesselt. Der verschl�sselte Text wird im Parameter text zur
     * Verf�gung gestellt.
     * 
     * @param text der zu verschluesselnde Text.
     */
    public void verschluesseln(StringBuffer text);

    /**
     * Der Text wird entschluesselt. Wenn kein Schluessel bereitgestellt ist,
     * oder f�r den Text ein Null-Zeiger uebergeben wird, wird nicht
     * entschluesselt. Der entschl�sselte Text wird im Parameter text zur
     * Verf�gung gestellt.
     * 
     * @param text der zu entschluesselnde Text.
     */
    public void entschluesseln(StringBuffer text);
}
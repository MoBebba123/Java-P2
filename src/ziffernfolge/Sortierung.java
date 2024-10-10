package ziffernfolge;

public interface Sortierung {
    /**
     * Die Liste wird sortiert.
     * 
     * @param liste Zu sortierende Liste.
     */
    public void sortiere(Liste liste);

    /**
     * Beim naechsten Sortieren wird aufsteigend sortiert.
     * Voreingestellt ist aufsteigend sortieren.
     */
    public void setze_aufsteigend();

    /**
     * Beim naechsten Sortieren wird absteigend sortiert.
     * Voreingestellt ist aufsteigend sortieren.
     */
    public void setze_absteigend();
}

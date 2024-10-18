package ziffernfolge;

import java.io.*;

/**
 * Klasse zur Verwaltung des Datenspeichers für Ergebnislisten.
 * Diese Klasse stellt Methoden zur Überprüfung, Speicherung und zum
 * Auslesen von Ergebnislisten zur Verfügung.
 * 
 * @author Mohamed Bebba
 * @version 08.10.2024
 */
public class Datenspeicher {

	private String zeile = null;
	private int zeilenanzahl = 0;

	/**
	 * Überprüft, ob eine Datei existiert, und erstellt sie, wenn sie nicht
	 * vorhanden ist.
	 * Falls die Datei existiert, wird die Anzahl der Zeilen gezählt.
	 * 
	 * @param dateiname Der Name der zu überprüfenden Datei.
	 * @return Der Pfad der Datei.
	 */
	private String checkFile(String dateiname) {

		File filename = new File(dateiname);
		try {
			if (filename.createNewFile() == true) {

				BufferedWriter writer = null;
				writer = new BufferedWriter(new FileWriter(filename.getPath(), true));
				writer.close();
			} else {
				try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
					while (reader.readLine() != null) {
						zeilenanzahl++;
					}
				}
			}
		} catch (Exception e) {
		}
		return filename.getPath();
	}

	/**
	 * Liest eine Ergebnisliste aus einer Datei und gibt diese zurück.
	 * Es wird die Datei ausgelesen, deren Name als Parameter übergeben wird.
	 * 
	 * @param dateiname Der Name der Datei, die ausgelesen werden soll.
	 * @return Die ausgelesene Ergebnisliste oder null, falls ein Fehler auftritt.
	 */
	@SuppressWarnings("resource")
	public Liste lesen(String dateiname) {
		try {
			FileReader readfile = new FileReader(checkFile(dateiname));
			BufferedReader bufferedReader = new BufferedReader(readfile);
			Liste liste = new VerketteteListe();
			StringBuffer buffer = new StringBuffer();
			Komprimierung compTest = new Lauflaenge();

			if (zeilenanzahl == 0) {
				return liste;
			} else {
				Ergebnis[] ergebnis = new Ergebnis[zeilenanzahl];
				int cnt = 0;
				while ((zeile = bufferedReader.readLine()) != null) {
					buffer = new StringBuffer();
					buffer.append(zeile);
					zeile = compTest.expandieren(buffer.toString());
					if (zeile.contains("|")) {
						String[] lineSplit = zeile.split("\\|", 3);
						ergebnis[cnt] = new Ergebnis();

						ergebnis[cnt].ziffernanzahl = Integer.parseInt(lineSplit[0]);
						ergebnis[cnt].zeit = Integer.parseInt(lineSplit[1]);
						ergebnis[cnt].name = lineSplit[2];
						liste.setze_an_Ende(ergebnis[cnt]);
					} else {
						continue;
					}
					cnt++;
				}
			}
			bufferedReader.close();
			return liste;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Speichert eine Ergebnisliste in einer Datei mit dem angegebenen Namen.
	 * Es wird eine Komprimierung der Liste durchgeführt und in der Datei
	 * abgespeichert.
	 * 
	 * @param liste     Die zu speichernde Ergebnisliste.
	 * @param dateiname Der Name der Datei, in der die Liste gespeichert wird.
	 * @throws IOException Falls ein Fehler beim Speichern der Datei auftritt.
	 */
	@SuppressWarnings("resource")
	public void speichern(Liste liste, String dateiname) throws IOException {
		if (liste != null) {
			Liste.Iterator iterator = liste.erzeuge_Iterator();
			String ergebnisString = "";
			Ergebnis line = new Ergebnis();
			Komprimierung compTest = new Lauflaenge();

			StringBuffer buffer;
			BufferedWriter writer = null;

			File writefile = new File(dateiname);
			writefile.delete();
			writer = new BufferedWriter(new FileWriter(checkFile(dateiname), true));
			for (; iterator.nach_ende() != true;) {
				line = (Ergebnis) iterator.element();
				ergebnisString = line.ziffernanzahl + "|" + line.zeit + "|" + line.name;
				ergebnisString = compTest.komprimieren(ergebnisString);
				buffer = new StringBuffer(ergebnisString);

				writer.write(buffer.toString());

				writer.newLine();
				writer.flush();
				iterator.weiter();
			}
			writer.close();

		}
	}

}

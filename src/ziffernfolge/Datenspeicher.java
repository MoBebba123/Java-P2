package ziffernfolge;

import java.io.*;

/**
 * Klasse fuer den Datenspeicher
 * @author Mohamed Bebba
 * @version 08.10.2024
 */

/**
 * Diese Klasse stellt die Funktionen fuer die Datenspeicher zur
 * Verfuegung.
 * 
 * @param String zeile
 * @param int    zeilenanzahl
 */

public class Datenspeicher {

	private String zeile = null;
	private int zeilenanzahl = 0;

	/**
	 * Methode fuer die Datei Ergbnisliste.txt es wird geprueft, ob die Datei
	 * existiert oder nicht.
	 * 
	 * @return Pfad der Datei durch die File Klasse
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
	 * Auslesen der Ergebnisliste aus einer Datei
	 * 
	 * @param dateiname Dateiname zum Auslesen der Ergebnisliste
	 * @return Eine Ergebnisliste, welche ausgelesen wurde
	 * 
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
						/*
						 * System.out.println(lineSplit[0]); System.out.println(lineSplit[1]);
						 * System.out.println(lineSplit[2]);
						 */
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
	 * Speichert eine Ergebnisliste in einer Datei mit dem übergebenen Dateinamen
	 * 
	 * @param liste     Die abzuspeichernde Liste
	 * @param dateiname Name der Datei ohne Dateiendung, in welcher die
	 *                  Ergebnisliste abgespeichert wird
	 *
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

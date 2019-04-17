package NichtParkhausrelevanteAufgaben;
import java.util.ArrayList;


//OUTDATED

//Tasksortierung
public class Tasks {
	//Beide Listen werden gespeichert für die Weiterverarbeitung
	private String[][] sorting;
	private String[] sequence;
	
	//Die Sortierregeln werden beim Erstellen übergeben
	public Tasks(String[][] sorting) {
		this.sorting = sorting;
	}

	//Die Hauptkomponente: Überprüfung der korrektheit einer Stringsequenz mittels Sortierregeln
	public boolean isWellSorted(String[] sequence) {
		//tmpPos: hatte keine lust mehrmals getLastPos(kommt unten) aufzurufen
		int tmpPos;
		//trivial
		for (int i = 0; i < sorting.length - 1; i++) {
			//Liste zum Speichern von Positionen von Einträgen mit Regeln
			ArrayList<Integer> positionList = new ArrayList<Integer>();
			//trivial
			for (int j = 0; j < sorting[i].length - 1; j++) {
				//v Das hier meinte ich v
				tmpPos = getLastPos(sorting[i][j]);
				//Die Position wird nur gespeichert, wenn der Eintrag aus den Regeln in der Sequenz existiert
				if (tmpPos != -1) {
					positionList.add(positionList.size() - 1, tmpPos);
				}
			}
			//Fallunterscheidung, für den Fall dass die Anzahl der Regeln > 2 ist oder weniger Einträge ex.
			switch (positionList.size()) {
			//Wenn nur 1 Eintrag gefunden wurde
			case 1:
				break;
			//2 Einträge
			case 2:
				if (positionList.get(0) > positionList.get(1)) {
					return false;
				}
				break;
		    //Für 3 oder mehr Einträge
			//Falls die letzte Position des momentanen Eintrags größer ist, als die des nächsten, wird false zurückgeliefert
			default:
				for (int n = 0; n < positionList.size() - 2; n++) {
					if (positionList.get(n) > positionList.get(n + 1)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	//Hilfsmethode zum Ermitteln der letzten Position des Eintrags in der Sequenz
	//Gibt -1 zurück, falls kein Eintrag existiert.
	private int getLastPos(String value) {
		int pos = -1;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] == value) {
				pos = i;
			}
		}
		return pos;
	}
}

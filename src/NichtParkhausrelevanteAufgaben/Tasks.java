package NichtParkhausrelevanteAufgaben;
import java.util.ArrayList;


//OUTDATED

//Tasksortierung
public class Tasks {
	//Beide Listen werden gespeichert f�r die Weiterverarbeitung
	private String[][] sorting;
	private String[] sequence;
	
	//Die Sortierregeln werden beim Erstellen �bergeben
	public Tasks(String[][] sorting) {
		this.sorting = sorting;
	}

	//Die Hauptkomponente: �berpr�fung der korrektheit einer Stringsequenz mittels Sortierregeln
	public boolean isWellSorted(String[] sequence) {
		//tmpPos: hatte keine lust mehrmals getLastPos(kommt unten) aufzurufen
		int tmpPos;
		//trivial
		for (int i = 0; i < sorting.length - 1; i++) {
			//Liste zum Speichern von Positionen von Eintr�gen mit Regeln
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
			//Fallunterscheidung, f�r den Fall dass die Anzahl der Regeln > 2 ist oder weniger Eintr�ge ex.
			switch (positionList.size()) {
			//Wenn nur 1 Eintrag gefunden wurde
			case 1:
				break;
			//2 Eintr�ge
			case 2:
				if (positionList.get(0) > positionList.get(1)) {
					return false;
				}
				break;
		    //F�r 3 oder mehr Eintr�ge
			//Falls die letzte Position des momentanen Eintrags gr��er ist, als die des n�chsten, wird false zur�ckgeliefert
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
	//Gibt -1 zur�ck, falls kein Eintrag existiert.
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

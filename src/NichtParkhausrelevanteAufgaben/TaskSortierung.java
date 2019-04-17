package NichtParkhausrelevanteAufgaben;

import java.util.HashMap;
import java.util.Map;

public class TaskSortierung {

	protected Map<String, Integer> topSort = new HashMap<String, Integer>();
	protected String[][] tString;

	public TaskSortierung(String[][] tString) {
		this.tString = tString;
		for (int i = 0; i < tString.length; i++) {
			for (int j = 0; j < tString[i].length; j++) {
				if (!(topSort.containsKey(tString[i][j]))) {
					topSort.put(tString[i][j], 0);
				}
				if (j > 0) {
					topSort.put(tString[i][j], (topSort.get(tString[i][j]) + 1));
				}
			}
		}

		System.out.println(topSort.entrySet().toString());
	}

	public boolean isWellSorted(String[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			if (topSort.containsKey(sequence[i])) {
				if (topSort.get(sequence[i]) != 0) {
					if (i == 0) {
						return false;
					} else {
						for (int j = 0; j < tString.length; j++) {
							for (int k = 1; k < tString[j].length; k++) {
								if (tString[j][k] == sequence[i] && k > 0) {
									for (int l = i + 1; l < sequence.length; l++) {
										if (sequence[l] == tString[j][k - 1]) {
											return false;
										}
									}
								}
							}
						}
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}
}

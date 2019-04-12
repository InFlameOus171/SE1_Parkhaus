import java.util.ArrayList;

public class Tasks {
	private String[][] sorting;
	private String[] sequence;

	public Tasks(String[][] sorting) {
		this.sorting = sorting;
	}

	public boolean isWellSorted(String[] sequence) {
		int tmpPos;
		for (int i = 0; i < sorting.length - 1; i++) {
			ArrayList<Integer> positionList = new ArrayList<Integer>();
			for (int j = 0; j < sorting[i].length - 1; j++) {
				tmpPos = getLastPos(sorting[i][j]);
				if (tmpPos != -1) {
					positionList.add(positionList.size() - 1, tmpPos);
				}
			}

			switch (positionList.size()) {
			case 1:
				break;
			case 2:
				if (positionList.get(0) > positionList.get(1)) {
					return false;
				}
				break;
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

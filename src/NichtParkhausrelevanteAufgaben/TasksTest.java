package NichtParkhausrelevanteAufgaben;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TasksTest {
	String[][] s = new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }};
	String[] sequence = new String[]{ "A" , "B", "C", "D" };
	
	@Test
	void test() {
		TaskSortierung t = new TaskSortierung(s);
		assertTrue(t.isWellSorted(sequence));
	}

}

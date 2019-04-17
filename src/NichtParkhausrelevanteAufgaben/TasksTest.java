package NichtParkhausrelevanteAufgaben;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TasksTest {
	String[][] s1 = new String[][]{{ "A" , "C", "D" }, { "B", "C", "D" }, { "B", "A", "C" }};
	String[][] s2 = new String[][]{{ "F" , "C" },{ "F" , "A" },{ "E" , "A" },{ "E" , "B" },{ "C" , "D" },{ "D" , "B" }};
	String[] sequence1 = new String[]{ "B", "A", "C", "D"};
	String[][] sequence2 = new String[][]{
		{"E","F","A","C","D","B"},//0 true
		{"F","E","A","C","D","B"},//1 true
		{"E","F","C","A","D","B"},//2 true
		{"E","F","A","D","A","B"},//3 true
		{"E","F","A","D","B","A"},//4 true
		{"E","A","F","C","D","B"},// 5 false
		};
	@Test

	void test() {
		TaskSortierung t = new TaskSortierung(s2);
		assertTrue(t.isWellSorted(sequence2[0]));
		assertTrue(t.isWellSorted(sequence2[1]));
		assertTrue(t.isWellSorted(sequence2[2]));
		assertTrue(t.isWellSorted(sequence2[3]));
		assertTrue(t.isWellSorted(sequence2[4]));	
		assertFalse(t.isWellSorted(sequence2[5]));
		
	}

}


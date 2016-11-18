package org.wuzl.study.guava.collect;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * table 相当于Map<FirstName, Map<LastName, Person>>
 * 
 * @author wuzl
 *
 */
public class TestTable {
	@Test
	public void shouldPutAndGet() {
		Table<Integer, Integer, String> studentTable = HashBasedTable.create();
		int row = 3;
		int column = 5;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				studentTable.put(i, j , "某某" + i + "," + j);
			}
		}
		assertEquals(studentTable.get(1, 1), "某某1,1");
		Map<Integer, String> row2Map = studentTable.row(2);
		assertEquals(row2Map.size(), 5);
		assertEquals(row2Map.get(3), "某某2,3");
	}
}

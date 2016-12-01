package org.wuzl.study.guava.collect;

import java.util.List;

import org.junit.Test;
import org.wuzl.study.guava.base.Person;
import org.wuzl.study.guava.base.PersonHelper;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import static org.junit.Assert.assertEquals;

/**
 * 好多有用的方法
 * 
 * @author wuzl
 *
 */
public class TestMaps {
	/**
	 * 根据id把personlist转为map
	 */
	@Test
	public void shouldGetIndexMapByList() {
		List<Person> rows = PersonHelper.getPersonList();
		ImmutableMap<Long, Person> map = Maps.uniqueIndex(rows,
				new Function<Person, Long>() {

					@Override
					public Long apply(Person input) {
						return input.getId();
					}
				});
		assertEquals(map.size(), rows.size());
		for (Person person : rows) {
			assertEquals(person, map.get(person.getId()));
		}
		System.out.println(map);
	}
}

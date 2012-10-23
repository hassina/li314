package pobj.util;

import java.util.Random;

import junit.framework.TestCase;

public class MyArrayListTest extends TestCase {

	MyArrayList<Double> list;
	Random gen;
	int size;

	public MyArrayListTest(String arg0) {
		super(arg0);
		list = new MyArrayList<Double>();
		gen = new Random();
		size = 0;
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * on vérifie que la dernière valeur de la liste est bien celle qui a été
	 * ajoutée précédemment
	 */
	public void testAdd() {
		Double d = gen.nextDouble();
		list.add(d);
		size++;
		assertTrue(list.get(list.size() - 1).equals(d));
		assertTrue(list.get(list.size() - 1) == d);
	}

	/*
	 * on vérifie que la valeur contenu à une position est bien la valeur qu'on
	 * a modifié à cette même position précédemment
	 */
	public void testSet() {
		Double d = gen.nextDouble();
		Double d_after = gen.nextDouble();
		list.add(d);
		size++;
		list.set(0, d_after);
		assertTrue(list.get(0).equals(d_after));
		assertTrue(list.get(0) == d_after);
	}

	public void testSize() {
		assertTrue(list.size() == size);
	}

}

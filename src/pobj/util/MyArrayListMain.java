package pobj.util;

import java.util.Iterator;

public class MyArrayListMain {

	public static void main(String[] args) {
		MyArrayList<Integer> mylist = new MyArrayList<Integer>();
		System.out.println(mylist.size());
		System.out.println("Ajout de 100 éléments dans mylist");
		for (int i = 0; i < 100; i++) {
			mylist.add(new Integer(i));
			System.out.print(mylist.get(i) + "\n");
		}
		System.out.println("Taille de mylist : " + mylist.size());

		Iterator<Integer> iter = mylist.iterator();
		System.out.println("Iterator");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}

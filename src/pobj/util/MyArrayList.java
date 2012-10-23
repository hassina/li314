package pobj.util;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Classe d'une ArrayList personnalisée
 * 
 * @param <T>
 *            Type
 */
public class MyArrayList<T> extends AbstractList<T> implements Iterable<T> {
	private final static int DEFAULT_CAPACITY = 10;
	/**
	 * Taille par défaut d'un vecteur
	 */
	private LinkedList<Vector<T>> list;
	/**
	 * Liste de vecteurs de type générique
	 */
	private int capacity;

	/**
	 * Taille maximale des vecteurs
	 */

	/**
	 * Construit une liste personnalisée
	 * 
	 * @param capacity
	 *            Taille maximale des vecteurs
	 */

	public MyArrayList(int capacity) {
		list = new LinkedList<Vector<T>>();
		this.capacity = capacity;
	}

	/**
	 * Construit une liste personnalisée
	 */
	public MyArrayList() {
		list = new LinkedList<Vector<T>>();
		capacity = DEFAULT_CAPACITY;
	}

	public boolean add(T object) {
		if (list.isEmpty() || (list.getLast().size() == capacity)) {
			// System.err.println("Réallocation");
			list.add(new Vector<T>(capacity));
			return add(object);
		}
		return list.getLast().add(object);
	}

	public T get(int location) {
		return list.get(location / capacity).get(location % capacity);
	}

	public T set(int location, T object) {
		T previous = get(location);
		list.get(location / capacity).setElementAt(object, location % capacity);
		return previous;
	}

	public int size() {
		if (list.isEmpty()) {
			return 0;
		}
		return (list.size() - 1) * capacity + list.getLast().size();
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(list);
	}

}

/**
 * Classe d'itérateur pour la classe MyArrayList
 * 
 * @param <T>
 *            Type
 */

class MyIterator<T> implements Iterator<T> {

	private Iterator<T> vectIT;
	/**
	 * Itérateur sur un vecteur
	 */
	private Iterator<Vector<T>> listIT;

	/**
	 * Itérateur sur une liste
	 */

	/**
	 * Construit un itérateur pour la liste personnalisée
	 * 
	 * @param mylist
	 *            Liste personnalisée
	 */
	public MyIterator(List<Vector<T>> mylist) {
		listIT = mylist.iterator();
		vectIT = listIT.next().iterator();
	}

	@Override
	public boolean hasNext() {
		return vectIT.hasNext() || listIT.hasNext();
	}

	@Override
	public T next() {
		if (!vectIT.hasNext()) {
			vectIT = listIT.next().iterator();
			return next();
		}
		return vectIT.next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}

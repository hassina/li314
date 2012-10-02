package pobj.util;

import java.util.Collections;
import java.util.Vector;

public class MonVecteur implements Reversible {

	private Vector<MaChaine> v;

	public MonVecteur() {
		v = new Vector<MaChaine>();
	}

	public int size() {
		return v.size();
	}

	public void add(MaChaine o) {
		v.add(o);
	}

	public void remove(MaChaine o) {
		v.remove(o);
	}

	public MaChaine get(int index) {
		return v.get(index);
	}

	@Override
	public void reverse() {
		Collections.reverse(v);
	}

}

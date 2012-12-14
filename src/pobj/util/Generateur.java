package pobj.util;

import java.util.Random;

public class Generateur {

	private static final Generateur instance = new Generateur();
	private static Random rand = new Random();

	private Generateur() {
	}

	public static Generateur getInstance() {
		return instance;
	}

	public int nextInt() {
		return rand.nextInt();
	}

	public int nextInt(int i) {
		return rand.nextInt(i);
	}

	public double nextDouble() {
		return rand.nextDouble();
	}
}
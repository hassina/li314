package pobj.util;

import java.util.Random;

public class Generateur {

	private static Random singleton = new Random();

	private Generateur() {
	}

	public static Random getInstance() {
		return singleton;
	}
}
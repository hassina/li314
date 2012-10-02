package pobj.util;

public class MaChaine implements Reversible {

	private String str;

	@Override
	public void reverse() {
		str = reverseRec(str);
	}

	private String reverseRec(String str) {
		if (str.length() <= 1) {
			return str;
		}
		return reverseRec(str.substring(1, str.length())) + str.charAt(0);
	}
}

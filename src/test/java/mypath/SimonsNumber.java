package mypath;

public class SimonsNumber {
	private int num;
	public SimonsNumber(String s) {
		num = Integer.parseInt(s);
	}
	@Override
	public String toString() {
		return "I'm simon's number " + num;
	}
}

package flyweight;

enum Color {
	V,I,B,G,Y,O,R;
}

class RainbowColor {

	private Color name;
	
	private RainbowColor(Color name) { this.name = name; }
	private static final RainbowColor v = new RainbowColor(Color.V);
	private static final RainbowColor i = new RainbowColor(Color.I);
	private static final RainbowColor b = new RainbowColor(Color.B);
	private static final RainbowColor g = new RainbowColor(Color.G);
	private static final RainbowColor y = new RainbowColor(Color.Y);
	// ...
	
	public static RainbowColor getColor(Color name) {
		switch(name) {
		case V: return v;
		case I: return i;
		case B: return b;
		// ...
		}
		return null;	
	}
	
	@Override
	public String toString() {
		return "" + this.name;
	}
	
}

public class Runner {
	
	public static void main(String[] args) {
		System.out.println(RainbowColor.getColor(Color.B).hashCode());
		System.out.println(RainbowColor.getColor(Color.B).hashCode());
		System.out.println(RainbowColor.getColor(Color.B).hashCode());
	}
	
}

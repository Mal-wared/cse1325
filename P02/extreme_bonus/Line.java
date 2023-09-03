public class Line{
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private Color color;

	public Line(double x1, double y1, double x2, double y2, Color color){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public double length(){
		return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
	}

	public String toString(){
		String colorIntToHex = Integer.toHexString(color.asInt()).toUpperCase();
		String ansiReset = "\u001B[0m";
		int redValue =  Integer.parseInt(colorIntToHex.substring(0,2), 16);
		int greenValue = Integer.parseInt(colorIntToHex.substring(2,4), 16);
		int blueValue = Integer.parseInt(colorIntToHex.substring(4,6), 16);
		String ansiRgbColor = "\u001B[38;2;" + redValue + ";" + greenValue + ";" + blueValue + "m";
		String toString = String.format("%10s (%s0x%s%s) (%.3f, %.3f) - (%.3f, %.3f) has a length of ", color, ansiRgbColor, colorIntToHex, ansiReset, x1, y1, x2, y2) + length();
		return toString;
	}
}

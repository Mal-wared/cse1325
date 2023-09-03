public class TestLine{
	public static void main(String[] args){
		Line purple = new Line(6.111, 4.234, 1.234, 5.678, Color.PURPLE);
		System.out.println(purple.toString());

		Line hotPink = new Line(6.969, 0.420, 1.357, 2.468, Color.HOT_PINK);
		System.out.println(hotPink.toString());

		Line limeGreen = new Line(2.6754, 7.765, 9.999, 3.545, Color.LIME_GREEN);
		System.out.println(limeGreen.toString());

		Line pink = new Line(9.420, 4.420, 9.111, 8.001, Color.PINK);
		System.out.println(pink.toString());
	}
}

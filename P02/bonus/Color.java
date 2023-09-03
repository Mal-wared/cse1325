public enum Color{
	PURPLE(7497904),
	HOT_PINK(14453936),
	LIME_GREEN(3002912),
	PINK(15147424);

	private final int rgb;

	private Color(int rgb){
		this.rgb = rgb;
	}

	public int asInt(){
		return rgb;
	}
}

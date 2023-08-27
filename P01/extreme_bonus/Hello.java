public class Hello{
	public static void main(String[] args){
		String username = new String(System.getProperty("user.name"));
		System.out.println("hello, " + username);
	}
}

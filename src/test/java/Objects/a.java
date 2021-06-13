package Objects;

public class a {
	public boolean name(int k) {
		if(k!=3) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		a b= new a();
		if(b.name(3)) {
			System.out.println("Test Pass");
		}
	}
}

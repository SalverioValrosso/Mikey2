
public class Main {
	static boolean active = false;
	public static void main(String[] args) throws Exception {
		new Frame();
		
		while(true) {
			//System.out.println(active);
			if(active) {
				Moove.start();
			}
			Thread.sleep(500);
		}
		
	}

	public Main() {
		super();
	}

}
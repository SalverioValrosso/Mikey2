
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.util.HashMap;

public class Moove {
	public static final int FIVE_SECONDS = 7000;
	public static boolean positiveMoove = false;
	
	public static void start() throws Exception {
		Robot robot = new Robot();
		
		System.out.println("action");
		HashMap<String, Integer> xy = Moove.getPos();
		
		if(Moove.clock()) {
			robot.mouseMove(xy.get("x")+10, xy.get("y")+2);	
		}else {
			robot.mouseMove(xy.get("x")-10, xy.get("y")-2);					
		}
		
		Thread.sleep(FIVE_SECONDS);

	}
	
	
	public static HashMap<String,Integer> getPos() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		HashMap<String,Integer> xy = new HashMap<String, Integer>();
		int x = (int) b.getX();
		int y = (int) b.getY();
		System.out.println("y: "+y+" - x: "+x);
		xy.put("x", x);
		xy.put("y", y);
		return xy;
	}
	
	public static boolean clock() {
		if(Moove.positiveMoove) {
			Moove.positiveMoove=false;
		}else {
			Moove.positiveMoove=true;
		}
		return positiveMoove;
	}
	
}
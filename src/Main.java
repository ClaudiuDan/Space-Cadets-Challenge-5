import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	static double r, R, O, speed;
	static String color;
	public static void main (String[] args)
	{
		read ();
		launch ();
		
	}
	
	public static void read ()
	{
		//Reads all the required data
		Scanner scanner = new Scanner (System.in);
		System.out.println("Insert the speed (recommended 0.02): ");
		speed = scanner.nextDouble();
		System.out.println("Insert the small circle's radius: ");
		r = scanner.nextDouble();
		System.out.println("Insert the big circle's radius: ");
		R = scanner.nextDouble();
		System.out.println("Insert the offset: ");
		O = scanner.nextDouble();
		System.out.println("Insert the color: ");
		color = scanner.nextLine();
		color = scanner.nextLine();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Hypocycloid hypo = new Hypocycloid (r, R, O, color, speed);
		stage.setScene (new Scene (hypo.createScene()));
		stage.show();
	}
}

import static java.lang.Math.sin;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static java.lang.Math.*;
public class Hypocycloid{
	double r, R, O, speed;
	String color;
	Hypocycloid (double r, double R, double O, String color, double speed) 
	{
		this.r = r;
		this.R = R;
		this.color = color;
		this.speed = speed;
	}
	private GraphicsContext g;
	private double t = 0.0;
	Parent createScene ()
	{
		Pane root = new Pane ();
		//sets the window's size
		root.setPrefSize(800, 600);
		//sets the drawable window's size
		Canvas canvas = new Canvas (800, 600);
		AnimationTimer timer = new AnimationTimer()
			{
				@Override
				public void handle (long now) {
					t += speed;
					paint ();
				}
				
			};
		timer.start();
		g = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		return root;
		
	}
	private void paint () {
		// gets the coordinates from the formula
		Point2D p = getPoint ();
		// Sets the required color
		if (color.contains("black"))
			g.setStroke(Color.BLACK);
		if (color.contains("red"))
			g.setStroke(Color.RED);
		if (color.contains("green"))
			g.setStroke(Color.GREEN);
		if (color.contains("blue"))
			g.setStroke(Color.AQUAMARINE);
		// the position in windows where it is drawn followed by the coordinates obtained using the formula
		double newX = 400 + p.getX();
		double newY = 300 + p.getY();
		g.strokeOval(newX,  newY,  3, 3);
	}
	private Point2D getPoint ()
	{
		double x = (R+r)*cos(t) - (r + O)*cos(((R+r)/r)*t);
		double y = (R+r)*sin(t) - (r + O)*sin(((R+r)/r)*t);
		return new Point2D(x, y).multiply(20);
	}
}

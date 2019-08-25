import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	String direction = "none";
	int speed;

	public Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
	}

	public void update() {
		// left
		if (direction.equalsIgnoreCase("left")) {
			x -= (5+speed);
		}
		// right
		else if (direction.equalsIgnoreCase("right")) {
			x += (5+speed);
		}
		// forward
		else if (direction.equalsIgnoreCase("forward")) {
			y -= (5+speed);
		}
		// back
		else if (direction.equalsIgnoreCase("back")) {
			y += (5+speed);
		}
		
}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}

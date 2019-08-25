import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Box.Filler;

public class Projectile extends GameObject {
	int speed = 10;
	String direction;

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		if (direction.equalsIgnoreCase("left")) {
			x -= (5 + speed);
		}
		// right
		else if (direction.equalsIgnoreCase("right")) {
			x += (5 + speed);
		}
		// forward
		else if (direction.equalsIgnoreCase("forward")) {
			y -= (5 + speed);
		}
		// back
		else if (direction.equalsIgnoreCase("back")) {
			y += (5 + speed);
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		fillrect
	}
}

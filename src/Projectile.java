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
		super.update();
		y -= speed;
		if (y <= 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}

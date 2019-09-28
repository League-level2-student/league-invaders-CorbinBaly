import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.Box.Filler;

public class Alien extends GameObject {
	int x;
	int y;
	int width;
	int height;

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

	void update() {
		super.update();
		y += 7;
if(y<800) {
	
}
	}
}

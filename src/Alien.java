import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.Box.Filler;

public class Alien extends GameObject {
	
	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

	void update() {
		super.update();
		y += 7;
	}
}

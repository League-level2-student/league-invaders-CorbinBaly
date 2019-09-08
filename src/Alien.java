import java.awt.Color;
import java.awt.Graphics;

public class Alien extends ObjectManager{

	public Alien(Rocketship rocketship) {
		super(rocketship);
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}

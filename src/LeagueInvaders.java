import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	final int width = 500;
	final int height = 800;
	JFrame frame;
	GamePanel gamepanel;

	public LeagueInvaders() {
		frame = new JFrame();
		gamepanel = new GamePanel();
	}

	void setup() {
		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		gamepanel.startGame();
	}

	public static void main(String[] args) {
		LeagueInvaders invader = new LeagueInvaders();
		invader.setup();
	}
}

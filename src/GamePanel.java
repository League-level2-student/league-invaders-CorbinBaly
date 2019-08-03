import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
GameObject gameobjects;
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		gameobjects = new GameObject(10, 10, 100, 100);
	}

	void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	repaint();
	}

	@Override

	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		gameobjects.draw(g);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyPressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyReleased");
	}
}

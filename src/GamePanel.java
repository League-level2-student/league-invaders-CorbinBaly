import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font enterFont;
	Font instructionFont;
	String direction = "none";
	int rocketx = 100;
	int rockety = 100;
	ObjectManager objectmanager = new ObjectManager();
	Rocketship rocketship = new Rocketship(rocketx, rockety, 50, 50, 5, direction);

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 30);
		instructionFont = new Font("Arial", Font.PLAIN, 30);
	}

	void updateMenuState() {

	}

	void updateEndState() {

	}

	void updateGameState() {
		objectmanager.draw(g);
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(enterFont);
		g.drawString("Press ENTER to start", 130, 350);
		g.setFont(instructionFont);
		g.drawString("Press SPACE for instructions", 75, 500);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		rocketship.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	}

	void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(direction);
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 10 && currentState != 2) {
			currentState++;
		} else if (e.getKeyCode() == 10 && currentState == 2) {
			currentState = 0;
		}
		// left
		if (e.getKeyCode() == 37) {
			rocketship.direction = "left";
		}
		// right
		else if (e.getKeyCode() == 39) {
			rocketship.direction = "right";
		}
		// back
		else if (e.getKeyCode() == 38) {
			rocketship.direction = "back";
		}
		// forward
		else if (e.getKeyCode() == 40) {
			rocketship.direction = "forward";
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyReleased");
		rocketship.direction = "none";
	}
}

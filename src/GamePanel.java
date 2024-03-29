import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	int rocketx = 100;
	int rockety = 100;
	int projectilesshot;
	Rocketship rocketship;
	ObjectManager objectmanager;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 30);
		instructionFont = new Font("Arial", Font.PLAIN, 30);
		rocketship = new Rocketship(rocketx, rockety, 50, 50, 5);
		objectmanager = new ObjectManager(rocketship);
		try {

			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	void updateMenuState() {

	}

	void updateEndState() {

	}

	void updateGameState() {
		objectmanager.update();
		objectmanager.manageEnemies();
		objectmanager.checkCollision();
		objectmanager.purgeObjects();
		if (rocketship.isAlive == false) {
			System.out.println("ded");
			currentState = END_STATE;
		}
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
		g.drawImage(spaceImg,0,0, LeagueInvaders.width, LeagueInvaders.height, null);


		objectmanager.draw(g);
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
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println(e.getKeyCode());
		System.out.println(rocketship.direction);
		if (e.getKeyCode() == 10 && currentState != 2) {
			currentState++;
			rocketship.isAlive = true;
		} else if (e.getKeyCode() == 10 && currentState == 2) {
			currentState = 0;
			if (currentState == 2) {
				objectmanager = new ObjectManager(rocketship);
				rocketship = new Rocketship(rocketx, rockety, 50, 50, 5);

			}
		}
		// left
		if (e.getKeyCode() == 37) {
			rocketship.direction = "left";
		}
		// right
		else if (e.getKeyCode() == 39) {
			rocketship.direction = "right";
		}
		// forward
		else if (e.getKeyCode() == 40) {
			rocketship.direction = "back";
		}
		// back
		else if (e.getKeyCode() == 38) {
			rocketship.direction = "forward";
		}
		if (e.getKeyCode() == 32) {
			objectmanager.addProjectile(new Projectile(rocketship.x + 20, rocketship.y + 15, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		rocketship.direction = "none";
	}
}

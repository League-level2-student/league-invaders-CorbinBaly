import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	Rocketship rocketship;
	long enemySpawnTime = 1500;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer;
	int score;

	public ObjectManager(Rocketship rocketship) {
		this.rocketship = rocketship;
	}

	public void purgeObjects() {
		for (int i = aliens.size() - 1; i >= 0; i--) {
			if (aliens.get(i).isAlive == false) {
				aliens.remove(aliens.get(i));
			}
		}
		for (int i = projectiles.size() - 1; i >= 0; i--) {
			if (projectiles.get(i).isAlive == false) {
				projectiles.remove(projectiles.get(i));
			}
		}

	}

	void draw(Graphics g) {
		rocketship.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
	}

	void update() {
		rocketship.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
	}
 public int getScore(int score) {
	 return score;
 }
	void addProjectile(Projectile thisprojectile) {
		projectiles.add(thisprojectile);
	}

	void addAlien(Alien useralien) {
		aliens.add(useralien);
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (rocketship.collisionBox.intersects(a.collisionBox)) {
				a.isAlive = false;
				rocketship.isAlive = false;
				System.out.println(rocketship.isAlive);
			}

			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					a.isAlive = false;
					p.isAlive = false;
					score++;
					getScore(score);
					System.out.println();
				}
			}
		}

	}

	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width-50), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

}

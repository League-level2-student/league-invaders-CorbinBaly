import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	Rocketship rocketship;
	long enemySpawnTime;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer;

	public ObjectManager(Rocketship rocketship) {
		this.rocketship = rocketship;
	}

	public void purgeObjects() {
		for (Alien alien : aliens) {
			if(alien.isAlive==false) {
				aliens.remove(alien);
			}
		}
			for (Projectile projecti : projectiles) {
				if(projecti.isAlive==false) {
					projectiles.remove(projecti);
				}
			}
		}
	
	

	void draw(Graphics g) {
		rocketship.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
			aliens.get(i).draw(g);
		}
	}

	void update() {
		rocketship.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			aliens.get(i).update();
		}
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

				rocketship.isAlive = false;
			}

			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					a.isAlive = false;
					p.isAlive = false;
				}
			}
		}

	}

	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

}

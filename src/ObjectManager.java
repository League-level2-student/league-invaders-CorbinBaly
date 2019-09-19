import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocketship;
long enemySpawnTime;
ArrayList<Projectile> projectiles= new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
long enemyTimer;
public ObjectManager(Rocketship rocketship){
	this.rocketship = rocketship;
}


void purgeObjects(Graphics g) {
	for (int i = 0; i < aliens.size(); i++) {
		if (aliens.get(i).isAlive==false) {
		aliens.remove(i);
		}
		if(projectiles.get(i).isAlive==false) {
			projectiles.remove(i);
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
public void manageEnemies(){
    

	if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
    }
}


}

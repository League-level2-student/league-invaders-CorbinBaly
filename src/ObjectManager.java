import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
Rocketship rocketship;
ArrayList<Projectile> projectiles= new ArrayList<Projectile>();
public ObjectManager(Rocketship rocketship){
	this.rocketship = rocketship;
}
void draw(Graphics g) {
	rocketship.draw(g);
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).draw(g);
	}
}
void update() {
	rocketship.update();
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).update();
	}
}

void addProjectile(Projectile thisprojectile) {
	projectiles.add(thisprojectile);
}
}

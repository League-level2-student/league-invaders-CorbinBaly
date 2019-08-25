import java.awt.Graphics;

public class ObjectManager {
Rocketship rocketship;
public ObjectManager(Rocketship rocketship){
	this.rocketship = rocketship;
}
void draw(Graphics g) {
	rocketship.draw(g);
}
void update() {
	rocketship.update();
}
}

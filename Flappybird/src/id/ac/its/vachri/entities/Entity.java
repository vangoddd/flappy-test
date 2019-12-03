package id.ac.its.vachri.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	protected int x, y;
	protected Rectangle boundingBox;
	protected int width, height;
	protected float speedX, speedY;
	
	public Entity() {
		boundingBox = new Rectangle(x, y, width, height);
	}
	
	protected void move() {
		x += (int) speedX;
		y += (int) speedY;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, boundingBox.width, boundingBox.height);
	}
}

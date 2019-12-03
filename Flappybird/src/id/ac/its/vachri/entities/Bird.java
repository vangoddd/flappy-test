package id.ac.its.vachri.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Bird extends Entity{
	
	private float gravity = (float) 0.1;
	
	public Bird(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 10;
		this.speedX = 0;
		this.speedY = 0;
	}

	@Override
	public void tick() {
		this.speedY += (int) gravity;
		move();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

}

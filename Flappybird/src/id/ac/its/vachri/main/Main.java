package id.ac.its.vachri.main;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import id.ac.its.vachri.entities.Bird;

public class Main {
	
	private JFrame frame;
	private int width = 600;
	private int height = 500;
	private boolean running = false;
	private Graphics g;
	private Bird b;
	
	public Main() {
		createFrame();
		running = true;
		g = frame.getGraphics();
		
		b = new Bird(50, height/2);
	}
	
	private void createFrame() {
		frame = new JFrame("Flappy Bird");
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	public void play() {
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >=1) {
				tick();
				render(g);
				delta--;
				ticks++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames : " + ticks);
				ticks = 0;
				timer = 0;
				
			}
		}
	}
	
	private void tick() {
		b.tick();
	}
	
	private void render(Graphics g) {
		
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, width, height);
		g.clearRect(0, 0, width, width);
		b.render(g);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
	
}

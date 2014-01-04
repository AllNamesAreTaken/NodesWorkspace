package com.wdh.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.wdh.nodes.NodesGame;

public class Player extends GameObject{
	
	private boolean left;
	private boolean right;
	private boolean up;
	
	private float maxSpeed;
	private float acceleration;
	private float deceleration;
	
	public Player() {
		x = NodesGame.resW / 2;
		y = NodesGame.resH / 2;
		
		maxSpeed = 300;
		acceleration = 200;
		deceleration = 10;
		
		shapex = new float[4];
		shapey = new float[4];
		
		radians = 3.1415f / 2;
		rotationSpeed = 3;
		speed = 3;
	}
	
	private void setShape() {
		shapex[0] = x + MathUtils.cos(radians)*8;
		shapey[0] = y + MathUtils.sin(radians)*8;
		
		shapex[1] = x + MathUtils.cos(radians - 4 * 3.1415f / 5) * 8;
		shapey[1] = y + MathUtils.sin(radians - 4 * 3.1415f / 5) * 8;
		
		shapex[2] = x + MathUtils.cos(radians + 3.1415f) * 5;
		shapey[2] = y + MathUtils.sin(radians + 3.1415f) * 5;
		
		shapex[3] = x + MathUtils.cos(radians + 4 * 3.1415f / 5) * 8;
		shapey[3] = y + MathUtils.sin(radians + 4 * 3.1415f / 5) * 8;
	}

	public void setLeft(boolean b) { left = b;}
	public void setRight(boolean b) { right = b;}
	public void setUp(boolean b) { up = b; }
	
	public void update(float dt) {
		if(left) {
			radians += rotationSpeed * dt;
		}
		else if(right) {
			radians -= rotationSpeed * dt;
		}
		
		if(up) {
			dx += MathUtils.cos(radians) * acceleration * dt;
			dy += MathUtils.sin(radians) * acceleration * dt;
		}
		
		float vec = (float) Math.sqrt(dx * dx + dy * dy);
		if(vec > 0) {
			dx -= (dx / vec) * deceleration * dt;
			dy -= (dy / vec) * deceleration * dt;
		}
//		if(vec > maxSpeed) {
//			dx -= (dx / vec) * maxSpeed * dt;
//			dy -= (dy / vec) * maxSpeed * dt;
//		}
		
		x += dx * dt;
		y += dy * dt;
		
		setShape();
		
		wrap();
	}
	
	public void draw(ShapeRenderer sr) {
		sr.setColor(1,1,1,1);
		sr.begin(ShapeType.Line);
		for(int i = 0, j = shapex.length - 1; 
				i < shapex.length; 
				j = i++) {
			sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);
		}
		sr.end();
	}
}

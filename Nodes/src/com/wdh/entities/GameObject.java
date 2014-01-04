package com.wdh.entities;

import com.wdh.nodes.NodesGame;

public class GameObject {

	protected float x;
	protected float y;
	
	protected float dx;
	protected float dy;
	
	protected float radians;
	protected float speed;
	protected float rotationSpeed;
	
	protected int width;
	protected int height;
	
	protected float[] shapex;
	protected float[] shapey;
	
	protected void wrap() {
		if(x < 0) x = NodesGame.resW;
		if(x > NodesGame.resW) x = 0;
		if(y < 0) y = NodesGame.resH;
		if(y > NodesGame.resH) y = 0;
	}
}

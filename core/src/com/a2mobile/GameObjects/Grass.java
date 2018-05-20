package com.a2mobile.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Grass {

	public static final int HEIGHT = 30;
	private Vector2 position;
	private int width;
	private int height;

	private Rectangle boundingRect;

	public Grass(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		boundingRect = new Rectangle();
        
        boundingRect.set(position.x, position.y , width, height); 
	}

	public Rectangle getBoundingShape() {
		return this.boundingRect;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}

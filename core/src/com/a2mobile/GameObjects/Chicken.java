package com.a2mobile.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Chicken {

	private static int BASKET_END = 3;
	private Vector2 position;

	private float rotation;
	private int width;
	private int height;

	private Rectangle boundingRect;

	private boolean moving;

	public Chicken(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		boundingRect = new Rectangle(position.x - 5, position.y + height - BASKET_END, width * 10, BASKET_END * 10); 
	}

	public void update(float delta, float runtime) {

		if (!this.moving && runtime % 5 < 1)
			this.moving = true;

		if (this.moving && runtime % 5 > 2)
			this.moving = false;

	}

	public boolean isMoving() {
		return this.moving;
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

	public float getRotation() {
		return rotation;
	}

	public Rectangle getBoundingShape() {
		return this.boundingRect;
	}
}

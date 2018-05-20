package com.a2mobile.GameObjects;

import com.a2mobile.GameWorld.GameWorld;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Hero {
	
//	private static int MOVE_VELOCITY = 100;
	private float delayToArrive = 0.25f;
	public static float BOUNCING_TIME = .12f;
	public static float DEFAULT_DELAY =  0.25f;
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation;
	private int width;
	private int height;

	// Timers
	private float runtime;
	private float startMoving = -1;
	private float startBouncing = -1;

	private int targetPosition = 0;

	private Circle boundingCircle;

	private boolean bouncing = false;
	private boolean moving = false;

	public Hero(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		boundingCircle = new Circle();
	}

	public void set(float x, float y, int width, int height, int targetPosition) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		boundingCircle = new Circle();	
		this.targetPosition = targetPosition;
	}
	
	public void update(float delta, float runtime) {

		this.runtime = runtime;
		
		velocity.add(acceleration.cpy().scl(delta));

		if(startMoving != -1 && runtime - startMoving >= delayToArrive){
			acceleration.x = 0;
			velocity.x = 0;
			position.x = GameWorld.fixedPositions[targetPosition];
			startMoving = -1;
			moving = false;
		}
		if(startBouncing != -1 && runtime - startBouncing >= BOUNCING_TIME){
			startBouncing = -1;
			bouncing = false;
		}

		position.add(velocity.cpy().scl(delta));
        
        boundingCircle.set(position.x + width / 4 * 1, position.y + height / 2 , width / 4); 

	}

	public void onCollide() {
		startBouncing = runtime;
		this.bouncing = true;
	}
	
	public void moveLeft() {
		targetPosition = Math.max(targetPosition - 1, 0);
		updateSpeed();
		
	}
	
	public void moveRight() {
		targetPosition = Math.min(targetPosition + 1, GameWorld.fixedPositions.length - 1);
		updateSpeed();
	}

	private void updateSpeed() {
		
		startMoving = runtime;
		
		moving = true;
		
		float delta = GameWorld.fixedPositions[targetPosition] - position.x;
		
		if(delta != 0){
			
			velocity.x = 2 * delta / delayToArrive;

			acceleration.x = - velocity.x / delayToArrive;

//			System.out.println("DLT: " + delta + " SPDX: " + velocity.x + " ACCX: " + acceleration.x);
			
		}
		
	}

	public boolean isBouncing() {
		return bouncing;
	}

	public boolean isMoving() {
		return moving;
	}

	public float getTargetX(){
		return GameWorld.fixedPositions[this.targetPosition];
	}
	
	public float getTargetPosition(){
		return this.targetPosition;
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

	public Circle getBoundingShape() {
		return this.boundingCircle;
	}

	public boolean isMovingLeft() {
		return this.velocity.x < 0;
	}

	public boolean isMovingRight() {
		return this.velocity.x > 0;
	}
	
	public void setDelayToArrive(float delay){
		this.delayToArrive = delay;
	}

}
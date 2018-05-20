package com.a2mobile.GameObjects;

import com.a2mobile.GameWorld.GameWorld;
import com.a2mobile.Helpers.AssetLoader;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class Egg {

	protected static int DEAD_TIME = 2;
	public static int JUMP_CONST = 100;

	protected Vector2 position;
	protected Vector2 velocity;
	protected Vector2 acceleration;

	protected float gameSpeed = 1;

	protected float rotation;
	protected int width;
	protected int height;

	// Timers
	protected float runtime;
	protected float starDeath = -1;

	protected int targetPosition = 0;

	protected int value = 1;

	protected boolean alive = true, scored = false;
	protected Circle boundingCircle;
	protected int lifeAmount = 1;
	protected EggType eggType = EggType.NORMAL;
	protected TextureRegion eggSprite, deadEggSprite;

	public enum EggType {
		NORMAL, LIFE_EGG, BOMB_EGG, SLOW_EGG, FAST_EGG, NINJA_EGG, SURVIVAL_EGG, SURVIVAL_LIFE_EGG
	}

	public Egg(float x, float y, int width, int height) {
		this(x, y, width, height, 0);
	}

	public Egg(float x, float y, int width, int height, int targetPosition) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, JUMP_CONST);
		boundingCircle = new Circle();
		this.targetPosition = targetPosition;
		eggSprite = AssetLoader.egg;
		deadEggSprite = AssetLoader.deadEgg;
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

		if (alive) {

			velocity.add(acceleration.cpy().scl(delta * gameSpeed));

			position.add(velocity.cpy().scl(delta * gameSpeed));

			if (isFalling())
				this.rotation += 200 * delta * gameSpeed;
		} else {
			if (starDeath != -1 && runtime - starDeath >= DEAD_TIME) {
				starDeath = -1;
				destroy();
			}
		}

		boundingCircle.set(position.x + width / 2, position.y + height / 2,
				width / 2);

	}

	public void heroCollide(Hero hero) {
		this.position.y = hero.getY() - 8;
		jump();
	}

	public void die(GameWorld world) {
		starDeath = runtime;
		this.alive = false;
		velocity.y = 0;
		velocity.x = 0;
		acceleration.x = 0;
		acceleration.y = 0;
		rotation = 0;
		AssetLoader.play(AssetLoader.die);
	}

	public void score(GameWorld world) {
		AssetLoader.play(AssetLoader.point, 0.5f);
		this.scored = true;
		destroy();
	}

	public void reset() {
		this.alive = true;
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, JUMP_CONST);
		targetPosition = 0;
		this.position.x = GameWorld.fixedPositions[0] + 5;
		this.position.y = 0;
	}

	public void jump() {

		targetPosition = Math.min(targetPosition + 1,
				GameWorld.fixedPositions.length);
		AssetLoader.play(AssetLoader.jump);

		velocity.y = -JUMP_CONST;

		updateSpeed();
	}

	public void updateSpeed() {

		float delta;

		if (targetPosition == GameWorld.fixedPositions.length)
			delta = GameWorld.basketPosition - position.x;
		else
			delta = GameWorld.fixedPositions[targetPosition] - position.x;

		if (delta != 0) {

			velocity.x = (delta + 5) / 2 ;

		}
	}

	public void draw(SpriteBatch batcher) {
		if (this.isAlive())
			batcher.draw(this.eggSprite, this.getX(), this.getY(),
					this.getWidth() / 2.0f, this.getHeight() / 2.0f,
					this.getWidth(), this.getHeight(), 1, 1, this.getRotation());
		else
			batcher.draw(this.deadEggSprite, this.getX(), this.getY(),
					this.getWidth() / 2.0f, this.getHeight() / 2.0f,
					this.getWidth(), this.getHeight(), 1, 1, this.getRotation());
	}

	public void destroy() {
		// alive = false;
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, JUMP_CONST);
		targetPosition = 0;
		this.position.x = -this.width * 10;
		this.position.y = -this.height * 10;
	}

	public boolean isFalling() {
		return velocity.y > 0;
	}

	public boolean isAlive() {
		return alive;
	}

	public boolean isScored() {
		return scored;
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

	public float getValue() {
		return value;
	}

	public Circle getBoundingShape() {
		return boundingCircle;
	}

	public boolean collidesHero(Hero hero) {
		return (Intersector.overlaps(this.getBoundingShape(),
				hero.getBoundingShape()));
	}

	public boolean collidesGrass(Grass grass) {
		return (Intersector.overlaps(this.getBoundingShape(),
				grass.getBoundingShape()));
	}

	public boolean collidesChicken(Chicken chicken) {
		return (Intersector.overlaps(this.getBoundingShape(),
				chicken.getBoundingShape()));
	}

	public float getGameSpeed() {
		return gameSpeed;
	}

	public void setGameSpeed(float gameSpeed) {
		this.gameSpeed = gameSpeed;

	}

	public int lifeAmount() {
		return lifeAmount;
	}

}

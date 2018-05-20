package com.a2mobile.GameObjects;

import com.a2mobile.GameWorld.GameWorld;

import java.util.ArrayList;

public class Eggs extends ArrayList<Egg> {
	private static final long serialVersionUID = 1L;
	private GameWorld world;
	private float gameSpeed = 1;

	public Eggs(GameWorld world) {

		this.world = world;
		this.gameSpeed = world.getSpeed();
	}

	public void update(float delta, float runtime) {
		for (Egg egg : this) {
			egg.update(delta, runtime);
		}
	}

	public void checkCollisions(Hero hero, Grass grass, Chicken chicken) {
		for (Egg egg : this) {
			if (egg.isAlive())
				if (egg.collidesHero(hero)) {
					egg.heroCollide(hero);
					hero.onCollide();
				} else if (egg.collidesGrass(grass)) {
					if (egg.targetPosition != GameWorld.fixedPositions.length) {
						world.informDead(egg.lifeAmount());
						egg.die(world);
					}else{
						egg.score(world);
						world.informScored(egg.getValue());
					}
				} else if (egg.collidesChicken(chicken)) {
					egg.score(world);
					world.informScored(egg.getValue());
				}
		}
	}

	public boolean anyDead() {

		for (Egg egg : this) {
			if (!egg.isAlive())
				return true;
		}
		return false;
	}

	public boolean allScored() {

		for (Egg egg : this) {
			if (!egg.isScored())
				return false;
		}

		return true;
	}

	public void reset() {
		this.removeRange(0, this.size());
	}

	public void setSpeed(float speed) {
		this.gameSpeed = speed;
		for (Egg egg : this) {
			egg.setGameSpeed(gameSpeed);
		}
	}

	@Override
	public boolean add(Egg egg) {

		// egg.setGameSpeed(gameSpeed);

		return super.add(egg);

	}

}

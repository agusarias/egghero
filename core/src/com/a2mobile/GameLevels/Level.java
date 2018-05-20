package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg;
import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameObjects.Eggs;
import com.a2mobile.GameObjects.LifeEgg;
import com.a2mobile.GameWorld.GameWorld;

public abstract class Level {

	protected int totalEggs, releasedEggs = 0;
	protected EggType[] eggTypes;

	protected int scoredEggs = 0, deadEggs = 0;

	// Timers
	protected float startLevelTime;
	protected float[] eggAppearTimes;
	protected int[] eggAppearTargetPositions;
	protected GameWorld world;
	protected Eggs eggs;
	protected float speed = 1.0f;

	public Level(GameWorld gameWorld) {
		this.world = gameWorld;
		this.speed = gameWorld.getSpeed();
	}

	public float getStartLevelTime() {
		return this.startLevelTime;
	}

	public void start(float runtime) {
		this.startLevelTime = runtime;
	}

	public void update(float delta, float runtime) {
		if (releasedEggs != totalEggs) {

			if (runtime - startLevelTime > this.eggAppearTimes[this.releasedEggs]
					/ this.speed) {

				Egg egg;

				switch (this.eggTypes[this.releasedEggs]) {
				case LIFE_EGG:
					egg = new LifeEgg(
							GameWorld.fixedPositions[eggAppearTargetPositions[this.releasedEggs]] + 3,
							-Egg.JUMP_CONST, 8, 8,
							eggAppearTargetPositions[this.releasedEggs]);
					break;
				case NORMAL:
				default:
					egg = new Egg(
							GameWorld.fixedPositions[eggAppearTargetPositions[this.releasedEggs]] + 3,
							-Egg.JUMP_CONST, 8, 8,
							eggAppearTargetPositions[this.releasedEggs]);
					break;
				}
				
				egg.setGameSpeed(speed);

				this.eggs.add(egg);
				this.releasedEggs++;
			}

		}

		if (world.getLifes() <= 0)
			this.lose();
		else if (scoredEggs + deadEggs == totalEggs)
			this.win();

	}

	public void win() {
		this.world.informWin();
	}

	public void lose() {
		this.world.informLose();
	}

	public void addScored() {
		this.scoredEggs++;
	}

	public void addDead() {
		this.deadEggs++;
	}

	public String getResultMessage() {

		if (deadEggs < totalEggs / 3)
			return "GREAT!";
		if (deadEggs < totalEggs / 3 * 2)
			return "GOOD!";
		else
			return "NOT BAD!";

	}

	public abstract Level getNextLevel();

	public abstract String getLevelNumber();

}

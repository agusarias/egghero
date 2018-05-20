package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level4_3 extends Level {

	public Level4_3(GameWorld gameWorld) {
		super(gameWorld);
		this.speed = 1.2f;

		this.totalEggs = 6;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[] { 0.0f, 0.3f, 0.6f, 0.9f, 1.2f, 1.5f };
		this.eggAppearTargetPositions = new int[] { 0, 1, 0, 1, 0, 1};

		for (int i = 0; i < totalEggs; i++) {
			this.eggTypes[i] = EggType.NORMAL;
		}
		this.eggs = gameWorld.getEggs();

	}

	@Override
	public String getLevelNumber() {
		return "Level 4 - 3";
	}

	@Override
	public Level getNextLevel() {
		return new Level4_4(world);
	}
}
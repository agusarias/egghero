package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level4_5 extends Level {

	public Level4_5(GameWorld gameWorld) {
		super(gameWorld);
		this.speed = 1.3f;

		this.totalEggs = 10;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[] { 0.0f, 0.3f, 0.6f, 0.9f, 1.2f, 1.5f , 5.8f , 6.1f, 6.4f, 6.7f};
		this.eggAppearTargetPositions = new int[] { 0, 1, 0, 1, 0, 1, 3, 4, 3, 4};

		for (int i = 0; i < totalEggs; i++) {
			this.eggTypes[i] = EggType.NORMAL;
		}
		
		gameWorld.getHero().setDelayToArrive(0.2f);
		
		this.eggs = gameWorld.getEggs();

	}

	@Override
	public String getLevelNumber() {
		return "Level 4 - 5";
	}

	@Override
	public Level getNextLevel() {
		return new Level4_5(world);
	}
}
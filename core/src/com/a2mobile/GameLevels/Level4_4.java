package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level4_4 extends Level {

	public Level4_4(GameWorld gameWorld) {
		super(gameWorld);
		this.speed = 1.3f;

		this.totalEggs = 7;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[] { 0.0f, 0.3f, 0.6f, 0.9f, 1.2f, 1.5f , 1.8f , 2.1f};
		this.eggAppearTargetPositions = new int[] { 0, 1, 2, 3, 4, 3, 2};

		for (int i = 0; i < totalEggs; i++) {
			this.eggTypes[i] = EggType.NORMAL;
		}
		
		gameWorld.getHero().setDelayToArrive(0.2f);
		
		this.eggs = gameWorld.getEggs();

	}

	@Override
	public String getLevelNumber() {
		return "Level 4 - 4";
	}

	@Override
	public Level getNextLevel() {
		return new Level4_5(world);
	}
}
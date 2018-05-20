package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level3_4 extends Level {

	public Level3_4(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 10;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[] { 0.0f, 0.1f, 0.3f, 0.6f, 0.9f, 1.0f, 1.2f, 1.5f, 1.8f, 1.9f};
		this.eggAppearTargetPositions = new int[] { 3, 3, 2, 1, 0,0, 1, 2, 3, 3};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		this.eggs = gameWorld.getEggs();
		this.eggs.reset();
	}

	@Override
	public String getLevelNumber(){
		return "Level 3 - 4";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level3_5(world);
	}
}
package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level2_1 extends Level {

	public Level2_1(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 3;
		this.eggTypes = new EggType[totalEggs];		
		this.eggAppearTimes = new float[] { 0.0f, 0.5f, 1.0f};
		this.eggAppearTargetPositions = new int[] { 3, 2, 1};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 2 - 1";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level2_2(world);
	}
}
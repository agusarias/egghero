package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level3_1 extends Level {

	public Level3_1(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 5;
		this.eggTypes = new EggType[totalEggs];		
		this.eggAppearTimes = new float[] { 0.0f, 2.1f, 3.7f, 5.2f, 7.5f, 8.1f};
		this.eggAppearTargetPositions = new int[] { 4, 2, 4, 2, 4, 2};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 3 - 1";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level3_2(world);
	}
}
package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level2_2 extends Level {

	public Level2_2(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 6;
		this.eggTypes = new EggType[totalEggs];		
		this.eggAppearTimes = new float[] { 0.0f, 0.1f, 
											0.6f, 0.7f, 
											1.2f, 1.3f};
		this.eggAppearTargetPositions = new int[] { 3,3, 2,2, 1,1};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 2 - 2";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level2_3(world);
	}
}
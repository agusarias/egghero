package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level1_3 extends Level {

	public Level1_3(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 3;
		this.eggTypes = new EggType[totalEggs];		
		this.eggAppearTimes = new float[] { 0.0f, 0.6f, 1.3f};
		this.eggAppearTargetPositions = new int[] { 0, 1, 2};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		
		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 1 - 3";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level1_4(world);
	}
}
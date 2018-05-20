package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level1_4 extends Level {

	public Level1_4(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 4;
		this.eggTypes = new EggType[totalEggs];		
		this.eggAppearTimes = new float[] { 0.0f, 0.4f, 0.8f, 1.2f};
		this.eggAppearTargetPositions = new int[] { 0, 1, 2, 3};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 1 - 4";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level1_5(world);
	}
}
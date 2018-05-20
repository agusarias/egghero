package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level2_3 extends Level {

	public Level2_3(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 12;
		this.eggTypes = new EggType[totalEggs];		
		float interval = 3f;
		this.eggAppearTimes = new float[] { 0.0f, 0.5f, 1.5f, 
				interval + 0.0f, interval + 0.5f, interval + 1.5f,
				interval * 2 + 0.0f, interval * 2+ 0.5f, interval * 2+ 1.5f,
				interval * 3 + 0.0f, interval * 3 + 0.5f, interval * 3 + 1.5f};
		this.eggAppearTargetPositions = new int[] { 4,3,2,
													4,3,2,
													4,3,2,
													4,3,2};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}

		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 2 - 3";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level2_4(world);
	}
}
package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level3_5 extends Level {

	public Level3_5(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 9;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[] { 0.0f, 0.3f, 0.6f, 0.9f, 1.2f, 1.5f, 1.8f, 2.1f, 2.4f, 2.7f, 3.0f};
		this.eggAppearTargetPositions = new int[] { 4, 3, 2, 1, 0, 1, 2, 3, 4};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		this.eggs = gameWorld.getEggs();
		this.eggs.reset();
	}

	@Override
	public String getLevelNumber(){
		return "Level 3 - 5";
	}
	
	@Override
	public Level getNextLevel() {
		if(world.getLifes() >= GameWorld.AMOUNT_OF_LIFES)
			return new Level3_B(world);
		else
			return new Level4_1(world);
	}
}
package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level1_5 extends Level {

	public Level1_5(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 10;
		this.eggTypes = new EggType[totalEggs];		
		this.eggAppearTimes = new float[] { 0.0f, 0.4f, 0.5f, 2.5f, 2.6f, 2.7f, 4.7f, 4.8f, 4.9f, 5f};
		this.eggAppearTargetPositions = new int[] { 0, 1, 1, 2, 2, 2, 3,3,3,3};

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 1 - 5";
	}
	
	@Override
	public Level getNextLevel() {
		if(world.getLifes() >= GameWorld.AMOUNT_OF_LIFES)
			return new Level1_B(world);
		else
			return new Level2_1(world);
	}
}
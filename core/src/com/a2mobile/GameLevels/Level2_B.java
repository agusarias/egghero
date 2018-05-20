package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level2_B extends Level {

	public Level2_B(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 50;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[totalEggs];
		this.eggAppearTargetPositions = new int[totalEggs];
		float anterior = 0;
		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = i % 25 != 0 ? EggType.NORMAL : EggType.LIFE_EGG;
			anterior += 0.03f;
			this.eggAppearTimes[i] = anterior;
			this.eggAppearTargetPositions[i] = 0;
		}
		this.eggs = gameWorld.getEggs();
		this.eggs.reset();
	}

	@Override
	public String getLevelNumber(){
		return "Second Bonus Level!";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level3_1(world);
	}
}
package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class RandomLevel extends Level {

	public RandomLevel(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 2;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[totalEggs];
		this.eggAppearTargetPositions = new int[totalEggs];
		float anterior = 0;
		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
			anterior += (float) (Math.random() * 4);
			this.eggAppearTimes[i] = anterior;
			this.eggAppearTargetPositions[i] = (int) ( Math.random() * 5);
		}
		this.eggs = gameWorld.getEggs();
		this.eggs.reset();
	}

	@Override
	public String getLevelNumber(){
		return "?";
	}
	
	@Override
	public Level getNextLevel() {
		return new RandomLevel(world);
	}
}

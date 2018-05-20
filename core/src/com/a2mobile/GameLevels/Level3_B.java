package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level3_B extends Level {

	public Level3_B(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 75;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[totalEggs];
		this.eggAppearTargetPositions = new int[totalEggs];
		float anterior = 0;
		for(int i = 0; i < totalEggs; i++){

			if(i % 25 == 0)
				anterior += 1.53f;

			this.eggTypes[i] = i % 35 != 0 ? EggType.NORMAL : EggType.LIFE_EGG;
			anterior += 0.03f;
			this.eggAppearTimes[i] = anterior;
			
			
			if(i < 25)
				this.eggAppearTargetPositions[i] = 0;
			else if(i < 50)
				this.eggAppearTargetPositions[i] = 1;
			else if(i < 75)
				this.eggAppearTargetPositions[i] = 2;
		}
		this.eggs = gameWorld.getEggs();
		this.eggs.reset();
	}

	@Override
	public String getLevelNumber(){
		return "Third Bonus Level!";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level4_1(world);
	}
}
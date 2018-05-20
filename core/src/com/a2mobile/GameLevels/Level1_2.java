package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level1_2 extends Level {

	public Level1_2(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 4;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[totalEggs];
		this.eggAppearTargetPositions = new int[totalEggs];
		
		this.eggTypes = new EggType[] { EggType.NORMAL, EggType.NORMAL, EggType.NORMAL , EggType.NORMAL};
		this.eggAppearTimes = new float[] { 0.0f, 1f, 4f , 
											5.0f};
		this.eggAppearTargetPositions = new int[] { 0, 1 , 2, 3};

//		this.world.setSpeed(2);
//		this.eggs.setSpeed(2);
//		this.speed = 2;
		
		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 1 - 2";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level1_3(world);
	}
}
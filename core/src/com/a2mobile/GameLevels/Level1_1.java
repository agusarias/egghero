package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg;
import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameObjects.Hero;
import com.a2mobile.GameWorld.GameWorld;

public class Level1_1 extends Level {

	public Level1_1(GameWorld gameWorld) {
		super(gameWorld);

		this.world.getHero().setDelayToArrive(Hero.DEFAULT_DELAY);
		
		this.totalEggs = 5;
		this.eggTypes = new Egg.EggType[totalEggs];
		this.eggAppearTimes = new float[totalEggs];
		this.eggAppearTargetPositions = new int[totalEggs];
		
		float anterior = 0;
		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
			anterior += 2.0f;
			this.eggAppearTimes[i] = anterior;
			this.eggAppearTargetPositions[i] = i;
		}
		this.eggs = gameWorld.getEggs();
//		
		this.eggs.reset();
	}
	
	@Override
	public void win() {
		world.informFirstLevelWin();
		super.win();
	}


	@Override
	public String getLevelNumber(){
		return "Level 1 - 1";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level1_2(world);
	}
}

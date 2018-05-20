package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level2_4 extends Level {

	public Level2_4(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 15;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[totalEggs];		
		this.eggAppearTargetPositions =  new int[totalEggs];
		

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		for(int i = 0; i < 3 ; i++){
			float interval = 12f * i;

			this.eggAppearTimes[i * 5] = interval + 0.0f;
			this.eggAppearTimes[i * 5 + 1] =  interval + 0.3f;
			this.eggAppearTimes[i * 5 + 2] =  interval + 0.6f;
			this.eggAppearTimes[i * 5 + 3] =  interval + 0.9f;
			this.eggAppearTimes[i * 5 + 4] =  interval + 1.2f;
			
			if(i == 1){
				this.eggAppearTargetPositions[i * 5] = 4;
				this.eggAppearTargetPositions[i * 5 + 1] =  3;
				this.eggAppearTargetPositions[i * 5 + 2] =  2;
				this.eggAppearTargetPositions[i * 5 + 3] =  1;
				this.eggAppearTargetPositions[i * 5 + 4] = 0;	
			}else{
				this.eggAppearTargetPositions[i * 5] = 0;
				this.eggAppearTargetPositions[i * 5 + 1] =  1;
				this.eggAppearTargetPositions[i * 5 + 2] =  2;
				this.eggAppearTargetPositions[i * 5 + 3] =  3;
				this.eggAppearTargetPositions[i * 5 + 4] = 4;
			}
				
		}

		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber(){
		return "Level 2 - 4";
	}
	
	@Override
	public Level getNextLevel() {
		return new Level2_5(world);
	}
}
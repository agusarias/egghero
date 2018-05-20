package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameWorld.GameWorld;

public class Level2_5 extends Level {

	public Level2_5(GameWorld gameWorld) {
		super(gameWorld);
		this.totalEggs = 27;
		this.eggTypes = new EggType[totalEggs];
		this.eggAppearTimes = new float[totalEggs];
		this.eggAppearTargetPositions = new int[totalEggs];

		int rounds = 3;
		int eggPerRound = totalEggs / rounds;

		for(int i = 0; i < totalEggs; i++){
			this.eggTypes[i] = EggType.NORMAL;
		}
		for (int i = 0; i < rounds; i++) {
			float interval = 8f * i;

			this.eggAppearTimes[i * eggPerRound ] = interval + 0.0f;
			this.eggAppearTimes[i * eggPerRound  + 1] = interval + 0.1f;
			this.eggAppearTimes[i * eggPerRound  + 2] = interval + 0.2f;

			this.eggAppearTimes[i * eggPerRound  + 3] = interval + 0.6f;
			this.eggAppearTimes[i * eggPerRound  + 4] = interval + 0.7f;
			this.eggAppearTimes[i * eggPerRound  + 5] = interval + 0.8f;
			
			this.eggAppearTimes[i * eggPerRound  + 6] = interval + 1.2f;
			this.eggAppearTimes[i * eggPerRound  + 7] = interval + 1.3f;
			this.eggAppearTimes[i * eggPerRound  + 8] = interval + 1.4f;

			this.eggAppearTargetPositions[i * eggPerRound ] = 3;
			this.eggAppearTargetPositions[i * eggPerRound  + 1] = 3;
			this.eggAppearTargetPositions[i * eggPerRound  + 2] = 3;
			this.eggAppearTargetPositions[i * eggPerRound  + 3] = 2;
			this.eggAppearTargetPositions[i * eggPerRound  + 4] = 2;
			this.eggAppearTargetPositions[i * eggPerRound  + 5] = 2;
			this.eggAppearTargetPositions[i * eggPerRound  + 6] = 1;
			this.eggAppearTargetPositions[i * eggPerRound  + 7] = 1;
			this.eggAppearTargetPositions[i * eggPerRound  + 8] = 1;

		}

		this.eggs = gameWorld.getEggs();
	}

	@Override
	public String getLevelNumber() {
		return "Level 2 - 5";
	}

	@Override
	public Level getNextLevel() {
		if(world.getLifes() >= GameWorld.AMOUNT_OF_LIFES)
			return new Level2_B(world);
		else
			return new Level3_1(world);
	}
}
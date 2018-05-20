package com.a2mobile.GameLevels;

import com.a2mobile.GameObjects.Egg;
import com.a2mobile.GameObjects.Egg.EggType;
import com.a2mobile.GameObjects.SurvivalEgg;
import com.a2mobile.GameObjects.SurvivalLifeEgg;
import com.a2mobile.GameWorld.GameWorld;

public class LevelSurvival extends Level {

	private float timeBetweenEggs = 2f;

	private int lastPos = 3;
	private int posAux = 0;

	protected float lastEggReleasedTime = 0.0f;

	public LevelSurvival(GameWorld gameWorld, float runtime) {
		super(gameWorld);

		this.startLevelTime = runtime;

		this.eggTypes = new EggType[] { EggType.SURVIVAL_EGG,
				EggType.SURVIVAL_EGG, EggType.SURVIVAL_EGG,
				EggType.SURVIVAL_LIFE_EGG, EggType.SURVIVAL_EGG,
				EggType.SURVIVAL_EGG, EggType.SURVIVAL_EGG,
				EggType.SURVIVAL_EGG, EggType.SURVIVAL_EGG, };
		this.eggAppearTargetPositions = GameWorld.fixedPositions;

		gameWorld.resetEggs();

		this.eggs = gameWorld.getEggs();

		this.eggs.setSpeed(1);
		
		this.eggs.reset();

		this.speed = 1;
	}

	@Override
	public void update(float delta, float runtime) {
		// if (releasedEggs != totalEggs) {

//		float time = Math.max((float) (timeBetweenEggs - ((speed * 1.4f) / (speed + 5))), 
//				0.28f);
		float time =  Math.max((float) (timeBetweenEggs / (speed / 2 + 5)), 0.22f);

		
		if (runtime - lastEggReleasedTime > time) {

			System.out.println(time);
			lastEggReleasedTime = runtime;

			Egg egg;

			int typeIdx = (int) Math
					.max(Math.random() * eggTypes.length - 1, 0);

			
			posAux = lastPos;
						
			lastPos = lastPos + (int) Math.round(Math.random() * 2 - 1);
			lastPos = Math.min(lastPos, eggAppearTargetPositions.length - 1);
			lastPos = Math.max(lastPos, 0);
			
			if(releasedEggs > 1 && posAux == lastPos)
				lastPos = lastPos <= eggAppearTargetPositions.length / 2 ? lastPos + 1 : lastPos - 1;

			System.out.println("idx: " + typeIdx);

			switch (this.eggTypes[typeIdx]) {
			case SURVIVAL_LIFE_EGG:
				egg = new SurvivalLifeEgg(
						eggAppearTargetPositions[this.lastPos] + 3,
						-Egg.JUMP_CONST, 8, 8, this.lastPos);
				break;
			case SURVIVAL_EGG:
			default:
				egg = new SurvivalEgg(
						eggAppearTargetPositions[this.lastPos] + 3,
						-Egg.JUMP_CONST, 8, 8, this.lastPos);
				break;
			}

//			egg.setGameSpeed((float) (1 + startLevelTime / 10));

			speed += 0.05f;
			world.getHero().setDelayToArrive(1 / (4 + Math.max(speed, 5)));

			this.eggs.add(egg);
			this.releasedEggs++;
		}

		// }

		if (world.getLifes() <= 0)
			this.lose();

	}

	@Override
	public String getLevelNumber() {
		return "Survival!";
	}

	public Level getNextLevel() {
		return new LevelSurvival(world, 1.0f);
	}

	@Override
	public void lose() {
		this.world.informLoseSurvival();
	}
}

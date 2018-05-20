package com.a2mobile.GameObjects;

import com.a2mobile.GameWorld.GameWorld;
import com.a2mobile.Helpers.AssetLoader;

public class SurvivalEgg extends Egg {

	public SurvivalEgg(float x, float y, int width, int height, int targetPosition) {
		super(x, y, width, height, targetPosition);
		
		this.eggType = EggType.SURVIVAL_EGG;
		this.eggSprite = AssetLoader.egg;
		this.lifeAmount = 1;
		
	}

	public void jump() {

		targetPosition = GameWorld.fixedPositions.length;
		AssetLoader.play(AssetLoader.jump);

		velocity.y = -JUMP_CONST;

		updateSpeed();
	}

}

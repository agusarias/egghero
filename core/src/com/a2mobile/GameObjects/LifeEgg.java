package com.a2mobile.GameObjects;

import com.a2mobile.GameWorld.GameWorld;
import com.a2mobile.Helpers.AssetLoader;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LifeEgg extends Egg {

	private TextureRegion signSprite;
	
	public LifeEgg(float x, float y, int width, int height, int targetPosition) {
		super(x, y, width, height, targetPosition);
		
		this.eggType = EggType.LIFE_EGG;
		this.eggSprite = AssetLoader.lifeEgg;
		this.signSprite = AssetLoader.lifeEggSign;
		this.lifeAmount = 0;
		
	}

	@Override
	public void score(GameWorld world) {
		AssetLoader.play(AssetLoader.life);
		this.scored = true;
		world.incrementLife(1);
		destroy();
	}

	public void draw(SpriteBatch batcher) {
		if (this.isAlive()){

			batcher.draw(this.signSprite, this.getX() - 1.25f, this.getY() - 5.0f,
					11.5f, 4.0f);
			
			batcher.draw(this.eggSprite, this.getX(), this.getY(),
					this.getWidth() / 2.0f, this.getHeight() / 2.0f,
					this.getWidth(), this.getHeight(), 1, 1, this.getRotation());
		}
			
		else
			batcher.draw(this.deadEggSprite, this.getX(), this.getY(),
					this.getWidth() / 2.0f, this.getHeight() / 2.0f,
					this.getWidth(), this.getHeight(), 1, 1, this.getRotation());
	}

}

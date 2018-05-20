package com.a2mobile.Screens;

import com.a2mobile.EggHero.EHGame;
import com.a2mobile.GameWorld.GameRenderer;
import com.a2mobile.GameWorld.GameWorld;
import com.a2mobile.Helpers.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;
    private float runTime;

	@SuppressWarnings("unused")
	private EHGame game;
	
	public GameScreen(EHGame game) {
		this.game = game;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = GameRenderer.WIDTH;
        float gameHeight = GameRenderer.HEIGHT;

        int midPointY = (int) (gameHeight / 2);
        int midPointX = (int) (gameWidth / 2);

        this.world = new GameWorld(gameWidth, gameHeight, game);
        
        Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
        
        this.renderer = new GameRenderer(world, (int) gameHeight, midPointY, midPointX);
        
	}
	
	@Override
	public void render(float delta) {
        
		if(!world.isPaused())
			runTime += delta;
        world.update(delta, runTime);
        renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public float getRunTime() {
		return runTime;
	}

}

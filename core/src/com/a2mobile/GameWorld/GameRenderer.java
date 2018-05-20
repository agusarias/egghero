package com.a2mobile.GameWorld;

import com.a2mobile.GameObjects.*;
import com.a2mobile.Helpers.AssetLoader;
import com.a2mobile.Helpers.InputHandler;
import com.a2mobile.ui.Button;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import java.util.List;

public class GameRenderer {

	private static final int ALIGN_LEFT = 0;
	private static final int ALIGN_CENTER = 1;
	private static final int ALIGN_RIGHT = 2;
	public static int WIDTH = 204;
	public static int HEIGHT = 136;

	public int midPointY;
	public int midPointX;
	private int gameHeight;

	// Game world and objects
	private GameWorld world;
	private Hero hero;
	private Chicken chicken;
	private Eggs eggs;

	// Rendering classes
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	private TextureRegion bg, grass, gameOversprite;
	public TextureRegion btnLeft, btnRight, btnLeftPressed, btnRightPressed;

	public TextureRegion title, pause;

	private List<Button> titleButtons, pausedButtons, runningButtons,
			gameOverButtons, readyButtons;

	private Animation downArrowAnimation;
	private Animation heroAnimation;
	private Animation heroChickenAnimation;
	private TextureRegion[] heroSprites, heroChickenSprites;
	private Animation chickenAnimation;
	private TextureRegion[] chickenSprites;
	private TextureRegion eggSprite;
	private TextureRegion basketSprite, basketBackSprite;

	public GameRenderer(GameWorld world, int gameHeight, int midPointY,
			int midPointX) {
		this.world = world;

		this.gameHeight = gameHeight;
		this.midPointY = midPointY;
		this.midPointX = midPointX;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, WIDTH, HEIGHT);
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		initGameObjects();
		initAssets();
	}

	private void initGameObjects() {
		hero = this.world.getHero();
		chicken = this.world.getChicken();
		eggs = this.world.getEggs();

		InputHandler ih = ((InputHandler) Gdx.input.getInputProcessor());

		titleButtons = ih.getTitleButtons();
		pausedButtons = ih.getPausedButtons();
		runningButtons = ih.getRunningButtons();
		readyButtons = ih.getReadyButtons();
		gameOverButtons = ih.getGameOverButtons();
	}

	private void initAssets() {
		bg = AssetLoader.bg;
		grass = AssetLoader.grass;
		gameOversprite = AssetLoader.gameover;
		title = AssetLoader.title;
		pause = AssetLoader.pause;
		downArrowAnimation = AssetLoader.downArrowAnimation;
		btnLeft = AssetLoader.btnLeft;
		btnRight = AssetLoader.btnRight;
		btnLeftPressed = AssetLoader.btnLeftPressed;
		btnRightPressed = AssetLoader.btnRightPressed;
		chickenAnimation = AssetLoader.chickenAnimation;
		heroAnimation = AssetLoader.heroAnimation;
		heroChickenAnimation = AssetLoader.heroChickenAnimation;
		heroSprites = AssetLoader.hero;
		heroChickenSprites = AssetLoader.heroChicken;
		chickenSprites = AssetLoader.chicken;
		eggSprite = AssetLoader.egg;
		basketSprite = AssetLoader.basket;
		basketBackSprite = AssetLoader.basketBack;
	}

	public void render(float runTime) {

		// Fill the entire screen with black, to prevent potential flickering.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*
		 * // Begin ShapeRenderer shapeRenderer.begin(ShapeType.Filled);
		 * 
		 * // Draw Background color shapeRenderer.setColor(107 / 255.0f, 215 /
		 * 255.0f, 255 / 255.0f, 1); shapeRenderer.rect(0, 0, WIDTH, HEIGHT);
		 * 
		 * // Draw Dirt shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 /
		 * 255.0f, 1); shapeRenderer.rect(0, midPointY + 77, WIDTH, 52);
		 * 
		 * // End ShapeRenderer shapeRenderer.end();
		 */

		// Begin SpriteBatch
		batcher.begin();

		// Disable transparency
		batcher.disableBlending();

		drawBackground();
		// The transparency
		batcher.enableBlending();

		if (world.isTitle()) {

			drawTitle(runTime);

		} else if (world.isPaused()) {

			drawPause(runTime);

		} else {

			if (world.isRunning()) {
				drawRunningButtons();
			}

			drawHero(runTime);

			drawChicken(runTime);

			drawEggsAndBasket(runTime);

			if (world.isReady()) {

				drawReady();
				drawLevel();

			} else if (world.isLevelWin()) {

				drawLevelWin(runTime);

			} else if (world.isGameOver()) {

				drawGameOver();

			} else if (world.isRunning()) {

				drawLifes();
				drawScore();
				drawLevel();

			}
		}

		// End SpriteBatch
		batcher.end();

		// drawShapes();
	}

	private void drawLevelWin(float runTime) {
		drawScore();
		drawLevelResult(runTime);
		
	}

	private void drawReady() {

		write("TOUCH to start!", (WIDTH / 2), HEIGHT / 2 - 20, ALIGN_CENTER);

		for (Button button : readyButtons) {
			button.draw(batcher);
		}

	}

	private void drawTitle(float runTime) {

		batcher.draw(this.title, WIDTH / 2 - 172.5f / 2, HEIGHT / 2 - 120 / 2,
				172.5f, 120);

		for (Button button : titleButtons) {
			button.draw(batcher);
		}
	}

	private void drawPause(float runTime) {

		batcher.draw(this.pause, WIDTH / 2 - 135 / 2, HEIGHT / 2 - 120 / 2,
				135, 120);

		for (Button button : pausedButtons) {
			button.draw(batcher);
		}
	}

	private void drawGameOver() {
		batcher.draw(this.gameOversprite, WIDTH / 2 - 135 / 2,
				HEIGHT / 2 - 120 / 2, 135, 120);

		writeScore(world.getScore(), 75, HEIGHT - 92, ALIGN_CENTER);

		if(world.wasSurvival())
			writeScore(world.getHighScoreSurvival(), 75 + 65, HEIGHT - 92, ALIGN_CENTER);
		else
			writeScore(world.getHighScore(), 75 + 65, HEIGHT - 92, ALIGN_CENTER);

		for (Button button : gameOverButtons) {
			button.draw(batcher);
		}
	}

	private void drawRunningButtons() {
		for (Button button : runningButtons) {
			button.draw(batcher);
		}
	}

	@SuppressWarnings("unused")
	private void drawShapes() {

		// Begin ShapeRenderer
		shapeRenderer.begin(ShapeType.Filled);
		// Draw Background color
		shapeRenderer.setColor(255 / 255.0f, 0 / 255.0f, 0 / 255.0f, 1);
		for (int i = 0; i < 300; i++)
			shapeRenderer.rect(2 * i, 0, 1f, HEIGHT);
		// End ShapeRenderer
		shapeRenderer.end();

	}

	private void drawScore() {
		write(world.getScore(), (WIDTH) - 10 - 17 - 5 - 3, 10, ALIGN_RIGHT);
	}

	private void drawLevel() {
		write(world.getLevelNumber(), (WIDTH / 2), HEIGHT - 10, ALIGN_CENTER);
	}

	private void drawLifes() {
		for (int i = 0; i < world.getLifes(); i++)
			batcher.draw(this.eggSprite, 10 + 5 * i, 10, 8, 8);
	}

	private void drawLevelResult(float runtime) {
		writeBig(world.getLevelResultMessage(), (WIDTH / 2), 20, true);
		writeBig(world.getLevelMessage(), (WIDTH / 2), 40, true);
		write("TOUCH to continue!", (WIDTH / 2), 65, ALIGN_CENTER);
	}

	private void writeBig(String text, float x, float y, boolean adjust) {
		if (adjust)
			x = x - text.length() * 8f;
		AssetLoader.bigFont.draw(batcher, text, x, y);
	}

	private void write(String text, float x, float y, int align) {
		if (align == ALIGN_CENTER)
			AssetLoader.smallFont
					.draw(batcher, text, x - text.length() * 4f, y);
		else if (align == ALIGN_LEFT)
			AssetLoader.smallFont
					.draw(batcher, text, x + text.length() * 8f, y);
		else if (align == ALIGN_RIGHT)
			AssetLoader.smallFont
					.draw(batcher, text, x - text.length() * 8f, y);
		else
			AssetLoader.smallFont.draw(batcher, text, x, y);
	}

	private void writeScore(String text, float x, float y, int align) {
		if (align == ALIGN_CENTER)
			AssetLoader.scoreFont
					.draw(batcher, text, x - text.length() * 5f, y);
		else if (align == ALIGN_LEFT)
			AssetLoader.scoreFont.draw(batcher, text, x + 0,
					y);
		else if (align == ALIGN_RIGHT)
			AssetLoader.scoreFont.draw(batcher, text, x - text.length() * 10f,
					y);
		else
			AssetLoader.scoreFont.draw(batcher, text, x, y);
	}

	private void drawChicken(float runTime) {

		// Draw chicken at its coordinates
		if (chicken.isMoving())
			batcher.draw(this.chickenAnimation.getKeyFrame(runTime),
					chicken.getX() + chicken.getWidth() / 2, chicken.getY(),
					chicken.getWidth() / 2, chicken.getHeight());
		else
			batcher.draw(this.chickenSprites[0],
					chicken.getX() + chicken.getWidth() / 2, chicken.getY(),
					chicken.getWidth() / 2, chicken.getHeight());

	}

	private void drawEggsAndBasket(float runtime) {

		// Draw basket back
		batcher.draw(this.basketBackSprite, chicken.getX(), chicken.getY(),
				chicken.getWidth() / 2, chicken.getHeight());
		// Draw eggs
		for (Egg egg : eggs) {
			if (egg.getY() >= -egg.getHeight()) {
				egg.draw(batcher);
			} else {
				batcher.draw(downArrowAnimation.getKeyFrame(runtime),
						egg.getX(), 2, 11f, 10f);
			}
		}
		// Draw basket
		batcher.draw(this.basketSprite, chicken.getX(), chicken.getY(),
				chicken.getWidth() / 2, chicken.getHeight());

	}

	private void drawHero(float runTime) {

		// Draw hero at its coordinates
		if (hero.isBouncing())
			batcher.draw(this.heroAnimation.getKeyFrame(runTime), hero.getX(),
					hero.getY(), hero.getWidth() / 2, hero.getHeight());
		else
			batcher.draw(this.heroSprites[0], hero.getX(), hero.getY(),
					hero.getWidth() / 2, hero.getHeight());

		if (hero.isMoving())
			batcher.draw(this.heroChickenAnimation.getKeyFrame(runTime),
					hero.getX() - hero.getWidth() / 2, hero.getY(),
					hero.getWidth() / 2, hero.getHeight());
		else
			batcher.draw(this.heroChickenSprites[2],
					hero.getX() - hero.getWidth() / 2, hero.getY(),
					hero.getWidth() / 2, hero.getHeight());

	}

	public void drawBackground() {

		// Draw background
		batcher.draw(this.bg, 0, 0, WIDTH, HEIGHT);

		// Draw Grass
		batcher.draw(this.grass, 0, HEIGHT - Grass.HEIGHT, WIDTH, Grass.HEIGHT);

	}

	public int getGameHeight() {
		return this.gameHeight;
	}

}
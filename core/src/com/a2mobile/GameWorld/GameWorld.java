package com.a2mobile.GameWorld;

import com.a2mobile.EggHero.EHGame;
import com.a2mobile.GameLevels.Level;
import com.a2mobile.GameLevels.Level1_1;
import com.a2mobile.GameLevels.LevelSurvival;
import com.a2mobile.GameObjects.Chicken;
import com.a2mobile.GameObjects.Eggs;
import com.a2mobile.GameObjects.Grass;
import com.a2mobile.GameObjects.Hero;
import com.a2mobile.Helpers.AssetLoader;
import com.badlogic.gdx.Gdx;

public class GameWorld {

	public static final int AMOUNT_OF_LIFES = 5;
	public static final int MAX_LIFES = 30;

	private Level level;

	private Hero hero;
	private Chicken chicken;
	private Eggs eggs;
	private Grass grass;
	private int score = 0;
	private int lifes = AMOUNT_OF_LIFES;

	 private EHGame game;

	private float speed = 1;

	public static int[] fixedPositions = { 30, 60, 90, 120, 150 };
	public static int basketPosition = 170;

	private GameState currentState;

	private boolean normalPressed = false, survivalPressed = false,
			musicOn = true, soundOn = true;

	private float runtime;
	private float winTime = -1;

	private int highScore = 0, highScoreSurvival = 0;

	private boolean wasSurvival;

	public enum GameState {
		READY, RUNNING, LEVELWIN, GAMEOVER, TITLE, PAUSED
	}

	public GameWorld(float gameWidth, float gameHeight, EHGame game) {

		this.game = game;

		currentState = GameState.TITLE;

		hero = new Hero(fixedPositions[0], GameRenderer.HEIGHT - Grass.HEIGHT
				- 16, 32, 16);
		chicken = new Chicken(basketPosition + 2, GameRenderer.HEIGHT
				- Grass.HEIGHT - 16, 32, 16);
		eggs = new Eggs(this);
		grass = new Grass(0, GameRenderer.HEIGHT - Grass.HEIGHT,
				GameRenderer.WIDTH, Grass.HEIGHT);

		// Start with level 1 - 1
		level = new Level1_1(this);

		// Load high Scores
		highScore = AssetLoader.prefs.getInteger(AssetLoader.PREFS_HIGHSCORE);

		highScoreSurvival = AssetLoader.prefs
				.getInteger(AssetLoader.PREFS_HIGHSCORE_SURVIVAL);

		musicOn = AssetLoader.prefs.getBoolean(AssetLoader.PREFS_MUSIC_ON);

		soundOn = AssetLoader.prefs.getBoolean(AssetLoader.PREFS_SOUND_ON);

		// Game sound loop
		AssetLoader.playMusic(AssetLoader.loop, true);
	}

	public void update(float delta, float runtime) {

		this.runtime = runtime;
		switch (currentState) {
		case TITLE:
			updateTitle(delta, runtime);
			break;

		case PAUSED:
			break;

		case READY:
			updateReady(delta, runtime);
			break;

		case LEVELWIN:
			updateLevelWin(delta, runtime);
			break;

		case GAMEOVER:
			updateGameover(delta, runtime);
			break;

		case RUNNING:
		default:
			updateRunning(delta, runtime);
			break;
		}
	}

	public void goNextLevel() {
		this.level = level.getNextLevel();
		reOrderObjects();
	}

	private void updateReady(float delta, float runtime) {
	}

	private void updateTitle(float delta, float runtime) {
	}

	private void updateGameover(float delta, float runtime) {
	}

	private void updateLevelWin(float delta, float runtime) {
	}

	private void updateRunning(float delta, float runtime) {

		this.hero.update(delta, runtime);
		this.chicken.update(delta, runtime);
		this.eggs.update(delta, runtime);

		this.eggs.checkCollisions(hero, grass, chicken);

		// Update the logic of the level
		this.level.update(delta, runtime);

	}

	public Hero getHero() {
		return this.hero;
	}

	public Chicken getChicken() {
		return this.chicken;
	}

	public Eggs getEggs() {
		return this.eggs;
	}

	public void addScore(float value) {
		this.score += value;
		System.out.println("Puntaje: " + score);
	}

	public void decrementLife(int lifeAmount) {
		this.lifes -= lifeAmount;
		System.out.println(lifeAmount + " vida/s menos: " + lifes);
	}

	public void incrementLife(int lifeAmount) {
		if (lifes < MAX_LIFES)
			this.lifes += lifeAmount;
		System.out.println(lifeAmount + " vida/s mas: " + lifes);
	}

	public boolean isReady() {
		return currentState == GameState.READY;
	}

	public void start() {
		currentState = GameState.RUNNING;
		level.start(this.runtime);
	}

	public void ready() {
		level = new Level1_1(this);
		currentState = GameState.READY;
	}

	public void survival() {
		level = new LevelSurvival(this, this.runtime);
		currentState = GameState.READY;
	}

	public void pause() {
		currentState = GameState.PAUSED;
	}

	public void resume() {
		currentState = GameState.RUNNING;
	}

	public void goTitle() {
		restart();
		currentState = GameState.TITLE;
	}

	public void restart() {
		try {
			game.showAds();
		} catch (Exception e) {

		}

		reOrderObjects();
		score = 0;
		lifes = AMOUNT_OF_LIFES;
		if (wasSurvival)
			setLevel(new LevelSurvival(this, this.runtime));
		else
			setLevel(new Level1_1(this));
	}

	public void reOrderObjects() {
		currentState = GameState.READY;

		hero.set(fixedPositions[0], GameRenderer.HEIGHT - Grass.HEIGHT - 16,
				32, 16, 0);
		eggs.reset();
		currentState = GameState.READY;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean isGameOver() {
		return currentState == GameState.GAMEOVER;
	}

	public boolean isTitle() {
		return currentState == GameState.TITLE;
	}

	public boolean isPaused() {
		return currentState == GameState.PAUSED;
	}

	public boolean isRunning() {
		return currentState == GameState.RUNNING;
	}

	public boolean isLevelWin() {
		return currentState == GameState.LEVELWIN;
	}

	public String getScore() {
		return this.score + "";
	}

	public void informWin() {
		this.currentState = GameState.LEVELWIN;
		this.winTime = this.runtime;

		AssetLoader.play(AssetLoader.winSound);

		System.out.println("Level WIN!");
	}

	public void informLose() {

		this.wasSurvival = false;

		try {
			if (this.score > 10)
				this.game.pushBeginnerAchievement();
			if (this.score > 50)
				this.game.pushIntermediateAchievement();
			if (this.score > 150)
				this.game.pushAdvancedAchievement();
			if (this.score > 270)
				this.game.pushEggsHeroAchievement();
		} catch (Exception e) {

		}

		if (highScore < this.score) {

			try {
				this.game.pushHighscoreNormal(this.score);

			} catch (Exception e) {

			}
			this.currentState = GameState.GAMEOVER;
			this.highScore = this.score;
			AssetLoader.prefs.putInteger(AssetLoader.PREFS_HIGHSCORE,
					this.score);
			AssetLoader.prefs.flush();
		} else
			this.currentState = GameState.GAMEOVER;

		AssetLoader.play(AssetLoader.loseSound);

		System.out.println("Game over!");
	}

	public void informLoseSurvival() {

		this.wasSurvival = true;

		try {
			if (this.score > 10)
				this.game.pushBeginnerAchievement();
			if (this.score > 50)
				this.game.pushIntermediateAchievement();
			if (this.score > 150)
				this.game.pushAdvancedAchievement();
			if (this.score > 270)
				this.game.pushEggsHeroAchievement();

		} catch (Exception e) {

		}
		if (highScoreSurvival < this.score) {

			try {
				this.game.pushHighscoreSurvival(this.score);

			} catch (Exception e) {

			}
			this.currentState = GameState.GAMEOVER;
			this.highScoreSurvival = this.score;
			AssetLoader.prefs.putInteger(AssetLoader.PREFS_HIGHSCORE_SURVIVAL,
					this.score);
			AssetLoader.prefs.flush();
		} else
			this.currentState = GameState.GAMEOVER;

		AssetLoader.play(AssetLoader.loseSound);

		System.out.println("Game over!");
	}

	public void rate(){
		
			try {
				this.game.goRate();

			} catch (Exception e) {

			}
	}
	
	public void informFirstLevelWin() {
		try{
		this.game.pushFirtLevelAchievement();
		}catch(Exception e){
			
		}
	}

	public void informFirstBonus() {
		try{
		this.game.pushDiscoverBonusAchievement();
		}catch(Exception e){
			
		}
	}

	public void informSecretAchievement() {
		try{
		this.game.pushSecretAchievement();
		}catch(Exception e){
			
		}
	}

	public void informDead(int lifeAmount) {
		this.level.addDead();
		this.decrementLife(lifeAmount);
	}

	public void informScored(float value) {
		addScore(value);
		this.level.addScored();
	}

	public void showAchievements() {
		try{
		this.game.showAchievements();
		}catch(Exception e){
			
		}
	}

	public void showLeaderboards() {
		try{
		this.game.showLeaderBoards();
		}catch(Exception e){
			
		}
	}

	public void showLeaderboardsSurvival() {
		try {
			this.game.showLeaderBoardsSurvival();
		}catch(Exception e){
			
		}
	}

	public float getWinTime() {
		return this.winTime;
	}

	public String getLevelResultMessage() {
		return level.getResultMessage();
	}

	public String getLevelMessage() {
		return "Next level";
	}

	public String getLevelNumber() {
		return this.level.getLevelNumber();
	}

	public int getLifes() {
		return this.lifes;
	}

	public String getHighScore() {
		return this.highScore + "";
	}

	public String getHighScoreSurvival() {
		return this.highScoreSurvival + "";
	}

	public float getSpeed() {
		return this.speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void setNormalPressed(boolean normalPressed) {
		this.normalPressed = normalPressed;
	}

	public void setSurvivalPressed(boolean survivalPressed) {
		this.survivalPressed = survivalPressed;
	}

	public void setMusicOn(boolean musicOn) {
		AssetLoader.prefs.putBoolean(AssetLoader.PREFS_MUSIC_ON, musicOn);
		AssetLoader.prefs.flush();

		if (musicOn)
			AssetLoader.playMusic(AssetLoader.loop, true);
		else
			AssetLoader.loop.stop();

		this.musicOn = musicOn;
	}

	public void setSoundOn(boolean soundOn) {
		AssetLoader.prefs.putBoolean(AssetLoader.PREFS_SOUND_ON, soundOn);
		AssetLoader.prefs.flush();
		this.soundOn = soundOn;
	}

	public boolean isNormalPressed() {
		return normalPressed;
	}

	public boolean isSurvivalPressed() {
		return survivalPressed;
	}

	public boolean isMusicOn() {
		return musicOn;
	}

	public boolean isSoundOn() {
		return soundOn;
	}

	public void exit() {
		Gdx.app.exit();
	}

	public boolean wasSurvival() {
		return this.wasSurvival;
	}

	public void resetEggs() {
		// this.eggs = new Eggs(this);
	}

}

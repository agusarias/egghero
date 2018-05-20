package com.a2mobile.Helpers;

import com.a2mobile.GameWorld.GameRenderer;
import com.a2mobile.GameWorld.GameWorld;
import com.a2mobile.ui.Button;
import com.a2mobile.ui.SimpleButton;
import com.a2mobile.ui.ToggleButton;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements InputProcessor {

	private GameWorld world;

	private float scaleFactorX;
	private float scaleFactorY;

	private List<Button> titleButtons, pauseButtons, runningButtons,
			readyButtons, gameOverButtons;

	private SimpleButton normalButton, resumeButton, endButton,
			gameOverEndButton, survivalButton, closeButton, rateButton, leaderBoardsButton,
			leaderBoardsSurvivalButton, achievementsButton, pauseButton,
			retryButton, smallCloseButton, smallRateButton;

	private ToggleButton musicButton, soundButton, leftButton, rightButton,
			smallMusicButton, smallSoundButton;

	public InputHandler(GameWorld world, float scaleFactorX, float scaleFactorY) {
		this.world = world;
		this.scaleFactorX = scaleFactorX;
		this.scaleFactorY = scaleFactorY;

		titleButtons = new ArrayList<Button>();
		pauseButtons = new ArrayList<Button>();
		runningButtons = new ArrayList<Button>();
		gameOverButtons = new ArrayList<Button>();
		readyButtons = new ArrayList<Button>();

		float bigPanelWidth = 115 * 3 / 2;
		float bigPanelHeight = 80 * 3 / 2;
		float panelWidth = 90 * 3 / 2;
//		float panelHeight = 80 * 3 / 2;
		float xBigPanel = GameRenderer.WIDTH / 2 - bigPanelWidth / 2 + 13.5f;
		float yBigPanel = GameRenderer.HEIGHT / 2 - bigPanelHeight / 2 - 24
				+ 53;
		float xPanel = GameRenderer.WIDTH / 2 - panelWidth / 2 + 13.5f;
//		float yPanel = GameRenderer.HEIGHT / 2 - panelHeight / 2 - 24 + 53;
		float bigButtonWidth = 108;
		float smallButtonWidth = 22 * 3 / 2;
		float buttonHeight = 24;
		float ygap = 4;
		float xgap = 4;

//		float centerBigButton = (smallButtonWidth + xgap) / 2;

		// Title Buttons

		normalButton = new SimpleButton(xBigPanel, yBigPanel, bigButtonWidth,
				buttonHeight, AssetLoader.btnNormal,
				AssetLoader.btnNormalPressed);

		leaderBoardsButton = new SimpleButton(
				xBigPanel + bigButtonWidth + xgap, yBigPanel, smallButtonWidth,
				buttonHeight, AssetLoader.btnLeaderBoards,
				AssetLoader.btnLeaderBoardsPressed);

		survivalButton = new SimpleButton(xBigPanel, yBigPanel + buttonHeight
				+ ygap, bigButtonWidth, buttonHeight, AssetLoader.btnSurvival,
				AssetLoader.btnSurvivalPressed);

		leaderBoardsSurvivalButton = new SimpleButton(xBigPanel
				+ bigButtonWidth + xgap, yBigPanel + buttonHeight + ygap,
				smallButtonWidth, buttonHeight,
				AssetLoader.btnLeaderBoardsSurvival,
				AssetLoader.btnLeaderBoardsSurvivalPressed);

		musicButton = new ToggleButton(xBigPanel, yBigPanel + buttonHeight * 2
				+ ygap * 2, smallButtonWidth, buttonHeight,
				AssetLoader.btnMusicOn, AssetLoader.btnMusicOff,
				!world.isMusicOn());

		soundButton = new ToggleButton(xBigPanel + smallButtonWidth + xgap,
				yBigPanel + buttonHeight * 2 + ygap * 2, smallButtonWidth,
				buttonHeight, AssetLoader.btnSoundOn, AssetLoader.btnSoundOff,
				!world.isSoundOn());

		achievementsButton = new SimpleButton(xBigPanel + smallButtonWidth * 2
				+ xgap * 2, yBigPanel + buttonHeight * 2 + ygap * 2,
				smallButtonWidth, buttonHeight, AssetLoader.btnAchievements,
				AssetLoader.btnAchievementsPressed);

		closeButton = new SimpleButton(xBigPanel + smallButtonWidth * 3 + xgap
				* 3, yBigPanel + buttonHeight * 2 + ygap * 2, smallButtonWidth,
				buttonHeight, AssetLoader.btnClose, AssetLoader.btnClosePressed);
		rateButton = new SimpleButton(xBigPanel + smallButtonWidth * 3 + xgap
				* 3, yBigPanel + buttonHeight * 2 + ygap * 2, smallButtonWidth,
				buttonHeight, AssetLoader.btnRate, AssetLoader.btnRatePressed);

		this.titleButtons.add(normalButton);
		this.titleButtons.add(survivalButton);
		this.titleButtons.add(leaderBoardsButton);
		this.titleButtons.add(leaderBoardsSurvivalButton);
		this.titleButtons.add(musicButton);
		this.titleButtons.add(soundButton);
		this.titleButtons.add(achievementsButton);
//		this.titleButtons.add(closeButton);
		this.titleButtons.add(rateButton);

		// Pause BUttons

		resumeButton = new SimpleButton(xPanel, yBigPanel, bigButtonWidth,
				buttonHeight, AssetLoader.btnResume,
				AssetLoader.btnResumePressed);

		endButton = new SimpleButton(xPanel, yBigPanel + buttonHeight + ygap,
				bigButtonWidth, buttonHeight, AssetLoader.btnEnd,
				AssetLoader.btnEndPressed);

		smallMusicButton = new ToggleButton(xPanel, yBigPanel + buttonHeight
				* 2 + ygap * 2, smallButtonWidth, buttonHeight,
				AssetLoader.btnMusicOn, AssetLoader.btnMusicOff,
				!world.isMusicOn());

		smallSoundButton = new ToggleButton(xPanel + smallButtonWidth + xgap,
				yBigPanel + buttonHeight * 2 + ygap * 2, smallButtonWidth,
				buttonHeight, AssetLoader.btnSoundOn, AssetLoader.btnSoundOff,
				!world.isSoundOn());
		smallCloseButton = new SimpleButton(xPanel + smallButtonWidth * 2
				+ xgap * 2, yBigPanel + buttonHeight * 2 + ygap * 2,
				smallButtonWidth, buttonHeight, AssetLoader.btnClose,
				AssetLoader.btnClosePressed);
		smallRateButton = new SimpleButton(xPanel + smallButtonWidth * 2
				+ xgap * 2, yBigPanel + buttonHeight * 2 + ygap * 2,
				smallButtonWidth, buttonHeight, AssetLoader.btnRate,
				AssetLoader.btnRatePressed);
		
		this.pauseButtons.add(resumeButton);
		this.pauseButtons.add(endButton);
		this.pauseButtons.add(smallMusicButton);
		this.pauseButtons.add(smallSoundButton);
//		this.pauseButtons.add(smallCloseButton);
		this.pauseButtons.add(smallRateButton);

		// GameOver Buttons

		retryButton = new SimpleButton(xPanel, yBigPanel + buttonHeight + ygap,
				bigButtonWidth, buttonHeight, AssetLoader.btnRetry,
				AssetLoader.btnRetryPressed);

		gameOverEndButton = new SimpleButton(xPanel, yBigPanel + buttonHeight
				* 2 + ygap * 2, bigButtonWidth, buttonHeight,
				AssetLoader.btnEnd, AssetLoader.btnEndPressed);

		this.gameOverButtons.add(retryButton);
		this.gameOverButtons.add(gameOverEndButton);

		// Running Buttons

		pauseButton = new SimpleButton(GameRenderer.WIDTH - 22 - 5, 5, 22, 17,
				AssetLoader.btnPause, AssetLoader.btnPausePressed);

		leftButton = new ToggleButton(5, GameRenderer.HEIGHT - 5 - 17, 22, 17,
				AssetLoader.btnLeft, AssetLoader.btnLeftPressed, false);

		rightButton = new ToggleButton(GameRenderer.WIDTH - 22 - 5,
				GameRenderer.HEIGHT - 5 - 17, 22, 17, AssetLoader.btnRight,
				AssetLoader.btnRightPressed, false);

		this.runningButtons.add(pauseButton);
		this.runningButtons.add(leftButton);
		this.runningButtons.add(rightButton);

	}

	@Override
	public boolean keyDown(int keycode) {

		if (world.isReady())
			world.start();

		if (keycode == 22)
			this.world.getHero().moveRight();

		if (keycode == 21)
			this.world.getHero().moveLeft();

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {

		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);

		if (world.isTitle()) {
			for (Button btn : titleButtons) {
				btn.isTouchDown(screenX, screenY);
			}

		} else if (world.isPaused()) {
			for (Button btn : pauseButtons) {
				btn.isTouchDown(screenX, screenY);
			}

		} else if (world.isReady())
			world.start();
		else if (world.isGameOver()) {
			for (Button btn : gameOverButtons) {
				btn.isTouchDown(screenX, screenY);
			}
		}

		else if (world.isLevelWin())
			world.goNextLevel();
		else if (world.isRunning()) {
			pauseButton.isTouchDown(screenX, screenY);

			if (screenY > GameRenderer.HEIGHT / 2)
				if (screenX > GameRenderer.WIDTH / 2) {
					this.world.getHero().moveRight();
					rightButton.setOn(true);
				} else {
					this.world.getHero().moveLeft();
					leftButton.setOn(true);
				}

		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);

		if (world.isRunning()) {

			if (pauseButton.isTouchUp(screenX, screenY)) {
				world.pause();
				return true;
			}
			rightButton.setOn(false);
			leftButton.setOn(false);

		} else if (world.isGameOver()) {

			if (retryButton.isTouchUp(screenX, screenY)) {
				world.restart();
				return true;
			}

			if (gameOverEndButton.isTouchUp(screenX, screenY)) {
				world.goTitle();
				return true;
			}
		} else {

			if (world.isTitle()) {

				if (normalButton.isTouchUp(screenX, screenY)) {
					world.ready();
					return true;
				}

				if (survivalButton.isTouchUp(screenX, screenY)) {
					world.survival();
					return true;
				}

				if (musicButton.isTouchUp(screenX, screenY)) {
					smallMusicButton.setOn(musicButton.isOn());
					world.setMusicOn(!musicButton.isOn());
					return true;
				}

				if (soundButton.isTouchUp(screenX, screenY)) {
					smallSoundButton.setOn(soundButton.isOn());
					world.setSoundOn(!soundButton.isOn());
					return true;
				}
/*
				if (closeButton.isTouchUp(screenX, screenY)) {
					world.exit();
					return true;
				}
*/
				if (rateButton.isTouchUp(screenX, screenY)) {
					world.rate();
					return true;
				}
				if (leaderBoardsButton.isTouchUp(screenX, screenY)) {
					world.showLeaderboards();
					return true;
				}

				if (leaderBoardsSurvivalButton.isTouchUp(screenX, screenY)) {
					world.showLeaderboardsSurvival();
					return true;
				}
				if (achievementsButton.isTouchUp(screenX, screenY)) {
					world.showAchievements();
					return true;
				}
			}

			if (world.isPaused()) {

				if (resumeButton.isTouchUp(screenX, screenY)) {
					world.resume();
					return true;
				}

				if (endButton.isTouchUp(screenX, screenY)) {
					world.goTitle();
					return true;
				}

				if (smallMusicButton.isTouchUp(screenX, screenY)) {
					musicButton.setOn(smallMusicButton.isOn());
					world.setMusicOn(!smallMusicButton.isOn());
					return true;
				}

				if (smallSoundButton.isTouchUp(screenX, screenY)) {
					soundButton.setOn(smallSoundButton.isOn());
					world.setSoundOn(!smallSoundButton.isOn());
					return true;
				}

//				if (smallCloseButton.isTouchUp(screenX, screenY)) {
//					world.exit();
//					return true;
//				}
				if (smallRateButton.isTouchUp(screenX, screenY)) {
					world.rate();
					return true;
				}

			}
		}

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	private int scaleX(int screenX) {
		return (int) (screenX / scaleFactorX);
	}

	private int scaleY(int screenY) {
		return (int) (screenY / scaleFactorY);
	}

	public List<Button> getTitleButtons() {
		return this.titleButtons;
	}

	public List<Button> getPausedButtons() {
		return this.pauseButtons;
	}

	public List<Button> getRunningButtons() {
		return this.runningButtons;
	}

	public List<Button> getGameOverButtons() {
		return this.gameOverButtons;
	}

	public List<Button> getReadyButtons() {
		return this.readyButtons;
	}

}

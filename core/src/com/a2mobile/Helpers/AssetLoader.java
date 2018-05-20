package com.a2mobile.Helpers;

import com.a2mobile.GameObjects.Hero;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static final String PREFS_HIGHSCORE = "com.a2mobile.EggHero.highScore";
	public static final String PREFS_HIGHSCORE_SURVIVAL = "com.a2mobile.EggHero.highScoreSurvival";
	public static final String PREFS_SOUND_ON = "com.a2mobile.EggHero.soundOn";
	public static final String PREFS_MUSIC_ON = "com.a2mobile.EggHero.musicOn";
	public static TextureAtlas atlas;
	public static TextureRegion logo, bg, grass, gameover;
	public static TextureRegion btnLeft, btnRight, btnLeftPressed,
			btnRightPressed, btnPause, btnPausePressed;

	public static TextureRegion title, pause, btnNormal, btnNormalPressed,
			btnSurvival, btnSurvivalPressed, btnResume, btnResumePressed,
			btnRetry, btnRetryPressed, btnEnd, btnEndPressed, btnMusicOn,
			btnMusicOff, btnLeaderBoardsSurvival,
			btnLeaderBoardsSurvivalPressed, btnSoundOn, btnSoundOff,
			btnLeaderBoards, btnLeaderBoardsPressed, btnAchievements,
			btnAchievementsPressed, btnClose, btnClosePressed, btnRate, btnRatePressed;

	public static TextureRegion downArrowUp, downArrowDown, downArrowCenter;
	public static TextureRegion egg, deadEgg, lifeEgg, lifeEggSign;
	public static TextureRegion basket, basketBack;

	public static Animation heroAnimation, heroChickenAnimation,
			chickenAnimation, downArrowAnimation;
	public static TextureRegion hero[], heroChicken[], chicken[];

	public static Sound die, jump, point, winSound, loseSound, buttonSound,
			life;

	public static Music loop;

	public static BitmapFont bigFont, smallFont, scoreFont;
	public static Preferences prefs;

	public static void load() {

		atlas = new TextureAtlas(Gdx.files.internal("data/texture.atlas"));

		logo = atlas.findRegion("logo");
		logo.flip(false, true);

		title = atlas.findRegion("title");
		title.flip(false, true);

		pause = atlas.findRegion("pause");
		pause.flip(false, true);

		btnNormal = atlas.findRegion("btn-normal");
		btnNormal.flip(false, true);
		btnNormalPressed = atlas.findRegion("btn-normal-pressed");
		btnNormalPressed.flip(false, true);
		btnSurvival = atlas.findRegion("btn-survival");
		btnSurvival.flip(false, true);
		btnSurvivalPressed = atlas.findRegion("btn-survival-pressed");
		btnSurvivalPressed.flip(false, true);
		btnResume = atlas.findRegion("btn-resume");
		btnResume.flip(false, true);
		btnResumePressed = atlas.findRegion("btn-resume-pressed");
		btnResumePressed.flip(false, true);
		btnRetry = atlas.findRegion("btn-retry");
		btnRetry.flip(false, true);
		btnRetryPressed = atlas.findRegion("btn-retry-pressed");
		btnRetryPressed.flip(false, true);
		btnEnd = atlas.findRegion("btn-end");
		btnEnd.flip(false, true);
		btnEndPressed = atlas.findRegion("btn-end-pressed");
		btnEndPressed.flip(false, true);
		btnMusicOn = atlas.findRegion("btn-music-on");
		btnMusicOn.flip(false, true);
		btnMusicOff = atlas.findRegion("btn-music-off");
		btnMusicOff.flip(false, true);
		btnSoundOn = atlas.findRegion("btn-sound-on");
		btnSoundOn.flip(false, true);
		btnSoundOff = atlas.findRegion("btn-sound-off");
		btnSoundOff.flip(false, true);
		btnLeaderBoards = atlas.findRegion("btn-leaderboards");
		btnLeaderBoards.flip(false, true);
		btnLeaderBoardsPressed = atlas.findRegion("btn-leaderboards-pressed");
		btnLeaderBoardsPressed.flip(false, true);
		btnLeaderBoardsSurvival = atlas.findRegion("btn-leaderboards-survival");
		btnLeaderBoardsSurvival.flip(false, true);
		btnLeaderBoardsSurvivalPressed = atlas.findRegion("btn-leaderboards-survival-pressed");
		btnLeaderBoardsSurvivalPressed.flip(false, true);
		btnAchievements = atlas.findRegion("btn-achievements");
		btnAchievements.flip(false, true);
		btnAchievementsPressed = atlas.findRegion("btn-achievements-pressed");
		btnAchievementsPressed.flip(false, true);
		btnClose = atlas.findRegion("btn-close");
		btnClose.flip(false, true);
		btnClosePressed = atlas.findRegion("btn-close-pressed");
		btnClosePressed.flip(false, true);
		btnRate = atlas.findRegion("btn-rate");
		btnRate.flip(false, true);
		btnRatePressed = atlas.findRegion("btn-rate-pressed");
		btnRatePressed.flip(false, true);

		bg = atlas.findRegion("bg2");
		bg.flip(false, true);

		grass = atlas.findRegion("grass");
		grass.flip(false, true);

		gameover = atlas.findRegion("gameover");
		gameover.flip(false, true);

		downArrowUp = atlas.findRegion("down-arrow-up");
		downArrowUp.flip(false, true);

		downArrowCenter = atlas.findRegion("down-arrow-center");
		downArrowCenter.flip(false, true);

		downArrowDown = atlas.findRegion("down-arrow-down");
		downArrowDown.flip(false, true);

		downArrowAnimation = new Animation(0.1f, downArrowUp, downArrowCenter, downArrowDown);
		downArrowAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

		btnLeft = atlas.findRegion("btn-left");
		btnLeft.flip(false, true);

		btnLeftPressed = atlas.findRegion("btn-left-pressed");
		btnLeftPressed.flip(false, true);

		btnRight = atlas.findRegion("btn-right");
		btnRight.flip(false, true);

		btnRightPressed = atlas.findRegion("btn-right-pressed");
		btnRightPressed.flip(false, true);

		btnPause = atlas.findRegion("btn-pause");
		btnPause.flip(false, true);

		btnPausePressed = atlas.findRegion("btn-pause-pressed");
		btnPausePressed.flip(false, true);

		egg = atlas.findRegion("egg");
		egg.flip(false, true);

		lifeEgg = atlas.findRegion("lifeegg");
		lifeEgg.flip(false, true);

		lifeEggSign = atlas.findRegion("lifeeggsign");
		lifeEggSign.flip(false, true);

		deadEgg = atlas.findRegion("deadegg");
		deadEgg.flip(false, true);

		basket = atlas.findRegion("basket");
		basket.flip(false, true);

		basketBack = atlas.findRegion("basket-back");
		basketBack.flip(false, true);

		// Chicken assets
		chicken = new TextureRegion[] { atlas.findRegion("c1"),
				atlas.findRegion("c2") };
		chicken[0].flip(false, true);
		chicken[1].flip(false, true);

		chickenAnimation = new Animation(1f, chicken);
		chickenAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

		// Hero assets
		hero = new TextureRegion[] { atlas.findRegion("h1"),
				atlas.findRegion("h2"), atlas.findRegion("h3") };
		hero[0].flip(false, true);
		hero[1].flip(false, true);
		hero[2].flip(false, true);

		heroAnimation = new Animation(Hero.BOUNCING_TIME, hero);
		heroAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

		heroChicken = new TextureRegion[] { atlas.findRegion("h1c"),
				atlas.findRegion("h2c"), atlas.findRegion("h3c") };
		heroChicken[0].flip(false, true);
		heroChicken[1].flip(false, true);
		heroChicken[2].flip(false, true);

		heroChickenAnimation = new Animation(0.2f, heroChicken[0], heroChicken[1]);
		heroChickenAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

		// Sounds
		die = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
		jump = Gdx.audio.newSound(Gdx.files.internal("data/jump.wav"));
		point = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
		life = Gdx.audio.newSound(Gdx.files.internal("data/life.wav"));
		loop = Gdx.audio.newMusic(Gdx.files.internal("data/loop.wav"));
		winSound = Gdx.audio.newSound(Gdx.files.internal("data/levelWin.wav"));
		loseSound = Gdx.audio.newSound(Gdx.files.internal("data/lose.wav"));
		buttonSound = Gdx.audio.newSound(Gdx.files.internal("data/button.wav"));

		smallFont = new BitmapFont(Gdx.files.internal("data/smallFont.fnt"));
		smallFont.getData().setScale(.10f, -.10f);

		bigFont = new BitmapFont(Gdx.files.internal("data/bigFont.fnt"));
		bigFont.getData().setScale(.5f, -.5f);

		scoreFont = new BitmapFont(Gdx.files.internal("data/scoreFont.fnt"));
		scoreFont.getData().setScale(.3f, -.3f);

		// Create (or retrieve existing) preferences file
		prefs = Gdx.app.getPreferences("EggHero");

		if (!prefs.contains(PREFS_HIGHSCORE)) {
			prefs.putInteger(PREFS_HIGHSCORE, 0);
		}
		if (!prefs.contains(PREFS_HIGHSCORE_SURVIVAL)) {
			prefs.putInteger(PREFS_HIGHSCORE_SURVIVAL, 0);
		}
		if (!prefs.contains(PREFS_MUSIC_ON)) {
			prefs.putBoolean(PREFS_MUSIC_ON, true);
		}
		if (!prefs.contains(PREFS_SOUND_ON)) {
			prefs.putBoolean(PREFS_SOUND_ON, true);
		}
	}

	public static void dispose() {
		atlas.dispose();

		die.dispose();
		jump.dispose();
		point.dispose();
		loop.dispose();
		winSound.dispose();
		loseSound.dispose();

		scoreFont.dispose();
		bigFont.dispose();
		smallFont.dispose();
	}

	public static void play(Sound sound) {
		play(sound, 1);
	}

	public static void play(Sound sound, float vol) {
		boolean soundOn = prefs.getBoolean(PREFS_SOUND_ON);
		if (soundOn)
			sound.play(vol);
	}

	public static void playMusic(Music music, boolean loop) {
		boolean musicOn = prefs.getBoolean(PREFS_MUSIC_ON);
		if (musicOn)
			music.play();
		music.setLooping(loop);
	}

}
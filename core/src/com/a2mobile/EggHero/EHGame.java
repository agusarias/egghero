package com.a2mobile.EggHero;

import com.a2mobile.Helpers.IActivityRequestHandler;
import com.a2mobile.Helpers.AssetLoader;
import com.a2mobile.Screens.SplashScreen;
import com.badlogic.gdx.Game;

public class EHGame extends Game {
	private IActivityRequestHandler requestHandler;

	public EHGame(IActivityRequestHandler handler) {
		requestHandler = handler;
	}

	public EHGame() {
	}

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

	public void showAds() {
		this.requestHandler.showAds(true);
	}

	public void showAchievements(){
		this.requestHandler.showAchievements();
	}
	
	public void showLeaderBoards(){
		this.requestHandler.showLeaderBoards();
	}
	public void showLeaderBoardsSurvival(){
		this.requestHandler.showLeaderBoardsSurvival();
	}

	public void pushHighscoreNormal(int points) {
		this.requestHandler.pushHighscoreNormal(points);
	}

	public void pushHighscoreSurvival(int points) {
		this.requestHandler.pushHighscoreSurvival(points);
	}

	public void pushFirtLevelAchievement() {
		this.requestHandler.pushFirstLevelAchievement();
	}

	public void pushDiscoverBonusAchievement() {
		this.requestHandler.pushDiscoverBonusAchievement();
	}

	public void pushBeginnerAchievement() {
		this.requestHandler.pushBeginnerAchievement();
	}

	public void pushIntermediateAchievement() {
		this.requestHandler.pushIntermediateAchievement();
	}

	public void pushAdvancedAchievement() {
		this.requestHandler.pushAdvancedAchievement();
	}

	public void pushEggsHeroAchievement() {
		this.requestHandler.pushEggsHeroAchievement();
	}

	public void pushSecretAchievement() {
		this.requestHandler.pushSecretAchievement();
	}

	public void goRate() {
		this.requestHandler.goRate();
	}

}

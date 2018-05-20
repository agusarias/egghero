package com.a2mobile.Helpers;

public interface IActivityRequestHandler {
	public void showAds(boolean show);

	public void pushHighscoreNormal(int points);
	public void pushHighscoreSurvival(int points);

	void showAchievements();
	
	void showLeaderBoards();
	
	void showLeaderBoardsSurvival();
	
	void pushFirstLevelAchievement();

	void pushDiscoverBonusAchievement();

	void pushBeginnerAchievement();

	void pushIntermediateAchievement();

	void pushAdvancedAchievement();

	void pushEggsHeroAchievement();

	void pushSecretAchievement();

	void goRate();
}
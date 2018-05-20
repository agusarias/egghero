package com.mygdx.game.desktop;

import com.a2mobile.EggHero.EHGame;
import com.a2mobile.Helpers.IActivityRequestHandler;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher implements IActivityRequestHandler {
    private static DesktopLauncher application;

    public static void main(String[] argv) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "EggHero";
        cfg.useGL30 = false;
        cfg.width = 720;
        cfg.height = 480;
        if (application == null) {
            application = new DesktopLauncher();
        }

        new LwjglApplication(new EHGame(application), cfg);
    }

    @Override
    public void showAds(boolean show) {
        System.out.println("Show adds: " + show);
    }

    @Override
    public void pushHighscoreNormal(int points) {
        System.out.println("Push normal: " + points);
    }

    @Override
    public void pushHighscoreSurvival(int points) {
        System.out.println("Push survival: " + points);
    }

    @Override
    public void pushFirstLevelAchievement() {
        System.out.println("Win first level Achievement!");
    }

    @Override
    public void pushDiscoverBonusAchievement() {
        System.out.println("Discover Bonus Achievement!");
    }

    @Override
    public void pushBeginnerAchievement() {
        System.out.println("Beginner Achievement!");
    }

    @Override
    public void pushIntermediateAchievement() {
        System.out.println("Intermediate Achievement!");
    }

    @Override
    public void pushAdvancedAchievement() {
        System.out.println("Advanced Achievement!");

    }

    @Override
    public void pushEggsHeroAchievement() {
        System.out.println("Egg's Hero Achievement!");
    }

    @Override
    public void pushSecretAchievement() {
        System.out.println("SECRET Achievement!");

    }

    @Override
    public void showLeaderBoards() {
        System.out.println("Show leaderboards");

    }

    @Override
    public void showLeaderBoardsSurvival() {
        System.out.println("Show survival leaderboards");
    }

    @Override
    public void showAchievements() {
        System.out.println("Show achievements");
    }

    @Override
    public void goRate() {
    }
}
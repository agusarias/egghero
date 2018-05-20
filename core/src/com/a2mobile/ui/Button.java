package com.a2mobile.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Button {

	public boolean isClicked(int screenX, int screenY);

	public void draw(SpriteBatch batcher);

	public boolean isTouchDown(int screenX, int screenY);
	
	public boolean isTouchUp(int screenX, int screenY);
}

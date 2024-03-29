package com.mem.game.input;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mem.game.components.NpcComponent;

public class NpcInputProcessor implements InputProcessor {
	private Entity npc;
	private NpcComponent component;
	
	public NpcInputProcessor(Entity npc, NpcComponent comp) {
		this.npc = npc;
		this.component = comp;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.ENTER) {
			if (npc.getComponent(NpcComponent.class).state == NpcComponent.NpcState.SILENT) {
				npc.getComponent(NpcComponent.class).dialog.reset();
				npc.getComponent(NpcComponent.class).state = NpcComponent.NpcState.TALKING;
			} else if (npc.getComponent(NpcComponent.class).state == NpcComponent.NpcState.TALKING) {
				if (npc.getComponent(NpcComponent.class).dialog.isEnd())
					npc.getComponent(NpcComponent.class).state = NpcComponent.NpcState.SILENT;
				npc.getComponent(NpcComponent.class).dialog.nextPhrase();
			}
		}
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}
	
	@Override
	public boolean keyTyped(char character) {
		return false;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}
	
	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}

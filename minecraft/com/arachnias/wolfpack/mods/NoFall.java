package com.arachnias.wolfpack.mods;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

public class NoFall extends Module {
	
	public NoFall() {
		super("NoFall", Keyboard.KEY_G);
	}
	
	@Override
	public void onTick() {
		if (mc.thePlayer.fallDistance > 3 && this.isEnabled()) {
			mc.thePlayer.onGround = true;
		}
	}
	
}

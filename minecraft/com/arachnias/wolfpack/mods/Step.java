package com.arachnias.wolfpack.mods;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

public class Step extends Module {
	
	public Step() {
		super("Step", Keyboard.KEY_B);
	}
	
	@Override
	public void onTick() {
		if (this.isEnabled() && mc.thePlayer.isCollidedHorizontally && !mc.thePlayer.isOnLadder()) {
			mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.5, mc.thePlayer.posZ);
			//mc.thePlayer.motionY = 5;
			
		}
	}

}

package com.arachnias.wolfpack.mods;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

public class Fly extends Module {
	
	public Fly() {
		super("Fly", Keyboard.KEY_R);
		this.setModuleColour(0x66FF66);
	}
	
	@Override
	public void onEnable() {
		mc.thePlayer.motionY = 0.01;
		mc.thePlayer.capabilities.isFlying = true;
		mc.thePlayer.onGround = false;
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
	}
	
	@Override
	public void onTick() {
		if (this.isEnabled() && this.mc.thePlayer.onGround && this.mc.thePlayer.fallDistance <= 3) {
			this.mc.thePlayer.motionY = 0.1;
			this.mc.thePlayer.onGround = false;
			this.mc.thePlayer.capabilities.isFlying = true;
		}
	}
}

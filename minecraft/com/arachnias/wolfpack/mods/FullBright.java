package com.arachnias.wolfpack.mods;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

public class FullBright extends Module {
	
	private float oldGamma;
	
	public FullBright() {
		super("FullBright", Keyboard.KEY_F);
	}
	
	@Override
	public void onEnable() {
		this.oldGamma = mc.gameSettings.gammaSetting;
		mc.gameSettings.gammaSetting = 100F;
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.gammaSetting = 0F;
	}

}

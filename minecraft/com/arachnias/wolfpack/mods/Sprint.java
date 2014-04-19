package com.arachnias.wolfpack.mods;

import net.minecraft.network.play.client.C0BPacketEntityAction;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

public class Sprint extends Module {
	
	public Sprint() {
		super("Sprint", Keyboard.KEY_H);
	}
	
	@Override
	public void onEnable() {
		this.mc.getNetHandler().addToSendQueue(new C0BPacketEntityAction(this.mc.thePlayer, 4));
	}
	
	@Override
	public void onDisable() {
		this.mc.getNetHandler().addToSendQueue(new C0BPacketEntityAction(this.mc.thePlayer, 5));
	}

}

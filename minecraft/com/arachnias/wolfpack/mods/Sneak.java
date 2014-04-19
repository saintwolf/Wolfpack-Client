package com.arachnias.wolfpack.mods;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class Sneak extends Module {
	
	public Sneak() {
		super("Sneak", Keyboard.KEY_C);
		
	}
	
	@Override
	public void onEnable() {
		this.mc.getNetHandler().addToSendQueue(new C0BPacketEntityAction(mc.thePlayer, 1));
	}
	
	@Override
	public void onDisable() {
		this.mc.getNetHandler().addToSendQueue(new C0BPacketEntityAction(mc.thePlayer, 2));
	}
	
}

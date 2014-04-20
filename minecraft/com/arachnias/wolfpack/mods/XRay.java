package com.arachnias.wolfpack.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.ChatComponentText;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

public class XRay extends Module {
	
	private static ArrayList<Integer> xRayList = new ArrayList<Integer>();
	
	public XRay() {
		super("XRay", Keyboard.KEY_X);
		this.setModuleColour(0x00FBFF);
		
		xRayList.add(Block.getIdFromBlock(Block.getBlockFromName("diamond_ore")));
	}
	
	@Override
	public void onEnable() {
		this.mc.renderGlobal.setWorldAndLoadRenderers(this.mc.theWorld);
	}
	
	@Override
	public void onDisable() {
		this.mc.renderGlobal.setWorldAndLoadRenderers(this.mc.theWorld);
	}
	
	//TODO: XRay commands to add/remove/list active blocks
	@Override
	public void onChatCommand(String[] commandwithArgs) {
		
	}
	
	public static ArrayList<Integer> getXRayList() {
		return xRayList;
	}

}

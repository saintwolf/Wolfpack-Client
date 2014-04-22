package com.arachnias.wolfpack.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.ChatComponentText;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.Wolfpack;
import com.arachnias.wolfpack.modulebase.Module;

public class XRay extends Module {
	
	private static ArrayList<String> xRayList = new ArrayList<String>();
	
	public XRay() {
		super("XRay", Keyboard.KEY_X, new String[] {"xray"});
		this.setModuleColour(0x00FBFF);
		
		xRayList.add("diamond_ore");
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
		if (commandwithArgs.length == 1) {
			// Toggle the module
			this.toggle();
		} else if (commandwithArgs[1].equalsIgnoreCase("list")) {
			String list = "Active XRay blocks: ";
			for (String blockName: xRayList) {
				list += blockName + ", ";
			}
			this.mc.thePlayer.addChatMessage(new ChatComponentText(list));
		} else if (commandwithArgs[1].equalsIgnoreCase("add")) {
			if (commandwithArgs.length < 3) {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Not enough parameters. Usage: .xray add block_name"));
			} else if (xRayList.contains(commandwithArgs[2])) { 
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Block already in XRay List!"));
			} else if (Block.getBlockFromName(commandwithArgs[2]) == null) {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Invalid block name!"));
			} else {
				xRayList.add(commandwithArgs[2]);
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Added " + commandwithArgs[2] + " to XRay list!"));
				this.mc.renderGlobal.setWorldAndLoadRenderers(this.mc.theWorld);
			}
		} else if (commandwithArgs[1].equalsIgnoreCase("remove")) {
			if (commandwithArgs.length < 3) {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Not enough parameters. Usage: .xray remove block_name"));
			} else if (Block.getBlockFromName(commandwithArgs[2]) == null) {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Invalid block name!"));
			} else if (!xRayList.contains(commandwithArgs[2])) { 
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Block not found in XRay List!"));
			} else {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Removed " + commandwithArgs[2] + " from XRay list!"));
				this.mc.renderGlobal.setWorldAndLoadRenderers(this.mc.theWorld);
				xRayList.remove(commandwithArgs[2]);
			}
		}
	}
	
	public static ArrayList<String> getXRayList() {
		return xRayList;
	}

}

package com.arachnias.wolfpack.mods.chatcommands;

import net.minecraft.util.ChatComponentText;

import com.arachnias.wolfpack.modulebase.Module;

public class Up extends Module {
	
	public Up() {
		super("Up", new String[] {"up"});
	}
	
	@Override
	public void onChatCommand(String[] commandWithArgs) {
		int upAmount = -1;
		try {
			upAmount = Integer.parseInt(commandWithArgs[1]);
		} catch (NumberFormatException e) {
			this.mc.thePlayer.addChatMessage(new ChatComponentText("Up amount must be numbers!"));
			this.mc.thePlayer.addChatMessage(new ChatComponentText("Usage: .up <y>"));
		}
		
		if (upAmount == -1)
			return;
		
		if (commandWithArgs.length < 2) {
			this.mc.thePlayer.addChatMessage(new ChatComponentText("Not enough parameters."));
			this.mc.thePlayer.addChatMessage(new ChatComponentText("Usage: .up <y>"));
		} else if (commandWithArgs.length > 2) {
			this.mc.thePlayer.addChatMessage(new ChatComponentText("Too many parameters"));
			this.mc.thePlayer.addChatMessage(new ChatComponentText("Usage: .up <y>"));
		} else if ( Integer.parseInt(commandWithArgs[1]) < 0 ) {
			this.mc.thePlayer.addChatMessage(new ChatComponentText("You can't go up a negative amount. Use .down"));
		} else {
			this.mc.thePlayer.addChatMessage(new ChatComponentText("Teleporting up by " + commandWithArgs[1]));
			this.mc.thePlayer.setPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + Integer.parseInt(commandWithArgs[1]), this.mc.thePlayer.posZ);
		}
	}

}

package com.arachnias.wolfpack.mods.chatcommands;

import org.lwjgl.input.Keyboard;

import net.minecraft.util.ChatComponentText;

import com.arachnias.wolfpack.Wolfpack;
import com.arachnias.wolfpack.modulebase.Module;

public class Keybinds extends Module {
	
	public Keybinds() {
		super("Keybinds", new String[] {"keybinds"});
	}
	
	@Override
	public void onChatCommand(String[] commandWithArgs) {
		if (commandWithArgs[0].equalsIgnoreCase("keybinds")) {
			for (Module mod: Wolfpack.getModuleManager().moduleList) {
				if (mod.getKeybind() != 0) {
					this.mc.thePlayer.addChatMessage(new ChatComponentText(mod.getName() + " - " + Keyboard.getKeyName(mod.getKeybind())));
				}
			}
		}
	}

}

package com.arachnias.wolfpack.modulebase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arachnias.wolfpack.Wolfpack;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public abstract class Module {
	
	private String name;
	private int keybind;
	private boolean enabled;
	private boolean isChatCommand;
	private int moduleColour;
	
	private String[] chatCommands;
	
	private static final Logger logger = LogManager.getLogger();
	
	protected static Minecraft mc;
	
	/**
	 * Instantiates a Module which can be toggled with a keybind
	 * 
	 * @param name The name of the Module
	 * @param keybind The assigned keybind for the Module
	 */
	public Module(String name, int keybind) {
		this.name = name;
		this.keybind = keybind;
		this.chatCommands = null;
		
		this.isChatCommand = false;
		
		this.moduleColour = 0xFFFFFF;
		
		this.mc = Wolfpack.getMinecraft();
	}
	
	/**
	 * Instantiates a Module which can be toggled/configured with a chat command
	 * 
	 * @param name The name of the Module
	 * @param chatCommands An array of command names used by this module
	 */
	public Module(String name, String[] chatCommands) {
		this.name = name;
		this.keybind = 0;
		this.chatCommands = chatCommands;
		
		this.isChatCommand = true;
		
		this.moduleColour = 0xFFFFFF;
		
		this.mc = Wolfpack.getMinecraft();
	}
	
	/**
	 * Instantiates a Module which uses both a keybind and a chat command
	 * 
	 * @param name The name of the Module
	 * @param keybind The assigned keybind for the Module
	 * @param chatCommands An array of command names used by this module
	 */
	public Module(String name, int keybind, String[] chatCommands) {
		this.name = name;
		this.keybind = keybind;
		this.chatCommands = chatCommands;
		
		this.isChatCommand = true;
		
		this.moduleColour = 0xFFFFFF;
		
		this.mc = Wolfpack.getMinecraft();
	}
	
	public void onTick() {}
	
	public void onEnable() {}
	
	public void onDisable() {}
	
	public void onToggle() {}
	
	public void onRender() {}
	
	public void onAttackEntity(EntityPlayer player, Entity entity) {}
	
	public void onChatCommand(String[] commandWithArgs) {}
	
	public void onClickBlock(int x, int y, int z, int side) {}
	
	public String getName() {
		return this.name;
	}
	
	public int getKeybind() {
		return this.keybind;
	}
	
	public void setKeybind(int keybind) {
		this.keybind = keybind;
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public boolean isChatCommand() {
		return isChatCommand;
	}
	
	public String[] getChatCommands() {
		return this.chatCommands;
	}
	
	public void setModuleColour(int colour) {
		this.moduleColour = colour;
	}
	
	public int getModuleColour() {
		return this.moduleColour;
	}
	
	public final void setState(boolean enabled) {
		this.enabled = enabled;
		if (this.isEnabled()) {
			this.onEnable();
		} else {
			this.onDisable();
		}
	}
	
	public final void toggle() {
		this.setState(!this.isEnabled());
		this.onToggle();
	}

}

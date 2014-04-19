package com.arachnias.wolfpack.mods;

import net.minecraft.block.Block;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.ChatComponentText;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

public class Nuker extends Module {
	
	private int xFromPlayer;
	private int yFromPlayer;
	private int zFromPlayer;
	
	private int nukeSize;
	
	public Nuker() {
		super("Nuker", Keyboard.KEY_N, new String[] {"nuker"});
		this.setModuleColour(0xF33100);
		
		this.nukeSize = 2;
		
		this.resetXFromPlayer();
		this.resetYFromPlayer();
		this.resetZFromPlayer();
	}
	
	@Override
	public void onTick() {
		if (this.isEnabled()) {
			
			if (this.isXOutOfNukeRange())
				this.resetXFromPlayer();
			
			if (this.isYOutOfNukeRange())
				this.resetYFromPlayer();
			
			if (this.isZOutOfNukeRange())
				this.resetZFromPlayer();
			
			for (int i = 0; i < 100; i++) {
				Block block = this.mc.theWorld.getBlock(this.xFromPlayer, this.yFromPlayer, this.zFromPlayer);

				int face;
				if (this.yFromPlayer > 0) {
					face = 0;
				} else {
					face = 1;
				}
				this.mc.getNetHandler().addToSendQueue(new C07PacketPlayerDigging(0, xFromPlayer, yFromPlayer, zFromPlayer, face));

				this.xFromPlayer--;
				if (this.isXOutOfNukeRange()) {
					this.resetXFromPlayer();
					this.zFromPlayer--;

					if (this.isZOutOfNukeRange()) {
						this.resetZFromPlayer();
						this.yFromPlayer--;

						if (this.isYOutOfNukeRange()) {
							this.resetYFromPlayer();
						}
					}
				}
			}
		}
	}
	
	//TODO: Nuker options chat command
	@Override
	public void onChatCommand(String[] commandWithArgs) {
		if (commandWithArgs[1].equalsIgnoreCase("setradius")) {
			int radius;
			try {
				radius = Integer.parseInt(commandWithArgs[2]);
			} catch (NumberFormatException e) {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Up amount must be numbers!"));
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Usage: .nuker setradius <radius>"));
				radius = -1;
			}

			if (radius < 0)
				return;

			if (commandWithArgs.length < 3) {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Not enough parameters."));
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Usage: .nuker setradius <radius>"));
			} else if (commandWithArgs.length > 3) {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Too many parameters"));
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Usage: .nuker setradius <radius>"));
			} else if ( Integer.parseInt(commandWithArgs[2]) < 0 ) {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("You can't nuke a negative radius, in this dimension anyway..."));
			} else {
				this.mc.thePlayer.addChatMessage(new ChatComponentText("Set nuker radius to: " + commandWithArgs[2]));
				this.nukeSize = radius;
			}
		}
	}
	
	private void resetXFromPlayer() {
		this.xFromPlayer = (int)this.mc.thePlayer.posX + this.nukeSize;
	}
	
	private void resetYFromPlayer() {
		this.yFromPlayer = (int)this.mc.thePlayer.posY + this.nukeSize;
	}
	
	private void resetZFromPlayer() {
		this.zFromPlayer = (int)this.mc.thePlayer.posZ + this.nukeSize;
	}
	
	private boolean isXOutOfNukeRange() {
		if (this.xFromPlayer > (int)this.mc.thePlayer.posX + (this.nukeSize + 1) || this.xFromPlayer < (int)this.mc.thePlayer.posX - (this.nukeSize + 1)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isYOutOfNukeRange() {
		if (this.yFromPlayer > (int)this.mc.thePlayer.posY + (this.nukeSize) || this.yFromPlayer < (int)this.mc.thePlayer.posY - (this.nukeSize)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isZOutOfNukeRange() {
		if (this.zFromPlayer > (int)this.mc.thePlayer.posZ + this.nukeSize || this.zFromPlayer < (int)this.mc.thePlayer.posZ - this.nukeSize) {
			return true;
		} else {
			return false;
		}
	}
	

}

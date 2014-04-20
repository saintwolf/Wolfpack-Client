package com.arachnias.wolfpack.mods;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.modulebase.Module;

public class KillAura extends Module {
	
	private int attackDistance;
	
	public KillAura() {
		super("KillAura", Keyboard.KEY_K);
		
		this.attackDistance = 5;
	}
	
	@Override
	public void onTick() {
		if (this.isEnabled()) {
			List<Entity> lel = this.mc.theWorld.getLoadedEntityList();
			for (Entity entity: lel) {
				if (this.mc.thePlayer.getDistanceToEntity(entity) <= this.attackDistance && entity.getEntityId() != this.mc.thePlayer.getEntityId() && entity instanceof EntityLivingBase) {
					this.mc.playerController.attackEntity(this.mc.thePlayer, entity);
				}
			}
		}
	}
	
}

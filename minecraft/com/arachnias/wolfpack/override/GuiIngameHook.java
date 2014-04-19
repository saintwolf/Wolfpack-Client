package com.arachnias.wolfpack.override;

import org.lwjgl.input.Keyboard;

import com.arachnias.wolfpack.Wolfpack;
import com.arachnias.wolfpack.modulebase.Module;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;

public class GuiIngameHook extends GuiIngame {

	private boolean keyStates[];
	Minecraft mc = Minecraft.getMinecraft();
	private FontRenderer fr = mc.fontRenderer;
	
	public GuiIngameHook(Minecraft minecraft) {
		super(minecraft);
		keyStates = new boolean[256];
	}
	
	public boolean checkKey(int i) {
		if (mc.currentScreen != null) {
			return false;
		}
		
		if (Keyboard.isKeyDown(i) != keyStates[i]) {
			return keyStates[i] = !keyStates[i];
		} else {
			return false;
		}
	}
	
	@Override
	public void renderGameOverlay(float par1, boolean par2, int par3, int par4) {
		super.renderGameOverlay(par1, par2, par3, par4);
		
		ScaledResolution sr = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		int width = sr.getScaledWidth();
		int height = sr.getScaledHeight();
		
		fr.drawString("Arachnias", 2, 2, 0x66FF66);
		
		int number = 0;
		for (Module mod: Wolfpack.getModuleManager().moduleList) {
			if (mod.getKeybind() > 0) {
				int x = 2;
				int y = (10 * number);
				fr.drawString(mod.getName() + " = " + Keyboard.getKeyName(mod.getKeybind()), x, y + 15, mod.isEnabled() ? 0xFF55FFFF : 0xFFFFFFFF);
				number++;
			}
		}
		
		for (Module m: Wolfpack.getModuleManager().moduleList) {
			if (checkKey(m.getKeybind())) {
				m.toggle();
			}
		}
	}
	
}

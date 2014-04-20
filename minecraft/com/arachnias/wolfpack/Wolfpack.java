package com.arachnias.wolfpack;

import com.arachnias.wolfpack.modulebase.ModuleManager;

import net.minecraft.client.Minecraft;

public final class Wolfpack {
	
	private static Minecraft mc;
	private static ModuleManager moduleManager;
	
	public static void StartUp() {
		try {
			moduleManager = new ModuleManager();
		} catch (Exception e) {
			
		}
	}
	
	public static String getName() {
		return "Wolfpack";
	}
	
	public static String getVersion() {
		return "0.2 Beta";
	}
	
	public static String getAuthor() {
		return "Arachnias";
	}
	
	public static Minecraft getMinecraft() {
		if (mc == null)
			mc = Minecraft.getMinecraft();
		
		return mc;
	}
	
	public static ModuleManager getModuleManager() {
		if (moduleManager == null) {
			moduleManager = new ModuleManager();
		}
		
		return moduleManager;
	}

}

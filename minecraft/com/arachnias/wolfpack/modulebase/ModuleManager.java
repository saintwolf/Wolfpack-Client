package com.arachnias.wolfpack.modulebase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.arachnias.wolfpack.mods.*;
import com.arachnias.wolfpack.mods.chatcommands.*;

public class ModuleManager {
	
	public static List<Module> moduleList = Arrays.asList(new Module[] {
			new Fly(),
			new FreeCam(),
			new FullBright(),
			new KillAura(),
			new NoFall(),
			new Nuker(),
			new Sneak(),
			new Sprint(),
			new Step(),
			
			// Chat command only modules here
			new Up(),
	});
	
	public static Module[] getEnabledMods() {
		ArrayList<Module> enabledMods = new ArrayList<Module>();
		for (Module mod: moduleList) {
			if (mod.isEnabled()) {
				enabledMods.add(mod);
			}
		}
		
		return enabledMods.toArray(new Module[enabledMods.size()]);
	}
	
	private static Module getModByClassName(String name) {
		for (Module mod: moduleList) {
			if (mod.getClass().getSimpleName().toLowerCase().trim().equals(name.toLowerCase().trim())) {
				return mod;
			}
		}
		
		return null;
	}
	
	private static Module getModByName(String name) {
		for (Module mod: moduleList) {
			if (mod.getName().toLowerCase().trim().equals(name.toLowerCase().trim())) {
				return mod;
			}
		}
		
		return null;
	}
	
	public static Module findMod(Class<?extends Module> theClass) {
		for (Module mod: moduleList) {
			if (mod.getClass() == theClass) {
				return mod;
			}
		}
		
		return null;
	}
	
	public static Module findMod(String name) {
		Module mod = getModByName(name);
		if (mod != null) {
			return mod;
		}
		mod = getModByClassName(name);
		
		return mod;
	}
	
}

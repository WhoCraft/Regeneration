package com.lcm.regeneration.events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	@Mod.EventHandler public void preInit(FMLPreInitializationEvent ev) {
	}

	@Mod.EventHandler public void init(FMLInitializationEvent ev) {
        MinecraftForge.EVENT_BUS.register(new ClientHandler());
	}

	@Mod.EventHandler public void postInit(FMLPostInitializationEvent ev) {
	}

}

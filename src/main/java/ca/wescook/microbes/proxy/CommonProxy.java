package ca.wescook.microbes.proxy;

import ca.wescook.microbes.blocks.ModBlocks;
import ca.wescook.microbes.configs.Config;
import ca.wescook.microbes.crafting.ModCrafting;
import ca.wescook.microbes.creativetabs.ModCreativeTabs;
import ca.wescook.microbes.fluids.ModFluids;
import ca.wescook.microbes.items.ModItems;
import ca.wescook.microbes.tileentities.ModTileEntities;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		Config.registerConfigs(event);
		ModCreativeTabs.registerCreativeTabs();
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModFluids.registerFluids();
		ModTileEntities.registerTileEntities();
	}

	public void init(FMLInitializationEvent event) {
		ModCrafting.registerCrafting();
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}

package ca.wescook.microbes.proxy;

import ca.wescook.microbes.blocks.ModBlocks;
import ca.wescook.microbes.fluids.ModFluids;
import ca.wescook.microbes.items.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		ModBlocks.renderBlocks();
		ModItems.renderItems();
		ModFluids.renderFluids();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}

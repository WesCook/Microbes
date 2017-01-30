package ca.wescook.microbes;

import ca.wescook.microbes.proxy.CommonProxy;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static ca.wescook.microbes.Microbes.MODID;
import static ca.wescook.microbes.Microbes.MODNAME;

@Mod(modid = MODID, name = MODNAME, version = "@VERSION@")
public class Microbes
{
	// Mod Info
	public static final String MODID = "microbes";
	public static final String MODNAME = "Microbes";

	// Mod Constants
	public static final String[] traits = {"acidic", "coagulant", "combustible"};

	// Enable Universal Bucket
	static {
		FluidRegistry.enableUniversalBucket();
	}

	// Create instance of mod
	// Needed in entity registry
	@Mod.Instance
	public static Microbes instance;

	// Create instance of proxy
	// This will vary depending on if the client or server is running
	@SidedProxy(clientSide="ca.wescook.microbes.proxy.ClientProxy", serverSide="ca.wescook.microbes.proxy.ServerProxy")
	static private CommonProxy proxy;

	// Events
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Microbes.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		Microbes.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Microbes.proxy.postInit(event);
	}
}

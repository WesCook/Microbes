package ca.wescook.microbes;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import static ca.wescook.microbes.Microbes.*;

@Mod(modid = MODID, name = MODNAME, version = "@VERSION@")
public class Microbes
{
	public static final String MODID = "microbes";
	public static final String MODNAME = "Microbes";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}

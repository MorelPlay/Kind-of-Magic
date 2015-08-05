package mrriegel.rwl;

import mrriegel.rwl.handler.ConfigurationHandler;
import mrriegel.rwl.handler.DeathHandler;
import mrriegel.rwl.init.CraftingRecipes;
import mrriegel.rwl.init.ModBlocks;
import mrriegel.rwl.init.ModItems;
import mrriegel.rwl.init.RitualRecipes;
import mrriegel.rwl.proxy.ClientProxy;
import mrriegel.rwl.proxy.CommonProxy;
import mrriegel.rwl.reference.Reference;
import mrriegel.rwl.world.RWLWorld;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class RWL {

	@Mod.Instance(Reference.MOD_ID)
	public static RWL instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	private static int modGuiIndex = 0;
	public static final int ItemInventoryGuiIndex = modGuiIndex++;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		GameRegistry.registerWorldGenerator(new RWLWorld(), 1);
		ModBlocks.init();
		ModItems.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
		MinecraftForge.EVENT_BUS.register(new DeathHandler());
		CraftingRecipes.init();
		RitualRecipes.init();
		ClientProxy.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}

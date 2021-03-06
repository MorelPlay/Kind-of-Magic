package mrriegel.rwl.item;

import mrriegel.rwl.creative.CreativeTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public abstract class ItemTalisman extends Item {

	public ItemTalisman() {
		super();
		this.setCreativeTab(CreativeTab.tab1);
		this.setMaxStackSize(1);
	}

	abstract public void perform(EntityPlayer player);

	public static void init() {
		MinecraftForge.EVENT_BUS.register(new ItemStepper());
		MinecraftForge.EVENT_BUS.register(new ItemFlyer());
		MinecraftForge.EVENT_BUS.register(new ItemVision());
		MinecraftForge.EVENT_BUS.register(new ItemJumper());
		MinecraftForge.EVENT_BUS.register(new ItemExtinger());
	}

}

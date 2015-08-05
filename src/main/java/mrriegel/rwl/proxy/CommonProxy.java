package mrriegel.rwl.proxy;

import java.util.HashMap;
import java.util.Map;

import mrriegel.rwl.gui.ContainerBag;
import mrriegel.rwl.gui.ContainerNevTool;
import mrriegel.rwl.gui.GuiBag;
import mrriegel.rwl.gui.GuiIDs;
import mrriegel.rwl.gui.GuiNevTool;
import mrriegel.rwl.gui.InventoryBag;
import mrriegel.rwl.gui.InventoryNevTool;
import mrriegel.rwl.utility.BlockLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

	public static void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name) {
		return extendedEntityData.remove(name);
	}

	public void registerRenderers() {
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case GuiIDs.NEVTOOL:
			return new ContainerNevTool(player, player.inventory,
					new InventoryNevTool(player.getHeldItem()));
		case GuiIDs.BAG:
			return new ContainerBag(player, player.inventory, new InventoryBag(
					player.getHeldItem()));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case GuiIDs.NEVTOOL:
			return new GuiNevTool(new ContainerNevTool(player,
					player.inventory,
					new InventoryNevTool(player.getHeldItem())));
		case GuiIDs.BAG:
			return new GuiBag(new ContainerBag(player, player.inventory,
					new InventoryBag(player.getHeldItem())));
		}
		return null;
	}

	public void generateParticles(World world, BlockLocation loc) {
	}

}

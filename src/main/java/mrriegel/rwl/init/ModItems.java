package mrriegel.rwl.init;

import mrriegel.rwl.item.AirOreDust;
import mrriegel.rwl.item.BloodRelic;
import mrriegel.rwl.item.Bloodie;
import mrriegel.rwl.item.Catalyst;
import mrriegel.rwl.item.CrystalBag;
import mrriegel.rwl.item.Crysthal;
import mrriegel.rwl.item.Drop;
import mrriegel.rwl.item.Dung;
import mrriegel.rwl.item.ItemBreather;
import mrriegel.rwl.item.ItemFeeder;
import mrriegel.rwl.item.ItemFlyer;
import mrriegel.rwl.item.ItemJumper;
import mrriegel.rwl.item.ItemRepair;
import mrriegel.rwl.item.ItemSprinter;
import mrriegel.rwl.item.ItemStepper;
import mrriegel.rwl.item.ItemVision;
import mrriegel.rwl.item.MazeDust;
import mrriegel.rwl.item.Nev;
import mrriegel.rwl.item.NevAxe;
import mrriegel.rwl.item.NevPick;
import mrriegel.rwl.item.NevShovel;
import mrriegel.rwl.item.NevSword;
import mrriegel.rwl.item.OreDust;
import mrriegel.rwl.item.OreStick;
import mrriegel.rwl.item.TaliBag;
import mrriegel.rwl.item.Up;
import mrriegel.rwl.item.WNugget;
import mrriegel.rwl.reference.Reference;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	public static Item bloodie = new Bloodie();
	public static Item relic = new BloodRelic();
	public static Item catalyst = new Catalyst();
	public static Item mdust = new MazeDust();
	public static Item nevsword = new NevSword();
	public static Item nevpick = new NevPick();
	public static Item nevshovel = new NevShovel();
	public static Item nevaxe = new NevAxe();
	public static Item cry = new Crysthal();
	public static Item bag = new CrystalBag();
	public static Item odust = new OreDust();
	public static Item aodust = new AirOreDust();
	public static Item nev = new Nev();
	public static Item ostick = new OreStick();
	public static Item wnugget = new WNugget();
	public static Item drop = new Drop();
	public static Item tbag = new TaliBag();
	public static Item feeder = new ItemFeeder();
	public static Item sprinter = new ItemSprinter();
	public static Item repair = new ItemRepair();
	public static Item stepper = new ItemStepper();
	public static Item flyer = new ItemFlyer();
	public static Item breather = new ItemBreather();
	public static Item vision = new ItemVision();
	public static Item jumper = new ItemJumper();
	public static Item dung = new Dung();
	public static Item up = new Up();

	public static void init() {
		GameRegistry.registerItem(bloodie, "bloodie");
		bloodie.setContainerItem(Items.glass_bottle);
		GameRegistry.registerItem(relic, "relic");
		GameRegistry.registerItem(catalyst, "catalyst");
		catalyst.setContainerItem(catalyst);
		GameRegistry.registerItem(mdust, "mdust");
		GameRegistry.registerItem(nevsword, "nevsword");
		GameRegistry.registerItem(nevpick, "nevpick");
		GameRegistry.registerItem(nevshovel, "nevshovel");
		GameRegistry.registerItem(nevaxe, "nevaxe");
		GameRegistry.registerItem(cry, "cry");
		GameRegistry.registerItem(bag, "bag");
		GameRegistry.registerItem(aodust, "airoredust");
		GameRegistry.registerItem(odust, "oredust");
		GameRegistry.registerItem(nev, "nev");
		GameRegistry.registerItem(ostick, "ostick");
		GameRegistry.registerItem(up, "up");
		GameRegistry.registerItem(wnugget, "wnugget");
		GameRegistry.registerItem(drop, "drop");
		GameRegistry.registerItem(tbag, "tbag");
		GameRegistry.registerItem(dung, "dung");
		GameRegistry.registerItem(feeder, "feeder");
		GameRegistry.registerItem(sprinter, "sprinter");
		GameRegistry.registerItem(repair, "repair");
		GameRegistry.registerItem(stepper, "stepper");
		GameRegistry.registerItem(flyer, "flyer");
		GameRegistry.registerItem(breather, "breather");
		GameRegistry.registerItem(vision, "vision");
		GameRegistry.registerItem(jumper, "jumper");

	}
}

package mrriegel.rwl.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import mrriegel.rwl.init.RitualRecipe;
import mrriegel.rwl.init.RitualRecipes;
import mrriegel.rwl.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class RecipeHandler extends TemplateRecipeHandler {

	public class CachedRitualRecipe extends CachedRecipe {
		PositionedStack output;
		public List<PositionedStack> input = new ArrayList<PositionedStack>();
		PositionedStack cat;
		int time, dimensionID;
		public int xp;

		public CachedRitualRecipe(RitualRecipe r) {
			output = new PositionedStack(r.getOutput(), 75, 4, false);
			input.add(new PositionedStack(r.getInput1(), 25, 40, false));
			input.add(new PositionedStack(r.getInput2(), 45, 40, false));
			input.add(new PositionedStack(r.getInput3(), 65, 40, false));
			input.add(new PositionedStack(r.getInput4(), 85, 40, false));
			cat = new PositionedStack(r.getCat(), 125, 40, false);
			time = r.getTime();
			dimensionID = r.getDimensionID();
			xp=r.getXp();
		}

		@Override
		public PositionedStack getResult() {
			return output;
		}

		@Override
		public List<PositionedStack> getIngredients() {
			input.add(cat);
			return input;
		}

	}

	@Override
	public String getRecipeName() {
		return "Lorem ipsum";
	}

	@Override
	public String getGuiTexture() {
		return new ResourceLocation(Reference.MOD_ID + ":"
				+ "textures/gui/nei.png").toString();
	}

	@Override
	public void drawBackground(int recipe) {
		super.drawBackground(recipe);
		if (!(arecipes.get(recipe) instanceof CachedRitualRecipe)) {
			return;
		}
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
		CachedRitualRecipe r = (CachedRitualRecipe) arecipes.get(recipe);
		if (r.dimensionID == 0)
			GuiDraw.drawString("Overworld", 7, 15, 0x404040, false);
		else if (r.dimensionID == 1)
			GuiDraw.drawString("End", 7, 15, 0x404040, false);
		else if (r.dimensionID == -1)
			GuiDraw.drawString("Nether", 7, 15, 0x404040, false);
		else
			GuiDraw.drawString("Anywhere", 7, 15, 0x404040, false);
		if (r.time == 0)
			GuiDraw.drawString("Day", 7, 5, 0x404040, false);
		else if (r.time == 1)
			GuiDraw.drawString("Night", 7, 5, 0x404040, false);
		else
			GuiDraw.drawString("Anytime", 7, 5, 0x404040, false);
		GuiDraw.drawString(r.xp+" XP", 7, 25, 0x404040, false);
	}

	@Override
	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(75, 23, 16, 16),
				"rwl:stone"));
	}

	@Override
	public int recipiesPerPage() {
		return 2;
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("rwl:stone")) {
			for (RitualRecipe recipe : RitualRecipes.lis) {
				arecipes.add(new CachedRitualRecipe(recipe));
			}

		} else
			super.loadCraftingRecipes(outputId, results);
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		for (RitualRecipe recipe : RitualRecipes.lis) {

			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getOutput(),
					result))
				arecipes.add(new CachedRitualRecipe(recipe));
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		for (RitualRecipe recipe : RitualRecipes.lis) {

			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getInput1(),
					ingredient)
					|| NEIServerUtils.areStacksSameTypeCrafting(
							recipe.getInput2(), ingredient)
					|| NEIServerUtils.areStacksSameTypeCrafting(
							recipe.getInput3(), ingredient)
					|| NEIServerUtils.areStacksSameTypeCrafting(
							recipe.getInput4(), ingredient)
					|| NEIServerUtils.areStacksSameTypeCrafting(
							recipe.getCat(), ingredient))
				arecipes.add(new CachedRitualRecipe(recipe));

		}
	}
}

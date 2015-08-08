package mrriegel.rwl.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import mrriegel.rwl.init.RitualRecipe;
import mrriegel.rwl.init.RitualRecipes;
import mrriegel.rwl.reference.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class RecipeHandler extends TemplateRecipeHandler {

	public class CachedRitualRecipe extends CachedRecipe {
		PositionedStack output;
		public List<PositionedStack> input = new ArrayList<PositionedStack>();
		PositionedStack cat;
		PositionedStack time;

		public CachedRitualRecipe(RitualRecipe r) {
			output = new PositionedStack(r.getOutput(), 75, 4, false);
			input.add(new PositionedStack(r.getInput1(), 25, 40, false));
			input.add(new PositionedStack(r.getInput2(), 45, 40, false));
			input.add(new PositionedStack(r.getInput3(), 65, 40, false));
			input.add(new PositionedStack(r.getInput4(), 85, 40, false));
			cat = new PositionedStack(r.getCat(), 125, 40, false);
			//time=new PositionedStack(object, 15, 20, false);
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
		return "Stone";
	}

	@Override
	public String getGuiTexture() {
		return new ResourceLocation(Reference.MOD_ID + ":"
				+ "textures/gui/nei.png").toString();
	}

	@Override
	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(75, 21, 16, 16),
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

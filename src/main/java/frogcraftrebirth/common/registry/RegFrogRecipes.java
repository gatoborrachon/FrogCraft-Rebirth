package frogcraftrebirth.common.registry;

import frogcraftrebirth.api.FrogAPI;
import frogcraftrebirth.common.FrogFluids;
import frogcraftrebirth.common.FrogItems;
import frogcraftrebirth.common.lib.PyrolyzerRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RegFrogRecipes {
	
	public static void init() {
		FrogAPI.managerPyrolyzer.add(new PyrolyzerRecipe(new ItemStack(Items.COAL), new ItemStack(FrogItems.itemIngot, 1, 7), new FluidStack(FrogFluids.coalTar, 50), 100));
		FrogAPI.managerPyrolyzer.add(new PyrolyzerRecipe(new ItemStack(Blocks.COBBLESTONE), new ItemStack(FrogItems.itemDust, 1, 2), new FluidStack(FrogFluids.carbonDioxide, 50), 100));
	
		defaultRecipe();
	}
	
	public static void postInit() {
		//Register crafting recipe!
		FrogAPI.FUEL_REG.regFuel(new ItemStack(FrogItems.itemIngot, 1, 3), 16000);
		FrogAPI.FUEL_REG.regFuel(new ItemStack(FrogItems.itemIngot, 1, 4), 1800);
	}
	
	private static void defaultRecipe() {
		
	}
}

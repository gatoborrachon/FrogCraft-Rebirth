/**
 * This file is a part of FrogCraftRebirth, 
 * created by U_Knowledge at 3:53:09 PM, Mar 28, 2016, EST
 * FrogCraftRebirth, is open-source under MIT license,
 * check https://github.com/FrogCraft-Rebirth/
 * FrogCraft-Rebirth/LICENSE_FrogCraft_Rebirth for 
 * more information.
 */
package frogcraftrebirth.api.tile;

import frogcraftrebirth.api.item.ICatalystModuleItem;
import frogcraftrebirth.api.recipes.IAdvChemRecRecipe;

public interface IAdvChemReactor {
	
	boolean checkIngredient(IAdvChemRecRecipe recipe);
	
	double modifyReactionRate(ICatalystModuleItem... catalyst);
	
	void produce();

}
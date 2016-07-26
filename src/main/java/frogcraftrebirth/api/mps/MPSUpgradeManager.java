/**
 * This file is a part of FrogCraftRebirth, 
 * created by 3TUSK at 1:41:04 PM, Jul 25, 2016, 
 * FrogCraftRebirth, is open-source under MIT license,
 * check https://github.com/FrogCraft-Rebirth/
 * FrogCraft-Rebirth/LICENSE_FrogCraft_Rebirth for 
 * more information.
 */
package frogcraftrebirth.api.mps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import frogcraftrebirth.api.FrogAPI;
import net.minecraft.item.ItemStack;

public enum MPSUpgradeManager {
	
	INSTANCE;
	
	private Set<ItemStack> validSolarUpgrades = new HashSet<ItemStack>();
	
	private Map<ItemStack, Integer> validStorageUpgrades = new HashMap<ItemStack, Integer>();
	
	private Map<ItemStack, Integer> validVoltageUpgrades = new HashMap<ItemStack, Integer>();
	
	public boolean isSolarUpgradeValid(ItemStack stack) { 
		for (ItemStack aStack : validSolarUpgrades) {
			if (aStack.isItemEqual(stack))
				return true;
		}
		
		return false;
	}
	
	public int getEnergyStoreIncreasementFrom(ItemStack stack) {
		for (Map.Entry<ItemStack, Integer> entry : validStorageUpgrades.entrySet()) {
			if (entry.getKey().isItemEqual(stack))
				return entry.getValue();
		}
		return 0;
	}
	
	public int getVoltageIncreasementFrom(ItemStack stack) {
		for (Map.Entry<ItemStack, Integer> entry : validVoltageUpgrades.entrySet()) {
			if (entry.getKey().isItemEqual(stack))
				return entry.getValue();
		}
		return 0;
	}
	
	/**
	 * @param stack The upgrade item being registered
	 * @return true if succeed, false if fail
	 */
	public boolean registerSolarUpgrade(ItemStack stack) {
		try {
			return validSolarUpgrades.add(stack);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @param stack The upgrade item being registered
	 * @param incrQuantity The quantity increased of energy storage, measured in EU
	 * @return true if succeed, false if fail
	 */
	public boolean registerStorageUpgrade(ItemStack stack, int incrQuantity) {
		try {
			validStorageUpgrades.put(stack, incrQuantity);
			return true;
		} catch (Exception e) {
			FrogAPI.FROG_LOG.error("Failed to register " + stack.toString() + " as valid MPS storage upgrade");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @param stack The upgrade item being registered
	 * @param incrQuantity The quantity increased of voltage level. 1 is LV, 2 is MV, 3 is HV, and so on.
	 * @return true if succeed, false if fail
	 * @See {@link ic2.api.energy.tile.IEnergySource}
	 */
	public boolean registerVoltageUpgrades(ItemStack stack, int incrQuantity) {
		try {
			validVoltageUpgrades.put(stack, incrQuantity);
			return true;
		} catch (Exception e) {
			FrogAPI.FROG_LOG.error("Failed to register " + stack.toString() + " as valid MPS voltage upgrade");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Clear all existed registry info.
	 * @return
	 */
	public boolean resetRegistry() {
		validSolarUpgrades.clear();
		validStorageUpgrades.clear();
		validVoltageUpgrades.clear();
		return true;
	}
}
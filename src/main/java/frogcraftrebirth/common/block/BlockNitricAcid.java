/*
 * Copyright (c) 2015 - 2020 3TUSK, et al.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package frogcraftrebirth.common.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockNitricAcid extends BlockFluidClassic {
	
	public BlockNitricAcid(Fluid fluid) {
		super(fluid, Material.WATER);
		this.setTranslationKey("nitric_acid");
		this.setDensity(fluid.getDensity());
		this.setQuantaPerBlock(8);
		this.setTickRate(20);
	}
	
	@Override
	public boolean canDisplace(IBlockAccess world, BlockPos pos) {
		return !world.getBlockState(pos).getMaterial().isLiquid() && super.canDisplace(world, pos);
	}

	@Override
	public boolean displaceIfPossible(World world, BlockPos pos) {
		return !world.getBlockState(pos).getMaterial().isLiquid() && super.displaceIfPossible(world, pos);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(world, pos, state, rand);

		if (rand.nextBoolean()) {
			return;
		}
		
		for (int m = -2; m < 3; m++) {
			for (int n = -2; n < 3; n++) {
				for (int o = -2; o < 0; o++) {
					int randInt = rand.nextInt(100);
					if (randInt < 75 && world.getBlockState(pos.add(m, n, o)) == Blocks.GRASS.getDefaultState()) {
						world.setBlockState(pos.add(m, n, o), Blocks.DIRT.getDefaultState());
					}
					if (randInt < 50 && world.getBlockState(pos.add(m, n, o)) == Blocks.DIRT.getDefaultState()) {
						world.setBlockState(pos.add(m, n, o), Blocks.SAND.getDefaultState());
						continue;
					}
					if (randInt < 25 && world.getBlockState(pos.add(m, n, o)) == Blocks.STONE.getDefaultState()) {
						world.setBlockState(pos.add(m, n, o), Blocks.COBBLESTONE.getDefaultState());
					}
					if (randInt < 15 && world.getBlockState(pos.add(m, n, o)) == Blocks.COBBLESTONE.getDefaultState()) {
						world.setBlockState(pos.add(m, n, o), Blocks.GRAVEL.getDefaultState());
						continue;
					}
					if (randInt < 20 && world.getBlockState(pos.add(m, n, o)) == Blocks.GRAVEL.getDefaultState()) {
						world.setBlockState(pos.add(m, n, o), Blocks.SAND.getDefaultState());
						continue;
					}
					if (randInt < 10 && world.getBlockState(pos.add(m, n, o)).getBlock() == Blocks.SAND) {
						world.setBlockToAir(pos.north(m).east(n));
					}
				}
			}
		}

		if (rand.nextInt(1000) == 0) {
			world.setBlockToAir(pos);
		}
	}

}

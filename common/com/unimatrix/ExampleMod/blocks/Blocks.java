package com.unimatrix.ExampleMod.blocks;

import net.minecraft.block.Block;

import com.unimatrix.ExampleMod.items.ItemExampleBlock;
import com.unimatrix.ExampleMod.lib.BlockInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks
{

    public static Block exampleblock;

    public static void Initialise()
    {
        exampleblock = new ExampleBlock(BlockInfo.EXAMPLEBLOCK_ID);
        GameRegistry.registerBlock(exampleblock, ItemExampleBlock.class, BlockInfo.EXAMPLEBLOCK_UNIQUE_NAME);

    }

    public static void Localise()
    {
        LanguageRegistry.addName(exampleblock, BlockInfo.EXAMPLEBLOCK_LOCAL_NAME);
    }
}

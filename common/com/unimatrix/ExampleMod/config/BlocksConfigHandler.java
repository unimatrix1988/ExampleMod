package com.unimatrix.ExampleMod.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.unimatrix.ExampleMod.lib.BlockInfo;

public class BlocksConfigHandler
{
    public static void LoadConfig(File configFile)
    {
        Configuration config = new Configuration(configFile);

        config.load();

        BlockInfo.EXAMPLEBLOCK_ID = config.getBlock(
                BlockInfo.EXAMPLEBLOCK_UNIQUE_NAME,
                BlockInfo.EXAMPLEBLOCK_DEFAULT_ID).getInt(
                BlockInfo.EXAMPLEBLOCK_DEFAULT_ID);

        config.save();
    }
}
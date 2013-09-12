package com.unimatrix.ExampleMod.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.unimatrix.ExampleMod.lib.ItemInfo;

public class ItemsConfigHandler
{

    public static void LoadConfig(File configFile)
    {
        Configuration config = new Configuration(configFile);

        config.load();

        // Loads or Creates the item ID in the Config file, 256 must be
        // subtracted as it was added automatically by the function.
        ItemInfo.EXAMPLEITEM_ID = config.getItem(
                ItemInfo.EXAMPLEITEM_UNIQUE_NAME,
                ItemInfo.EXAMPLEITEM_DEFALT_ID).getInt(
                ItemInfo.EXAMPLEITEM_DEFALT_ID);
        ItemInfo.MULTITEXTUREITEM_ID = config.getItem(
                ItemInfo.MULTITEXTUREITEM_UNIQUE_NAME,
                ItemInfo.MULTITEXTUREITEM_DEFAULT_ID).getInt(
                ItemInfo.MULTITEXTUREITEM_ID);
        ItemInfo.CARD_ID = config.getItem(ItemInfo.CARD_UNIQUE_NAME,
                ItemInfo.CARD_DEFAULT_ID).getInt(ItemInfo.CARD_DEFAULT_ID);

        config.save();
    }
}
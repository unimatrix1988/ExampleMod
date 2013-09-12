package com.unimatrix.ExampleMod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.unimatrix.ExampleMod.lib.ItemInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items
{
    public static Item exampleItem;
    public static Item multiTextureItem;
    public static Item card;

    // Here we initialise single instances of all the items loaded by this mod.
    public static void Initialise()
    {
        // initialise a new item of type ExampleWand
        exampleItem = new ExampleItem(ItemInfo.EXAMPLEITEM_ID);
        
        multiTextureItem = new MultiTextureItem(ItemInfo.MULTITEXTUREITEM_ID);
        card = new CardItem(ItemInfo.CARD_ID);
    }

    public static void Localise()
    {
        // Takes a loaded item and assigns the localised name to it.
        LanguageRegistry.addName(exampleItem, ItemInfo.EXAMPLEITEM_LOCAL_NAME);

        LanguageRegistry.addName(multiTextureItem, ItemInfo.MULTITEXTUREITEM_LOCAL_NAME);
        for (short i = 0; i < ItemInfo.CARD_LOCAL_NAMES.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(card, 1, i), ItemInfo.CARD_LOCAL_NAMES[i]);
        }
    }

    public static void RegisterRecipes()
    {
        //Adds a recipe for an Item, Grid identifiers must be in single quotes 'E' as a char.
        GameRegistry.addRecipe(new ItemStack(exampleItem),
                new Object[] { "  X",
                               " / ",
                               "/  ",
                               'X', Item.goldenCarrot,
                               '/', Item.stick});
        
        GameRegistry.addRecipe(new ItemStack(multiTextureItem),
                new Object[] { "  G",
                               " X ",
                               "/  ",
                               'G', Item.glowstone,
                               'X', exampleItem,
                               '/', Item.stick});
    }
}
 
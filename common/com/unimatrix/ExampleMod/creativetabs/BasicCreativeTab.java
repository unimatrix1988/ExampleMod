package com.unimatrix.ExampleMod.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

import com.unimatrix.ExampleMod.lib.ItemInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicCreativeTab extends CreativeTabs
{
    public BasicCreativeTab(int tabID, String tabLabel)
    {
        super(tabID, tabLabel);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return ItemInfo.EXAMPLEITEM_ID;
    }
}

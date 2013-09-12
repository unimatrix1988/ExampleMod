package com.unimatrix.ExampleMod.items;

/*import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;*/
import net.minecraft.item.Item;

import com.unimatrix.ExampleMod.lib.Reference;

public class ItemWrapper extends Item
{
    public ItemWrapper(int id) {

        super(id - Reference.ITEM_ID_CORRECTION);
    }

/*    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }*/
}

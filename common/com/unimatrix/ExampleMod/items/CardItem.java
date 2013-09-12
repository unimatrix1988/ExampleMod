package com.unimatrix.ExampleMod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.unimatrix.ExampleMod.ExampleMod;
import com.unimatrix.ExampleMod.blocks.Blocks;
import com.unimatrix.ExampleMod.lib.ItemInfo;
import com.unimatrix.ExampleMod.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CardItem extends ItemWrapper
{
    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public CardItem(int id)
    {
        super(id);

        setCreativeTab(ExampleMod.tabExampleMod);

        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return ItemInfo.CARD_UNIQUE_NAME + itemStack.getItemDamage();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        icons = new Icon[ItemInfo.CARD_ICONS.length];
        for (short i = 0; i < icons.length; i++)
        {
            icons[i] = register.registerIcon(Reference.ASSETS_LOCATION + ":"
                    + ItemInfo.CARD_ICONS[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int damage)
    {
        return icons[damage];
    }

    @SuppressWarnings(value = { "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (short i = 0; i < ItemInfo.CARD_LOCAL_NAMES.length; i++)
        {
            ItemStack stack = new ItemStack(id, 1, i);
            list.add(stack);
        }
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,
            World world, int x, int y, int z, int side, float hitX, float hitY,
            float hitZ)
    {
        if (!world.isRemote
                && world.getBlockId(x, y, z) == Blocks.exampleblock.blockID)
        {
            int meta = world.getBlockMetadata(x, y, z);

            int disabled = meta % 2;

            int type = stack.getItemDamage() + 1;

            int newMeta = type * 2 + disabled;

            world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);

            stack.stackSize--;

            return true;
        }
        else
        {
            return false;
        }
    }
}

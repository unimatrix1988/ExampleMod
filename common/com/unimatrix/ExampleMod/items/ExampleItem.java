package com.unimatrix.ExampleMod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.unimatrix.ExampleMod.ExampleMod;
import com.unimatrix.ExampleMod.lib.ItemInfo;
import com.unimatrix.ExampleMod.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExampleItem extends ItemWrapper
{
    public ExampleItem(int id)
    {
        super(id);
        
        //Specifies what creative tab the item should be placed in, as its a weapon its placed in the Combat Tab.
        setCreativeTab(ExampleMod.tabExampleMod);
        
        //Specifies how many of this item can be held in one stack, as its a weapon only 1 can be held so the stack is 1.
        setMaxStackSize(1);
        
        //sets the basic unlocalised name of the item.
        setUnlocalizedName(ItemInfo.EXAMPLEITEM_UNIQUE_NAME);
    }
    
    @Override
    public boolean func_111207_a(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase target)
    {
        if(!target.worldObj.isRemote)
        {
            target.motionY = 2;
            itemStack.setItemDamage(itemStack.getItemDamage() + 1);
        }
        
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        itemIcon = register.registerIcon(Reference.ASSETS_LOCATION + ":" + ItemInfo.EXAMPLEITEM_ICON);
    }
    
    @SuppressWarnings(value =
        { "rawtypes", "unchecked" }) //Here to remove warnings related to Vanilla minecraft and not this code, Relates to "List info"
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add(
            EnumChatFormatting.GRAY +"Used: " +
            EnumChatFormatting.GREEN + itemStack.getItemDamage() +
            EnumChatFormatting.GRAY + " times");
    }
}
package com.unimatrix.ExampleMod.items;

import net.minecraft.item.ItemBlock;

public class ItemExampleBlock extends ItemBlock
{
    public  ItemExampleBlock(int id)
    {
        super(id);
        setHasSubtypes(true);
}
    
    @Override
    public int getMetadata(int dmg)
    {
        return dmg;
    }
}

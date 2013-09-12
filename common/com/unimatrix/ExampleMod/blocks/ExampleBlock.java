package com.unimatrix.ExampleMod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.unimatrix.ExampleMod.ExampleMod;
import com.unimatrix.ExampleMod.lib.BlockInfo;
import com.unimatrix.ExampleMod.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExampleBlock extends Block
{

    @SideOnly(Side.CLIENT)
    private Icon topIcon;
    @SideOnly(Side.CLIENT)
    private Icon bottomIcon;
    @SideOnly(Side.CLIENT)
    private Icon[] sideIcons;
    @SideOnly(Side.CLIENT)
    private Icon topDisabledIcon;

    public ExampleBlock(int id)
    {
        super(id, Material.iron);

        setCreativeTab(ExampleMod.tabExampleMod);
        setHardness(2F);
        setStepSound(Block.soundMetalFootstep);
        setUnlocalizedName(BlockInfo.EXAMPLEBLOCK_UNIQUE_NAME);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister register)
    {
        topIcon = register.registerIcon(Reference.ASSETS_LOCATION + ":" + BlockInfo.EXAMPLEBLOCK_TOP);
        bottomIcon = register.registerIcon(Reference.ASSETS_LOCATION + ":" + BlockInfo.EXAMPLEBLOCK_BOTTOM);

        sideIcons = new Icon[BlockInfo.EXAMPLEBLOCK_SIDES.length];
        for (byte i = 0; i < sideIcons.length; i++)
        {
            sideIcons[i] = register.registerIcon(Reference.ASSETS_LOCATION + ":" + BlockInfo.EXAMPLEBLOCK_SIDES[i]);
        }
        topDisabledIcon = register.registerIcon(Reference.ASSETS_LOCATION + ":" + BlockInfo.EXAMPLEBLOCK_TOP_DISABLED);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {
        switch (side)
        {
        case 0:
            return bottomIcon;
        case 1:
            return isDisabled(meta) ? topDisabledIcon : topIcon;
        default:
            int type = meta / 2;
            return sideIcons[type];
        }
    }

    private boolean isDisabled(int meta)
    {
        return meta % 2 == 1;
    }

    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
        if (!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z)))
        {
            spawnAnvil(world, x, y + 20, z);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int id)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && !isDisabled(meta))
        {
            switch (meta / 2)
            {
            case 1:
                for (int i = 0; i < 5; i++)
                {
                    spawnAnvil(world, x, y + 20 + i, z);
                }
                break;

            case 2:
                for (int i = 1; i <= 3; i++)
                {
                    spawnAnvil(world, x + i, y + 20, z);
                    spawnAnvil(world, x - i, y + 20, z);
                    spawnAnvil(world, x, y + 20, z + i);
                    spawnAnvil(world, x, y + 20, z - i);
                }
                break;

            case 3:
                for (int i = -1; i <= 1; i++)
                {
                    spawnAnvil(world, x + i, y + 20, z - 2);
                    spawnAnvil(world, x + i, y + 20, z + 2);
                    spawnAnvil(world, x - 2, y + 20, z + i);
                    spawnAnvil(world, x + 2, y + 20, z + i);
                }
                break;
            }
        }
    }

    private void spawnAnvil(World world, int x, int y, int z)
    {
        if (world.isAirBlock(x, y, z))
        {
            world.setBlock(x, y, z, Block.anvil.blockID);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            int meta = world.getBlockMetadata(x, y, z);

            int type = meta / 2;

            int disabled = meta % 2 == 0 ? 1 : 0;

            int newMeta = type * 2 + disabled;

            world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
        }

        return true;
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta;
    }

    @SuppressWarnings(value = { "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < BlockInfo.EXAMPLEBLOCK_SIDES.length; i++)
        {
            list.add(new ItemStack(id, 1, i * 2));
        }
    }
}

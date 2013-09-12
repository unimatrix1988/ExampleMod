package com.unimatrix.ExampleMod;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.unimatrix.ExampleMod.blocks.Blocks;
import com.unimatrix.ExampleMod.config.BlocksConfigHandler;
import com.unimatrix.ExampleMod.config.ItemsConfigHandler;
import com.unimatrix.ExampleMod.creativetabs.BasicCreativeTab;
import com.unimatrix.ExampleMod.items.Items;
import com.unimatrix.ExampleMod.lib.Reference;
import com.unimatrix.ExampleMod.network.PacketHandler;
import com.unimatrix.ExampleMod.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = { Reference.MOD_CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class ExampleMod
{
    // Holds the Forge loaded instance of this mod "There can be only one"
    @Instance(Reference.MOD_ID)
    public static ExampleMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    public static CreativeTabs tabExampleMod = new BasicCreativeTab(CreativeTabs.getNextID(), Reference.MOD_ID);

    @EventHandler
    public void PreLoading(FMLPreInitializationEvent event)
    {
        // Runs First
        // Place all setting and localisation loading here.

        // Load Config file should be the first thing done.
        ItemsConfigHandler.LoadConfig(new File(event.getModConfigurationDirectory().getAbsoluteFile()
                + File.separator
                + Reference.MOD_CHANNEL
                + File.separator + Reference.MOD_ID + "_ITEMS.cfg"));
        
        BlocksConfigHandler.LoadConfig(new File(event.getModConfigurationDirectory().getAbsoluteFile()
                + File.separator
                + Reference.MOD_CHANNEL
                + File.separator + Reference.MOD_ID + "_BLOCKS.cfg"));
        

        // creates all items used by this Mod
        Items.Initialise();
        Items.Localise();
        
        Blocks.Initialise();
        Blocks.Localise();
        
        proxy.LoadSound();
        proxy.LoadRenderers();
    }

    @EventHandler
    public void Loading(FMLInitializationEvent event)
    {
        // Runs Second
        // Can be called at any time during Minecraft mod loading phase
        // "Do Not place cross mod code here unless child mod is specified"
        
        Items.RegisterRecipes();
    }

    @EventHandler
    public void PostLoading(FMLPostInitializationEvent event)
    {

    }
}
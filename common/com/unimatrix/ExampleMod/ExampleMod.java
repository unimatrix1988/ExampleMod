package com.unimatrix.ExampleMod;

import com.unimatrix.ExampleMod.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class ExampleMod
{
    
    @Instance(Reference.MOD_ID)
    public static ExampleMod instance;
    
    @EventHandler
    public void PreLoading(FMLPreInitializationEvent event)
    {
        //Runs First
        //Place all setting and localisation loading here.
        
        
    }
    
    @EventHandler
    public void Loading(FMLInitializationEvent event)
    {
        //Runs Second
        //Can be called at any time during Minecraft mod loading phase "Do Not place cross mod code here unless child mod is specified"
    }
    
    @EventHandler
    public void PostLoading(FMLPostInitializationEvent event)
    {
        
    }
}
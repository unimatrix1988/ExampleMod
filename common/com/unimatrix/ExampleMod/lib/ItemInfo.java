package com.unimatrix.ExampleMod.lib;

public class ItemInfo
{
    //Values required to load a single item.
    //+++
    //The default item ID to be used if a Config isn't available.
    public static final int EXAMPLEITEM_DEFALT_ID = 20000;
    
    //Variable to hold the loaded it ID whether Default or Loaded by Config.
    public static int EXAMPLEITEM_ID;
    
    //the unique name of the item.
    public static final String EXAMPLEITEM_UNIQUE_NAME = "exampleitem";
    
    //Any Human readable name as its only displayed to the player.
    public static final String EXAMPLEITEM_LOCAL_NAME = "Wand o Throw";
    
    //file name of the texture to be loaded (without .png file extension) as its added later by the file loaded automatically
    //WARNING textures must be visible in Package Explorer or they don't get Copied on Build
    public static final String EXAMPLEITEM_ICON = "example_item";
    //+++
    
    public static final int MULTITEXTUREITEM_DEFAULT_ID = 20001;
    public static int MULTITEXTUREITEM_ID;
    public static final String MULTITEXTUREITEM_UNIQUE_NAME = "exampleitemcharge";
    public static final String MULTITEXTUREITEM_LOCAL_NAME = "Wand o Throw n Knock Back";
    public static final String MULTITEXTUREITEMUNCHARGED_ICON = "multi_textured_item_uncharged";
    public static final String MULTITEXTUREITEMCHARGED_ICON = "multi_textured_item_charged";
    
    
    public static final int CARD_DEFAULT_ID = 20002;
    public static int CARD_ID;
    public static final String CARD_UNIQUE_NAME = "card";
    public static final String[] CARD_LOCAL_NAMES = {"Arrow Card", "Cross Card", "Board Card"};    
    public static final String[] CARD_ICONS = {"card_arrow", "card_cross", "card_board"};
}
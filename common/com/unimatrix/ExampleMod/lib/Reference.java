package com.unimatrix.ExampleMod.lib;

public class Reference
{
    //The ID Forge will register to load this Mod
    public static final String MOD_ID = "ExampleMod";
    //The Human readable name of this Mod
    public static final String MOD_NAME = "Example Mod";
    
    /* The version of this Mod seen as Human readable
     
     % Version Standard Used
     % 0.0.0.0
     % Major.Minor.Stage.Revision
     %
     % * Major - The significant release version (denotes a large overall change in program functionality)
     % * Minor - The Lesser release version (denotes a change/upgrade to existing functionality)
     % * Stage - The Release Stage (denotes what stage of development the functionality is at,
     %    0 = Pre Alpha
     %    1 = Alpha
     %    2 = Beta
     %    3 = Release Candidate
     %    4 = Final Build
     % * Revision - Bug Fix Attempts (denotes how many bug fixes and builds have been released)
     
     */
    public static final String MOD_VERSION = "1.0.0.1";
    
    //The unique comms channel this mod should use to talk to server side
    public static final String MOD_CHANNEL = MOD_ID;

    //
    public static final String CLIENT_PROXY_CLASS = "com.unimatrix.ExampleMod.proxies.ClientProxy";
    //
    public static final String SERVER_PROXY_CLASS = "com.unimatrix.ExampleMod.proxies.CommonProxy";
    
    
    //Will be used to correct the vanilla item ID shift currently 256.
    public static final int ITEM_ID_CORRECTION = 256;
    
    //states the location of all mod assets, this has to be all lower-case and match the resource file structure.
    public static final String ASSETS_LOCATION = Reference.MOD_ID.toLowerCase();
}

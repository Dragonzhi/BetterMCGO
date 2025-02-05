package com.Dragon_Zhi.better_mcgo_mod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BetterMCGOMod.MODID)
public class BetterMCGOMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "better_mcgo_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BetterMCGOMod()
    {

    }
}

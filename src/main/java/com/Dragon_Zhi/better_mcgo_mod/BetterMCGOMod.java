package com.Dragon_Zhi.better_mcgo_mod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(BetterMCGOMod.MODID)
public class BetterMCGOMod
{
    public static final String MODID = "better_mcgo_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BetterMCGOMod()
    {
        // 注册事件处理器//
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        LOGGER.info("BetterMCGOMod initialized!");
    }
}

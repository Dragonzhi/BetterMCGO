// 文件路径：src/main/java/com/Dragon_Zhi/better_mcgo_mod/BetterMCGOMod.java
package com.Dragon_Zhi.better_mcgo_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(BetterMCGOMod.MODID)
public class BetterMCGOMod {
    public static final String MODID = "better_mcgo_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    // 注册自定义效果
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID);
    public static final RegistryObject<MobEffect> CUSTOM_GLOWING = EFFECTS.register("custom_glowing", CustomGlowingEffect::new);

    public BetterMCGOMod() {
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        LOGGER.info("BetterMCGOMod initialized!");
    }
}
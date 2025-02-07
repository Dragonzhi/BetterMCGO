// 文件路径：src/main/java/com/Dragon_Zhi/better_mcgo_mod/CustomGlowingEffect.java
package com.Dragon_Zhi.better_mcgo_mod;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class CustomGlowingEffect extends MobEffect {
    public CustomGlowingEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFFFFF);
    }

//    @Override
    public boolean isVisible() {
        return false; // 禁用原版发光渲染
    }
}
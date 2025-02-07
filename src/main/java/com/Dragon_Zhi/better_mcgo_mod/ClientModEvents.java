// 文件路径：src/main/java/com/Dragon_Zhi/better_mcgo_mod/ClientModEvents.java
package com.Dragon_Zhi.better_mcgo_mod;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMCGOMod.MODID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRenderLiving(RenderLivingEvent.Pre<?, ?> event) {
        LivingEntity target = event.getEntity();
        Player observer = Minecraft.getInstance().player;
        if (observer == null) return;

        // 检查目标是否带有自定义效果
        MobEffectInstance effect = target.getEffect(BetterMCGOMod.CUSTOM_GLOWING.get());
        if (effect == null) return;

        // 检查观察者与目标是否同队伍
        boolean sameTeam =
                target.getTeam() != null
                        && observer.getTeam() != null
                        && target.getTeam().equals(observer.getTeam());

        // 动态覆盖发光标签：仅同队伍可见
        target.setGlowingTag(sameTeam);

        // 调试日志
        System.out.println("目标是否发光: " + sameTeam);
    }
}
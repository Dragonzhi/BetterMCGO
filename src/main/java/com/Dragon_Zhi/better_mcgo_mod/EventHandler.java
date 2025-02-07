// 文件路径：src/main/java/com/Dragon_Zhi/better_mcgo_mod/EventHandler.java
package com.Dragon_Zhi.better_mcgo_mod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.Team;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventHandler.class);

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Team playerTeam = player.getTeam();

            if (playerTeam != null) {
                // 遍历玩家周围50格内的实体
                for (Entity entity : player.level().getEntities(player, player.getBoundingBox().inflate(50))) {
                    Team entityTeam = entity.getTeam();

                    // 服务端施加自定义效果
                    if (entityTeam != null && entityTeam.isAlliedTo(playerTeam)) {
                        if (entity instanceof LivingEntity livingEntity) {
                            // 施加自定义发光效果（持续2秒）
                            livingEntity.addEffect(new MobEffectInstance(
                                    BetterMCGOMod.CUSTOM_GLOWING.get(),
                                    40, 0, false, false
                            ));
                            LOGGER.debug("Applied glowing to: {}", entity.getName().getString());
                        }
                    }
                }
            }
        }
    }
}
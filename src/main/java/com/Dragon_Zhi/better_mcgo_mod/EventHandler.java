package com.Dragon_Zhi.better_mcgo_mod;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.Team;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EventHandler.class);

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if (event.phase == TickEvent.Phase.END)
        {
            Player player = event.player;
            Team playerTeam = player.getTeam();

            if (playerTeam != null)
            {
                // 遍历所有实体，找到与玩家同队伍的实体
                for (Entity entity : player.level().getEntities(player, player.getBoundingBox().inflate(50)))
                {
                    Team entityTeam = entity.getTeam();

                    if (entityTeam != null && entityTeam.isAlliedTo(playerTeam))
                    {
                        // 应用发光效果
                        entity.setGlowingTag(true);
                        LOGGER.debug("Applied glowing effect to entity: {}", entity.getName().getString());
                    }
                    else
                    {
                        // 移除发光效果
                        entity.setGlowingTag(false);
                    }
                }
            }
        }
    }
}

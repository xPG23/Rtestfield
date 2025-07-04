package com.Dudu.rtestfield.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class DavaAxe extends AxeItem {

    public DavaAxe() {
        super(Tiers.STONE, 6, -3.1f, new Item.Properties());
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (isLogBlock(state)) {
                breakTree(level, pos, player);
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }

    private boolean isLogBlock(BlockState state) {
        return state.is(BlockTags.LOGS);
    }

    private void breakTree(Level level, BlockPos origin, Player player) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> toCheck = new ArrayDeque<>();
        toCheck.add(origin);

        while (!toCheck.isEmpty()) {
            BlockPos current = toCheck.poll();
            if (!visited.add(current)) continue;

            BlockState state = level.getBlockState(current);
            if (!isLogBlock(state)) continue;

            level.destroyBlock(current, true, player);

            for (Direction dir : Direction.values()) {
                BlockPos nextPos = current.relative(dir);
                toCheck.add(nextPos);
            }
        }
    }
}

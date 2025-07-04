package com.Dudu.rtestfield.item.custom;

import com.mojang.authlib.properties.Property;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

public class UltraPickaxe extends PickaxeItem {

    public static final Tier TestTier = new Tier() {

        @Override
        public int getUses() {
            return 2;
        }

        @Override
        public float getSpeed() {
            return 100.0f;
        }

        @Override
        public float getAttackDamageBonus() {
            return 8.0f;
        }

        @Override
        public int getLevel() {
            return 3;
        }

        @Override
        public int getEnchantmentValue() {
            return 10;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.GLASS);
        }
    };

    public UltraPickaxe() {

        super(UltraPickaxe.TestTier,3,-2.4f,new Properties());
    }
}

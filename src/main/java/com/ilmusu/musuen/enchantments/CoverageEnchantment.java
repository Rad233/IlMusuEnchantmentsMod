package com.ilmusu.musuen.enchantments;

import com.ilmusu.musuen.callbacks.ShieldCoverageAngleCallback;
import com.ilmusu.musuen.registries.ModEnchantmentTargets;
import com.ilmusu.musuen.registries.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;

public class CoverageEnchantment extends Enchantment implements _IEnchantmentExtensions
{
    public CoverageEnchantment(Rarity weight)
    {
        super(weight, ModEnchantmentTargets.SHIELD, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinLevel()
    {
        return ModEnchantments.getMinLevel(this, 1);
    }

    @Override
    public int getMaxLevel()
    {
        return ModEnchantments.getMaxLevel(this, 5);
    }

    static
    {
        ShieldCoverageAngleCallback.BEFORE.register(((user, shield, source) ->
        {
            int level = EnchantmentHelper.getLevel(ModEnchantments.COVERAGE, shield);
            if(level == 0)
                return 0.0;

            return (double)level/ModEnchantments.COVERAGE.getMaxLevel();
        }));
    }
}

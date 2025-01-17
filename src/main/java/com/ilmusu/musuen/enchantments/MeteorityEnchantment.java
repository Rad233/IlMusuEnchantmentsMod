package com.ilmusu.musuen.enchantments;

import com.ilmusu.musuen.callbacks.FireworkElytraSpeedCallback;
import com.ilmusu.musuen.registries.ModEnchantmentTargets;
import com.ilmusu.musuen.registries.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;

public class MeteorityEnchantment extends Enchantment implements _IEnchantmentExtensions
{
    public MeteorityEnchantment(Rarity weight)
    {
        super(weight, ModEnchantmentTargets.ELYTRA, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }

    @Override
    public int getMinLevel()
    {
        return ModEnchantments.getMinLevel(this, 1);
    }

    @Override
    public int getMaxLevel()
    {
        return ModEnchantments.getMaxLevel(this, 3);
    }

    static
    {
        FireworkElytraSpeedCallback.EVENT.register(((shooter, firework, rotation) ->
        {
            int level = EnchantmentHelper.getEquipmentLevel(ModEnchantments.METEORITY, shooter);
            if(level == 0)
                return rotation;

            float speedBonus = 1.0F + level * 0.7F;
            return rotation.multiply(speedBonus);
        }));
    }
}

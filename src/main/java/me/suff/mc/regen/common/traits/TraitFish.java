package me.suff.mc.regen.common.traits;

import me.suff.mc.regen.common.regen.IRegen;
import me.suff.mc.regen.util.RConstants;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class TraitFish extends Traits.ITrait {
    @Override
    public void apply(IRegen data) {

    }

    @Override
    public void reset(IRegen data) {

    }

    @Override
    public void tick(IRegen data) {
        LivingEntity living = data.getLiving();
        if (living.isInWater()) {
            living.setAirSupply(300);
        }
    }

    @Override
    public boolean isPlayerOnly() {
        return false;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return new ResourceLocation(RConstants.MODID, "fish");
    }

    @Override
    public int getColor() {
        return 8954814;
    }
}

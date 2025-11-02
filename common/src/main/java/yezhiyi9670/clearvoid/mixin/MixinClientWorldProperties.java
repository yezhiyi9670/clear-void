package yezhiyi9670.clearvoid.mixin;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.LevelHeightAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import yezhiyi9670.clearvoid.compat.LevelHeightAccessorCompat;

@Mixin(ClientLevel.ClientLevelData.class)
public class MixinClientWorldProperties {

    /**
     * @reason Remove black void by shifting the horizon height to 64 blocks below the min build height.
     * This is where the void damage comes in.
     *
     * @author yezhiyi9670
     */
    @Overwrite
    public double getHorizonHeight(LevelHeightAccessor levelHeightAccessor) {
        return LevelHeightAccessorCompat.getMinBuildHeight(levelHeightAccessor) - 64.0;
    }

}

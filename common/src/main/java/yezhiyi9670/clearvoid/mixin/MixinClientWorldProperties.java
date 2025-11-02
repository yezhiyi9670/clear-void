package yezhiyi9670.clearvoid.mixin;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.LevelHeightAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ClientLevel.ClientLevelData.class)
public class MixinClientWorldProperties {

    /**
     * Remove black void by shifting the horizon height to 64 blocks below the min build height.
     * This is where the void damage comes in.
     */
    @Overwrite
    public double getHorizonHeight(LevelHeightAccessor levelHeightAccessor) {
        return levelHeightAccessor.getMinBuildHeight() - 64.0;
    }

}

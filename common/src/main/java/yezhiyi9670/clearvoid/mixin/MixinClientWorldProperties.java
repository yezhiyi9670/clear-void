package yezhiyi9670.clearvoid.mixin;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.LevelHeightAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

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
        return levelHeightAccessor.getMinBuildHeight() - 64.0;
    }

}

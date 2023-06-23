package yezhiyi9670.clearvoid.mixin;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.HeightLimitView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientWorld.Properties.class)
public class MixinClientWorldProperties {

    @Overwrite
    public double getSkyDarknessHeight(HeightLimitView world) {
        return world.getBottomY() - 64.0;
    }

}

package yezhiyi9670.clearvoid.mixin;

import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.HeightLimitView;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = WorldRenderer.class)
public class MixinWorldRenderer {

//    @Redirect(
//            method = "Lnet/minecraft/client/render/WorldRenderer;renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/math/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lnet/minecraft/client/network/ClientPlayerEntity;getCameraPosVec(F)Lnet/minecraft/util/math/Vec3d;"
//            )
//    )
//    private Vec3d clearvoid$getSkyDarknessHeight(ClientPlayerEntity instance, float v) {
//        Vec3d vec = instance.getCameraPosVec(v);
//        return new Vec3d(vec.x, 2032.0 + 64.0, vec.z);
//    }

}
package yezhiyi9670.clearvoid.mixin;

import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.render.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.world.HeightLimitView;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = WorldRenderer.class)
public class MixinWorldRenderer {

    @Redirect(
            method = "Lnet/minecraft/client/render/WorldRenderer;renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/math/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gl/VertexBuffer;setShader(Lnet/minecraft/util/math/Matrix4f;Lnet/minecraft/util/math/Matrix4f;Lnet/minecraft/client/render/Shader;)V",
                    ordinal = 2
            )
    )
    private void clearvoid$getSkyDarknessHeight(VertexBuffer instance, Matrix4f viewMatrix, Matrix4f projectionMatrix, Shader shader) {
        // Stop doing that
    }

}
package yezhiyi9670.clearvoid.mixin;

import net.minecraft.client.render.*;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix4f;

@Mixin(value = WorldRenderer.class, priority = 19)
public abstract class MixinWorldRenderer {
    @Shadow
    private VertexBuffer darkSkyBuffer;

    /**
     * @author yezhiyi9670
     * @reason Overwrite renderDarkSky to prevent the behavior
     */
    @Overwrite
    private void renderDarkSky() {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        if (this.darkSkyBuffer != null) {
            this.darkSkyBuffer.close();
        }

        this.darkSkyBuffer = new VertexBuffer();
        // this.darkSkyBuffer.upload(bufferBuilder);
    }

}
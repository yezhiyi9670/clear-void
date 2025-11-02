package yezhiyi9670.clearvoid.compat;

import net.minecraft.world.level.LevelHeightAccessor;
import yezhiyi9670.clearvoid.compat.proxy.InterfaceProxyHandler;
import yezhiyi9670.clearvoid.compat.version.MinecraftVersion;

public class LevelHeightAccessorCompat {
    private static final boolean USES_COMPAT_1_21_2;
    private interface Compat_1_21_2 {
        int getMinY();
    }

    static {
        USES_COMPAT_1_21_2 = MinecraftVersion.isAtLeast("1.21.2");
    }

    public static int getMinBuildHeight(LevelHeightAccessor accessor) {
        if (USES_COMPAT_1_21_2) {
            return InterfaceProxyHandler.createProxy(accessor, Compat_1_21_2.class).getMinY();
        } else {
            return accessor.getMinBuildHeight();
        }
    }
}

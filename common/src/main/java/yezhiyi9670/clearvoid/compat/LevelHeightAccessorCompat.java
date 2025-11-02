package yezhiyi9670.clearvoid.compat;

import net.minecraft.SharedConstants;
import net.minecraft.world.level.LevelHeightAccessor;
import yezhiyi9670.clearvoid.compat.proxy.InterfaceProxyHandler;

public class LevelHeightAccessorCompat {
    private static final boolean USES_COMPAT_1_21_2;
    public interface Compat_1_21_2 {
        int getMinY();
    }

    static {
        String version = SharedConstants.getCurrentVersion().getName();
        USES_COMPAT_1_21_2 = version.compareTo("1.21.2") >= 0;
    }

    public static int getMinBuildHeight(LevelHeightAccessor accessor) {
        if (USES_COMPAT_1_21_2) {
            return InterfaceProxyHandler.createProxy(accessor, Compat_1_21_2.class).getMinY();
        } else {
            return accessor.getMinBuildHeight();
        }
    }
}

package yezhiyi9670.clearvoid.compat;

import net.minecraft.WorldVersion;
import yezhiyi9670.clearvoid.compat.proxy.InterfaceProxyHandler;

public class WorldVersionCompat {
    public interface Compat_1_21_unknown {
        String name();
    }

    public static String getName(WorldVersion version) {
        try {
            return version.getName();
        } catch(NoSuchMethodError _e) {
            return InterfaceProxyHandler.createProxy(version, Compat_1_21_unknown.class).name();
        }
    }
}

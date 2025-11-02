package yezhiyi9670.clearvoid.compat.version;

import net.minecraft.SharedConstants;

public class MinecraftVersion {
    public static boolean isAtLeast(String targetVersion) {
        String version = WorldVersionCompat.getName(SharedConstants.getCurrentVersion());
        return new SemanticVersion(version).compareTo(new SemanticVersion(targetVersion)) >= 0;
    }
}

package yezhiyi9670.clearvoid.compat.version;

import java.util.Arrays;

public class SemanticVersion implements Comparable<SemanticVersion> {
    private final int[] parts;

    public SemanticVersion(String version) {
        String cleanVersion = version.replaceAll("^[^0-9]+", "").replaceAll("[^0-9.].*$", "");
        this.parts = Arrays.stream(cleanVersion.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    @Override
    public int compareTo(SemanticVersion other) {
        int length = Math.max(this.parts.length, other.parts.length);
        for (int i = 0; i < length; i++) {
            int thisPart = i < this.parts.length ? this.parts[i] : 0;
            int otherPart = i < other.parts.length ? other.parts[i] : 0;

            if (thisPart != otherPart) {
                return Integer.compare(thisPart, otherPart);
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemanticVersion that = (SemanticVersion) o;
        return Arrays.equals(parts, that.parts);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parts);
    }
}
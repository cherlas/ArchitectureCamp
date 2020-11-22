import java.util.*;
import java.util.stream.Collectors;

public class Utils {
    private static final long FNV_32_INIT = 2166136261L;
    private static final int FNV_32_PRIME = 16777619;

    public static Integer getHashCode(String origin) {
        int hash = (int) FNV_32_INIT;
        for (int i = 0; i < origin.length(); i++) {
            hash = (hash ^ origin.charAt(i)) * FNV_32_PRIME;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        hash = Math.abs(hash);

        return hash;
    }

    public static String[] generateIpAddresses(int num) {
        String[] res = new String[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            res[i] = random.nextInt(256) + "." + random.nextInt(256) + "."
                    + random.nextInt(256) + "." + random.nextInt(256) + ":"
                    + random.nextInt(9999);
        }
        return res;
    }

    // 求方差
    public static double variance(Long[] arr) {
        int m = arr.length;
        double sum = Arrays.stream(arr).mapToLong(value -> value).sum();
        double dAve = sum / m;
        double dVar = Arrays.stream(arr).mapToDouble(value -> (value - dAve) * (value - dAve)).sum();
        return dVar / m;
    }

    // <节点，服务器>
    public static double analysis(Map<String, String> map) {
        Map<Object, Long> countMap = map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                Collectors.counting()));
        Collection<Long> values = countMap.values();
        Iterator<Long> val = values.iterator();
        int count = 0;
        Long[] res = new Long[values.size()];
        while (val.hasNext()) {
            res[count++] = val.next();
        }
        return variance(res);
    }

}

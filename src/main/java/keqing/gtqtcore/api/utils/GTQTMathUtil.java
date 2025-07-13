package keqing.gtqtcore.api.utils;

import java.math.BigInteger;

public class GTQTMathUtil {
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }else {
            return Math.min(value, max);
        }
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }else {
            return Math.min(value, max);
        }
    }

    //超过Long.MAX 返回Long.MAX
    public static long getAsLong(BigInteger number){
        return number.bitLength() <= 63 ? number.longValue() : Long.MAX_VALUE;
    }

    public static long min(long i1,long i2,long i3){
        return i1<i2 ? Math.min(i1,i3) : Math.min(i2,i3);
    }
}

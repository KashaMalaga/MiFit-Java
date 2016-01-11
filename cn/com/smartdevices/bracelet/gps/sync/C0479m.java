package cn.com.smartdevices.bracelet.gps.sync;

public class C0479m {
    public static void a(long[] jArr) {
        C0479m.c(jArr, 0, jArr.length - 1);
    }

    private static void a(long[] jArr, int i, int i2) {
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
    }

    private static int b(long[] jArr, int i, int i2) {
        long j = jArr[i2];
        int i3 = i - 1;
        while (i < i2) {
            if (jArr[i] > j) {
                i3++;
                if (i3 != i) {
                    C0479m.a(jArr, i3, i);
                }
            }
            i++;
        }
        if (i3 + 1 != i2) {
            C0479m.a(jArr, i3 + 1, i2);
        }
        return i3 + 1;
    }

    private static void c(long[] jArr, int i, int i2) {
        if (jArr != null && (i2 - i) + 1 >= 2) {
            int b = C0479m.b(jArr, i, i2);
            if (b == i) {
                C0479m.c(jArr, b + 1, i2);
            } else if (b == i2) {
                C0479m.c(jArr, i, b - 1);
            } else {
                C0479m.c(jArr, i, b - 1);
                C0479m.c(jArr, b + 1, i2);
            }
        }
    }
}

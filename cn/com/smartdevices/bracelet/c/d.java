package cn.com.smartdevices.bracelet.c;

/* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[e.values().length];

    static {
        try {
            a[e.ACCELERATION.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[e.GPS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[e.HEART.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

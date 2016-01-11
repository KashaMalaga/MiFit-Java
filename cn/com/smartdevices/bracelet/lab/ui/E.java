package cn.com.smartdevices.bracelet.lab.ui;

class E {
    static final int a = 2000;
    static long b = 0;

    private E() {
    }

    static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b <= 2000) {
            return false;
        }
        b = currentTimeMillis;
        return true;
    }
}

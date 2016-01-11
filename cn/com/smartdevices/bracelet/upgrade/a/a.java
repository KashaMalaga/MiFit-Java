package cn.com.smartdevices.bracelet.upgrade.a;

public class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private int d;
    private int e;

    public a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String toString() {
        return "EventFwUpgradeComplete [upgradeType=" + this.d + ", state=" + this.e + "]";
    }
}

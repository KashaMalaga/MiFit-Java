package kankan.wheel.widget;

public class b {
    private int a;
    private int b;

    public b() {
        this(0, 0);
    }

    public b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int a() {
        return this.a;
    }

    public boolean a(int i) {
        return i >= a() && i <= b();
    }

    public int b() {
        return (a() + c()) - 1;
    }

    public int c() {
        return this.b;
    }
}

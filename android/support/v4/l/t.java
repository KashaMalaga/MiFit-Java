package android.support.v4.l;

public class t<T> extends s<T> {
    private final Object a = new Object();

    public t(int i) {
        super(i);
    }

    public T a() {
        T a;
        synchronized (this.a) {
            a = super.a();
        }
        return a;
    }

    public boolean a(T t) {
        boolean a;
        synchronized (this.a) {
            a = super.a(t);
        }
        return a;
    }
}

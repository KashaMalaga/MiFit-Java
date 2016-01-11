package android.support.v4.l;

public class p<F, S> {
    public final F a;
    public final S b;

    public p(F f, S s) {
        this.a = f;
        this.b = s;
    }

    public static <A, B> p<A, B> a(A a, B b) {
        return new p(a, b);
    }

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return b(pVar.a, this.a) && b(pVar.b, this.b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.a == null ? 0 : this.a.hashCode();
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode ^ i;
    }
}

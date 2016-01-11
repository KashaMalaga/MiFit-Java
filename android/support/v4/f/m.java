package android.support.v4.f;

class m extends ThreadLocal<n> {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    protected n a() {
        return new n();
    }

    protected /* synthetic */ Object initialValue() {
        return a();
    }
}

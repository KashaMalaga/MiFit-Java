package android.support.v7.widget;

class C0271p {
    public aj a;
    public aj b;
    public int c;
    public int d;
    public int e;
    public int f;

    private C0271p(aj ajVar, aj ajVar2) {
        this.a = ajVar;
        this.b = ajVar2;
    }

    private C0271p(aj ajVar, aj ajVar2, int i, int i2, int i3, int i4) {
        this(ajVar, ajVar2);
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
}

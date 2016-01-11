package b.a;

public class cP implements db {
    protected boolean a;
    protected boolean b;
    protected int c;

    public cP() {
        this(false, true);
    }

    public cP(boolean z, boolean z2) {
        this(z, z2, 0);
    }

    public cP(boolean z, boolean z2, int i) {
        this.a = false;
        this.b = true;
        this.a = z;
        this.b = z2;
        this.c = i;
    }

    public cY a(C0375do c0375do) {
        cY cOVar = new cO(c0375do, this.a, this.b);
        if (this.c != 0) {
            cOVar.c(this.c);
        }
        return cOVar;
    }
}

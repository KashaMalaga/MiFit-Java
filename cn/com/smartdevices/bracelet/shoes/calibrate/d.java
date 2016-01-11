package cn.com.smartdevices.bracelet.shoes.calibrate;

class d {
    final /* synthetic */ a a;
    private final short[] b = new short[this.f];
    private final short[] c = new short[this.f];
    private final short[] d = new short[this.f];
    private int e = 0;
    private final int f;

    public d(a aVar, int i) {
        this.a = aVar;
        this.f = i;
    }

    public void a() {
        this.e = 0;
    }

    public boolean a(c cVar) {
        if (this.e == this.f) {
            return false;
        }
        this.b[this.e] = cVar.a;
        this.c[this.e] = cVar.b;
        this.d[this.e] = cVar.c;
        this.e++;
        return true;
    }

    public int b() {
        return this.e;
    }

    public short[] c() {
        return this.b;
    }

    public short[] d() {
        return this.c;
    }

    public short[] e() {
        return this.d;
    }
}

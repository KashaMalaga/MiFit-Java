package android.support.v4.app;

class bF implements bO {
    final String a;
    final int b;
    final String c;
    final boolean d;

    public bF(String str) {
        this.a = str;
        this.b = 0;
        this.c = null;
        this.d = true;
    }

    public bF(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = false;
    }

    public void a(C0031as c0031as) {
        if (this.d) {
            c0031as.a(this.a);
        } else {
            c0031as.a(this.a, this.b, this.c);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CancelTask[");
        stringBuilder.append("packageName:").append(this.a);
        stringBuilder.append(", id:").append(this.b);
        stringBuilder.append(", tag:").append(this.c);
        stringBuilder.append(", all:").append(this.d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

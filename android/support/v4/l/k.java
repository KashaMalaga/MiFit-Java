package android.support.v4.l;

import java.util.Iterator;

final class k<T> implements Iterator<T> {
    final int a;
    int b;
    int c;
    boolean d = false;
    final /* synthetic */ j e;

    k(j jVar, int i) {
        this.e = jVar;
        this.a = i;
        this.b = jVar.a();
    }

    public boolean hasNext() {
        return this.c < this.b;
    }

    public T next() {
        T a = this.e.a(this.c, this.a);
        this.c++;
        this.d = true;
        return a;
    }

    public void remove() {
        if (this.d) {
            this.c--;
            this.b--;
            this.d = false;
            this.e.a(this.c);
            return;
        }
        throw new IllegalStateException();
    }
}

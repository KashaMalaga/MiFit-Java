package android.support.v7.widget;

import android.database.Observable;

class O extends Observable<P> {
    O() {
    }

    public void a(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((P) this.mObservers.get(size)).a(i, i2);
        }
    }

    public boolean a() {
        return !this.mObservers.isEmpty();
    }

    public void b() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((P) this.mObservers.get(size)).a();
        }
    }

    public void b(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((P) this.mObservers.get(size)).b(i, i2);
        }
    }

    public void c(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((P) this.mObservers.get(size)).c(i, i2);
        }
    }

    public void d(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((P) this.mObservers.get(size)).a(i, i2, 1);
        }
    }
}

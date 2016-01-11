package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class ae {
    public static final int a = -1;
    public static final int b = -2;
    private DataSetObservable c = new DataSetObservable();

    public int a(Object obj) {
        return a;
    }

    public Parcelable a() {
        return null;
    }

    public Object a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object a(ViewGroup viewGroup, int i) {
        return a((View) viewGroup, i);
    }

    public void a(DataSetObserver dataSetObserver) {
        this.c.registerObserver(dataSetObserver);
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void a(View view) {
    }

    public void a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void a(ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        a((View) viewGroup, i, obj);
    }

    public abstract boolean a(View view, Object obj);

    public abstract int b();

    public void b(DataSetObserver dataSetObserver) {
        this.c.unregisterObserver(dataSetObserver);
    }

    public void b(View view) {
    }

    public void b(View view, int i, Object obj) {
    }

    public void b(ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        b((View) viewGroup, i, obj);
    }

    public CharSequence c(int i) {
        return null;
    }

    public void c() {
        this.c.notifyChanged();
    }

    public float d(int i) {
        return 1.0f;
    }
}

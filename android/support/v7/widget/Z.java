package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class Z {
    private static final int d = 5;
    private SparseArray<ArrayList<aj>> a = new SparseArray();
    private SparseIntArray b = new SparseIntArray();
    private int c = 0;

    private ArrayList<aj> b(int i) {
        ArrayList<aj> arrayList = (ArrayList) this.a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.a.put(i, arrayList);
            if (this.b.indexOfKey(i) < 0) {
                this.b.put(i, d);
            }
        }
        return arrayList;
    }

    public aj a(int i) {
        ArrayList arrayList = (ArrayList) this.a.get(i);
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size() - 1;
        aj ajVar = (aj) arrayList.get(size);
        arrayList.remove(size);
        return ajVar;
    }

    public void a() {
        this.a.clear();
    }

    public void a(int i, int i2) {
        this.b.put(i, i2);
        ArrayList arrayList = (ArrayList) this.a.get(i);
        if (arrayList != null) {
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    void a(N n) {
        this.c++;
    }

    void a(N n, N n2, boolean z) {
        if (n != null) {
            c();
        }
        if (!z && this.c == 0) {
            a();
        }
        if (n2 != null) {
            a(n2);
        }
    }

    public void a(aj ajVar) {
        int g = ajVar.g();
        ArrayList b = b(g);
        if (this.b.get(g) > b.size()) {
            ajVar.t();
            b.add(ajVar);
        }
    }

    int b() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            ArrayList arrayList = (ArrayList) this.a.valueAt(i2);
            if (arrayList != null) {
                i += arrayList.size();
            }
        }
        return i;
    }

    void c() {
        this.c--;
    }
}

package com.activeandroid.e;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.activeandroid.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class a<T extends g> extends ArrayAdapter<T> {
    public a(Context context, int i) {
        super(context, i);
    }

    public a(Context context, int i, int i2) {
        super(context, i, i2);
    }

    public a(Context context, int i, int i2, List<T> list) {
        super(context, i, i2, list);
    }

    public a(Context context, int i, List<T> list) {
        super(context, i, list);
    }

    public void a(Collection<? extends T> collection) {
        clear();
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                add((g) it.next());
            }
        }
    }

    public long getItemId(int i) {
        g gVar = (g) getItem(i);
        return gVar != null ? gVar.getId().longValue() : -1;
    }
}

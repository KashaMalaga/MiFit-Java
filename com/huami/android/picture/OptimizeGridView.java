package com.huami.android.picture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.GridView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OptimizeGridView extends GridView {
    public OptimizeGridView(Context context) {
        super(context);
    }

    public OptimizeGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OptimizeGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        int numColumns;
        int i3 = 1;
        int i4 = 0;
        super.onMeasure(i, i2);
        if (VERSION.SDK_INT < 11) {
            i3 = 0;
        }
        if (i3 != 0) {
            numColumns = getNumColumns();
        } else {
            try {
                Field declaredField = GridView.class.getDeclaredField("mNumColumns");
                declaredField.setAccessible(true);
                numColumns = declaredField.getInt(this);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                numColumns = -1;
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
                numColumns = -1;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                numColumns = -1;
            }
        }
        if (numColumns != -1) {
            Adapter adapter = getAdapter();
            if (adapter instanceof e) {
                int count = adapter.getCount() % numColumns;
                if (count != 0) {
                    numColumns -= count;
                    e eVar = (e) adapter;
                    List arrayList = new ArrayList();
                    arrayList.addAll(eVar.a());
                    while (i4 < numColumns) {
                        arrayList.add(eVar.b());
                        i4++;
                    }
                    eVar.a(arrayList);
                }
            }
        }
    }
}

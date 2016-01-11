package cn.com.smartdevices.bracelet.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.U;
import android.support.v7.widget.ag;
import android.view.View;

class aa extends U {
    final /* synthetic */ WeightUserQuickPicker a;

    aa(WeightUserQuickPicker weightUserQuickPicker) {
        this.a = weightUserQuickPicker;
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, ag agVar) {
        rect.left = this.a.e;
        rect.top = 0;
        rect.bottom = 0;
        rect.right = this.a.e;
    }
}

package android.support.v4.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

class C0077n extends C0076p {
    private cn a;

    public C0077n(cn cnVar) {
        this.a = cnVar;
    }

    public Parcelable a(View view, Matrix matrix, RectF rectF) {
        return this.a.a(view, matrix, rectF);
    }

    public View a(Context context, Parcelable parcelable) {
        return this.a.a(context, parcelable);
    }

    public void a(List<View> list) {
        this.a.a(list);
    }

    public void a(List<String> list, List<View> list2, List<View> list3) {
        this.a.a((List) list, (List) list2, (List) list3);
    }

    public void a(List<String> list, Map<String, View> map) {
        this.a.a((List) list, (Map) map);
    }

    public void b(List<String> list, List<View> list2, List<View> list3) {
        this.a.b(list, list2, list3);
    }
}

package android.support.v4.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

class C0079q extends SharedElementCallback {
    private C0076p a;

    public C0079q(C0076p c0076p) {
        this.a = c0076p;
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        return this.a.a(view, matrix, rectF);
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        return this.a.a(context, parcelable);
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map) {
        this.a.a((List) list, (Map) map);
    }

    public void onRejectSharedElements(List<View> list) {
        this.a.a(list);
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        this.a.b(list, list2, list3);
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        this.a.a((List) list, (List) list2, (List) list3);
    }
}

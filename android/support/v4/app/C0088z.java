package android.support.v4.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

class C0088z {
    private final ActivityOptions a;

    private C0088z(ActivityOptions activityOptions) {
        this.a = activityOptions;
    }

    public static C0088z a(Context context, int i, int i2) {
        return new C0088z(ActivityOptions.makeCustomAnimation(context, i, i2));
    }

    public static C0088z a(View view, int i, int i2, int i3, int i4) {
        return new C0088z(ActivityOptions.makeScaleUpAnimation(view, i, i2, i3, i4));
    }

    public static C0088z a(View view, Bitmap bitmap, int i, int i2) {
        return new C0088z(ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
    }

    public Bundle a() {
        return this.a.toBundle();
    }

    public void a(C0088z c0088z) {
        this.a.update(c0088z.a);
    }
}

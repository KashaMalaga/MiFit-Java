package cn.com.smartdevices.bracelet.shoes.c;

import android.app.Activity;
import android.content.DialogInterface;
import com.huami.android.view.a;

final class e extends a {
    final /* synthetic */ Activity a;
    final /* synthetic */ f b;

    e(Activity activity, f fVar) {
        this.a = activity;
        this.b = fVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.a != null) {
            this.a.finish();
        }
    }

    protected void onRightButtonClicked() {
        if (this.a != null && this.b == null) {
            this.a.finish();
        } else if (this.b != null) {
            this.b.a();
        }
    }
}

package cn.com.smartdevices.bracelet.ui;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

class C0751d extends ContentObserver {
    final /* synthetic */ ContentResolver a;
    final /* synthetic */ AlarmActivity b;

    C0751d(AlarmActivity alarmActivity, Handler handler, ContentResolver contentResolver) {
        this.b = alarmActivity;
        this.a = contentResolver;
        super(handler);
    }

    @SuppressLint({"NewApi"})
    public void onChange(boolean z, Uri uri) {
        super.onChange(z, uri);
        this.b.a(this.a);
    }
}

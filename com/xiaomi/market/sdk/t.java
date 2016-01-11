package com.xiaomi.market.sdk;

import android.app.DownloadManager.Request;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.File;

class t implements Runnable {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public void run() {
        if (!x.a(true)) {
            Toast.makeText(this.a.a.b, x.a(this.a.a.b.getPackageName(), "string", "xiaomi_external_storage_unavailable"), 0).show();
        } else if (this.a.a.g != null) {
            Uri parse = Uri.parse(TextUtils.isEmpty(this.a.a.c.i) ? h.a(this.a.a.c.a, this.a.a.c.f) : h.a(this.a.a.c.a, this.a.a.c.i));
            File file = new File(new StringBuilder(String.valueOf(this.a.a.b.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath())).append("/updates").toString());
            if (!(file == null || file.exists())) {
                file.mkdirs();
            }
            this.a.a.f = new File(file.getAbsolutePath() + "/" + this.a.a.d.a + this.a.a.c.d);
            if (this.a.a.f.exists()) {
                this.a.a.f.delete();
            }
            Uri parse2 = Uri.parse("file://" + this.a.a.f.getAbsolutePath());
            Request request = new Request(parse);
            request.setMimeType("application/apk-ota");
            request.setTitle(this.a.a.d.b);
            request.setDestinationUri(parse2);
            this.a.a.e = this.a.a.g.enqueue(request);
            ContentValues contentValues = new ContentValues();
            contentValues.put(q.c, this.a.a.d.a);
            contentValues.put(q.d, Long.valueOf(this.a.a.e));
            contentValues.put(q.e, Integer.valueOf(this.a.a.c.d));
            contentValues.put(q.f, this.a.a.c.f);
            contentValues.put(q.g, this.a.a.c.g);
            contentValues.put(q.h, this.a.a.c.i);
            contentValues.put(q.i, this.a.a.c.j);
            contentValues.put(q.j, this.a.a.f.getAbsolutePath());
            w.a(this.a.a.b).a(contentValues);
        }
    }
}

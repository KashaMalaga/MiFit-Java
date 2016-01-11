package android.support.v4.h;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;
import cn.com.smartdevices.bracelet.chart.util.a;
import java.io.FileNotFoundException;

class l extends AsyncTask<Uri, Boolean, Bitmap> {
    final /* synthetic */ CancellationSignal a;
    final /* synthetic */ PrintAttributes b;
    final /* synthetic */ PrintAttributes c;
    final /* synthetic */ LayoutResultCallback d;
    final /* synthetic */ k e;

    l(k kVar, CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, LayoutResultCallback layoutResultCallback) {
        this.e = kVar;
        this.a = cancellationSignal;
        this.b = printAttributes;
        this.c = printAttributes2;
        this.d = layoutResultCallback;
    }

    protected Bitmap a(Uri... uriArr) {
        try {
            return this.e.g.a(this.e.d, (int) a.e);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    protected void a(Bitmap bitmap) {
        boolean z = true;
        super.onPostExecute(bitmap);
        this.e.b = bitmap;
        if (bitmap != null) {
            PrintDocumentInfo build = new Builder(this.e.c).setContentType(1).setPageCount(1).build();
            if (this.b.equals(this.c)) {
                z = false;
            }
            this.d.onLayoutFinished(build, z);
            return;
        }
        this.d.onLayoutFailed(null);
    }

    protected void b(Bitmap bitmap) {
        this.d.onLayoutCancelled();
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Uri[]) objArr);
    }

    protected /* synthetic */ void onCancelled(Object obj) {
        b((Bitmap) obj);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Bitmap) obj);
    }

    protected void onPreExecute() {
        this.a.setOnCancelListener(new m(this));
    }
}

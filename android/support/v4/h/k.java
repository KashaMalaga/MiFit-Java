package android.support.v4.h;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument.Page;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;

class k extends PrintDocumentAdapter {
    AsyncTask<Uri, Boolean, Bitmap> a;
    Bitmap b = null;
    final /* synthetic */ String c;
    final /* synthetic */ Uri d;
    final /* synthetic */ n e;
    final /* synthetic */ int f;
    final /* synthetic */ i g;
    private PrintAttributes h;

    k(i iVar, String str, Uri uri, n nVar, int i) {
        this.g = iVar;
        this.c = str;
        this.d = uri;
        this.e = nVar;
        this.f = i;
    }

    private void a() {
        synchronized (this.g.n) {
            if (this.g.b != null) {
                this.g.b.requestCancelDecode();
                this.g.b = null;
            }
        }
    }

    public void onFinish() {
        super.onFinish();
        a();
        this.a.cancel(true);
        if (this.e != null) {
            this.e.a();
        }
    }

    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
        boolean z = true;
        if (cancellationSignal.isCanceled()) {
            layoutResultCallback.onLayoutCancelled();
            this.h = printAttributes2;
        } else if (this.b != null) {
            PrintDocumentInfo build = new Builder(this.c).setContentType(1).setPageCount(1).build();
            if (printAttributes2.equals(printAttributes)) {
                z = false;
            }
            layoutResultCallback.onLayoutFinished(build, z);
        } else {
            this.a = new l(this, cancellationSignal, printAttributes2, printAttributes, layoutResultCallback);
            this.a.execute(new Uri[0]);
            this.h = printAttributes2;
        }
    }

    public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
        PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.g.a, this.h);
        try {
            Page startPage = printedPdfDocument.startPage(1);
            startPage.getCanvas().drawBitmap(this.b, this.g.a(this.b.getWidth(), this.b.getHeight(), new RectF(startPage.getInfo().getContentRect()), this.f), null);
            printedPdfDocument.finishPage(startPage);
            printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
            writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
        } catch (Throwable e) {
            Log.e("PrintHelperKitkat", "Error writing printed content", e);
            writeResultCallback.onWriteFailed(null);
        } catch (Throwable th) {
            if (printedPdfDocument != null) {
                printedPdfDocument.close();
            }
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e2) {
                }
            }
        }
        if (printedPdfDocument != null) {
            printedPdfDocument.close();
        }
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e3) {
            }
        }
    }
}

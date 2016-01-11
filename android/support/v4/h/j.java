package android.support.v4.h;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument.Page;
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

class j extends PrintDocumentAdapter {
    final /* synthetic */ String a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ int c;
    final /* synthetic */ n d;
    final /* synthetic */ i e;
    private PrintAttributes f;

    j(i iVar, String str, Bitmap bitmap, int i, n nVar) {
        this.e = iVar;
        this.a = str;
        this.b = bitmap;
        this.c = i;
        this.d = nVar;
    }

    public void onFinish() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
        boolean z = true;
        this.f = printAttributes2;
        PrintDocumentInfo build = new Builder(this.a).setContentType(1).setPageCount(1).build();
        if (printAttributes2.equals(printAttributes)) {
            z = false;
        }
        layoutResultCallback.onLayoutFinished(build, z);
    }

    public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
        PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.e.a, this.f);
        try {
            Page startPage = printedPdfDocument.startPage(1);
            startPage.getCanvas().drawBitmap(this.b, this.e.a(this.b.getWidth(), this.b.getHeight(), new RectF(startPage.getInfo().getContentRect()), this.c), null);
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

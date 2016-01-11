package android.support.v4.i;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

class c {
    private static final String a = "DocumentFile";

    c() {
    }

    public static Uri a(Context context, Uri uri, String str) {
        return a(context, uri, "vnd.android.document/directory", str);
    }

    public static Uri a(Context context, Uri uri, String str, String str2) {
        return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
    }

    public static Uri a(Uri uri) {
        return DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
    }

    private static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static Uri[] a(Context context, Uri uri) {
        AutoCloseable query;
        Object e;
        Throwable th;
        ContentResolver contentResolver = context.getContentResolver();
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        try {
            query = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(uri, query.getString(0)));
                } catch (Exception e2) {
                    e = e2;
                }
            }
            a(query);
        } catch (Exception e3) {
            e = e3;
            query = null;
            try {
                Log.w(a, "Failed query: " + e);
                a(query);
                return (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            } catch (Throwable th2) {
                th = th2;
                a(query);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            a(query);
            throw th;
        }
        return (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
    }

    public static Uri b(Context context, Uri uri, String str) {
        return DocumentsContract.renameDocument(context.getContentResolver(), uri, str);
    }
}

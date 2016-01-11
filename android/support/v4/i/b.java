package android.support.v4.i;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

class b {
    private static final String a = "DocumentFile";

    b() {
    }

    private static int a(Context context, Uri uri, String str, int i) {
        return (int) a(context, uri, str, (long) i);
    }

    private static long a(Context context, Uri uri, String str, long j) {
        AutoCloseable query;
        Object e;
        Throwable th;
        try {
            query = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (!query.moveToFirst() || query.isNull(0)) {
                    a(query);
                    return j;
                }
                j = query.getLong(0);
                a(query);
                return j;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w(a, "Failed query: " + e);
                    a(query);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    a(query);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.w(a, "Failed query: " + e);
            a(query);
            return j;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            a(query);
            throw th;
        }
    }

    private static String a(Context context, Uri uri, String str, String str2) {
        AutoCloseable query;
        Object e;
        Throwable th;
        try {
            query = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (!query.moveToFirst() || query.isNull(0)) {
                    a(query);
                    return str2;
                }
                str2 = query.getString(0);
                a(query);
                return str2;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w(a, "Failed query: " + e);
                    a(query);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    a(query);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.w(a, "Failed query: " + e);
            a(query);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            a(query);
            throw th;
        }
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

    public static boolean a(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static String b(Context context, Uri uri) {
        return a(context, uri, "_display_name", null);
    }

    public static String c(Context context, Uri uri) {
        String l = l(context, uri);
        return "vnd.android.document/directory".equals(l) ? null : l;
    }

    public static boolean d(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(l(context, uri));
    }

    public static boolean e(Context context, Uri uri) {
        CharSequence l = l(context, uri);
        return ("vnd.android.document/directory".equals(l) || TextUtils.isEmpty(l)) ? false : true;
    }

    public static long f(Context context, Uri uri) {
        return a(context, uri, "last_modified", 0);
    }

    public static long g(Context context, Uri uri) {
        return a(context, uri, "_size", 0);
    }

    public static boolean h(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(l(context, uri));
    }

    public static boolean i(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        CharSequence l = l(context, uri);
        int a = a(context, uri, "flags", 0);
        return !TextUtils.isEmpty(l) ? (a & 4) != 0 ? true : (!"vnd.android.document/directory".equals(l) || (a & 8) == 0) ? (TextUtils.isEmpty(l) || (a & 2) == 0) ? false : true : true : false;
    }

    public static boolean j(Context context, Uri uri) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
    }

    public static boolean k(Context context, Uri uri) {
        Object e;
        Throwable th;
        AutoCloseable query;
        try {
            query = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            try {
                boolean z = query.getCount() > 0;
                a(query);
                return z;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w(a, "Failed query: " + e);
                    a(query);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    a(query);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.w(a, "Failed query: " + e);
            a(query);
            return false;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            a(query);
            throw th;
        }
    }

    private static String l(Context context, Uri uri) {
        return a(context, uri, "mime_type", null);
    }
}

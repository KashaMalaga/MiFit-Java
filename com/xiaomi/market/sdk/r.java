package com.xiaomi.market.sdk;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.database.Cursor;
import android.os.HandlerThread;
import com.amap.api.location.LocationManagerProxy;
import java.io.File;

public class r {
    public static r a;
    private Context b;
    private B c;
    private v d;
    private long e = -1;
    private File f;
    private DownloadManager g;
    private HandlerThread h;
    private s i;

    private r(Context context) {
        this.b = context;
        this.g = (DownloadManager) this.b.getSystemService("download");
        this.h = new HandlerThread("Worker Thread");
        this.h.start();
        this.i = new s(this, this.h.getLooper());
    }

    public static r a(Context context) {
        if (a == null) {
            a = new r(context);
        }
        return a;
    }

    public void a(long j) {
        if (this.e <= 0 || this.e == j) {
            this.i.b();
        }
    }

    public void a(v vVar, B b) {
        if (b != null && vVar != null) {
            this.c = b;
            this.d = vVar;
            this.i.a();
        }
    }

    public boolean a(v vVar) {
        long j;
        Cursor query;
        int i;
        Cursor a = w.a(this.b).a(q.b, q.l, "package_name=?", new String[]{vVar.a}, null, null, null);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    j = a.getLong(a.getColumnIndex(q.d));
                    if (j != -1) {
                        if (a != null) {
                            a.close();
                        }
                        return false;
                    }
                    if (a != null) {
                        a.close();
                    }
                    Query query2 = new Query();
                    query2.setFilterById(new long[]{j});
                    query = this.g.query(query2);
                    i = -1;
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                i = query.getInt(query.getColumnIndexOrThrow(LocationManagerProxy.KEY_STATUS_CHANGED));
                            }
                        } catch (Throwable th) {
                            if (query != null) {
                                query.close();
                            }
                        }
                    }
                    if (i != 4 || i == 1 || i == 2) {
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return false;
                }
            } catch (Throwable th2) {
                if (a != null) {
                    a.close();
                }
            }
        }
        j = -1;
        if (j != -1) {
            if (a != null) {
                a.close();
            }
            Query query22 = new Query();
            query22.setFilterById(new long[]{j});
            query = this.g.query(query22);
            i = -1;
            if (query != null) {
                if (query.moveToFirst()) {
                    i = query.getInt(query.getColumnIndexOrThrow(LocationManagerProxy.KEY_STATUS_CHANGED));
                }
            }
            if (i != 4) {
            }
            if (query != null) {
                query.close();
            }
            return true;
        }
        if (a != null) {
            a.close();
        }
        return false;
    }
}

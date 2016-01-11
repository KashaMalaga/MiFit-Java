package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class aj {
    private ai a;
    private SQLiteDatabase b;

    public aj(Context context) {
        this.a = new ai(context, "logdb.db", null, 1);
    }

    private SQLiteDatabase a() {
        this.b = this.a.getReadableDatabase();
        return this.b;
    }

    private SQLiteDatabase b() {
        this.b = this.a.getWritableDatabase();
        return this.b;
    }

    public <T> void a(aq<T> aqVar) {
        if (aqVar != null) {
            ContentValues b = aqVar.b();
            if (b != null && aqVar.a() != null) {
                if (this.b == null || this.b.isReadOnly()) {
                    this.b = b();
                }
                if (this.b != null) {
                    try {
                        this.b.insert(aqVar.a(), null, b);
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    } catch (Throwable th) {
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    }
                }
            }
        }
    }

    public <T> void a(String str, aq<T> aqVar) {
        if (aqVar.a() != null && str != null) {
            if (this.b == null || this.b.isReadOnly()) {
                this.b = b();
            }
            if (this.b != null) {
                try {
                    this.b.delete(aqVar.a(), str, null);
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                } catch (Throwable th) {
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                }
            }
        }
    }

    public <T> void b(String str, aq<T> aqVar) {
        if (aqVar != null && str != null && aqVar.a() != null) {
            ContentValues b = aqVar.b();
            if (b != null) {
                if (this.b == null || this.b.isReadOnly()) {
                    this.b = b();
                }
                if (this.b != null) {
                    try {
                        this.b.update(aqVar.a(), b, str, null);
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    } catch (Throwable th) {
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    }
                }
            }
        }
    }

    public <T> List<T> c(String str, aq<T> aqVar) {
        List<T> arrayList = new ArrayList();
        if (this.b == null) {
            this.b = a();
        }
        if (this.b == null || aqVar.a() == null || str == null) {
            return arrayList;
        }
        try {
            Cursor query = this.b.query(aqVar.a(), null, str, null, null, null, null);
            if (query == null) {
                this.b.close();
                this.b = null;
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
                return arrayList;
            }
            while (query.moveToNext()) {
                arrayList.add(aqVar.b(query));
            }
            query.close();
            if (this.b != null) {
                this.b.close();
                this.b = null;
            }
            return arrayList;
        } catch (Throwable th) {
            if (this.b != null) {
                this.b.close();
                this.b = null;
            }
        }
    }
}

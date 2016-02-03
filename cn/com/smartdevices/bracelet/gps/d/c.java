package cn.com.smartdevices.bracelet.gps.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.lab.sync.l;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.xiaomi.e.a;
import java.util.LinkedList;
import java.util.List;

public class c {
    private static a a = null;

    private static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    public static List<cn.com.smartdevices.bracelet.gps.model.c> a(Context context, long j) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        SQLiteDatabase readableDatabase = a(context).getReadableDatabase();
        List<cn.com.smartdevices.bracelet.gps.model.c> linkedList = new LinkedList();
        try {
            query = readableDatabase.query(b.a, new String[]{ParamKey.LATITUDE, b.c}, "track_id=?", new String[]{a.f + j}, null, null, null);
            while (query.moveToNext()) {
                try {
                    cn.com.smartdevices.bracelet.gps.model.c cVar = new cn.com.smartdevices.bracelet.gps.model.c();
                    cVar.q = query.getDouble(query.getColumnIndex(b.c));
                    cVar.p = query.getDouble(query.getColumnIndex(ParamKey.LATITUDE));
                    linkedList.add(cVar);
                } catch (Exception e) {
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
            return linkedList;
        } catch (Exception e2) {
            query = null;
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean a(Context context, long j, cn.com.smartdevices.bracelet.gps.model.c cVar) {
        SQLiteDatabase writableDatabase = a(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(l.f, Long.valueOf(j));
        contentValues.put(b.c, Double.valueOf(cVar.q));
        contentValues.put(ParamKey.LATITUDE, Double.valueOf(cVar.p));
        return writableDatabase.insert(b.a, null, contentValues) != -1;
    }
}

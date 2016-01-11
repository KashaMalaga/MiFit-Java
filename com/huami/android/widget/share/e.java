package com.huami.android.widget.share;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.d.a.c;
import cn.com.smartdevices.bracelet.d.a.d;
import com.huami.android.widget.share.ShareDataManager.SharedData;
import java.util.ArrayList;
import java.util.List;

class e extends c {
    private static final int a = 1;
    private static final String b = "shares_db";
    private static List<Class<? extends d>> c = new ArrayList();

    static {
        c.add(SharedData.class);
    }

    public e(Context context) {
        super(context, b, a);
    }

    public List<Class<? extends d>> a() {
        return c;
    }

    public f b() {
        return (f) a(f.class);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}

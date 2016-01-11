package de.greenrobot.daobracelet;

import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;

public class LuaListDaoHelper {
    public static final String LUA_DB = "user-db";

    public static void altTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("DROP TABLE " + (z ? "IF EXISTS " : a.f) + "'LUA_LIST'");
    }

    public static void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        DaoMaster.dropAllTables(sQLiteDatabase, true);
        DaoMaster.createAllTables(sQLiteDatabase, false);
    }

    public static void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0596r.e("greenDAO", "onUpgrage, old = " + i + ", new = " + i2);
        if (i2 >= 7) {
            String str = "ALTER TABLE 'LUA_LIST' ADD 'EXPIRE_TIME' TEXT";
            C0596r.e("greenDAO", "SQL=" + str);
            sQLiteDatabase.execSQL(str);
        }
    }
}

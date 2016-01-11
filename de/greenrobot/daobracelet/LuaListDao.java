package de.greenrobot.daobracelet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.huami.android.zxing.y;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.p;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class LuaListDao extends AbstractDao<LuaList, Long> {
    public static final String TABLENAME = "LUA_LIST";

    public class Properties {
        public static final Property Date = new Property(1, String.class, g.a, false, "DATE");
        public static final Property ExpireTime = new Property(13, String.class, "expireTime", false, "EXPIRE_TIME");
        public static final Property Id = new Property(0, Long.class, SyncShoesDataService.d, true, p.a);
        public static final Property Index = new Property(5, String.class, ay.F, false, "INDEX");
        public static final Property JsonString = new Property(6, String.class, "jsonString", false, "JSON_STRING");
        public static final Property LuaActionScript = new Property(8, String.class, "luaActionScript", false, "LUA_ACTION_SCRIPT");
        public static final Property Right = new Property(4, String.class, "right", false, "RIGHT");
        public static final Property ScriptVersion = new Property(7, String.class, "scriptVersion", false, "SCRIPT_VERSION");
        public static final Property Start = new Property(11, String.class, "start", false, "START");
        public static final Property Stop = new Property(12, String.class, "stop", false, "STOP");
        public static final Property Text1 = new Property(9, String.class, "text1", false, "TEXT1");
        public static final Property Text2 = new Property(10, String.class, "text2", false, "TEXT2");
        public static final Property Time = new Property(2, String.class, cn.com.smartdevices.bracelet.gps.c.a.g.f, false, "TIME");
        public static final Property Type = new Property(3, String.class, SocialConstants.PARAM_TYPE, false, y.c);
    }

    public LuaListDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public LuaListDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : a.f) + "'LUA_LIST' (" + "'_id' INTEGER PRIMARY KEY ," + "'DATE' TEXT," + "'TIME' TEXT," + "'TYPE' TEXT," + "'RIGHT' TEXT," + "'INDEX' TEXT," + "'JSON_STRING' TEXT," + "'SCRIPT_VERSION' TEXT," + "'LUA_ACTION_SCRIPT' TEXT," + "'TEXT1' TEXT," + "'TEXT2' TEXT," + "'START' TEXT," + "'STOP' TEXT," + "'EXPIRE_TIME' TEXT);");
    }

    public static void dropTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("DROP TABLE " + (z ? "IF EXISTS " : a.f) + "'LUA_LIST'");
    }

    protected void bindValues(SQLiteStatement sQLiteStatement, LuaList luaList) {
        sQLiteStatement.clearBindings();
        Long id = luaList.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String date = luaList.getDate();
        if (date != null) {
            sQLiteStatement.bindString(2, date);
        }
        date = luaList.getTime();
        if (date != null) {
            sQLiteStatement.bindString(3, date);
        }
        date = luaList.getType();
        if (date != null) {
            sQLiteStatement.bindString(4, date);
        }
        date = luaList.getRight();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        date = luaList.getIndex();
        if (date != null) {
            sQLiteStatement.bindString(6, date);
        }
        date = luaList.getJsonString();
        if (date != null) {
            sQLiteStatement.bindString(7, date);
        }
        date = luaList.getScriptVersion();
        if (date != null) {
            sQLiteStatement.bindString(8, date);
        }
        date = luaList.getLuaActionScript();
        if (date != null) {
            sQLiteStatement.bindString(9, date);
        }
        date = luaList.getText1();
        if (date != null) {
            sQLiteStatement.bindString(10, date);
        }
        date = luaList.getText2();
        if (date != null) {
            sQLiteStatement.bindString(11, date);
        }
        date = luaList.getStart();
        if (date != null) {
            sQLiteStatement.bindString(12, date);
        }
        date = luaList.getStop();
        if (date != null) {
            sQLiteStatement.bindString(13, date);
        }
        date = luaList.getExpireTime();
        if (date != null) {
            sQLiteStatement.bindString(14, date);
        }
    }

    public Long getKey(LuaList luaList) {
        return luaList != null ? luaList.getId() : null;
    }

    protected boolean isEntityUpdateable() {
        return true;
    }

    public LuaList readEntity(Cursor cursor, int i) {
        return new LuaList(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : cursor.getString(i + 3), cursor.isNull(i + 4) ? null : cursor.getString(i + 4), cursor.isNull(i + 5) ? null : cursor.getString(i + 5), cursor.isNull(i + 6) ? null : cursor.getString(i + 6), cursor.isNull(i + 7) ? null : cursor.getString(i + 7), cursor.isNull(i + 8) ? null : cursor.getString(i + 8), cursor.isNull(i + 9) ? null : cursor.getString(i + 9), cursor.isNull(i + 10) ? null : cursor.getString(i + 10), cursor.isNull(i + 11) ? null : cursor.getString(i + 11), cursor.isNull(i + 12) ? null : cursor.getString(i + 12), cursor.isNull(i + 13) ? null : cursor.getString(i + 13));
    }

    public void readEntity(Cursor cursor, LuaList luaList, int i) {
        String str = null;
        luaList.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        luaList.setDate(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        luaList.setTime(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        luaList.setType(cursor.isNull(i + 3) ? null : cursor.getString(i + 3));
        luaList.setRight(cursor.isNull(i + 4) ? null : cursor.getString(i + 4));
        luaList.setIndex(cursor.isNull(i + 5) ? null : cursor.getString(i + 5));
        luaList.setJsonString(cursor.isNull(i + 6) ? null : cursor.getString(i + 6));
        luaList.setScriptVersion(cursor.isNull(i + 7) ? null : cursor.getString(i + 7));
        luaList.setLuaActionScript(cursor.isNull(i + 8) ? null : cursor.getString(i + 8));
        luaList.setText1(cursor.isNull(i + 9) ? null : cursor.getString(i + 9));
        luaList.setText2(cursor.isNull(i + 10) ? null : cursor.getString(i + 10));
        luaList.setStart(cursor.isNull(i + 11) ? null : cursor.getString(i + 11));
        luaList.setStop(cursor.isNull(i + 12) ? null : cursor.getString(i + 12));
        if (!cursor.isNull(i + 13)) {
            str = cursor.getString(i + 13);
        }
        luaList.setExpireTime(str);
    }

    public Long readKey(Cursor cursor, int i) {
        return cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0));
    }

    protected Long updateKeyAfterInsert(LuaList luaList, long j) {
        luaList.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }
}

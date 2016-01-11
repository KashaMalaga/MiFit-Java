package de.greenrobot.daobracelet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import com.xiaomi.market.sdk.p;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class LuaZipFileDao extends AbstractDao<LuaZipFile, Long> {
    public static final String TABLENAME = "LUA_ZIP_FILE";

    public class Properties {
        public static final Property Date = new Property(2, String.class, g.a, false, "DATE");
        public static final Property Id = new Property(0, Long.class, SyncShoesDataService.d, true, p.a);
        public static final Property Version = new Property(1, String.class, o.x, false, "VERSION");
        public static final Property ZipFile = new Property(3, byte[].class, "zipFile", false, "ZIP_FILE");
    }

    public LuaZipFileDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public LuaZipFileDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : a.f) + "'LUA_ZIP_FILE' (" + "'_id' INTEGER PRIMARY KEY ," + "'VERSION' TEXT," + "'DATE' TEXT," + "'ZIP_FILE' BLOB);");
    }

    public static void dropTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("DROP TABLE " + (z ? "IF EXISTS " : a.f) + "'LUA_ZIP_FILE'");
    }

    protected void bindValues(SQLiteStatement sQLiteStatement, LuaZipFile luaZipFile) {
        sQLiteStatement.clearBindings();
        Long id = luaZipFile.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String version = luaZipFile.getVersion();
        if (version != null) {
            sQLiteStatement.bindString(2, version);
        }
        version = luaZipFile.getDate();
        if (version != null) {
            sQLiteStatement.bindString(3, version);
        }
        byte[] zipFile = luaZipFile.getZipFile();
        if (zipFile != null) {
            sQLiteStatement.bindBlob(4, zipFile);
        }
    }

    public Long getKey(LuaZipFile luaZipFile) {
        return luaZipFile != null ? luaZipFile.getId() : null;
    }

    protected boolean isEntityUpdateable() {
        return true;
    }

    public LuaZipFile readEntity(Cursor cursor, int i) {
        byte[] bArr = null;
        Long valueOf = cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0));
        String string = cursor.isNull(i + 1) ? null : cursor.getString(i + 1);
        String string2 = cursor.isNull(i + 2) ? null : cursor.getString(i + 2);
        if (!cursor.isNull(i + 3)) {
            bArr = cursor.getBlob(i + 3);
        }
        return new LuaZipFile(valueOf, string, string2, bArr);
    }

    public void readEntity(Cursor cursor, LuaZipFile luaZipFile, int i) {
        byte[] bArr = null;
        luaZipFile.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        luaZipFile.setVersion(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        luaZipFile.setDate(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        if (!cursor.isNull(i + 3)) {
            bArr = cursor.getBlob(i + 3);
        }
        luaZipFile.setZipFile(bArr);
    }

    public Long readKey(Cursor cursor, int i) {
        return cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0));
    }

    protected Long updateKeyAfterInsert(LuaZipFile luaZipFile, long j) {
        luaZipFile.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }
}

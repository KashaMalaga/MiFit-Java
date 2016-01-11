package de.greenrobot.daobracelet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 7;

    public abstract class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context, String str, CursorFactory cursorFactory) {
            super(context, str, cursorFactory, DaoMaster.SCHEMA_VERSION);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.i("greenDAO", "Creating tables for schema version 7");
            DaoMaster.createAllTables(sQLiteDatabase, false);
        }
    }

    public class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str, CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.i("greenDAO", "onDowngrade, from version: " + i + " to " + i2);
            LuaListDaoHelper.onDowngrade(sQLiteDatabase, i, i2);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            LuaListDaoHelper.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, SCHEMA_VERSION);
        registerDaoClass(LuaListDao.class);
        registerDaoClass(LuaZipFileDao.class);
    }

    public static void createAllTables(SQLiteDatabase sQLiteDatabase, boolean z) {
        LuaListDao.createTable(sQLiteDatabase, z);
        LuaZipFileDao.createTable(sQLiteDatabase, z);
    }

    public static void dropAllTables(SQLiteDatabase sQLiteDatabase, boolean z) {
        LuaListDao.dropTable(sQLiteDatabase, z);
        LuaZipFileDao.dropTable(sQLiteDatabase, z);
    }

    public DaoSession newSession() {
        return new DaoSession(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.db, identityScopeType, this.daoConfigMap);
    }
}

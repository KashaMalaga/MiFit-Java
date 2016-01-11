package de.greenrobot.daobracelet;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

public class DaoSession extends AbstractDaoSession {
    private final LuaListDao luaListDao = new LuaListDao(this.luaListDaoConfig, this);
    private final DaoConfig luaListDaoConfig;
    private final LuaZipFileDao luaZipFileDao = new LuaZipFileDao(this.luaZipFileDaoConfig, this);
    private final DaoConfig luaZipFileDaoConfig;

    public DaoSession(SQLiteDatabase sQLiteDatabase, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(sQLiteDatabase);
        this.luaListDaoConfig = ((DaoConfig) map.get(LuaListDao.class)).clone();
        this.luaListDaoConfig.initIdentityScope(identityScopeType);
        this.luaZipFileDaoConfig = ((DaoConfig) map.get(LuaZipFileDao.class)).clone();
        this.luaZipFileDaoConfig.initIdentityScope(identityScopeType);
        registerDao(LuaList.class, this.luaListDao);
        registerDao(LuaZipFile.class, this.luaZipFileDao);
    }

    public void clear() {
        this.luaListDaoConfig.getIdentityScope().clear();
        this.luaZipFileDaoConfig.getIdentityScope().clear();
    }

    public LuaListDao getLuaListDao() {
        return this.luaListDao;
    }

    public LuaZipFileDao getLuaZipFileDao() {
        return this.luaZipFileDao;
    }
}

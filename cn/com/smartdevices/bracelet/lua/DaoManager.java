package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import de.greenrobot.daobracelet.DaoMaster;
import de.greenrobot.daobracelet.DaoMaster.DevOpenHelper;
import de.greenrobot.daobracelet.DaoSession;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDaoHelper;
import de.greenrobot.daobracelet.LuaZipFileDao;

public class DaoManager {
    private static Context context = null;
    private static DaoManager instance = null;
    DaoSession daoSession = null;

    private DaoManager(Context context) {
        this.daoSession = new DaoMaster(new DevOpenHelper(context, LuaListDaoHelper.LUA_DB, null).getWritableDatabase()).newSession();
    }

    public static DaoManager getInstance() {
        if (instance == null) {
            instance = new DaoManager(context);
        }
        return instance;
    }

    public static void init(Context context) {
        context = context;
    }

    public LuaListDao getLuaListDao() {
        return this.daoSession.getLuaListDao();
    }

    public LuaZipFileDao getLuaZipFileDao() {
        return this.daoSession.getLuaZipFileDao();
    }
}

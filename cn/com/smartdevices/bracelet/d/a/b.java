package cn.com.smartdevices.bracelet.d.a;

import android.content.Context;
import de.greenrobot.daobracelet.DaoMaster;
import de.greenrobot.daobracelet.DaoMaster.DevOpenHelper;
import de.greenrobot.daobracelet.DaoSession;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDaoHelper;
import de.greenrobot.daobracelet.LuaZipFileDao;

public class b {
    private static b b = null;
    private static Context c = null;
    DaoSession a = null;

    private b(Context context) {
        this.a = new DaoMaster(new DevOpenHelper(context, LuaListDaoHelper.LUA_DB, null).getWritableDatabase()).newSession();
    }

    public static b a() {
        if (b == null) {
            b = new b(c);
        }
        return b;
    }

    public static void a(Context context) {
        c = context;
    }

    public LuaListDao b() {
        return this.a.getLuaListDao();
    }

    public LuaZipFileDao c() {
        return this.a.getLuaZipFileDao();
    }
}

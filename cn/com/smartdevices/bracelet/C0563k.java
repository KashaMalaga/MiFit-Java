package cn.com.smartdevices.bracelet;

import android.content.Context;
import de.greenrobot.daobracelet.DaoMaster;
import de.greenrobot.daobracelet.DaoMaster.DevOpenHelper;
import de.greenrobot.daobracelet.DaoSession;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDaoHelper;
import de.greenrobot.daobracelet.LuaZipFileDao;

public class C0563k {
    private static C0563k b = null;
    private static Context c = null;
    DaoSession a = null;

    private C0563k(Context context) {
        this.a = new DaoMaster(new DevOpenHelper(context, LuaListDaoHelper.LUA_DB, null).getWritableDatabase()).newSession();
    }

    public static C0563k a() {
        if (b == null) {
            b = new C0563k(c);
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

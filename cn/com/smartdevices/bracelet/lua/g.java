package cn.com.smartdevices.bracelet.lua;

import android.util.Base64;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventLuaUpdated;
import com.d.a.a.h;
import de.greenrobot.daobracelet.LuaZipFile;
import de.greenrobot.daobracelet.LuaZipFileDao;
import de.greenrobot.event.EventBus;
import org.apache.http.Header;

class g extends h {
    final /* synthetic */ LuaManager a;

    g(LuaManager luaManager) {
        this.a = luaManager;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("LuaManager", "getLuaZipFile onFailure=========================================");
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        try {
            h hVar = (h) Utils.c().a(Utils.b(bArr), h.class);
            if (hVar.a != 1) {
                C0596r.e("LuaManager", "get latest luaZipFile error (message:" + hVar.b + ")");
                return;
            }
            byte[] decode = Base64.decode(hVar.c.b, 2);
            LuaZipFile luaZipFile = new LuaZipFile();
            luaZipFile.setVersion(hVar.c.c);
            luaZipFile.setZipFile(decode);
            LuaZipFileDao c = C0563k.a().c();
            c.insertOrReplace(luaZipFile);
            this.a.getLatestDBLuaFile();
            Keeper.keepLatestDBLuaVersion(hVar.c.c);
            C0596r.e("LuaManager", "save DB luaZipFile onSuccess====(version:" + hVar.c.c + ")");
            this.a.resetLuaState();
            LuaEvent.getInstance(this.a.context).setCurLocale();
            EventBus.getDefault().post(new EventLuaUpdated());
            C0596r.e("LuaManager", "zipfile count:" + c.count());
        } catch (Exception e) {
            C0596r.a("LuaManager", "get latest lua gson error!:" + e.getMessage());
        }
    }
}

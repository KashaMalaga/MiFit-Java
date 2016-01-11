package cn.com.smartdevices.bracelet.lua;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.d.a.a.h;
import org.apache.http.Header;

class f extends h {
    final /* synthetic */ LuaManager a;

    f(LuaManager luaManager) {
        this.a = luaManager;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("LuaManager", "getLuaZipFile onFailure=======================================================");
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        try {
            h hVar = (h) Utils.c().a(Utils.b(bArr), h.class);
            if (hVar.a != 1) {
                C0596r.e("LuaManager", "get latest luaZipFileVersion error (message:" + hVar.b + ")");
                return;
            }
            String str = hVar.c.c;
            String readLatestDBLuaVersion = Keeper.readLatestDBLuaVersion();
            C0596r.e("LuaManager", "getLuaZipFileVersion onSuccess====(server version:" + str + ", cur version:" + readLatestDBLuaVersion + ")");
            if (str.compareTo(readLatestDBLuaVersion) > 0 || LuaManager.TEST) {
                this.a.getLatestLuaZipFile();
            }
        } catch (Exception e) {
            C0596r.a("LuaManager", "get latest lua gson error!:" + e.getMessage());
        }
    }
}

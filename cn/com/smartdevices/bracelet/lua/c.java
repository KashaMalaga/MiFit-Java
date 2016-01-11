package cn.com.smartdevices.bracelet.lua;

import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.partner.Partner;
import cn.com.smartdevices.bracelet.partner.PartnerDataManager;
import cn.com.smartdevices.bracelet.partner.WebActivity;
import de.greenrobot.daobracelet.LuaList;

class c implements OnClickListener {
    final /* synthetic */ LuaList a;
    final /* synthetic */ LuaListAdapter b;

    c(LuaListAdapter luaListAdapter, LuaList luaList) {
        this.b = luaListAdapter;
        this.a = luaList;
    }

    public void onClick(View view) {
        LuaList luaList = (LuaList) ((e) view.getTag()).a.getTag();
        C0401a.a(this.b.mContext, C0401a.da, luaList.getType());
        C0596r.e("LuaListAdapter", "upload clicked type to server " + luaList.getType());
        String luaActionScript = luaList.getLuaActionScript();
        if (luaActionScript != null && luaActionScript.length() >= 5) {
            if (luaActionScript.contains("weight_history_result")) {
                C0401a.a(this.b.mContext, C0401a.fL);
            }
            try {
                if (PartnerDataManager.LUA_SERVICE_RIGHT.equals(this.a.getRight())) {
                    if (this.a.getType() != null) {
                        C0401a.a(this.b.mContext, C0409b.bH + this.a.getType());
                    }
                    Partner serviceById = this.b.mServiceManager.getServiceById(this.a.getType());
                    if (serviceById != null) {
                        this.b.mContext.startActivity(WebActivity.buildIntent(this.b.mContext, serviceById));
                        return;
                    }
                }
                if (luaActionScript.startsWith("http://")) {
                    C0596r.a("chenee", "should not use http:// use script directly instead!!(script:" + luaActionScript + ")");
                } else if (luaActionScript.startsWith("file://")) {
                    C0596r.a("chenee", "should not use file:// use script directly instead!!(script:" + luaActionScript + ")");
                } else {
                    LuaAction.getInstance(this.b.mContext).doLuaAction(luaActionScript);
                }
            } catch (Exception e) {
                C0596r.a("chenee", e.getMessage());
            }
        }
    }
}

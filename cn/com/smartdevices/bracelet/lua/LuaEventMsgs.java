package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.lab.sportmode.LabFactoryActiveItem;
import de.greenrobot.daobracelet.LuaListDao;
import org.keplerproject.luajava.LuaState;

public class LuaEventMsgs {
    private static LuaEventMsgs __instance = null;
    private Context context = null;
    private LuaListDao listDao = C0563k.a().b();

    public static LuaEventMsgs getInstance(Context context) {
        if (__instance == null) {
            LuaEventMsgs luaEventMsgs = new LuaEventMsgs();
            luaEventMsgs.context = context;
            LuaManager.getInstance(context);
            __instance = luaEventMsgs;
        }
        return __instance;
    }

    public void luaEventAchievementMsg(ConfigDynamicDataInfo configDynamicDataInfo) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getAchievementMsgs");
        luaState.pushJavaObject(this.listDao);
        luaState.pushJavaObject(configDynamicDataInfo);
        luaState.pushJavaObject(Keeper.readPersonInfo());
        instance.callLua(3, 0);
    }

    public void luaEventActivityMsg(ConfigDynamicDataInfo configDynamicDataInfo) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getActivityMsgs");
        luaState.pushJavaObject(this.listDao);
        luaState.pushJavaObject(configDynamicDataInfo);
        luaState.pushJavaObject(Keeper.readPersonInfo());
        instance.callLua(3, 0);
    }

    public void luaEventDefaultMsg(ConfigDynamicDataInfo configDynamicDataInfo) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getDefaultMsgs");
        luaState.pushJavaObject(this.listDao);
        luaState.pushJavaObject(configDynamicDataInfo);
        instance.callLua(2, 0);
    }

    public void luaEventSleepMsg(ConfigDynamicDataInfo configDynamicDataInfo) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getSleepMsgs");
        luaState.pushJavaObject(this.listDao);
        luaState.pushJavaObject(configDynamicDataInfo);
        instance.callLua(2, 0);
    }

    public void luaEventSysInfoMsg(ConfigDynamicDataInfo configDynamicDataInfo) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getSysInfoMsgs");
        luaState.pushJavaObject(this.listDao);
        luaState.pushJavaObject(configDynamicDataInfo);
        instance.callLua(2, 0);
        C0596r.e("SCORPIONEAL", "call luaEventSysInfoMsg " + configDynamicDataInfo.toString());
    }

    public void luaLabFactoryActivityMsg(LabFactoryActiveItem labFactoryActiveItem) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getLabFactoryActivityMsgs");
        luaState.pushJavaObject(this.listDao);
        luaState.pushJavaObject(labFactoryActiveItem);
        instance.callLua(2, 0);
    }

    public void testLuaImp(int i, ConfigDynamicDataInfo configDynamicDataInfo) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getEventMsgs");
        luaState.pushJavaObject(this.listDao);
        luaState.pushJavaObject(configDynamicDataInfo);
        luaState.pushInteger(i);
        instance.callLua(3, 0);
    }
}

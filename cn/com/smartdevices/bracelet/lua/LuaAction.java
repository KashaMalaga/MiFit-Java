package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaList;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDao.Properties;
import java.util.List;
import org.keplerproject.luajava.LuaState;

public class LuaAction {
    private static LuaAction __instance = null;
    private Context context = null;

    public LuaAction(Context context) {
        this.context = context;
    }

    public static LuaAction getInstance() {
        return __instance == null ? null : __instance;
    }

    public static LuaAction getInstance(Context context) {
        if (__instance == null) {
            LuaAction luaAction = new LuaAction(context);
            luaAction.context = context;
            __instance = luaAction;
        }
        __instance.context = context;
        return __instance;
    }

    public void clearDB() {
        C0563k.a().b().deleteAll();
    }

    public void delMsg(WhereCondition whereCondition, WhereCondition whereCondition2) {
        QueryBuilder queryBuilder = C0563k.a().b().queryBuilder();
        queryBuilder.where(whereCondition, new WhereCondition[0]);
        if (whereCondition2 != null) {
            queryBuilder.where(whereCondition2, new WhereCondition[0]);
        }
        queryBuilder.buildDelete().executeDeleteWithoutDetachingEntities();
    }

    public void delMsg4(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition whereCondition3, WhereCondition whereCondition4) {
        QueryBuilder queryBuilder = C0563k.a().b().queryBuilder();
        queryBuilder.where(whereCondition, new WhereCondition[0]);
        if (whereCondition2 != null) {
            queryBuilder.where(whereCondition2, new WhereCondition[0]);
        }
        if (whereCondition3 != null) {
            queryBuilder.where(whereCondition3, new WhereCondition[0]);
        }
        if (whereCondition4 != null) {
            queryBuilder.where(whereCondition4, new WhereCondition[0]);
        }
        queryBuilder.buildDelete().executeDeleteWithoutDetachingEntities();
    }

    public void doLuaAction(String str) {
        C0596r.e("chenee", "-------------\n" + str);
        C0596r.e("chenee", "--------------------\n");
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = LuaManager.getInstance().getLuaState();
        luaState.LdoString(str);
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "doAction");
        luaState.pushJavaObject(this.context);
        luaState.pushJavaObject(__instance);
        instance.callLua(2, 0);
    }

    public ConfigDynamicDataInfo getConfigInfo() {
        return ConfigDynamicDataInfo.getInstance();
    }

    public int getCount(WhereCondition whereCondition, WhereCondition whereCondition2) {
        QueryBuilder queryBuilder = C0563k.a().b().queryBuilder();
        queryBuilder.where(whereCondition, new WhereCondition[0]);
        if (whereCondition2 != null) {
            queryBuilder.where(whereCondition2, new WhereCondition[0]);
        }
        return (int) queryBuilder.count();
    }

    public int getCount4(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition whereCondition3, WhereCondition whereCondition4) {
        QueryBuilder queryBuilder = C0563k.a().b().queryBuilder();
        queryBuilder.where(whereCondition, new WhereCondition[0]);
        if (whereCondition2 != null) {
            queryBuilder.where(whereCondition2, new WhereCondition[0]);
        }
        if (whereCondition3 != null) {
            queryBuilder.where(whereCondition3, new WhereCondition[0]);
        }
        if (whereCondition3 != null) {
            queryBuilder.where(whereCondition3, new WhereCondition[0]);
        }
        return (int) queryBuilder.count();
    }

    public LuaListDao getDao() {
        return C0563k.a().b();
    }

    public Intent getIntentFromString(String str) {
        Class cls = null;
        C0596r.e("chenee", "luaAction,classname is: " + str);
        if (str != null) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                C0596r.e("chenee", e.getMessage());
                return cls;
            }
        }
        return new Intent(this.context, cls);
    }

    public Boolean getIsBind() {
        return Boolean.valueOf(Utils.e());
    }

    public void putExtra(Intent intent, String str, Object obj) {
        if (obj instanceof String) {
            intent.putExtra(str, (String) obj);
        } else if (obj instanceof Byte) {
            intent.putExtra(str, (Byte) obj);
        } else if (obj instanceof Integer) {
            intent.putExtra(str, ((Integer) obj).intValue());
        } else if (obj instanceof Parcelable) {
            intent.putExtra(str, (Parcelable) obj);
        }
    }

    public int queryCount(QueryBuilder<LuaList> queryBuilder) {
        return (int) queryBuilder.count();
    }

    public void queryDel(QueryBuilder<LuaList> queryBuilder) {
        queryBuilder.buildDelete().executeDeleteWithoutDetachingEntities();
    }

    public LuaList queryLastItem(QueryBuilder<LuaList> queryBuilder) {
        queryBuilder.orderDesc(Properties.Id);
        List list = queryBuilder.list();
        return list.size() > 0 ? (LuaList) list.get(0) : null;
    }

    public void queryWhere(QueryBuilder<LuaList> queryBuilder, WhereCondition whereCondition) {
        queryBuilder.where(whereCondition, new WhereCondition[0]);
    }
}

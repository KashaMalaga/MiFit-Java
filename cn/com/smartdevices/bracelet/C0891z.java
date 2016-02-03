package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.text.format.DateFormat;
import cn.com.smartdevices.bracelet.f.f;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.LuaItem;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.bt.profile.Weight.m;
import com.xiaomi.hm.health.dataprocess.SportDay;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaList;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDao.Properties;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class C0891z {
    private static final String a = "LuaUtil";
    private static C0891z b;
    private Context c;

    private C0891z(Context context) {
        this.c = context;
    }

    public static C0891z a(Context context) {
        if (b == null) {
            b = new C0891z(context);
        }
        return b;
    }

    public static String a(UserInfo userInfo, e eVar) {
        C0596r.e(a, "getWeightLuaScript " + eVar.n());
        return "function doAction(context, luaAction)  \n   local intent = luaAction:getIntentFromString('cn.com.smartdevices.bracelet.weight.WeightReportActivity'); \n   luaAction:putExtra(intent,'WEIGHTADVDATA_KEY','" + eVar.n() + "')  \n" + "   luaAction:putExtra(intent,'" + UserInfo.USERINFO_KEY + "','" + userInfo.toJsonString() + "')  \n" + "   context:startActivity(intent)  \n" + "end";
    }

    public String a(e eVar) {
        C0596r.e(a, "getChooseUserLuaScript" + eVar.n());
        return "function doAction(context, luaAction)  \n   local intent = luaAction:getIntentFromString('cn.com.smartdevices.bracelet.weight.family.WeightChooseUserActivity'); \n   luaAction:putExtra(intent,'WEIGHTADVDATA_KEY','" + eVar.n() + "')  \n" + "   context:startActivity(intent)  \n" + "end";
    }

    public void a() {
        C0401a.a(this.c, C0401a.fM);
        C0596r.e(a, "addWeightConnectFailedDynamic");
        LuaItem luaItem = new LuaItem();
        luaItem.setStype("weight_connect_failed");
        luaItem.setT1(this.c.getResources().getString(R.string.weight_connect_failed_title));
        luaItem.setT2(a.f);
        luaItem.setScript("function doAction(context, luaAction)  \n   local intent = luaAction:getIntentFromString('cn.com.smartdevices.bracelet.ui.HelpActivity'); \n   luaAction:putExtra(intent,'REF_DEVICE_TYPE','TYPE_WEIGHT')  \n   context:startActivity(intent)  \nend");
        LuaEvent.getInstance(this.c).showLuaItem(luaItem);
    }

    public void a(int i) {
        LuaListDao b = C0563k.a().b();
        for (LuaList delete : b.queryBuilder().where(Properties.Type.eq("notice_" + i), new WhereCondition[0]).list()) {
            b.delete(delete);
        }
    }

    public void a(e eVar, UserInfo userInfo, String str) {
        C0596r.e(a, "EventUserWEight " + eVar + " weight.userinfo " + userInfo + " weight.stype " + str);
        LuaListDao b = C0563k.a().b();
        List list = b.queryBuilder().where(Properties.Type.eq(str), new WhereCondition[0]).list();
        String a = f.a(new Date(eVar.e()));
        int h = eVar.h();
        if (-1 == userInfo.uid) {
            C0596r.e(a, "save user stable weight into google fit");
        }
        String a2 = aA.a(this.c, h);
        float a3 = aA.a(userInfo.height, Birthday.fromStr(userInfo.birthday).getAge(), aA.a(eVar.j(), eVar.h()));
        if (list == null || list.size() < 1 || list.get(0) == null) {
            C0596r.e(a, "not match dynamic item!!!");
            return;
        }
        LuaList luaList = (LuaList) list.get(0);
        C0596r.e(a, "new lualist " + luaList.toString());
        C0596r.e(a, "bmi " + a3);
        String str2 = a.f;
        Birthday fromStr = Birthday.fromStr(userInfo.birthday);
        int b2 = ah.a().b(userInfo.uid);
        if (b2 == 1) {
            if (fromStr.getAge() <= 6) {
                str2 = aA.a(this.c, userInfo, eVar);
            } else if (userInfo.height < 100) {
                str2 = this.c.getString(R.string.height_less_than_100);
            } else {
                str2 = this.c.getString(R.string.bmi_item_tips, new Object[]{a3 + a.f, aA.a(this.c, a3, Birthday.fromStr(userInfo.birthday).getAge(), userInfo.gender)});
            }
        } else if (userInfo.targetWeight > 0.0f) {
            r3 = aA.c(((float) ((int) aA.b(userInfo.targetWeight, eVar.h()))) - eVar.j(), 1);
            if (r3 > 0.0f) {
                str2 = this.c.getString(R.string.lighter_than_goal, new Object[]{Math.abs(r3) + aA.a(this.c, eVar.h())});
            } else if (r3 < 0.0f) {
                str2 = this.c.getString(R.string.heavier_than_goal, new Object[]{Math.abs(r3) + aA.a(this.c, eVar.h())});
            } else {
                str2 = this.c.getString(R.string.weight_reach_goal);
            }
        } else {
            WeightInfo a4 = ah.a().a(userInfo.uid, eVar.e());
            if (a4 != null) {
                r3 = aA.c(eVar.j() - aA.b(a4.weight, eVar.h()), 1);
                if (r3 > 0.0f) {
                    str2 = this.c.getString(R.string.add_than_last_time, new Object[]{r3 + aA.a(this.c, eVar.h())});
                } else if (r3 < 0.0f) {
                    r3 = Math.abs(r3);
                    str2 = this.c.getString(R.string.less_than_last_time, new Object[]{r3 + aA.a(this.c, eVar.h())});
                } else {
                    str2 = this.c.getString(R.string.equal_last_time);
                }
            }
        }
        String a5 = aA.a(eVar.e(), userInfo.uid);
        C0596r.e(a, "stype is " + a5);
        luaList.setType(a5);
        if (userInfo.uid == 0) {
            luaList.setText1(this.c.getResources().getString(R.string.weight_dynamic_visitor_title, new Object[]{a, Float.valueOf(eVar.j()), a2}));
            luaList.setText2(this.c.getString(R.string.weight_dynamic_list_visit_tips));
            luaList.setLuaActionScript(C0891z.a(this.c).a(eVar));
        } else {
            luaList.setText1(this.c.getResources().getString(R.string.weight_dynamic_title, new Object[]{a, Utils.h(userInfo.name), Float.valueOf(aA.c(eVar.j(), 1)), a2}));
            luaList.setText2(this.c.getResources().getString(R.string.weight_dynamic_detail, new Object[]{str2}));
            luaList.setLuaActionScript(C0891z.a(userInfo, eVar));
            C0596r.e(a, "weightinfo count  is " + b2);
            List list2 = b.queryBuilder().where(Properties.Type.eq("notice_" + userInfo.uid), new WhereCondition[0]).list();
            h = -1;
            if (list2 != null) {
                h = list2.size();
            }
            C0596r.e(a, "luaCount is " + h);
            if (b2 == 1 && h == 0 && userInfo.targetWeight <= 0.0f) {
                LuaList luaList2 = new LuaList();
                C0596r.e(a, "lenght " + userInfo.name.length());
                luaList2.setText1(this.c.getString(R.string.set_weight_goal_tips, new Object[]{Utils.h(userInfo.name)}));
                luaList2.setType("notice_" + userInfo.uid);
                Date date = new Date();
                luaList2.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date));
                luaList2.setTime(f.a(date));
                luaList2.setLuaActionScript("function doAction(context, luaAction)  \n   local intent = luaAction:getIntentFromString('cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity'); \n   luaAction:putExtra(intent,'UID'," + userInfo.uid + ")  \n" + "   context:startActivity(intent)  \n" + "end");
                b.insert(luaList2);
                C0401a.a(this.c, C0401a.gq);
            }
        }
        b.update(luaList);
    }

    public void a(m mVar, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(mVar.a);
        String d = Utils.d(new SportDay(instance));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(mVar.b);
        String d2 = Utils.d(new SportDay(instance2));
        LuaItem luaItem = new LuaItem();
        luaItem.setStype("weight_history_result" + mVar);
        luaItem.setT1(this.c.getResources().getString(R.string.weight_history_dynamic_title, new Object[]{Integer.valueOf(i)}));
        if (Utils.b(instance, instance2) == 0) {
            luaItem.setT2(this.c.getResources().getString(R.string.weight_history_dynamic_detail_oneday, new Object[]{d}));
        } else {
            luaItem.setT2(this.c.getResources().getString(R.string.weight_history_dynamic_detail, new Object[]{d, d2}));
        }
        luaItem.setScript("function doAction(context, luaAction)  \n   local intent = luaAction:getIntentFromString('cn.com.smartdevices.bracelet.ui.StatisticActivity'); \n   luaAction:putExtra(intent,'Mode',256)  \n   context:startActivity(intent)  \nend");
        LuaEvent.getInstance(this.c).showLuaItem(luaItem);
    }

    public void a(boolean z) {
        C0596r.e(a, "setWeiboToken");
        String str = "weibo_token_tips";
        if (z) {
            LuaItem luaItem = new LuaItem();
            luaItem.setExpire((System.currentTimeMillis() / 1000) + 68400);
            luaItem.setStype(str);
            luaItem.setT1(this.c.getResources().getString(R.string.weibo_token_expired_tips));
            luaItem.setT2(a.f);
            luaItem.setScript("function doAction(context, luaAction)  \n   local intent = luaAction:getIntentFromString('cn.com.smartdevices.bracelet.weibo.BindHealthActivity'); \n   luaAction:putExtra(intent,'action_type',2)  \n   context:startActivity(intent)  \nend");
            LuaEvent.getInstance(this.c).showLuaItem(luaItem);
            return;
        }
        LuaEvent.getInstance(this.c).deleteLuaItem(str);
    }

    public boolean a(String str) {
        List list = C0563k.a().b().queryBuilder().where(Properties.Type.eq(str), new WhereCondition[0]).list();
        return (list == null || list.size() == 0) ? false : true;
    }

    public void b(int i) {
        LuaItem luaItem = new LuaItem();
        luaItem.setStype("addRtHeart");
        luaItem.setT1("\u5b9e\u65f6\u5fc3\u7387\uff1a" + i);
        luaItem.setT2(DateFormat.format(f.a(Boolean.valueOf(false), System.currentTimeMillis()), System.currentTimeMillis()).toString());
        LuaEvent.getInstance(this.c).showLuaItem(luaItem);
    }

    public void b(UserInfo userInfo, e eVar) {
        String a = f.a(new Date(eVar.e()));
        C0596r.e("TIMESTAMP", "timestamp in BaseSCActivity " + eVar.e());
        int h = eVar.h();
        if (-1 == userInfo.uid) {
            C0596r.e(a, "save user stable weight into google fit");
        }
        LuaListDao b = C0563k.a().b();
        String a2 = aA.a(this.c, h);
        String str = a.f;
        Birthday fromStr = Birthday.fromStr(userInfo.birthday);
        if (userInfo.uid != 0) {
            C0596r.e(a, "bmi is " + eVar.i());
            int b2 = ah.a().b(userInfo.uid);
            C0596r.e(a, "count is " + b2);
            if (b2 == 1) {
                if (fromStr.getAge() <= 6) {
                    str = aA.a(this.c, userInfo, eVar);
                } else if (userInfo.height < 100) {
                    str = this.c.getString(R.string.height_less_than_100);
                } else {
                    str = this.c.getString(R.string.bmi_item_tips, new Object[]{r5 + a.f, aA.a(this.c, r5, Birthday.fromStr(userInfo.birthday).getAge(), userInfo.gender)});
                }
            } else if (userInfo.targetWeight > 0.0f) {
                r0 = aA.c(((float) ((int) aA.b(userInfo.targetWeight, eVar.h()))) - eVar.j(), 1);
                if (r0 > 0.0f) {
                    str = this.c.getString(R.string.lighter_than_goal, new Object[]{Math.abs(r0) + aA.a(this.c, eVar.h())});
                } else if (r0 < 0.0f) {
                    str = this.c.getString(R.string.heavier_than_goal, new Object[]{Math.abs(r0) + aA.a(this.c, eVar.h())});
                } else {
                    str = this.c.getString(R.string.weight_reach_goal);
                }
            } else {
                WeightInfo a3 = ah.a().a(userInfo.uid, eVar.e());
                if (a3 != null) {
                    r0 = aA.c(eVar.j() - aA.b(a3.weight, eVar.h()), 1);
                    if (r0 > 0.0f) {
                        str = this.c.getString(R.string.add_than_last_time, new Object[]{r0 + aA.a(this.c, eVar.h())});
                    } else if (r0 < 0.0f) {
                        r0 = Math.abs(r0);
                        str = this.c.getString(R.string.less_than_last_time, new Object[]{r0 + aA.a(this.c, eVar.h())});
                    } else {
                        str = this.c.getString(R.string.equal_last_time);
                    }
                }
            }
        } else {
            str = this.c.getString(R.string.weight_dynamic_list_visit_tips);
        }
        LuaList luaList = new LuaList();
        Date date = new Date();
        luaList.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date));
        luaList.setTime(f.a(date));
        String a4 = aA.a(eVar.e(), userInfo.uid);
        luaList.setType(a4);
        C0596r.e(a, "lua type is " + a4);
        if (userInfo.uid == 0) {
            luaList.setText1(this.c.getResources().getString(R.string.weight_dynamic_visitor_title, new Object[]{a, Float.valueOf(eVar.j()), a2}));
            luaList.setLuaActionScript(C0891z.a(this.c).a(eVar));
        } else {
            luaList.setText1(this.c.getResources().getString(R.string.weight_dynamic_title, new Object[]{a, Utils.h(userInfo.name), Float.valueOf(aA.c(eVar.j(), 1)), a2}));
            luaList.setLuaActionScript(C0891z.a(userInfo, eVar));
            int b3 = ah.a().b(userInfo.uid);
            C0596r.e(a, "weightinfo count  is " + b3);
            List list = b.queryBuilder().where(Properties.Type.eq("notice_" + userInfo.uid), new WhereCondition[0]).list();
            int i = -1;
            if (list != null) {
                i = list.size();
            }
            C0596r.e(a, "luaCount is " + i);
            if (b3 == 1 && i == 0 && userInfo.targetWeight <= 0.0f) {
                LuaList luaList2 = new LuaList();
                C0596r.e(a, "lenght " + userInfo.name.length());
                luaList2.setText1(this.c.getString(R.string.set_weight_goal_tips, new Object[]{Utils.h(userInfo.name)}));
                luaList2.setType("notice_" + userInfo.uid);
                Date date2 = new Date();
                luaList2.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date2));
                luaList2.setTime(f.a(date2));
                luaList2.setLuaActionScript("function doAction(context, luaAction)  \n   local intent = luaAction:getIntentFromString('cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity'); \n   luaAction:putExtra(intent,'UID'," + userInfo.uid + ")  \n" + "   context:startActivity(intent)  \n" + "end");
                b.insert(luaList2);
                C0401a.a(this.c, C0401a.gq);
            }
        }
        luaList.setText2(this.c.getResources().getString(R.string.weight_dynamic_detail, new Object[]{str}));
        b.insert(luaList);
        List<LuaList> list2 = b.queryBuilder().where(Properties.Type.eq(a4), new WhereCondition[0]).list();
        if (list2 != null && list2.size() > 0) {
            for (LuaList luaList3 : list2) {
                C0596r.e(a, "id:" + luaList3.getId() + ",type:" + luaList3.getType() + ",date:" + luaList3.getDate() + ",time:" + luaList3.getTime() + ",script:" + luaList3.getLuaActionScript() + ",text1:" + luaList3.getText1() + ",text2:" + luaList3.getText2());
            }
        }
        if (userInfo.uid == 0) {
            C0401a.a(this.c, C0401a.fE, "visitor");
        } else if (userInfo.uid == -1) {
            C0401a.a(this.c, C0401a.fE, "person_self");
        } else {
            C0401a.a(this.c, C0401a.fE, "user");
        }
    }

    public boolean b() {
        LuaListDao b = C0563k.a().b();
        List<LuaList> list = b.queryBuilder().where(Properties.Type.eq("weight_connect_failed"), new WhereCondition[0]).list();
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (LuaList delete : list) {
            b.delete(delete);
        }
        return true;
    }
}

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.support.v4.view.C0151az;
import android.support.v7.widget.af;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.model.LuaItem;
import cn.com.smartdevices.bracelet.partner.PartnerDataManager;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.e;
import com.xiaomi.hm.health.j;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaList;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDao.Properties;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kankan.wheel.widget.g;
import org.json.JSONException;
import org.json.JSONObject;

public class LuaListAdapter extends BaseAdapter {
    private static final String DISABLE_TAG = "_DISABLE";
    private static final String TAG = "LuaListAdapter";
    private static Boolean isFirstTimeBoolean = Boolean.valueOf(true);
    private Animation animT2B;
    private int fakeListCount = 0;
    private List<d> infoList = null;
    private Context mContext = null;
    private PartnerDataManager mServiceManager;
    private int newItemCount = 0;
    private TranslateAnimation taBlow;
    private TranslateAnimation taLeft;
    private TranslateAnimation taRight;
    private TranslateAnimation taTop;

    public class MyComparator implements Comparator<LuaList> {
        public int compare(LuaList luaList, LuaList luaList2) {
            String right = luaList2.getRight();
            String right2 = luaList.getRight();
            return (right == null && right2 == null) ? 0 : (right != null || right2 == null) ? (right == null || right2 != null) ? right.length() > right2.length() ? 1 : right.length() >= right2.length() ? right.compareTo(right2) : -1 : 1 : -1;
        }
    }

    public LuaListAdapter(Context context, List<LuaList> list) {
        this.mContext = context;
        isFirstTimeBoolean = Boolean.valueOf(true);
        this.mServiceManager = new PartnerDataManager(context);
        getNewList(list);
        InitAnim();
    }

    private void InitAnim() {
        this.taLeft = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        this.taRight = new TranslateAnimation(2, GroundOverlayOptions.NO_DIMENSION, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        this.taTop = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        this.taBlow = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, GroundOverlayOptions.NO_DIMENSION, 2, 0.0f);
        this.taLeft.setDuration(1000);
        this.taRight.setDuration(1000);
        this.taTop.setDuration(1000);
        this.taBlow.setDuration(1000);
        this.animT2B = AnimationUtils.loadAnimation(this.mContext, e.list_anim_slide_t2b);
    }

    private String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void getNewList(List<LuaList> list) {
        this.newItemCount = 0;
        if (list == null || list.size() == 0) {
            this.infoList = null;
            return;
        }
        List arrayList = new ArrayList();
        int i;
        d dVar;
        if (this.infoList == null || this.infoList.size() == 0) {
            for (i = 0; i < list.size(); i++) {
                dVar = new d(this);
                dVar.a = (LuaList) list.get(i);
                dVar.b = Boolean.valueOf(false);
                arrayList.add(dVar);
            }
            this.newItemCount = arrayList.size();
        } else {
            for (i = 0; i < list.size(); i++) {
                dVar = new d(this);
                dVar.a = (LuaList) list.get(i);
                if (judgeIsNew(dVar.a).booleanValue()) {
                    this.newItemCount++;
                    dVar.b = Boolean.valueOf(true);
                } else {
                    dVar.b = Boolean.valueOf(false);
                }
                arrayList.add(dVar);
            }
        }
        this.infoList = arrayList;
    }

    private Boolean judgeIsNew(LuaList luaList) {
        for (int i = 0; i < this.infoList.size(); i++) {
            if (luaList.getId() == ((d) this.infoList.get(i)).a.getId()) {
                return ((d) this.infoList.get(i)).b;
            }
        }
        return Boolean.valueOf(true);
    }

    public int getCount() {
        if (this.infoList == null || this.infoList.size() == 0) {
            this.fakeListCount = 3;
            return this.fakeListCount;
        }
        this.fakeListCount = 0;
        return this.infoList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getNewItemCount() {
        if (!isFirstTimeBoolean.booleanValue()) {
            return this.newItemCount;
        }
        isFirstTimeBoolean = Boolean.valueOf(false);
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        String str = null;
        if (view == null) {
            e eVar2 = new e(this);
            view = LayoutInflater.from(this.mContext).inflate(n.lua_list_item, null);
            eVar2.a = (TextView) view.findViewById(l.textView1);
            eVar2.b = (TextView) view.findViewById(l.textView2);
            eVar2.c = (ImageView) view.findViewById(l.lua_list_item_icon);
            eVar2.d = (ImageView) view.findViewById(l.rightArrow);
            view.setTag(eVar2);
            if (t.a()) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) eVar2.a.getLayoutParams();
                marginLayoutParams.bottomMargin = (int) t.a(this.mContext, 4.0f);
                eVar2.a.setTextSize(13.5f);
                eVar2.a.setLayoutParams(marginLayoutParams);
                eVar2.b.setTextSize(11.0f);
                eVar = eVar2;
            } else {
                eVar = eVar2;
            }
        } else {
            eVar = (e) view.getTag();
        }
        if (this.fakeListCount > 0) {
            eVar.d.setVisibility(4);
        } else {
            d dVar = (d) this.infoList.get(i);
            LuaList luaList = dVar.a;
            if (luaList.getType().contains(DISABLE_TAG)) {
                eVar.d.setVisibility(4);
            } else {
                eVar.d.setVisibility(0);
            }
            String jsonString = luaList.getJsonString();
            int color = this.mContext.getResources().getColor(g.main_ui_title_color);
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                color = jSONObject.optInt(LuaItem.JSON_TXT_COLOR);
                str = jSONObject.optString(LuaItem.JSON_ICON_URI);
            } catch (JSONException e) {
                color = color;
            } catch (NullPointerException e2) {
                color = color;
            }
            C0596r.e(TAG, "iconUri = " + str + " txtColor = " + color);
            if (TextUtils.isEmpty(str)) {
                eVar.c.setVisibility(8);
                ((LayoutParams) ((LinearLayout) view.findViewById(l.linearLayout1)).getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(j.mili_margin);
            } else {
                eVar.c.setVisibility(0);
                ((LayoutParams) ((LinearLayout) view.findViewById(l.linearLayout1)).getLayoutParams()).leftMargin = 0;
                C0544h.a().a(str, eVar.c, new b(this));
            }
            eVar.a.setTextColor(-872415232 | color);
            eVar.b.setTextColor((C0151az.r & color) | af.a);
            view.setOnClickListener(new c(this, luaList));
            eVar.a.setText(luaList.getText1());
            CharSequence text2 = luaList.getText2();
            if (text2 == null || text2.length() == 0) {
                eVar.b.setVisibility(8);
            } else {
                eVar.b.setVisibility(0);
                eVar.b.setText(text2);
            }
            view.setTag(eVar);
            eVar.a.setTag(luaList);
            if (dVar.b.booleanValue()) {
                view.startAnimation(this.animT2B);
            }
            dVar.b = Boolean.valueOf(false);
        }
        return view;
    }

    public void refExpTimeDB(LuaList luaList, long j) {
        LuaItem luaItem = new LuaItem();
        luaItem.setStype(luaList.getType());
        luaItem.setT1(luaList.getText1());
        luaItem.setT2(luaList.getText2());
        luaItem.setExpire(j);
        luaItem.setScript(luaList.getLuaActionScript());
        luaItem.setRight(luaList.getRight());
        luaItem.setStyleJson(luaList.getJsonString());
        LuaEvent.getInstance(this.mContext).showLuaItem(luaItem);
        C0596r.e(TAG, "refExpTimeDB");
    }

    public void refreshList() {
        LuaListDao b = C0563k.a().b();
        List<LuaList> list = b.queryBuilder().where(Properties.ExpireTime.isNotNull(), Properties.ExpireTime.notEq(a.f)).orderDesc(Properties.Id).list();
        if (!(list == null || list.size() == 0)) {
            for (LuaList luaList : list) {
                String expireTime = luaList.getExpireTime();
                if (expireTime.contains("-")) {
                    String[] split = expireTime.split("-");
                    Calendar instance = Calendar.getInstance();
                    instance.set(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue() - 1, Integer.valueOf(split[2]).intValue());
                    instance.set(11, 23);
                    instance.set(12, 59);
                    instance.set(13, 59);
                    C0596r.e(TAG, "old Lua-expire: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(instance.getTimeInMillis())));
                    refExpTimeDB(luaList, instance.getTimeInMillis() / 1000);
                }
            }
        }
        String date = getDate();
        C0596r.e(TAG, "===curTime: " + (System.currentTimeMillis() / 1000));
        QueryBuilder queryBuilder = b.queryBuilder();
        List list2 = queryBuilder.whereOr(queryBuilder.and(Properties.Date.eq(date), Properties.ExpireTime.eq(a.f), new WhereCondition[0]), queryBuilder.and(Properties.Date.eq(date), Properties.ExpireTime.isNull(), new WhereCondition[0]), queryBuilder.and(Properties.ExpireTime.isNotNull(), Properties.ExpireTime.ge(Long.valueOf(r2)), new WhereCondition[0])).orderDesc(Properties.Id).list();
        Collections.sort(list2, new MyComparator());
        setList(list2);
    }

    public void setFlagsToFalse() {
        for (int i = 0; i < this.infoList.size(); i++) {
            ((d) this.infoList.get(i)).b = Boolean.valueOf(false);
        }
    }

    public void setList(List<LuaList> list) {
        if (list != null) {
            getNewList(list);
            notifyDataSetChanged();
        }
    }
}

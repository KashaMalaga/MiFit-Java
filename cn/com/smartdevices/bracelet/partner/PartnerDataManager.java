package cn.com.smartdevices.bracelet.partner;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.eventbus.EventHomeListLoad;
import cn.com.smartdevices.bracelet.eventbus.EventServiceListLoad;
import cn.com.smartdevices.bracelet.eventbus.EventServiceStateChanged;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.LuaItem;
import com.d.a.a.h;
import com.d.a.a.p;
import com.huami.android.widget.share.m;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.R;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaList;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDao.Properties;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PartnerDataManager {
    public static final int GROUP_LOCAL = 0;
    public static final int GROUP_SERVER = 2;
    public static final int GROUP_SPECIAL = 1;
    private static final String INPUT_AUTHORIZATION_STATUS = "authorization_status";
    private static final String INPUT_COLOR = "color";
    private static final String INPUT_EXPIRE_TIME = "expire_time";
    private static final String INPUT_ICON = "icon";
    private static final String INPUT_ID = "id";
    private static final String INPUT_SHARE_CONTENT = "share_content";
    private static final String INPUT_SUB_TITLE = "sub_title";
    private static final String INPUT_TITLE = "title";
    private static final String INPUT_URL = "url";
    public static final String LUA_SERVICE_RIGHT = "service";
    private static final String TAG = "PartnerDataManager";
    private final b CONFIG = b.h();
    private final Context mContext;
    private C0425b mDBHelper = null;
    h mHomeListHandler = new p<List<Partner>>() {
        public void onFailure(int i, Header[] headerArr, Throwable th, String str, List<Partner> list) {
            EventBus.getDefault().post(new EventHomeListLoad());
        }

        public void onSuccess(int i, Header[] headerArr, String str, List<Partner> list) {
            int i2 = PartnerDataManager.GROUP_LOCAL;
            HashSet hashSet = new HashSet();
            if (!(list == null || list.isEmpty())) {
                for (Partner buildLuaItem : list) {
                    LuaItem buildLuaItem2 = PartnerDataManager.buildLuaItem(buildLuaItem);
                    hashSet.add(buildLuaItem2.getStype());
                    PartnerDataManager.this.mLuaEvent.showLuaItem(buildLuaItem2);
                }
            }
            LuaListDao b = C0563k.a().b();
            QueryBuilder where = b.queryBuilder().where(Properties.Right.eq(PartnerDataManager.LUA_SERVICE_RIGHT), new WhereCondition[PartnerDataManager.GROUP_LOCAL]);
            Property[] propertyArr = new Property[PartnerDataManager.GROUP_SPECIAL];
            propertyArr[PartnerDataManager.GROUP_LOCAL] = Properties.Id;
            List list2 = where.orderDesc(propertyArr).list();
            if (list2 != null) {
                int size = list2.size();
                while (size > i2) {
                    LuaList luaList = (LuaList) list2.get(i2);
                    String type = luaList.getType();
                    if (!(type == null || hashSet.contains(type))) {
                        b.delete(luaList);
                    }
                    i2 += PartnerDataManager.GROUP_SPECIAL;
                }
            }
            EventHomeListLoad eventHomeListLoad = new EventHomeListLoad();
            eventHomeListLoad.success = true;
            EventBus.getDefault().post(eventHomeListLoad);
        }

        protected List<Partner> parseResponse(String str, boolean z) {
            List<Partner> list = null;
            if (!z) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(com.xiaomi.channel.gamesdk.b.a) == PartnerDataManager.GROUP_SPECIAL) {
                    list = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray(com.xiaomi.channel.gamesdk.b.b);
                    int length = jSONArray.length();
                    for (int i = PartnerDataManager.GROUP_LOCAL; i < length; i += PartnerDataManager.GROUP_SPECIAL) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        Partner partner = new Partner();
                        partner.id = jSONObject2.optString(f.av);
                        partner.url = jSONObject2.optString("page_url");
                        partner.title = jSONObject2.optString(SocialConstants.PARAM_COMMENT);
                        partner.subTitle = jSONObject2.optString("subtitle");
                        partner.shareContent = jSONObject2.optString(PartnerDataManager.INPUT_SHARE_CONTENT);
                        partner.icon = jSONObject2.optString(PartnerDataManager.INPUT_ICON);
                        partner.color = jSONObject2.optString(PartnerDataManager.INPUT_COLOR);
                        partner.expireTime = jSONObject2.optLong("expired_timestamp", 0);
                        partner.authorizeStatus = jSONObject2.optInt(PartnerDataManager.INPUT_AUTHORIZATION_STATUS, PartnerDataManager.GROUP_LOCAL);
                        list.add(partner);
                    }
                }
            }
            return list;
        }
    };
    private final LoginData mLoginData;
    private final LuaEvent mLuaEvent;
    h mServiceListHandler = new p<List<Partner>>() {
        public void onFailure(int i, Header[] headerArr, Throwable th, String str, List<Partner> list) {
            EventBus.getDefault().post(new EventServiceListLoad());
        }

        public void onSuccess(int i, Header[] headerArr, String str, List<Partner> list) {
            if (C0596r.b()) {
                C0596r.e(PartnerDataManager.TAG, "Get all list success " + list);
            }
            EventServiceListLoad eventServiceListLoad = new EventServiceListLoad();
            if (list != null) {
                eventServiceListLoad.success = true;
                eventServiceListLoad.partners = list;
                Keeper.setServiceUpdateTime(System.currentTimeMillis());
            }
            EventBus.getDefault().post(eventServiceListLoad);
        }

        protected List<Partner> parseResponse(String str, boolean z) {
            if (z) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(com.xiaomi.channel.gamesdk.b.a) != PartnerDataManager.GROUP_SPECIAL) {
                return null;
            }
            List<Partner> arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(com.xiaomi.channel.gamesdk.b.b);
            String a = cn.com.smartdevices.bracelet.lab.b.b.a(str);
            String partnerEtag = Keeper.getPartnerEtag();
            if (!TextUtils.isEmpty(a)) {
                if (a.equals(partnerEtag)) {
                    return null;
                }
                Keeper.setPartnerEtag(a);
            }
            int length = jSONArray.length();
            for (int i = PartnerDataManager.GROUP_LOCAL; i < length; i += PartnerDataManager.GROUP_SPECIAL) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Partner partner = new Partner();
                partner.id = jSONObject2.getString(f.av);
                partner.url = jSONObject2.getString("page_url");
                partner.title = jSONObject2.getString(SocialConstants.PARAM_COMMENT);
                partner.subTitle = jSONObject2.getString("subtitle");
                partner.shareContent = jSONObject2.optString(PartnerDataManager.INPUT_SHARE_CONTENT);
                partner.icon = jSONObject2.getString(PartnerDataManager.INPUT_ICON);
                partner.color = jSONObject2.getString(PartnerDataManager.INPUT_COLOR);
                partner.expireTime = jSONObject2.optLong("expired_timestamp", 0);
                partner.authorizeStatus = jSONObject2.optInt(PartnerDataManager.INPUT_AUTHORIZATION_STATUS, PartnerDataManager.GROUP_LOCAL);
                arrayList.add(partner);
            }
            if (PartnerDataManager.this.mDBHelper.f()) {
                PartnerDataManager.this.mDBHelper.a((List) arrayList);
                Keeper.setServiceUpdateTime(System.currentTimeMillis());
            }
            return arrayList;
        }
    };

    public PartnerDataManager(Context context) {
        this.mContext = context;
        this.mLoginData = a.f(context);
        this.mDBHelper = C0425b.a(context);
        this.mLuaEvent = LuaEvent.getInstance(context);
    }

    static Intent buildIntent(Context context, Partner partner) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(INPUT_TITLE, partner.title);
        intent.putExtra(INPUT_SUB_TITLE, partner.subTitle);
        intent.putExtra(INPUT_ICON, partner.icon);
        intent.putExtra(INPUT_ID, partner.id);
        intent.putExtra(INPUT_URL, partner.url);
        intent.putExtra(INPUT_COLOR, partner.color);
        intent.putExtra(INPUT_EXPIRE_TIME, partner.expireTime);
        intent.putExtra(INPUT_SHARE_CONTENT, partner.shareContent);
        intent.putExtra(INPUT_AUTHORIZATION_STATUS, partner.authorizeStatus);
        return intent;
    }

    public static LuaItem buildLuaItem(Partner partner) {
        LuaItem luaItem = new LuaItem();
        luaItem.setStype(partner.id);
        luaItem.setT1(partner.title);
        luaItem.setT2(partner.subTitle);
        luaItem.setExpire(partner.expireTime);
        luaItem.setScript(("function doAction(context, luaAction)  \\\n        local intent = luaAction:getIntentFromString('" + WebActivity.class.getName() + "'); \\\n" + "        luaAction:putExtra(intent,'" + INPUT_URL + "','" + partner.url + "')  \\\n" + "        luaAction:putExtra(intent,'" + INPUT_ID + "','" + partner.id + "')  \\\n" + "        luaAction:putExtra(intent,'" + INPUT_TITLE + "','" + partner.title + "')  \\\n" + "        luaAction:putExtra(intent,'" + INPUT_SHARE_CONTENT + "','" + partner.shareContent + "')  \\\n" + "        luaAction:putExtra(intent,'" + INPUT_SUB_TITLE + "','" + partner.subTitle + "')  \\\n" + "        luaAction:putExtra(intent,'" + INPUT_ICON + "','" + partner.icon + "')  \\\n" + "        luaAction:putExtra(intent,'" + INPUT_COLOR + "','" + partner.color + "')  \\\n" + "        luaAction:putExtra(intent,'" + INPUT_EXPIRE_TIME + "'," + partner.expireTime + ")  \\\n" + "        luaAction:putExtra(intent,'" + INPUT_AUTHORIZATION_STATUS + "'," + partner.authorizeStatus + ")  \\\n" + "        context:startActivity(intent)  \\\n" + "end").replace("\\\n", "\n"));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LuaItem.JSON_TXT_COLOR, partner.color);
            jSONObject.put(LuaItem.JSON_ICON_URI, partner.icon);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        luaItem.setRight(LUA_SERVICE_RIGHT);
        luaItem.setStyleJson(jSONObject.toString());
        return luaItem;
    }

    public static Partner buildService(Intent intent) {
        Partner partner = new Partner();
        partner.id = intent.getStringExtra(INPUT_ID);
        partner.icon = intent.getStringExtra(INPUT_ICON);
        partner.expireTime = intent.getLongExtra(INPUT_EXPIRE_TIME, 0);
        partner.subTitle = intent.getStringExtra(INPUT_SUB_TITLE);
        partner.title = intent.getStringExtra(INPUT_TITLE);
        partner.url = intent.getStringExtra(INPUT_URL);
        partner.color = intent.getStringExtra(INPUT_COLOR);
        partner.shareContent = intent.getStringExtra(INPUT_SHARE_CONTENT);
        partner.authorizeStatus = intent.getIntExtra(INPUT_AUTHORIZATION_STATUS, GROUP_LOCAL);
        return partner;
    }

    public void bind(final String str) {
        l.a(this.mLoginData, str, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                EventServiceStateChanged eventServiceStateChanged = new EventServiceStateChanged();
                eventServiceStateChanged.action = PartnerDataManager.GROUP_LOCAL;
                eventServiceStateChanged.success = false;
                EventBus.getDefault().post(eventServiceStateChanged);
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                boolean z = true;
                EventServiceStateChanged eventServiceStateChanged = new EventServiceStateChanged();
                eventServiceStateChanged.action = PartnerDataManager.GROUP_LOCAL;
                eventServiceStateChanged.thirdAppId = str;
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, h.DEFAULT_CHARSET));
                    int optInt = jSONObject.optInt(com.xiaomi.channel.gamesdk.b.a);
                    jSONObject = jSONObject.getJSONObject(com.xiaomi.channel.gamesdk.b.b);
                    if (jSONObject != null) {
                        eventServiceStateChanged.url = jSONObject.optString("redirect_url");
                    }
                    if (optInt != PartnerDataManager.GROUP_SPECIAL || jSONObject == null) {
                        z = false;
                    }
                    eventServiceStateChanged.success = z;
                    if (eventServiceStateChanged.success) {
                        if (!PartnerDataManager.this.mDBHelper.a(str, (int) PartnerDataManager.GROUP_SPECIAL, eventServiceStateChanged.url)) {
                            Keeper.setServiceUpdateTime(0);
                        }
                        if (PartnerDataManager.this.getServiceById(str) == null) {
                            return;
                        }
                    }
                } catch (Exception e) {
                    eventServiceStateChanged.success = false;
                }
                EventBus.getDefault().post(eventServiceStateChanged);
            }
        });
    }

    public SparseArray<ArrayList<Partner>> getLocalServiceList() {
        Partner partner;
        ArrayList arrayList = new ArrayList();
        SparseArray<ArrayList<Partner>> sparseArray = new SparseArray();
        if (this.CONFIG.c.e.booleanValue()) {
            partner = new Partner();
            partner.id = Partner.HEALTH_LINK_ID;
            partner.title = this.mContext.getString(R.string.health_link);
            arrayList.add(partner);
            sparseArray.put(GROUP_SPECIAL, arrayList);
        }
        arrayList = new ArrayList();
        partner = new Partner();
        partner.title = this.mContext.getString(R.string.action_pop_weixin_enter);
        partner.id = m.a;
        arrayList.add(partner);
        if (!this.CONFIG.w.booleanValue()) {
            partner = new Partner();
            partner.id = m.c;
            partner.title = this.mContext.getString(R.string.bind_qq);
            arrayList.add(partner);
        }
        if (this.CONFIG.c.f.booleanValue()) {
            partner = new Partner();
            partner.id = Partner.WEIBO_HEALTH_ID;
            partner.title = this.mContext.getString(R.string.bind_weibo);
            arrayList.add(partner);
        }
        if (this.CONFIG.c.g.booleanValue()) {
            partner = new Partner();
            partner.id = Partner.GOOGLE_FIT_ID;
            partner.title = this.mContext.getString(R.string.bind_google_fit);
            arrayList.add(partner);
        }
        sparseArray.put(GROUP_LOCAL, arrayList);
        return sparseArray;
    }

    public Partner getServiceById(String str) {
        return this.mDBHelper.a(str);
    }

    public void loadAvailableServiceList(boolean z) {
        if (!this.CONFIG.c.c.booleanValue()) {
            return;
        }
        if (z) {
            l.b(this.mLoginData, this.mServiceListHandler);
            return;
        }
        EventServiceListLoad eventServiceListLoad = new EventServiceListLoad();
        eventServiceListLoad.success = true;
        eventServiceListLoad.partners = this.mDBHelper.e();
        EventBus.getDefault().post(eventServiceListLoad);
        l.b(this.mLoginData, this.mServiceListHandler);
    }

    public void loadHomeMessageList() {
        if (this.CONFIG.c.c.booleanValue()) {
            l.a(this.mLoginData, this.mHomeListHandler);
        }
    }

    public void unbind(final String str) {
        l.b(this.mLoginData, str, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                EventServiceStateChanged eventServiceStateChanged = new EventServiceStateChanged();
                eventServiceStateChanged.action = PartnerDataManager.GROUP_SPECIAL;
                EventBus.getDefault().post(eventServiceStateChanged);
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                boolean z = true;
                EventServiceStateChanged eventServiceStateChanged = new EventServiceStateChanged();
                eventServiceStateChanged.action = PartnerDataManager.GROUP_SPECIAL;
                eventServiceStateChanged.thirdAppId = str;
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, h.DEFAULT_CHARSET));
                    int optInt = jSONObject.optInt(com.xiaomi.channel.gamesdk.b.a);
                    jSONObject = jSONObject.getJSONObject(com.xiaomi.channel.gamesdk.b.b);
                    if (jSONObject != null) {
                        eventServiceStateChanged.url = jSONObject.optString("redirect_url");
                    }
                    if (optInt != PartnerDataManager.GROUP_SPECIAL || jSONObject == null) {
                        z = false;
                    }
                    eventServiceStateChanged.success = z;
                } catch (Exception e) {
                    eventServiceStateChanged.success = false;
                }
                if (eventServiceStateChanged.success && !PartnerDataManager.this.mDBHelper.a(str, (int) PartnerDataManager.GROUP_LOCAL, eventServiceStateChanged.url)) {
                    Keeper.setServiceUpdateTime(0);
                }
                EventBus.getDefault().post(eventServiceStateChanged);
            }
        });
    }
}

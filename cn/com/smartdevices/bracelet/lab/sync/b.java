package cn.com.smartdevices.bracelet.lab.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.DynamicManager;
import cn.com.smartdevices.bracelet.b.c;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.lab.b.f;
import cn.com.smartdevices.bracelet.lab.m;
import cn.com.smartdevices.bracelet.lab.sportmode.DaySportOriginInfo;
import cn.com.smartdevices.bracelet.lab.sportmode.DaySportUserOriginInfo;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import cn.com.smartdevices.bracelet.lab.sportmode.LabFactoryActiveItem;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.lab.ui.C0590z;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private b() {
    }

    private static DaySportOriginInfo a(Context context, int i, boolean z, JSONObject jSONObject, JSONObject jSONObject2) {
        int i2;
        JSONException jSONException;
        if (jSONObject == null || jSONObject2 == null) {
            C0596r.e("Lab", "Error  dataObject = null || serverSummeryObject = null");
            return null;
        }
        c a;
        int i3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        DaySportOriginInfo daySportUserOriginInfo = new DaySportUserOriginInfo(i);
        c cVar = null;
        try {
            a = cn.com.smartdevices.bracelet.b.b.a(i);
        } catch (IllegalArgumentException e) {
            C0596r.e("Lab", e.getMessage());
            a = cVar;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        long j2 = 0;
        int i12 = 0;
        long j3 = 0;
        String str = a.f;
        C0590z c0590z = z ? new C0590z(context, i) : null;
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(SportBaseInfo.KEY_PB);
            i11 = jSONObject3.getInt(SportBaseInfo.KEY_ROUND_COUNT_OF_PB);
            j2 = jSONObject3.getLong(SportBaseInfo.KEY_ROUND_COST_TIME_OF_PB);
            i12 = jSONObject3.getInt(SportBaseInfo.KEY_COUNT_IN_GROUP_OF_PB);
            j3 = jSONObject3.getLong(SportBaseInfo.KEY_COST_TIME_IN_GROUP_OF_PB);
            i3 = i12;
            j = j2;
            i4 = i11;
        } catch (JSONException e2) {
            C0596r.a("Lab", e2.getMessage());
            i3 = i12;
            j = j2;
            i4 = i11;
        }
        try {
            Iterator keys = jSONObject.keys();
            j2 = 0;
            i11 = 0;
            i5 = 0;
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                Object obj = jSONObject.get(str2);
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    int length = jSONArray.length();
                    if (length > 0) {
                        String str3;
                        List arrayList = new ArrayList(length);
                        i6 = 0;
                        int i13 = i5;
                        i5 = 0;
                        i2 = i11;
                        i11 = 0;
                        i7 = Integer.MAX_VALUE;
                        for (int i14 = 0; i14 < length; i14++) {
                            JSONObject jSONObject4 = jSONArray.getJSONObject(i14);
                            if (!jSONObject4.isNull(GroupItemBaseInfo.KEY_COUNT)) {
                                try {
                                    int i15 = jSONObject4.getInt(GroupItemBaseInfo.KEY_START_TIME);
                                    int i16 = jSONObject4.getInt(GroupItemBaseInfo.KEY_END_TIME);
                                    int i17 = jSONObject4.getInt(GroupItemBaseInfo.KEY_COUNT);
                                    i2 = Math.max(i2, i17);
                                    i11 += Math.max(0, i16 - i15);
                                    i13 += i17;
                                    j2 += (long) Math.max(0, i16 - i15);
                                    i7 = Math.min(i15, i7);
                                    i6 = Math.max(i16, i6);
                                    i5 += i17;
                                    arrayList.add(Integer.valueOf(i17));
                                } catch (JSONException e22) {
                                    i12 = 0;
                                    i11 = i10;
                                    i5 = i9;
                                    i6 = i2;
                                    i7 = i13;
                                    jSONException = e22;
                                    i8 = 0;
                                }
                            }
                        }
                        if (i6 >= i10) {
                            str3 = str2;
                            i10 = i6;
                            i9 = i7;
                        } else {
                            str3 = str;
                        }
                        if (c0590z != null) {
                            if (i11 <= 0) {
                                str = str3;
                                i11 = i2;
                                i5 = i13;
                            } else {
                                float a2 = a == null ? 0.0f : a.a(i5, (long) i11);
                                if (a2 <= 0.0f) {
                                    str = str3;
                                    i11 = i2;
                                    i5 = i13;
                                } else {
                                    LabFactoryActiveItem labFactoryActiveItem = new LabFactoryActiveItem(i);
                                    labFactoryActiveItem.setCount(i5);
                                    labFactoryActiveItem.setStart(f.b((long) i7));
                                    labFactoryActiveItem.setStop(f.b((long) i6));
                                    labFactoryActiveItem.setCalories((int) a2);
                                    labFactoryActiveItem.setShareData(c0590z.a(i4, arrayList, c0590z.a(i5, (long) i11)));
                                    daySportUserOriginInfo.addActiveItem(labFactoryActiveItem);
                                }
                            }
                        }
                        arrayList.clear();
                        str = str3;
                        i11 = i2;
                        i5 = i13;
                    } else {
                        continue;
                    }
                } else {
                    try {
                        if (obj instanceof Integer) {
                        }
                    } catch (JSONException e222) {
                        jSONException = e222;
                        i12 = 0;
                        i6 = i11;
                        i7 = i5;
                        i5 = i9;
                        i8 = 0;
                        i11 = i10;
                    }
                }
            }
            if (jSONObject.isNull(str)) {
                i8 = 0;
                i12 = 0;
            } else {
                JSONArray jSONArray2 = jSONObject.getJSONArray(str);
                i2 = jSONArray2.length();
                i6 = 0;
                i12 = 0;
                i8 = 0;
                while (i6 < i2) {
                    try {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i6);
                        if (!jSONObject5.isNull(GroupItemBaseInfo.KEY_COUNT)) {
                            i12 += jSONObject5.getInt(GroupItemBaseInfo.KEY_COUNT);
                            i8 += Math.max(0, jSONObject5.getInt(GroupItemBaseInfo.KEY_END_TIME) - jSONObject5.getInt(GroupItemBaseInfo.KEY_START_TIME));
                        }
                        i6++;
                    } catch (JSONException e3) {
                        jSONException = e3;
                        i7 = i5;
                        i5 = i9;
                        i6 = i11;
                        i11 = i10;
                    }
                }
            }
            i6 = i11;
            i7 = i5;
            i11 = i10;
            i5 = i9;
        } catch (JSONException e2222) {
            i12 = 0;
            j2 = 0;
            i11 = 0;
            i7 = 0;
            i5 = 0;
            i6 = 0;
            jSONException = e2222;
            i8 = 0;
            C0596r.a("Lab", jSONException.getMessage());
            daySportUserOriginInfo.setGroupPBCountOfDay(i6);
            daySportUserOriginInfo.setTotalCountOfDay(i7);
            daySportUserOriginInfo.setCalOfDay((int) (a != null ? a.a(i7, j2) : 0.0f));
            daySportUserOriginInfo.setStartTimeOfLatestGroup(i5);
            daySportUserOriginInfo.setEndTimeOfLatestGroup(i11);
            daySportUserOriginInfo.setCountOfLatestGroup(i12);
            daySportUserOriginInfo.setCostTimeOfLatestGroup(i8);
            daySportUserOriginInfo.setRoundCountOfPB(i4);
            daySportUserOriginInfo.setRoundCostTimeOfPB(j);
            daySportUserOriginInfo.setGroupCountOfPB(i3);
            daySportUserOriginInfo.setGroupCostTimeOfPB(j3);
            return daySportUserOriginInfo;
        }
        daySportUserOriginInfo.setGroupPBCountOfDay(i6);
        daySportUserOriginInfo.setTotalCountOfDay(i7);
        if (a != null) {
        }
        daySportUserOriginInfo.setCalOfDay((int) (a != null ? a.a(i7, j2) : 0.0f));
        daySportUserOriginInfo.setStartTimeOfLatestGroup(i5);
        daySportUserOriginInfo.setEndTimeOfLatestGroup(i11);
        daySportUserOriginInfo.setCountOfLatestGroup(i12);
        daySportUserOriginInfo.setCostTimeOfLatestGroup(i8);
        daySportUserOriginInfo.setRoundCountOfPB(i4);
        daySportUserOriginInfo.setRoundCostTimeOfPB(j);
        daySportUserOriginInfo.setGroupCountOfPB(i3);
        daySportUserOriginInfo.setGroupCostTimeOfPB(j3);
        return daySportUserOriginInfo;
    }

    private static JSONObject a(Context context, int i, String str, String str2) {
        byte[] d = C0425b.a(context).d(str, new C0595q(i));
        if (d == null || d.length == 0) {
            return a(str2);
        }
        JSONObject a = a(str2);
        JSONObject a2 = a(d);
        try {
            long j;
            int i2;
            long j2;
            int i3;
            int i4;
            long j3;
            int i5;
            int i6;
            int i7;
            long j4;
            if (a.isNull(SportBaseInfo.KEY_PB)) {
                j = 0;
                i2 = 0;
                j2 = 0;
                i3 = 0;
            } else {
                JSONObject jSONObject = a.getJSONObject(SportBaseInfo.KEY_PB);
                i4 = jSONObject.getInt(SportBaseInfo.KEY_ROUND_COUNT_OF_PB);
                j3 = jSONObject.getLong(SportBaseInfo.KEY_ROUND_COST_TIME_OF_PB);
                i5 = jSONObject.getInt(SportBaseInfo.KEY_COUNT_IN_GROUP_OF_PB);
                j = jSONObject.getLong(SportBaseInfo.KEY_COST_TIME_IN_GROUP_OF_PB);
                i2 = i5;
                j2 = j3;
                i3 = i4;
            }
            int i8 = a.getInt(DaySportOriginInfo.KEY_CAL_OF_DAY);
            int i9 = a.getInt(DaySportOriginInfo.KEY_TOTAL_COUNT_OF_DAY);
            long j5 = 0;
            if (a2.isNull(SportBaseInfo.KEY_PB)) {
                i6 = 0;
                i7 = 0;
                j4 = 0;
            } else {
                i4 = a2.getJSONObject(SportBaseInfo.KEY_PB).getInt(SportBaseInfo.KEY_ROUND_COUNT_OF_PB);
                j3 = a2.getLong(SportBaseInfo.KEY_ROUND_COST_TIME_OF_PB);
                i5 = a2.getInt(SportBaseInfo.KEY_COUNT_IN_GROUP_OF_PB);
                j5 = a2.getLong(SportBaseInfo.KEY_COST_TIME_IN_GROUP_OF_PB);
                long j6 = j3;
                i6 = i5;
                i7 = i4;
                j4 = j6;
            }
            int i10 = a2.getInt(DaySportOriginInfo.KEY_CAL_OF_DAY);
            int i11 = a2.getInt(DaySportOriginInfo.KEY_TOTAL_COUNT_OF_DAY);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            if (i7 > i3) {
                jSONObject3.put(SportBaseInfo.KEY_ROUND_COUNT_OF_PB, i7);
                jSONObject3.put(SportBaseInfo.KEY_ROUND_COST_TIME_OF_PB, j4);
            } else {
                jSONObject3.put(SportBaseInfo.KEY_ROUND_COUNT_OF_PB, i3);
                jSONObject3.put(SportBaseInfo.KEY_ROUND_COST_TIME_OF_PB, j2);
            }
            if (i6 > i2) {
                jSONObject3.put(SportBaseInfo.KEY_COUNT_IN_GROUP_OF_PB, i6);
                jSONObject3.put(SportBaseInfo.KEY_COST_TIME_IN_GROUP_OF_PB, j5);
            } else {
                jSONObject3.put(SportBaseInfo.KEY_COUNT_IN_GROUP_OF_PB, i2);
                jSONObject3.put(SportBaseInfo.KEY_COST_TIME_IN_GROUP_OF_PB, j);
            }
            jSONObject2.put(SportBaseInfo.KEY_PB, jSONObject3);
            jSONObject2.put(DaySportOriginInfo.KEY_CAL_OF_DAY, i8 + i10);
            jSONObject2.put(DaySportOriginInfo.KEY_TOTAL_COUNT_OF_DAY, i9 + i11);
            return jSONObject2;
        } catch (JSONException e) {
            C0596r.a("Lab", e.getMessage());
            return a;
        }
    }

    private static JSONObject a(Context context, SportBaseInfo sportBaseInfo, String str, int i) {
        byte[] b = C0425b.a(context).b(str, new C0595q(i));
        if (sportBaseInfo != null) {
            return sportBaseInfo.createJsonForDbData(b);
        }
        if (b != null) {
            try {
                return new JSONObject(new String(b));
            } catch (JSONException e) {
                C0596r.a("Lab", e.getMessage());
            }
        }
        return null;
    }

    private static JSONObject a(String str) {
        if (str == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C0596r.a("Lab", e.getMessage());
            return new JSONObject();
        }
    }

    private static JSONObject a(byte[] bArr) {
        if (bArr == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(new String(bArr));
        } catch (JSONException e) {
            C0596r.a("Lab", e.getMessage());
            return new JSONObject();
        }
    }

    public static boolean a(Context context, SportBaseInfo sportBaseInfo, ShareData shareData) {
        if (context == null || sportBaseInfo == null || shareData == null) {
            throw new IllegalArgumentException();
        }
        JSONObject a = a(context, sportBaseInfo, sportBaseInfo.getDay().getKey(), sportBaseInfo.getSportType());
        if (a == null) {
            return false;
        }
        DaySportOriginInfo a2 = a(context, sportBaseInfo.getSportType(), false, a, b(context, sportBaseInfo, sportBaseInfo.getDay().getKey(), sportBaseInfo.getSportType()));
        if (a2 == null) {
            return false;
        }
        float a3;
        C0425b.a(context).a(sportBaseInfo.getDay().getKey(), a.toString().getBytes(), a2.getSummeryJson().toString(), null, new C0595q(sportBaseInfo.getSportType()));
        try {
            a3 = cn.com.smartdevices.bracelet.b.b.a(sportBaseInfo.getSportType()).a(a2.getCountOfLatestGroup(), (long) a2.getCostTimeOfLatestGroup());
        } catch (IllegalArgumentException e) {
            C0596r.e("Lab", e.getMessage());
            a3 = 0.0f;
        }
        if (a3 > 0.0f) {
            LabFactoryActiveItem labFactoryActiveItem = new LabFactoryActiveItem(a2.getSportType());
            labFactoryActiveItem.setCalories((int) a3);
            labFactoryActiveItem.setCount(a2.getCountOfLatestGroup());
            labFactoryActiveItem.setStart(f.b((long) a2.getStartTimeOfLatestGroup()));
            labFactoryActiveItem.setStop(f.b((long) a2.getEndTimeOfLatestGroup()));
            labFactoryActiveItem.setShareData(shareData);
            DynamicManager.getInstance().a(context, labFactoryActiveItem);
        }
        return true;
    }

    public static boolean a(Context context, ArrayList<BasicDateData> arrayList, int i, int i2) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (arrayList != null && arrayList.size() > 0) {
            return !m.a(i) ? false : b(context, (ArrayList) arrayList, i, i2);
        } else {
            C0596r.e("Lab", "No data from server of sportType:" + i);
            return true;
        }
    }

    private static JSONObject b(Context context, SportBaseInfo sportBaseInfo, String str, int i) {
        JSONObject pBSummeryObject = sportBaseInfo != null ? sportBaseInfo.getPBSummeryObject() : null;
        if (pBSummeryObject != null) {
            return pBSummeryObject;
        }
        byte[] b = cn.com.smartdevices.bracelet.lab.b.b(context, str, new C0595q(i));
        if (b == null || b.length == 0) {
            return null;
        }
        try {
            return new JSONObject(new String(b));
        } catch (JSONException e) {
            C0596r.a("Lab", e.getMessage());
            return null;
        }
    }

    private static boolean b(Context context, ArrayList<BasicDateData> arrayList, int i, int i2) {
        List<DaySportOriginInfo> arrayList2 = new ArrayList();
        String key = new SportDay(Calendar.getInstance()).getKey();
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            DaySportOriginInfo a;
            BasicDateData basicDateData = (BasicDateData) it.next();
            int i3 = (basicDateData.data == null || basicDateData.data.length == 0) ? 1 : 0;
            boolean isEmpty = TextUtils.isEmpty(basicDateData.summary);
            if (i3 == 0 || !isEmpty) {
                BasicDateData basicDateData2 = new BasicDateData();
                basicDateData2.data = basicDateData.data;
                basicDateData2.date = basicDateData.date;
                basicDateData2.summary = basicDateData.summary;
                basicDateData2.indexs = basicDateData.indexs;
                if (i3 == 0 || isEmpty) {
                    byte[] b = C0425b.a(context).b(basicDateData2.date, new C0595q(i));
                    if (b != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(new String(basicDateData2.data)).deleteCharAt(stringBuilder.length() - 1).append(com.xiaomi.mipush.sdk.f.i).append(new String(b).substring(1));
                        basicDateData2.data = stringBuilder.toString().getBytes();
                    }
                    a = a(context, i, key.equals(basicDateData2.date), a(basicDateData2.data), a(context, i, basicDateData2.date, basicDateData2.summary));
                    if (a == null) {
                        C0596r.d("Lab", "parseOriginUserDBInfo is empty; save server data to db, date = " + basicDateData2.date);
                        z = C0425b.a(context).a(basicDateData2, i2, new C0595q(i)) & z;
                    } else {
                        arrayList2.add(a);
                        basicDateData2.summary = a.getSummeryJson().toString();
                        z = C0425b.a(context).a(basicDateData2, i2, new C0595q(i)) & z;
                    }
                } else {
                    z = C0425b.a(context).a(basicDateData2, i2, new C0595q(i)) & z;
                }
            } else {
                C0596r.d("Lab", "Server dayData is null return date = " + basicDateData.date);
            }
        }
        for (DaySportOriginInfo a2 : arrayList2) {
            if (a2 instanceof DaySportUserOriginInfo) {
                for (LabFactoryActiveItem a3 : ((DaySportUserOriginInfo) a2).getActiveItemList()) {
                    DynamicManager.getInstance().a(context, a3);
                }
            }
        }
        return z;
    }
}

package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.f;
import com.xiaomi.hm.health.r;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDao.Properties;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aA {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = -1;
    public static final int d = 2;
    public static final int e = -2;
    public static final String f = "WeightUtil";
    public static final float g = 18.5f;
    public static final float h = 24.0f;
    public static final float i = 28.0f;
    public static final int j = 3;
    public static boolean k;
    public static final float[] l = new float[]{17.4f, 18.1f, 18.9f, 19.6f, 20.3f, 21.0f, 21.9f, 22.6f, 23.1f, 23.5f, 23.8f, h};
    public static final float[] m = new float[]{19.2f, 20.3f, 21.4f, 22.5f, 23.6f, 24.7f, 25.7f, 26.4f, 26.9f, 27.4f, 27.8f, i};
    public static final float[] n = new float[]{17.2f, 18.1f, 19.0f, 20.0f, 21.1f, 21.9f, 22.6f, 23.0f, 23.4f, 23.7f, 23.8f, h};
    public static final float[] o = new float[]{18.9f, 19.9f, 21.0f, 22.1f, 23.3f, 24.5f, 25.6f, 26.3f, 26.9f, 27.4f, 27.7f, i};
    private static HashMap<aD, String> p = null;
    private static HashMap<aD, String> q = null;
    private static HashMap<aD, String> r = null;
    private static HashMap<aD, Integer> s = null;

    public static float a(float f) {
        return c(f, b);
    }

    public static float a(float f, float f2, int i) {
        return c((f * f2) * f2, a, i);
    }

    public static float a(float f, int i) {
        return c(f, i, a);
    }

    public static float a(float f, int i, float f2) {
        float f3 = (f < 1.0f || (i != c && i <= 6)) ? GroundOverlayOptions.NO_DIMENSION : f2 / (f * f);
        return a(f3);
    }

    public static float a(int i) {
        return i == 0 ? 150.0f : i == 16 ? BitmapDescriptorFactory.HUE_MAGENTA : i == b ? 331.1f : 150.0f;
    }

    public static float a(int i, int i2) {
        return i2 == b ? l[i - 7] : i2 == 0 ? n[i - 7] : GroundOverlayOptions.NO_DIMENSION;
    }

    public static float a(int i, int i2, float f) {
        return a(((float) i) / CropOverlayView.a, i2, f);
    }

    public static float a(UserInfo userInfo, float f) {
        return a(userInfo.height, Birthday.fromStr(userInfo.birthday).getAge(), f);
    }

    public static int a(float f, int i, int i2) {
        if (s == null) {
            s = new HashMap();
            s.put(aD.Light, Integer.valueOf(-15685185));
            s.put(aD.Normal, Integer.valueOf(-8476672));
            s.put(aD.Weight, Integer.valueOf(-24525));
            s.put(aD.Fat, Integer.valueOf(-42171));
        }
        return ((Integer) s.get(b(f, i, i2))).intValue();
    }

    public static String a(long j, int i) {
        return "weight_" + j + "_" + i;
    }

    public static String a(Context context, float f, int i, int i2) {
        String[] stringArray = context.getResources().getStringArray(f.weight_body_figures);
        if (i > 6 && i < 18) {
            stringArray = context.getResources().getStringArray(f.weight_body_figures_for_child);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(aD.Light, stringArray[a]);
        hashMap.put(aD.Normal, stringArray[b]);
        hashMap.put(aD.Weight, stringArray[d]);
        hashMap.put(aD.Fat, stringArray[j]);
        String str = (String) hashMap.get(b(f, i, i2));
        return str == null ? "--" : str;
    }

    public static String a(Context context, int i) {
        SparseArray sparseArray = new SparseArray();
        String[] stringArray = context.getResources().getStringArray(f.weight_unit);
        sparseArray.put(a, stringArray[a]);
        sparseArray.put(16, stringArray[b]);
        sparseArray.put(b, stringArray[d]);
        String str = (String) sparseArray.get(i);
        return str == null ? (String) sparseArray.get(a) : str;
    }

    public static String a(Context context, int i, int i2, float f) {
        if (p == null) {
            p = new HashMap();
            String[] stringArray = context.getResources().getStringArray(f.weight_report_suggestions_girl);
            p.put(aD.Light, stringArray[a]);
            p.put(aD.Normal, stringArray[b]);
            p.put(aD.Weight, stringArray[d]);
            p.put(aD.Fat, stringArray[j]);
        }
        if (q == null) {
            q = new HashMap();
            stringArray = context.getResources().getStringArray(f.weight_report_suggestions_boy);
            q.put(aD.Light, stringArray[a]);
            q.put(aD.Normal, stringArray[b]);
            q.put(aD.Weight, stringArray[d]);
            q.put(aD.Fat, stringArray[j]);
        }
        return i2 == b ? (String) q.get(b(f, i, i2)) : (String) p.get(b(f, i, i2));
    }

    public static String a(Context context, UserInfo userInfo, e eVar) {
        float c;
        Object[] objArr;
        if (userInfo.targetWeight > 0.0f) {
            c = c(((float) ((int) b(userInfo.targetWeight, eVar.h()))) - eVar.j(), b);
            if (c > 0.0f) {
                objArr = new Object[b];
                objArr[a] = Math.abs(c) + a(context, eVar.h());
                return context.getString(r.lighter_than_goal, objArr);
            } else if (c < 0.0f) {
                objArr = new Object[b];
                objArr[a] = Math.abs(c) + a(context, eVar.h());
                return context.getString(r.heavier_than_goal, objArr);
            }
        } else if (userInfo.uid != 0) {
            WeightInfo a = ah.a().a(userInfo.uid, eVar.e());
            if (a == null) {
                return context.getString(r.baby_no_weight);
            }
            c = c(eVar.j() - b(a.weight, eVar.h()), b);
            if (c > 0.0f) {
                objArr = new Object[b];
                objArr[a] = c + a(context, eVar.h());
                return context.getString(r.add_than_last_time, objArr);
            } else if (c >= 0.0f) {
                return context.getString(r.equal_last_time);
            } else {
                objArr = new Object[b];
                objArr[a] = Math.abs(c) + a(context, eVar.h());
                return context.getString(r.less_than_last_time, objArr);
            }
        }
        return a.f;
    }

    public static List<UserInfo> a(e eVar) {
        List<UserInfo> arrayList = new ArrayList();
        List<UserInfo> d = J.a().d();
        ah a = ah.a();
        for (UserInfo userInfo : d) {
            WeightInfo e = a.e(userInfo.uid);
            if (e != null) {
                userInfo.weight = e.weight;
                C0596r.e(f, "lastest user:" + userInfo.uid + ",weight:" + e.weight);
            }
        }
        if (d == null || d.size() < b) {
            C0596r.e(f, "no user info for weight!!!");
        } else {
            for (UserInfo userInfo2 : d) {
                C0596r.e(f, "info:" + userInfo2);
                if (Math.abs(userInfo2.weight - a(eVar.j(), eVar.h())) < 3.0f) {
                    arrayList.add(userInfo2);
                }
            }
        }
        C0596r.d(f, "matched user info size:" + arrayList.size());
        return arrayList;
    }

    public static void a(WeightInfo weightInfo) {
        C0596r.e(f, "deleteWeightInfoMarkFully:" + weightInfo);
        a(a(weightInfo.timestamp, weightInfo.uid));
        ah.a().c(weightInfo);
    }

    public static void a(String str) {
        C0596r.e(f, "deleteDynamicItem type is " + str);
        LuaListDao b = C0563k.a().b();
        List list = b.queryBuilder().where(Properties.Type.eq(str), new WhereCondition[a]).list();
        if (list != null && list.size() > 0 && list.get(a) != null) {
            C0596r.e(f, "delete lua list:" + list.get(a));
            b.delete(list.get(a));
        }
    }

    public static boolean a(Context context) {
        boolean a = J.a().a(context);
        C0596r.d(f, "Sync UserInfos To Server : " + a);
        if (!a) {
            return false;
        }
        a = ah.a().b(context);
        C0596r.d(f, "Sync WeightInfos To Server : " + a);
        return a;
    }

    public static float b(float f, int i) {
        return c(f, a, i);
    }

    public static float b(int i, int i2) {
        return i2 == b ? m[i - 7] : i2 == 0 ? o[i - 7] : GroundOverlayOptions.NO_DIMENSION;
    }

    public static aD b(float f, int i, int i2) {
        C0596r.e(f, "bmi " + f + " age " + i + " gender  " + i2);
        return (i < 0 || i > 6) ? (i <= 6 || i > 18) ? i > 18 ? f <= 0.0f ? aD.Unknown : f < g ? aD.Light : f < h ? aD.Normal : f < i ? aD.Weight : aD.Fat : aD.Normal : i2 == b ? f < l[i + -7] ? aD.Normal : (f < l[i + -7] || f >= m[i - 7]) ? aD.Fat : aD.Weight : i2 == 0 ? f < n[i + -7] ? aD.Normal : (f < n[i + -7] || f >= o[i - 7]) ? aD.Fat : aD.Weight : aD.Unknown : aD.Unknown;
    }

    public static String b(float f) {
        return f > 0.0f ? String.valueOf(f) : "--";
    }

    public static String b(int i, int i2, float f) {
        return b(a(i, i2, f));
    }

    public static String b(Context context, float f, int i, int i2) {
        if (r == null) {
            r = new HashMap();
            String[] stringArray = context.getResources().getStringArray(f.weight_dynamic_list_bmi_tips);
            r.put(aD.Light, stringArray[a]);
            r.put(aD.Normal, stringArray[b]);
            r.put(aD.Weight, stringArray[d]);
            r.put(aD.Fat, stringArray[j]);
        }
        return (String) r.get(b(f, i, i2));
    }

    public static void b(Context context) {
        if (!k) {
            new aB(context).execute(new Void[a]);
        }
    }

    public static void b(Context context, int i) {
        C0596r.e(f, "Delete User Weights : " + i);
        List a = ah.a().a(i);
        for (int i2 = a; i2 < a.size(); i2 += b) {
            a((WeightInfo) a.get(i2));
        }
        C0891z.a(context.getApplicationContext()).a(i);
        C0596r.e(f, "Delete User Weights Finish!!");
    }

    private static void b(QQHealth qQHealth) {
        List arrayList;
        List<WeightInfo> d = ah.a().d();
        if (d != null && d.size() > 0) {
            arrayList = new ArrayList(d.size());
            for (WeightInfo weightInfo : d) {
                if (weightInfo.uid == c) {
                    arrayList.add(Long.valueOf(weightInfo.timestamp));
                }
            }
            qQHealth.removeNeedSyncWeights(arrayList);
        }
        d = ah.a().f();
        if (d != null && d.size() > 0) {
            arrayList = new ArrayList(d.size());
            for (WeightInfo weightInfo2 : d) {
                if (weightInfo2.uid == c) {
                    arrayList.add(Long.valueOf(weightInfo2.timestamp));
                }
            }
            qQHealth.addNeedSyncWeights(arrayList);
        }
    }

    public static float c(float f) {
        return c(f, b);
    }

    public static float c(float f, int i) {
        return new BigDecimal((double) f).setScale(i, 4).floatValue();
    }

    public static float c(float f, int i, int i2) {
        switch (i) {
            case a /*0*/:
                switch (i2) {
                    case a /*0*/:
                        return f;
                    case b /*1*/:
                        return c(2.20462f * f, d);
                    case kankan.wheel.widget.a.bp /*16*/:
                        return f * 2.0f;
                    default:
                        return f;
                }
            case b /*1*/:
                switch (i2) {
                    case a /*0*/:
                        return c(0.45359f * f, d);
                    case b /*1*/:
                        return f;
                    case kankan.wheel.widget.a.bp /*16*/:
                        return c(0.90718f * f, d);
                    default:
                        return 0.0f;
                }
            case kankan.wheel.widget.a.bp /*16*/:
                switch (i2) {
                    case a /*0*/:
                        return f / 2.0f;
                    case b /*1*/:
                        return c(1.10231f * f, d);
                    case kankan.wheel.widget.a.bp /*16*/:
                        return f;
                    default:
                        return 0.0f;
                }
            default:
                return f;
        }
    }

    public static int c(Context context) {
        return !Utils.k() ? Constant.at : Constant.at;
    }

    public static String d(float f, int i, int i2) {
        float f2 = (g * f) * f;
        C0596r.e(f, "lightWeight " + f2);
        int c = (int) (((double) (c(f2, a, i2) * 10.0f)) + 0.5d);
        C0596r.e(f, c + a.f);
        f2 = ((float) c) / 10.0f;
        C0596r.e(f, "after lightWeight " + f2 + "unit " + i2);
        float c2 = ((float) ((int) (((double) (c((h * f) * f, a, i2) * 10.0f)) + 0.5d))) / 10.0f;
        float c3 = ((float) ((int) (((double) (c((i * f) * f, a, i2) * 10.0f)) + 0.5d))) / 10.0f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f2 + com.xiaomi.mipush.sdk.f.i);
        stringBuilder.append(c2 + com.xiaomi.mipush.sdk.f.i);
        stringBuilder.append(c3 + com.xiaomi.mipush.sdk.f.i);
        return stringBuilder.toString();
    }
}

package cn.com.smartdevices.bracelet.chart.util;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0890y;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.f.f;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.R;
import java.text.DecimalFormat;

public final class ChartData {
    public static final String KEY_MODE = "Mode";
    public static final String KEY_SOURCE = "Source";
    public static final int MODE_STEP = 1;
    public static final int a = 0;
    public static final int b = 16;
    public static final int c = 256;
    public static final int d = 4096;
    public static final int e = 4352;
    public static final int f = 0;
    public static final int g = 1;
    public static final String h = "From";
    public static final String i = "Action";
    public static final String j = "DynamicActivitySubTitle";
    public static final String k = "Key";
    public static final String l = "Weight_UserId";
    public static final String m = "Weight_AdvData";
    public static final String n = "DynamicView";
    public static final String o = "RefCompleteGoal";
    private static PersonInfo p;

    public static r a() {
        return r.a();
    }

    public static String a(double d, int i) {
        String str = "####";
        if (i < 0) {
            throw new IllegalArgumentException("Accuracy must >= 0");
        }
        if (i > 0) {
            str = str + ".";
            int i2 = f;
            while (i2 < i) {
                i2 += g;
                str = str + "#";
            }
        }
        return new DecimalFormat(str).format(d);
    }

    public static String a(long j) {
        return new DecimalFormat("#,###,###").format(j);
    }

    public static void a(View view, int i, Context context) {
        TextView textView = (TextView) view.findViewById(R.id.item_value);
        TextView textView2 = (TextView) view.findViewById(R.id.item_value_1);
        TextView textView3 = (TextView) view.findViewById(R.id.item_value_unit);
        TextView textView4 = (TextView) view.findViewById(R.id.item_value_unit_1);
        String[] e = f.e(i);
        if (e[f].equals(Constants.VIA_RESULT_SUCCESS)) {
            CharSequence string = context.getString(R.string.unit_min);
            textView.setVisibility(8);
            textView3.setVisibility(8);
            textView2.setText(e[g]);
            textView4.setText(string);
            return;
        }
        string = context.getString(R.string.unit_hour);
        CharSequence string2 = context.getString(R.string.unit_min_short);
        textView.setVisibility(f);
        textView3.setVisibility(f);
        textView.setText(e[f]);
        textView3.setText(string);
        textView2.setText(e[g]);
        textView4.setText(string2);
    }

    public static void a(View view, String str, String str2) {
        TextView textView = (TextView) view.findViewById(R.id.item_value_unit);
        ((TextView) view.findViewById(R.id.item_value)).setText(str);
        if (str2 != null) {
            textView.setText(str2);
        }
    }

    public static String[] a(Context context, int i) {
        return a(context, i, 2);
    }

    public static String[] a(Context context, int i, int i2) {
        String[] strArr = new String[2];
        float f = (float) i;
        p = Keeper.readPersonInfo();
        if (p.getUnit() == g) {
            return C0890y.a(context, Float.valueOf(((float) i) * 1.0f), i2);
        }
        if (p.getUnit() != 0) {
            return strArr;
        }
        if (i >= h.E) {
            strArr[f] = a((double) (f / 1000.0f), i2);
            strArr[g] = context.getString(R.string.unit_kilometer);
            return strArr;
        }
        strArr[f] = String.valueOf(i);
        strArr[g] = context.getString(R.string.unit_meter);
        return strArr;
    }
}

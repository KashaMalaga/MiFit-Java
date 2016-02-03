package com.c.b.b.a;

import com.c.b.a;
import com.c.b.s;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.relationservice.data.b;
import com.xiaomi.hm.health.t;
import java.util.HashMap;
import java.util.Map;

public final class l extends u {
    private static String a(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        CharSequence substring = str.substring(i + 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return stringBuilder.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    private static String b(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (a(i2, substring) != null) {
                    break;
                }
                stringBuilder.append('(');
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    public C1009k a(s sVar) {
        if (sVar.d() != a.RSS_EXPANDED) {
            return null;
        }
        String c = u.c(sVar);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        Map hashMap = new HashMap();
        int i = 0;
        while (i < c.length()) {
            String a = a(i, c);
            if (a == null) {
                return null;
            }
            int length = (a.length() + 2) + i;
            String b = b(length, c);
            length += b.length();
            Object obj = -1;
            switch (a.hashCode()) {
                case 1536:
                    if (a.equals("00")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1537:
                    if (a.equals("01")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1567:
                    if (a.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1568:
                    if (a.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1570:
                    if (a.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1572:
                    if (a.equals(Constants.VIA_REPORT_TYPE_WPA_STATE)) {
                        obj = 5;
                        break;
                    }
                    break;
                case 1574:
                    if (a.equals(Constants.VIA_REPORT_TYPE_START_GROUP)) {
                        obj = 6;
                        break;
                    }
                    break;
                case 1567966:
                    if (a.equals("3100")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 1567967:
                    if (a.equals("3101")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 1567968:
                    if (a.equals("3102")) {
                        obj = 9;
                        break;
                    }
                    break;
                case 1567969:
                    if (a.equals("3103")) {
                        obj = 10;
                        break;
                    }
                    break;
                case 1567970:
                    if (a.equals("3104")) {
                        obj = 11;
                        break;
                    }
                    break;
                case 1567971:
                    if (a.equals("3105")) {
                        obj = 12;
                        break;
                    }
                    break;
                case 1567972:
                    if (a.equals("3106")) {
                        obj = 13;
                        break;
                    }
                    break;
                case 1567973:
                    if (a.equals("3107")) {
                        obj = 14;
                        break;
                    }
                    break;
                case 1567974:
                    if (a.equals("3108")) {
                        obj = 15;
                        break;
                    }
                    break;
                case 1567975:
                    if (a.equals("3109")) {
                        obj = 16;
                        break;
                    }
                    break;
                case 1568927:
                    if (a.equals("3200")) {
                        obj = 17;
                        break;
                    }
                    break;
                case 1568928:
                    if (a.equals("3201")) {
                        obj = 18;
                        break;
                    }
                    break;
                case 1568929:
                    if (a.equals("3202")) {
                        obj = 19;
                        break;
                    }
                    break;
                case 1568930:
                    if (a.equals("3203")) {
                        obj = 20;
                        break;
                    }
                    break;
                case 1568931:
                    if (a.equals("3204")) {
                        obj = 21;
                        break;
                    }
                    break;
                case 1568932:
                    if (a.equals("3205")) {
                        obj = 22;
                        break;
                    }
                    break;
                case 1568933:
                    if (a.equals("3206")) {
                        obj = 23;
                        break;
                    }
                    break;
                case 1568934:
                    if (a.equals("3207")) {
                        obj = 24;
                        break;
                    }
                    break;
                case 1568935:
                    if (a.equals("3208")) {
                        obj = 25;
                        break;
                    }
                    break;
                case 1568936:
                    if (a.equals("3209")) {
                        obj = 26;
                        break;
                    }
                    break;
                case 1575716:
                    if (a.equals("3920")) {
                        obj = 27;
                        break;
                    }
                    break;
                case 1575717:
                    if (a.equals("3921")) {
                        obj = 28;
                        break;
                    }
                    break;
                case 1575718:
                    if (a.equals("3922")) {
                        obj = 29;
                        break;
                    }
                    break;
                case 1575719:
                    if (a.equals("3923")) {
                        obj = 30;
                        break;
                    }
                    break;
                case 1575747:
                    if (a.equals("3930")) {
                        obj = 31;
                        break;
                    }
                    break;
                case 1575748:
                    if (a.equals("3931")) {
                        obj = 32;
                        break;
                    }
                    break;
                case 1575749:
                    if (a.equals("3932")) {
                        obj = 33;
                        break;
                    }
                    break;
                case 1575750:
                    if (a.equals("3933")) {
                        obj = 34;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case kankan.wheel.widget.a.i /*0*/:
                    str2 = b;
                    break;
                case kankan.wheel.widget.l.a /*1*/:
                    str = b;
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    str3 = b;
                    break;
                case kankan.wheel.widget.a.l /*3*/:
                    str4 = b;
                    break;
                case kankan.wheel.widget.a.aQ /*4*/:
                    str5 = b;
                    break;
                case kankan.wheel.widget.a.X /*5*/:
                    str6 = b;
                    break;
                case kankan.wheel.widget.a.bt /*6*/:
                    str7 = b;
                    break;
                case kankan.wheel.widget.a.bc /*7*/:
                case kankan.wheel.widget.a.ba /*8*/:
                case kankan.wheel.widget.a.bo /*9*/:
                case kankan.wheel.widget.a.bd /*10*/:
                case kankan.wheel.widget.a.aW /*11*/:
                case kankan.wheel.widget.a.be /*12*/:
                case t.WeightView_wv_bmi_size /*13*/:
                case t.WeightView_wv_tips /*14*/:
                case kankan.wheel.widget.a.aV /*15*/:
                case kankan.wheel.widget.a.bp /*16*/:
                    str9 = C1009k.a;
                    str10 = a.substring(3);
                    str8 = b;
                    break;
                case kankan.wheel.widget.a.bu /*17*/:
                case kankan.wheel.widget.a.br /*18*/:
                case kankan.wheel.widget.a.bs /*19*/:
                case kankan.wheel.widget.a.aF /*20*/:
                case com.xiaomi.hm.health.bt.profile.a.a.Z /*21*/:
                case com.xiaomi.hm.health.bt.profile.a.a.aa /*22*/:
                case b.x /*23*/:
                case b.y /*24*/:
                case b.z /*25*/:
                case b.A /*26*/:
                    str9 = C1009k.b;
                    str10 = a.substring(3);
                    str8 = b;
                    break;
                case com.xiaomi.hm.health.bt.profile.a.a.ab /*27*/:
                case b.C /*28*/:
                case b.D /*29*/:
                case kankan.wheel.widget.a.bR /*30*/:
                    str12 = a.substring(3);
                    str11 = b;
                    break;
                case b.F /*31*/:
                case kankan.wheel.widget.a.bl /*32*/:
                case b.H /*33*/:
                case b.I /*34*/:
                    if (b.length() >= 4) {
                        str11 = b.substring(3);
                        str13 = b.substring(0, 3);
                        str12 = a.substring(3);
                        break;
                    }
                    return null;
                default:
                    hashMap.put(a, b);
                    break;
            }
            i = length;
        }
        return new C1009k(c, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashMap);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}

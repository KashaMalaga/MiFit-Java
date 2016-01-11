package cn.com.smartdevices.bracelet.weight;

import android.util.Log;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import java.lang.reflect.Array;

public class C0873k {
    private static final String c = "BabyWeightUtil";
    private static C0873k d;
    public String[][] a;
    public String[][] b;

    public C0873k() {
        r0 = new String[37][];
        r0[0] = new String[]{"\u5e74\u9f84", "\u6708\u9f84", "-3SD", "-2SD", "-1SD", "\u4e2d\u4f4d\u6570", "+1SD", "+2SD", "+3SD"};
        r0[1] = new String[]{"\u51fa\u751f", Constants.VIA_RESULT_SUCCESS, "2.26", "2.58", "2.93", "3.32", "3.73", "4.18", "4.66"};
        r0[2] = new String[]{a.f, Constants.VIA_TO_TYPE_QQ_GROUP, "3.09", "3.52", "3.99", "4.51", "5.07", "5.67", "6.33"};
        r0[3] = new String[]{a.f, Constants.VIA_SSO_LOGIN, "3.94", "4.47", "5.05", "5.68", "6.38", "7.14", "7.97"};
        r0[4] = new String[]{a.f, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, "4.69", "5.29", "5.97", "6.7", "7.51", "8.4", "9.37"};
        r0[5] = new String[]{a.f, Constants.VIA_TO_TYPE_QZONE, "5.25", "5.91", "6.64", "7.45", "8.34", "9.32", "10.39"};
        r0[6] = new String[]{a.f, Constants.VIA_SHARE_TYPE_TEXT, "5.66", "6.36", "7.14", "8", "8.95", "9.99", "11.15"};
        r0[7] = new String[]{a.f, Constants.VIA_SHARE_TYPE_INFO, "5.97", "6.7", "7.51", "8.41", "9.41", "10.5", "11.72"};
        r0[8] = new String[]{a.f, "7", "6.24", "6.99", "7.83", "8.76", "9.79", "10.93", "12.2"};
        r0[9] = new String[]{a.f, "8", "6.46", "7.23", "8.09", "9.05", "10.11", "11.29", "12.6"};
        r0[10] = new String[]{a.f, "9", "6.67", "7.46", "8.35", "9.33", "10.42", "11.64", "12.99"};
        r0[11] = new String[]{a.f, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "6.86", "7.67", "8.58", "9.58", "10.71", "11.95", "13.34"};
        r0[12] = new String[]{a.f, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "7.04", "7.87", "8.8", "9.83", "10.98", "12.26", "13.68"};
        r0[13] = new String[]{"1\u5c81", Constants.VIA_REPORT_TYPE_SET_AVATAR, "7.21", "8.06", "9", "10.05", "11.23", "12.54", Constants.VIA_REPORT_TYPE_MAKE_FRIEND};
        r0[14] = new String[]{a.f, Constants.VIA_REPORT_TYPE_WPA_STATE, "7.68", "8.57", "9.57", "10.68", "11.93", "13.32", "14.88"};
        r0[15] = new String[]{a.f, Constants.VIA_REPORT_TYPE_BIND_GROUP, "8.13", "9.07", "10.12", "11.29", "12.61", "14.09", "15.75"};
        r0[16] = new String[]{a.f, Constants.VIA_REPORT_TYPE_QQFAVORITES, "8.61", "9.59", "10.69", "11.93", "13.33", "14.9", "16.66"};
        r0[17] = new String[]{"2\u5c81", "24", "9.06", "10.09", "11.24", "12.54", "14.01", "15.67", "17.54"};
        r0[18] = new String[]{a.f, "27", "9.47", "10.54", "11.75", "13.11", "14.64", "16.38", "18.36"};
        r0[19] = new String[]{a.f, "30", "9.86", "10.97", "12.22", "13.64", "15.24", "17.06", "19.13"};
        r0[20] = new String[]{a.f, "33", "10.24", "11.39", "12.68", "14.15", "15.82", "17.72", "19.89"};
        r0[21] = new String[]{"3\u5c81", "36", "10.61", "11.79", "13.13", "14.65", "16.39", "18.37", "20.64"};
        r0[22] = new String[]{a.f, "39", "10.97", "12.19", "13.57", "15.15", "16.95", "19.02", "21.39"};
        r0[23] = new String[]{a.f, "42", "11.31", "12.57", Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "15.63", "17.5", "19.65", "22.13"};
        r0[24] = new String[]{a.f, "45", "11.66", "12.96", "14.44", "16.13", "18.07", "20.32", "22.91"};
        r0[25] = new String[]{"4\u5c81", "48", "12.01", "13.35", "14.88", "16.64", "18.67", "21.01", "23.73"};
        r0[26] = new String[]{a.f, "51", "12.37", "13.76", "15.35", "17.18", "19.3", "21.76", "24.63"};
        r0[27] = new String[]{a.f, "54", "12.74", "14.18", "15.84", "17.75", "19.98", "22.57", "25.61"};
        r0[28] = new String[]{a.f, "57", "13.12", "14.61", "16.34", "18.35", "20.69", "23.43", "26.68"};
        r0[29] = new String[]{"5\u5c81", "60", "13.5", "15.06", "16.87", "18.98", "21.46", "24.38", "27.85"};
        r0[30] = new String[]{a.f, "63", "13.86", "15.48", "17.38", "19.6", "22.21", "25.32", "29.04"};
        r0[31] = new String[]{a.f, "66", "14.18", "15.87", "17.85", "20.18", "22.94", "26.24", "30.22"};
        r0[32] = new String[]{a.f, "69", "14.48", "16.24", "18.31", "20.75", "23.66", "27.17", "31.43"};
        r0[33] = new String[]{"6\u5c81", "72", "14.74", "16.56", "18.71", "21.26", "24.32", "28.03", "32.57"};
        r0[34] = new String[]{a.f, "75", "15.01", "16.9", "19.14", "21.82", "25.06", "29.01", "33.89"};
        r0[35] = new String[]{a.f, "78", "15.3", "17.27", "19.62", "22.45", "25.89", "30.13", "35.41"};
        r0[36] = new String[]{a.f, "81", "15.66", "17.73", "20.22", "23.24", "26.95", "31.56", "37.39"};
        this.a = r0;
        r0 = new String[37][];
        r0[0] = new String[]{"\u5e74\u9f84", "\u6708\u9f84", "-3SD", "-2SD", "-1SD", "\u4e2d\u4f4d\u6570", "+1SD", "+2SD", "+3SD"};
        r0[1] = new String[]{"\u51fa\u751f", Constants.VIA_RESULT_SUCCESS, "2.26", "2.54", "2.85", "3.21", "3.63", "4.1", "4.65"};
        r0[2] = new String[]{a.f, Constants.VIA_TO_TYPE_QQ_GROUP, "2.98", "3.33", "3.74", "4.2", "4.74", "5.35", "6.05"};
        r0[3] = new String[]{a.f, Constants.VIA_SSO_LOGIN, "3.72", "4.14", "4.65", "5.21", "5.86", "6.6", "7.46"};
        r0[4] = new String[]{a.f, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, "4.4", "4.9", "5.47", "6.13", "6.87", "7.73", "8.71"};
        r0[5] = new String[]{a.f, Constants.VIA_TO_TYPE_QZONE, "4.93", "5.48", "6.11", "6.83", "7.65", "8.59", "9.66"};
        r0[6] = new String[]{a.f, Constants.VIA_SHARE_TYPE_TEXT, "5.33", "5.92", "6.59", "7.36", "8.23", "9.23", "10.38"};
        r0[7] = new String[]{a.f, Constants.VIA_SHARE_TYPE_INFO, "5.64", "6.26", "6.96", "7.77", "8.68", "9.73", "10.93"};
        r0[8] = new String[]{a.f, "7", "5.9", "6.55", "7.28", "8.11", "9.06", "10.15", "11.4"};
        r0[9] = new String[]{a.f, "8", "6.13", "6.79", "7.55", "8.41", "9.39", "10.51", "11.8"};
        r0[10] = new String[]{a.f, "9", "6.34", "7.03", "7.81", "8.69", "9.7", "10.86", "12.18"};
        r0[11] = new String[]{a.f, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "6.53", "7.23", "8.03", "8.94", "9.98", "11.16", "12.52"};
        r0[12] = new String[]{a.f, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "6.71", "7.43", "8.25", "9.18", "10.24", "11.46", "12.85"};
        r0[13] = new String[]{"1\u5c81", Constants.VIA_REPORT_TYPE_SET_AVATAR, "6.87", "7.61", "8.45", "9.4", "10.48", "11.73", "13.15"};
        r0[14] = new String[]{a.f, Constants.VIA_REPORT_TYPE_WPA_STATE, "7.34", "8.12", "9.01", "10.02", "11.18", "12.5", "14.02"};
        r0[15] = new String[]{a.f, Constants.VIA_REPORT_TYPE_BIND_GROUP, "7.79", "8.63", "9.57", "10.65", "11.88", "13.29", "14.9"};
        r0[16] = new String[]{a.f, Constants.VIA_REPORT_TYPE_QQFAVORITES, "8.26", "9.15", "10.15", "11.3", "12.61", "14.12", "15.85"};
        r0[17] = new String[]{"2\u5c81", "24", "8.7", "9.64", "10.7", "11.92", "13.31", "14.92", "16.77"};
        r0[18] = new String[]{a.f, "27", "9.1", "10.09", "11.21", "12.5", "13.97", "15.67", "17.63"};
        r0[19] = new String[]{a.f, "30", "9.48", "10.52", "11.7", "13.05", "14.6", "16.39", "18.47"};
        r0[20] = new String[]{a.f, "33", "9.86", "10.94", "12.18", "13.59", "15.22", "17.11", "19.29"};
        r0[21] = new String[]{"3\u5c81", "36", "10.23", "11.36", "12.65", "14.13", "15.83", "17.81", "20.1"};
        r0[22] = new String[]{a.f, "39", "10.6", "11.77", "13.11", "14.65", "16.43", "18.5", "20.9"};
        r0[23] = new String[]{a.f, "42", "10.95", "12.16", "13.55", "15.16", "17.01", "19.17", "21.69"};
        r0[24] = new String[]{a.f, "45", "11.29", "12.55", Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "15.67", "17.6", "19.85", "22.49"};
        r0[25] = new String[]{"4\u5c81", "48", "11.62", "12.93", "14.44", "16.17", "18.19", "20.54", "23.3"};
        r0[26] = new String[]{a.f, "51", "11.96", "13.32", "14.88", "16.69", "18.79", "21.25", "24.14"};
        r0[27] = new String[]{a.f, "54", "12.3", "13.71", "15.33", "17.22", "19.42", Constants.VIA_REPORT_TYPE_DATALINE, "25.04"};
        r0[28] = new String[]{a.f, "57", "12.62", "14.08", "15.78", "17.75", "20.05", "22.75", "25.96"};
        r0[29] = new String[]{"5\u5c81", "60", "12.93", "14.44", "16.2", "18.26", "20.66", "23.5", "26.87"};
        r0[30] = new String[]{a.f, "63", "13.32", "14.8", "16.64", "18.78", "21.3", "24.28", "27.84"};
        r0[31] = new String[]{a.f, "66", "13.54", "15.18", "17.09", "19.33", "21.98", "24.12", "28.89"};
        r0[32] = new String[]{a.f, "69", "13.84", "15.54", "17.53", "19.88", "22.65", "25.96", "29.95"};
        r0[33] = new String[]{"6\u5c81", "72", "14.11", "15.87", "17.94", "20.37", "23.27", "26.74", "30.94"};
        r0[34] = new String[]{a.f, "75", "14.38", "16.21", "18.35", "20.89", "23.92", "27.57", "32"};
        r0[35] = new String[]{a.f, "78", "14.66", "16.55", "18.78", "21.44", "24.61", "28.46", "33.14"};
        r0[36] = new String[]{a.f, "81", "14.96", "16.92", "19.25", "22.03", "25.37", "29.42", "34.4"};
        this.b = r0;
    }

    public static C0873k a() {
        if (d == null) {
            d = new C0873k();
        }
        return d;
    }

    public String[][] a(int i, int i2) {
        Log.d(c, "changeDataByUnit ");
        String[][] strArr = i2 == 1 ? this.a : this.b;
        String[][] strArr2 = (String[][]) Array.newInstance(String.class, new int[]{strArr.length, strArr[0].length});
        for (int i3 = 0; i3 < strArr.length; i3++) {
            int i4 = 0;
            while (i4 < strArr[i3].length) {
                if (i3 == 0) {
                    strArr2[i3][i4] = strArr[i3][i4];
                } else if (i4 == 0 || i4 == 1) {
                    strArr2[i3][i4] = strArr[i3][i4];
                } else {
                    strArr2[i3][i4] = aA.b(Float.parseFloat(strArr[i3][i4]), i) + a.f;
                }
                i4++;
            }
        }
        return strArr2;
    }
}

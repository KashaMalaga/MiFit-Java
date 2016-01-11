package cn.com.smartdevices.bracelet.lab;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.d.C0424a;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.d.E;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends C0424a {
    public b(Context context) {
        super(context);
    }

    public static JSONObject a(Context context, String str, C0595q c0595q) {
        JSONObject jSONObject = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        byte[] c = c(context, str, c0595q);
        if (c == null) {
            c = c(context, null, c0595q);
        }
        if (c != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(new StringBuilder(new String(c)).toString());
                if (!jSONObject2.isNull(SportBaseInfo.KEY_PB)) {
                    jSONObject = jSONObject2.getJSONObject(SportBaseInfo.KEY_PB);
                }
            } catch (JSONException e) {
                C0596r.a("Lab", e.getMessage());
            }
        }
        return jSONObject;
    }

    public static byte[] b(Context context, String str, C0595q c0595q) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        byte[] c = c(context, str, c0595q);
        return (c == null || c.length == 0) ? c(context, null, c0595q) : c;
    }

    private static byte[] c(Context context, String str, C0595q c0595q) {
        String str2;
        String[] strArr;
        Throwable th;
        Cursor cursor = null;
        String[] strArr2 = new String[]{SocialConstants.PARAM_SUMMARY};
        if (TextUtils.isEmpty(str)) {
            str2 = "type=? AND source=?";
            strArr = new String[]{String.valueOf(c0595q.b()), String.valueOf(c0595q.a())};
        } else {
            str2 = "date=? AND type=? AND source=?";
            strArr = new String[]{str, String.valueOf(c0595q.b()), String.valueOf(c0595q.a())};
        }
        try {
            Cursor query = C0425b.a(context).a(false).query(E.a, strArr2, str2, strArr, null, null, "date DESC");
            while (query != null) {
                try {
                    if (!query.moveToFirst()) {
                        break;
                    }
                    byte[] blob = query.getBlob(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                    if (blob != null && blob.length != 0) {
                        if (query == null) {
                            return blob;
                        }
                        query.close();
                        return blob;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}

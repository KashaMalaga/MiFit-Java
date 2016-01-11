package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import android.os.Parcelable;

class C0056bn {
    public static final String a = "call";
    public static final String b = "msg";
    public static final String c = "email";
    public static final String d = "event";
    public static final String e = "promo";
    public static final String f = "alarm";
    public static final String g = "progress";
    public static final String h = "social";
    public static final String i = "err";
    public static final String j = "transport";
    public static final String k = "sys";
    public static final String l = "service";
    public static final String m = "recommendation";
    public static final String n = "status";
    private static final String o = "author";
    private static final String p = "text";
    private static final String q = "messages";
    private static final String r = "remote_input";
    private static final String s = "on_reply";
    private static final String t = "on_read";
    private static final String u = "participants";
    private static final String v = "timestamp";

    C0056bn() {
    }

    private static RemoteInput a(ca caVar) {
        return new Builder(caVar.a()).setLabel(caVar.b()).setChoices(caVar.c()).setAllowFreeFormInput(caVar.d()).addExtras(caVar.e()).build();
    }

    static Bundle a(bs bsVar) {
        String str = null;
        int i = 0;
        if (bsVar == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (bsVar.e() != null && bsVar.e().length > 1) {
            str = bsVar.e()[0];
        }
        Parcelable[] parcelableArr = new Parcelable[bsVar.a().length];
        while (i < parcelableArr.length) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(p, bsVar.a()[i]);
            bundle2.putString(o, str);
            parcelableArr[i] = bundle2;
            i++;
        }
        bundle.putParcelableArray(q, parcelableArr);
        ca h = bsVar.h();
        if (h != null) {
            bundle.putParcelable(r, C0056bn.a(h));
        }
        bundle.putParcelable(s, bsVar.c());
        bundle.putParcelable(t, bsVar.d());
        bundle.putStringArray(u, bsVar.e());
        bundle.putLong(v, bsVar.g());
        return bundle;
    }

    static bs a(Bundle bundle, bt btVar, cb cbVar) {
        Object obj = null;
        if (bundle == null) {
            return null;
        }
        String[] strArr;
        Parcelable[] parcelableArray = bundle.getParcelableArray(q);
        if (parcelableArray != null) {
            String[] strArr2 = new String[parcelableArray.length];
            for (int i = 0; i < strArr2.length; i++) {
                if (!(parcelableArray[i] instanceof Bundle)) {
                    break;
                }
                strArr2[i] = ((Bundle) parcelableArray[i]).getString(p);
                if (strArr2[i] == null) {
                    break;
                }
            }
            int i2 = 1;
            if (obj == null) {
                return null;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(t);
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable(s);
        RemoteInput remoteInput = (RemoteInput) bundle.getParcelable(r);
        String[] stringArray = bundle.getStringArray(u);
        if (stringArray == null || stringArray.length != 1) {
            return null;
        }
        return btVar.b(strArr, remoteInput != null ? C0056bn.a(remoteInput, cbVar) : null, pendingIntent2, pendingIntent, stringArray, bundle.getLong(v));
    }

    private static ca a(RemoteInput remoteInput, cb cbVar) {
        return cbVar.b(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
    }

    public static String a(Notification notification) {
        return notification.category;
    }
}

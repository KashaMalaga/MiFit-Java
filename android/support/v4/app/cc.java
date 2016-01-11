package android.support.v4.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;

class cc {
    public static final String a = "android.remoteinput.results";
    public static final String b = "android.remoteinput.resultsData";
    private static final String c = "resultKey";
    private static final String d = "label";
    private static final String e = "choices";
    private static final String f = "allowFreeFormInput";
    private static final String g = "extras";

    cc() {
    }

    static Bundle a(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        return (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals(a)) ? (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable(b) : null;
    }

    static Bundle a(ca caVar) {
        Bundle bundle = new Bundle();
        bundle.putString(c, caVar.a());
        bundle.putCharSequence(d, caVar.b());
        bundle.putCharSequenceArray(e, caVar.c());
        bundle.putBoolean(f, caVar.d());
        bundle.putBundle(g, caVar.e());
        return bundle;
    }

    static ca a(Bundle bundle, cb cbVar) {
        return cbVar.b(bundle.getString(c), bundle.getCharSequence(d), bundle.getCharSequenceArray(e), bundle.getBoolean(f), bundle.getBundle(g));
    }

    static void a(ca[] caVarArr, Intent intent, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        for (ca caVar : caVarArr) {
            Object obj = bundle.get(caVar.a());
            if (obj instanceof CharSequence) {
                bundle2.putCharSequence(caVar.a(), (CharSequence) obj);
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra(b, bundle2);
        intent.setClipData(ClipData.newIntent(a, intent2));
    }

    static Bundle[] a(ca[] caVarArr) {
        if (caVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[caVarArr.length];
        for (int i = 0; i < caVarArr.length; i++) {
            bundleArr[i] = a(caVarArr[i]);
        }
        return bundleArr;
    }

    static ca[] a(Bundle[] bundleArr, cb cbVar) {
        if (bundleArr == null) {
            return null;
        }
        ca[] b = cbVar.b(bundleArr.length);
        for (int i = 0; i < bundleArr.length; i++) {
            b[i] = a(bundleArr[i], cbVar);
        }
        return b;
    }
}

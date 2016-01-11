package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.account.a;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class p {
    private static final String a = "code";
    private static final String b = "token";
    private static final String c = "XiaomiOAuthorize";
    private static final String d = "com.xiaomi";
    private boolean e = false;
    private int[] f = null;
    private Long g = null;
    private String h = null;
    private Boolean i = null;
    private String j = null;
    private boolean k = false;

    private j<l> a(Activity activity, String str) {
        if (activity == null || activity.isFinishing()) {
            throw new IllegalArgumentException("activity should not be null and should be running");
        } else if (this.g == null || this.g.longValue() <= 0) {
            throw new IllegalArgumentException("client id is error!!!");
        } else if (TextUtils.isEmpty(this.h)) {
            throw new IllegalArgumentException("redirect url is empty!!!");
        } else if (!TextUtils.isEmpty(str)) {
            return new r(this, activity, str).start();
        } else {
            throw new IllegalArgumentException("responseType is empty!!!");
        }
    }

    @Deprecated
    public static void a(Activity activity, long j, String str, Bundle bundle, int i) {
        Log.w(c, "you are calling startGetAccessToken(). Is still works but it is deprecated. Instead please use \n                XiaomiOAuthFuture<XiaomiOAuthResults> future = new XiaomiOAuthorize()\n                        .setAppId(appId)\n                        .setRedirectUrl(redirectUri)\n                        .setScope(scope)\n                        .setAllowSwitchAccount(true)\n                        .startGetAccessToken(acitivity);\n                XiaomiOAuthResults results = future.getResult();//call on background thread.\nIt provides better user experience! Checkout the Demo codes!");
        a(activity, j, str, b, bundle, i);
    }

    @Deprecated
    private static void a(Activity activity, long j, String str, String str2, Bundle bundle, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        p b = new p().a(j).a(str).a(c(bundle.getString(h.aj))).b(bundle.getString(h.ak));
        if (bundle.containsKey(h.al)) {
            b.a(bundle.getBoolean(h.al));
        }
        new w(a.equalsIgnoreCase(str2) ? b.b(activity) : b.a(activity), str2, activity, i).execute(new Void[0]);
    }

    private static Bundle b(Context context, Account account, Bundle bundle) {
        return (Bundle) new t(context, account, bundle).start().get();
    }

    private static Bundle b(Context context, Bundle bundle, a aVar) {
        return (Bundle) new s(context, null, bundle, aVar).start().get();
    }

    @Deprecated
    public static void b(Activity activity, long j, String str, Bundle bundle, int i) {
        Log.w(c, "you are calling startGetOAuthCode(). Is still works but it is deprecated. Instead please use \n                XiaomiOAuthFuture<XiaomiOAuthResults> future = new XiaomiOAuthorize()\n                        .setAppId(appId)\n                        .setRedirectUrl(redirectUri)\n                        .setScope(scope)\n                        .setAllowSwitchAccount(true)\n                        .startGetOAuthCode(acitivity);\n                XiaomiOAuthResults results = future.getResult();//call on background thread.\nIt provides better user experience! Checkout the Demo codes!");
        a(activity, j, str, a, bundle, i);
    }

    private static boolean b(Context context) {
        try {
            return ((Boolean) new u(context, null, null).start().get()).booleanValue();
        } catch (InterruptedException e) {
            return false;
        } catch (ExecutionException e2) {
            return false;
        }
    }

    private static String c(int[] iArr) {
        int i = 0;
        if (iArr == null || iArr.length <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (i2 > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(i3);
            i++;
            i2 = i4;
        }
        return stringBuilder.toString();
    }

    private boolean c(Context context) {
        try {
            return ((Boolean) new v(this, context, null, null).start().get()).booleanValue();
        } catch (InterruptedException e) {
            return false;
        } catch (ExecutionException e2) {
            return false;
        }
    }

    @Deprecated
    private static int[] c(String str) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            for (String valueOf : str.split(" ")) {
                try {
                    arrayList.add(Integer.valueOf(valueOf));
                } catch (NumberFormatException e) {
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (i = 0; i < iArr.length; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    private Account d(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType(d);
        return accountsByType.length == 0 ? null : accountsByType[0];
    }

    public i<l> a(Activity activity) {
        return a(activity, b);
    }

    public i<String> a(Context context, long j, String str, String str2, String str3, String str4) {
        return new q(this, context, str, j, str2, str3, str4).start();
    }

    public p a(long j) {
        this.g = Long.valueOf(j);
        return this;
    }

    public p a(String str) {
        this.h = str;
        return this;
    }

    public p a(boolean z) {
        this.i = Boolean.valueOf(z);
        return this;
    }

    public p a(int[] iArr) {
        this.f = iArr;
        return this;
    }

    public i<l> b(Activity activity) {
        return a(activity, a);
    }

    public p b(String str) {
        this.j = str;
        return this;
    }

    public p b(boolean z) {
        this.e = z;
        return this;
    }

    public p c(boolean z) {
        this.k = z;
        return this;
    }
}

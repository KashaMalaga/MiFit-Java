package com.xiaomi.channel.b;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.channel.gamesdk.b;
import java.util.Map;

public class a {
    public static final String a = "authtoken";
    public static final String b = "authAccount";
    public static final String c = "errorCode";
    public static final String d = "errorMessage";
    private static final String e = "service_token_pref";
    private static a f = null;
    private static final int i = 20001;
    private static final int j = 20002;
    private Context g;
    private int h = 0;

    public a(Context context) {
        this.g = context;
    }

    private Bundle a(String str, String str2, Activity activity) {
        Bundle bundle = new Bundle();
        CharSequence b = b(str, str2);
        bundle.putString(a, b);
        bundle.putString(b, str);
        if (TextUtils.isEmpty(b)) {
            bundle = b(str, str2, activity);
            Object string = bundle.getString(a);
            if (!TextUtils.isEmpty(string)) {
                Editor edit = this.g.getSharedPreferences(e, 0).edit();
                edit.putString(str2 + str, string);
                edit.commit();
            }
        }
        return bundle;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f == null) {
                f = new a(context);
            }
            aVar = f;
        }
        return aVar;
    }

    private void a() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == this.g.getMainLooper()) {
            Throwable illegalStateException = new IllegalStateException("calling this from your main thread can lead to deadlock");
            Log.e(n.a, "calling this from your main thread can lead to deadlock and/or ANRs", illegalStateException);
            if (this.g.getApplicationInfo().targetSdkVersion >= 8) {
                throw illegalStateException;
            }
        }
    }

    private Bundle b(String str, String str2, Activity activity) {
        return b.a(this.g) ? c(str, str2, activity) : d(str, str2, activity);
    }

    private String b(String str, String str2) {
        return this.g.getSharedPreferences(e, 0).getString(str2 + str, null);
    }

    private Account[] b(String str) {
        Bundle c;
        try {
            c = b.b(this.g).c();
        } catch (RemoteException e) {
            Log.e(n.a, e.toString());
            c = null;
        }
        if (c != null) {
            int i = c.getInt(b.a);
            int i2 = c.getInt(b.c);
            switch (i) {
                case kankan.wheel.widget.a.i /*0*/:
                    this.h = i2;
                    if (!TextUtils.isEmpty(c.getString(b.b))) {
                        return new Account[]{new Account(c.getString(b.b), str)};
                    }
                    break;
            }
        }
        return new Account[0];
    }

    private Bundle c(String str, String str2, Activity activity) {
        Bundle b;
        Bundle bundle = new Bundle();
        bundle.putString(b, str);
        bundle.putString(a, null);
        try {
            b = b.b(this.g).b(str, str2);
        } catch (RemoteException e) {
            Log.e(n.a, e.toString());
            b = null;
        }
        if (b != null) {
            int i = b.getInt(b.a);
            int i2 = b.getInt(b.c);
            String string = b.getString(b.b);
            if (i == 0) {
                bundle.putString(a, string);
            } else if (i2 == b.i) {
                if (!(activity == null || activity.isFinishing())) {
                    activity.runOnUiThread(new j(this, string, activity));
                }
                bundle.putInt(c, b.i);
                bundle.putString(d, "xiaomi account needs upgrade");
            } else {
                bundle.putInt(c, i2);
                bundle.putString(d, "xiaomi account error");
            }
        }
        return bundle;
    }

    private Account[] c(String str) {
        Exception e;
        Throwable th;
        Uri parse = Uri.parse("content://com.xiaomi.channel.providers.AccountProvider/getAccount");
        Cursor query;
        try {
            query = this.g.getContentResolver().query(parse, new String[]{b.a, "name", b.c}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        int i2 = query.getInt(2);
                        switch (i) {
                            case n.b /*10001*/:
                                this.h = i2;
                                if (!TextUtils.isEmpty(query.getString(1))) {
                                    Account[] accountArr = new Account[]{new Account(query.getString(1), str)};
                                    if (query == null || query.isClosed()) {
                                        return accountArr;
                                    }
                                    query.close();
                                    return accountArr;
                                }
                                break;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.e(n.a, e.toString());
                        query.close();
                        return new Account[0];
                    } catch (Throwable th2) {
                        th = th2;
                        query.close();
                        throw th;
                    }
                }
            }
            if (!(query == null || query.isClosed())) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.e(n.a, e.toString());
            if (!(query == null || query.isClosed())) {
                query.close();
            }
            return new Account[0];
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (!(query == null || query.isClosed())) {
                query.close();
            }
            throw th;
        }
        return new Account[0];
    }

    private Bundle d(String str, String str2, Activity activity) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Uri parse = Uri.parse("content://com.xiaomi.channel.providers.AccountProvider/getAuthToken");
        Log.v(n.a, "get auth token from miliao...");
        Bundle bundle = new Bundle();
        bundle.putString(a, null);
        bundle.putString(b, str);
        Cursor query;
        try {
            query = this.g.getContentResolver().query(parse, new String[]{b.a, "token", b.c}, null, new String[]{str, str2}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        switch (query.getInt(0)) {
                            case n.b /*10001*/:
                                bundle.putString(a, query.getString(1));
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                                return bundle;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.e(n.a, e.toString());
                        query.close();
                        return bundle;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        cursor.close();
                        throw th;
                    }
                }
            }
            if (!(query == null || query.isClosed())) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.e(n.a, e.toString());
            if (!(query == null || query.isClosed())) {
                query.close();
            }
            return bundle;
        } catch (Throwable th3) {
            th = th3;
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
            throw th;
        }
        return bundle;
    }

    public AccountManagerFuture<Bundle> a(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.h == i ? new b(this, null, handler, accountManagerCallback, account, str, activity).start() : this.h == j ? AccountManager.get(this.g).getAuthToken(account, str, bundle, activity, accountManagerCallback, handler) : new d(this, null, handler, accountManagerCallback, account).start();
    }

    public AccountManagerFuture<Bundle> a(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.h == i ? new f(this, null, handler, accountManagerCallback, account, str).start() : this.h == j ? AccountManager.get(this.g).getAuthToken(account, str, bundle, z, accountManagerCallback, handler) : new h(this, null, handler, accountManagerCallback, account).start();
    }

    public AccountManagerFuture<Bundle> a(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return null;
    }

    public void a(String str, String str2) {
        SharedPreferences sharedPreferences = this.g.getSharedPreferences(e, 0);
        Map all = sharedPreferences.getAll();
        if (all != null) {
            for (String str3 : all.keySet()) {
                Object obj = all.get(str3);
                if (obj != null && (obj instanceof String) && ((String) obj).equals(str2)) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove(str3);
                    edit.commit();
                }
            }
        }
        AccountManager.get(this.g).invalidateAuthToken(str, str2);
    }

    public Account[] a(String str) {
        return b.a(this.g) ? b(str) : c(str);
    }
}

package com.xiaomi.account.openauth;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.ExecutionException;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class r extends o<l> {
    final /* synthetic */ Activity a;
    final /* synthetic */ String b;
    final /* synthetic */ p d;

    r(p pVar, Activity activity, String str) {
        this.d = pVar;
        this.a = activity;
        this.b = str;
    }

    private void a(z zVar) {
        y yVar = y.INIT;
        while (true) {
            switch (x.a[yVar.ordinal()]) {
                case l.a /*1*/:
                    if (!this.d.e && p.b(this.a)) {
                        if (!this.d.c(this.a)) {
                            if (this.d.d(this.a) == null) {
                                yVar = y.ADD_SYSTEM_ACCOUNT;
                                break;
                            } else {
                                yVar = y.OAUTH_FROM_MIUI;
                                break;
                            }
                        }
                        yVar = y.OAUTH_FROM_MIUI_WITH_RESPONSE;
                        break;
                    }
                    yVar = y.OAUTH_FROM_3RD_PARTY;
                    break;
                case a.k /*2*/:
                    try {
                        Bundle bundle = (Bundle) AccountManager.get(this.a).addAccount("com.xiaomi", null, null, null, this.a, null, null).getResult();
                        if (bundle != null && bundle.containsKey(com.xiaomi.channel.b.a.b)) {
                            yVar = y.OAUTH_FROM_MIUI;
                            break;
                        } else {
                            zVar.setException(new Exception("fail to add account"));
                            return;
                        }
                    } catch (SecurityException e) {
                        yVar = y.OAUTH_FROM_3RD_PARTY;
                        break;
                    } catch (AuthenticatorException e2) {
                        yVar = y.OAUTH_FROM_3RD_PARTY;
                        break;
                    }
                case a.l /*3*/:
                    zVar.a(p.b(this.a, this.d.d(this.a), b()));
                    return;
                case a.aQ /*4*/:
                    p.b(this.a, b(), zVar.b());
                    return;
                case a.X /*5*/:
                    zVar.a(AuthorizeActivity.a(this.a, String.valueOf(this.d.g), this.d.h, this.b, p.c(this.d.f), this.d.j, this.d.i, this.d.k, zVar.b()));
                    return;
                default:
                    break;
            }
        }
    }

    private Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(h.T, String.valueOf(this.d.g));
        bundle.putString(h.U, this.d.h);
        bundle.putString(h.ai, this.b);
        if (this.d.i != null) {
            bundle.putBoolean(h.al, this.d.i.booleanValue());
        }
        if (!TextUtils.isEmpty(this.d.j)) {
            bundle.putString(h.ak, this.d.j);
        }
        Object b = p.c(this.d.f);
        if (!TextUtils.isEmpty(b)) {
            bundle.putString(h.aj, b);
        }
        return bundle;
    }

    public void a() {
        try {
            a(new z(this.a, this.c));
        } catch (ExecutionException e) {
            this.c.setException(e.getCause());
        } catch (Throwable e2) {
            this.c.setException(e2);
        } catch (Throwable e22) {
            this.c.setException(e22);
        } catch (Throwable e222) {
            this.c.setException(e222);
        }
    }
}

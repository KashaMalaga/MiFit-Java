package com.xiaomi.channel.b;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.os.Handler;

class f extends k {
    final /* synthetic */ Account a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    f(a aVar, Activity activity, Handler handler, AccountManagerCallback accountManagerCallback, Account account, String str) {
        this.c = aVar;
        this.a = account;
        this.b = str;
        super(aVar, activity, handler, accountManagerCallback);
    }

    public void a() {
        new Thread(new g(this)).run();
    }
}

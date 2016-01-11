package com.xiaomi.channel.b;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.os.Handler;

class b extends k {
    final /* synthetic */ Account a;
    final /* synthetic */ String b;
    final /* synthetic */ Activity c;
    final /* synthetic */ a d;

    b(a aVar, Activity activity, Handler handler, AccountManagerCallback accountManagerCallback, Account account, String str, Activity activity2) {
        this.d = aVar;
        this.a = account;
        this.b = str;
        this.c = activity2;
        super(aVar, activity, handler, accountManagerCallback);
    }

    public void a() {
        new Thread(new c(this)).run();
    }
}

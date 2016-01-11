package com.xiaomi.channel.b;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.os.Handler;

class h extends k {
    final /* synthetic */ Account a;
    final /* synthetic */ a b;

    h(a aVar, Activity activity, Handler handler, AccountManagerCallback accountManagerCallback, Account account) {
        this.b = aVar;
        this.a = account;
        super(aVar, activity, handler, accountManagerCallback);
    }

    public void a() {
        new Thread(new i(this)).run();
    }
}

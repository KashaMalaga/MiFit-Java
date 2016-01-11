package com.xiaomi.channel.b;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.os.Handler;

class d extends k {
    final /* synthetic */ Account a;
    final /* synthetic */ a b;

    d(a aVar, Activity activity, Handler handler, AccountManagerCallback accountManagerCallback, Account account) {
        this.b = aVar;
        this.a = account;
        super(aVar, activity, handler, accountManagerCallback);
    }

    public void a() {
        new Thread(new e(this)).run();
    }
}

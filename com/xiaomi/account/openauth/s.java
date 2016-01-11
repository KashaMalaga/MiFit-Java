package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.xiaomi.account.a;
import com.xiaomi.account.d;

final class s extends e<Bundle> {
    final /* synthetic */ a d;

    s(Context context, Account account, Bundle bundle, a aVar) {
        this.d = aVar;
        super(context, account, bundle);
    }

    protected /* synthetic */ Object a(a.b.a aVar) {
        return b(aVar);
    }

    protected /* synthetic */ Object a(d dVar) {
        return b(dVar);
    }

    protected Bundle b(a.b.a aVar) {
        throw new IllegalStateException("should not be here");
    }

    protected Bundle b(d dVar) {
        dVar.a(this.d, this.b, 1, 0);
        return null;
    }
}

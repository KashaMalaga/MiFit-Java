package com.xiaomi.market.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

class z implements OnClickListener {
    z() {
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (!x.b(d.b) || d.g.l == 1) {
            r.a(d.b).a(d.f, d.g);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + d.f.a));
        intent.setClassName("com.xiaomi.market", "com.xiaomi.market.ui.AppDetailActivity");
        d.b.startActivity(intent);
    }
}

package com.xiaomi.mipush.sdk;

import android.content.pm.PackageItemInfo;

public class h extends Exception {
    private PackageItemInfo a;

    public h(String str, PackageItemInfo packageItemInfo) {
        super(str);
        this.a = packageItemInfo;
    }
}

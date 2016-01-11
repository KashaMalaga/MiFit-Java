package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import java.util.List;

final class p implements Runnable {
    final /* synthetic */ Context a;

    p(Context context) {
        this.a = context;
    }

    public void run() {
        if (!f.a(this.a) && 1 == m.a(this.a).m()) {
            try {
                List<PackageInfo> installedPackages = this.a.getPackageManager().getInstalledPackages(4);
                if (installedPackages != null) {
                    for (PackageInfo packageInfo : installedPackages) {
                        ServiceInfo[] serviceInfoArr = packageInfo.services;
                        if (serviceInfoArr != null) {
                            for (ServiceInfo serviceInfo : serviceInfoArr) {
                                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !this.a.getPackageName().equals(serviceInfo.packageName)) {
                                    try {
                                        Thread.sleep(((long) ((Math.random() * 300.0d) + 60.0d)) * 1000);
                                    } catch (InterruptedException e) {
                                    }
                                    Intent intent = new Intent();
                                    intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                                    intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                                    this.a.startService(intent);
                                }
                            }
                            continue;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}

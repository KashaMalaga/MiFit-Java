package android.support.v4.app;

import android.app.Notification;

class bD extends C0032at {
    final /* synthetic */ NotificationCompatSideChannelService d;

    private bD(NotificationCompatSideChannelService notificationCompatSideChannelService) {
        this.d = notificationCompatSideChannelService;
    }

    public void a(String str) {
        this.d.a(getCallingUid(), str);
        long clearCallingIdentity = clearCallingIdentity();
        try {
            this.d.a(str);
        } finally {
            restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void a(String str, int i, String str2) {
        this.d.a(getCallingUid(), str);
        long clearCallingIdentity = clearCallingIdentity();
        try {
            this.d.a(str, i, str2);
        } finally {
            restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void a(String str, int i, String str2, Notification notification) {
        this.d.a(getCallingUid(), str);
        long clearCallingIdentity = clearCallingIdentity();
        try {
            this.d.a(str, i, str2, notification);
        } finally {
            restoreCallingIdentity(clearCallingIdentity);
        }
    }
}

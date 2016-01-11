package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

class bW implements bU {
    bW() {
    }

    public Bundle a(Intent intent) {
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        return null;
    }

    public void a(C0041bR[] c0041bRArr, Intent intent, Bundle bundle) {
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    }
}

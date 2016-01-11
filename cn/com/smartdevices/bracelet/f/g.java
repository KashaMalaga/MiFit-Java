package cn.com.smartdevices.bracelet.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;

public class g {
    private g() {
    }

    public static boolean a(Context context, Uri uri) {
        boolean z = false;
        if (context == null || uri == null) {
            throw new IllegalArgumentException();
        }
        ContentProviderClient contentProviderClient = null;
        try {
            contentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
            if (contentProviderClient != null) {
                z = true;
                if (contentProviderClient != null) {
                    contentProviderClient.release();
                }
            } else if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        } catch (Exception e) {
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        } catch (Throwable th) {
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
        return z;
    }
}

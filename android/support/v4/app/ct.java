package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class ct implements cr {
    ct() {
    }

    public PendingIntent a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return cv.a(context, i, intentArr, i2);
    }
}

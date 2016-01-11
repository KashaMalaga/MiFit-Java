package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class q {
    q() {
    }

    public static Intent a(ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }

    public static Intent b(ComponentName componentName) {
        return Intent.makeRestartActivityTask(componentName);
    }
}

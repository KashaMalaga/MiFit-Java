package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class n implements m {
    n() {
    }

    public Intent a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }

    public Intent a(String str, String str2) {
        Intent intent = new Intent(str);
        intent.addCategory(str2);
        return intent;
    }

    public Intent b(ComponentName componentName) {
        Intent a = a(componentName);
        a.addFlags(268468224);
        return a;
    }
}

package android.support.v4.app;

import android.app.Activity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class C0080r {
    C0080r() {
    }

    static void a(Activity activity) {
        activity.invalidateOptionsMenu();
    }

    static void a(Activity activity, String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        activity.dump(str, fileDescriptor, printWriter, strArr);
    }
}

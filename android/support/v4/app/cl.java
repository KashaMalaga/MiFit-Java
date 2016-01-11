package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class cl {
    private static final String a = ".sharecompat_";

    cl() {
    }

    public static void a(MenuItem menuItem, Activity activity, Intent intent) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        if (actionProvider instanceof ShareActionProvider) {
            ShareActionProvider shareActionProvider = (ShareActionProvider) actionProvider;
        } else {
            actionProvider = new ShareActionProvider(activity);
        }
        actionProvider.setShareHistoryFileName(a + activity.getClass().getName());
        actionProvider.setShareIntent(intent);
        menuItem.setActionProvider(actionProvider);
    }
}

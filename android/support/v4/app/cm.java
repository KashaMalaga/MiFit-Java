package android.support.v4.app;

import android.text.Html;

class cm {
    cm() {
    }

    public static String a(CharSequence charSequence) {
        return Html.escapeHtml(charSequence);
    }
}

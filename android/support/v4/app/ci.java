package android.support.v4.app;

import android.view.MenuItem;

class ci implements ch {
    ci() {
    }

    private static void a(StringBuilder stringBuilder, CharSequence charSequence, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = charSequence.charAt(i3);
            if (charAt == '<') {
                stringBuilder.append("&lt;");
            } else if (charAt == '>') {
                stringBuilder.append("&gt;");
            } else if (charAt == '&') {
                stringBuilder.append("&amp;");
            } else if (charAt > '~' || charAt < ' ') {
                stringBuilder.append("&#" + charAt + ";");
            } else if (charAt == ' ') {
                while (i3 + 1 < i2 && charSequence.charAt(i3 + 1) == ' ') {
                    stringBuilder.append("&nbsp;");
                    i3++;
                }
                stringBuilder.append(' ');
            } else {
                stringBuilder.append(charAt);
            }
            i3++;
        }
    }

    public String a(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder, charSequence, 0, charSequence.length());
        return stringBuilder.toString();
    }

    public void a(MenuItem menuItem, cf cfVar) {
        menuItem.setIntent(cfVar.c());
    }
}

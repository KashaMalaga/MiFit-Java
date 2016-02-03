package android.support.v4.k;

import android.support.a.q;
import android.support.a.r;
import com.xiaomi.channel.relationservice.data.b;
import com.xiaomi.e.a;
import java.util.Locale;
import kankan.wheel.widget.l;

public class s {
    public static final Locale a = new Locale(a.f, a.f);
    private static String b = "Arab";
    private static String c = "Hebr";

    public static int a(@r Locale locale) {
        if (!(locale == null || locale.equals(a))) {
            String a = e.a(e.b(locale.toString()));
            if (a == null) {
                return b(locale);
            }
            if (a.equalsIgnoreCase(b) || a.equalsIgnoreCase(c)) {
                return 1;
            }
        }
        return 0;
    }

    @q
    public static String a(@q String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case b.I /*34*/:
                    stringBuilder.append("&quot;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                case kankan.wheel.widget.a.ay /*39*/:
                    stringBuilder.append("&#39;");
                    break;
                case kankan.wheel.widget.a.aD /*60*/:
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
                default:
                    stringBuilder.append(charAt);
                    break;
            }
        }
        return stringBuilder.toString();
    }

    private static int b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case l.a /*1*/:
            case kankan.wheel.widget.a.k /*2*/:
                return 1;
            default:
                return 0;
        }
    }
}

package cn.com.smartdevices.bracelet.config;

import android.database.AbstractCursor;
import com.xiaomi.e.a;

public class e extends AbstractCursor {
    public static final String a = "content";
    public static final String b = "channel";
    public static final String c = "host";
    private String[] d = new String[]{a, b, c};
    private String[] e = new String[]{a.f, a.f, a.f};

    public e(String str, String str2, String str3) {
        this.e[0] = str;
        this.e[1] = str2;
        this.e[2] = str3;
    }

    public String[] getColumnNames() {
        return this.d;
    }

    public int getCount() {
        return 1;
    }

    public double getDouble(int i) {
        return 0.0d;
    }

    public float getFloat(int i) {
        return 0.0f;
    }

    public int getInt(int i) {
        return 0;
    }

    public long getLong(int i) {
        return 0;
    }

    public short getShort(int i) {
        return (short) 0;
    }

    public String getString(int i) {
        return this.e[i];
    }

    public boolean isNull(int i) {
        return i != 0;
    }
}

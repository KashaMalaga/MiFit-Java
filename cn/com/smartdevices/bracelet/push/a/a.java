package cn.com.smartdevices.bracelet.push.a;

import android.content.ContentValues;
import android.database.Cursor;
import cn.com.smartdevices.bracelet.d.a.d;
import cn.com.smartdevices.bracelet.d.a.e;
import cn.com.smartdevices.bracelet.d.a.f;

@f(a = "push_message")
public class a extends d {
    public static final String b = "msg_id";
    @e(a = "msg_id")
    public long c = 0;

    public boolean a(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        int columnIndex = cursor.getColumnIndex(b);
        if (columnIndex < 0) {
            return false;
        }
        this.c = cursor.getLong(columnIndex);
        return true;
    }

    public ContentValues b() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(b, Long.valueOf(this.c));
        return contentValues;
    }
}

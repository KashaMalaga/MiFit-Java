package cn.com.smartdevices.bracelet.relation.db;

import android.content.ContentValues;
import android.util.Log;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.d.a.a;
import cn.com.smartdevices.bracelet.d.a.c;
import java.sql.SQLDataException;
import java.util.List;

public class d extends a<Friend> {
    private static final String b = "friendDao";

    public d(c cVar) {
        super(cVar);
    }

    public Friend a(long j) {
        try {
            return (Friend) a("user_id= ?", new String[]{j + com.xiaomi.e.a.f});
        } catch (SQLDataException e) {
            C0596r.a(b, e.getMessage());
            return null;
        }
    }

    public List<Friend> a(int i, int i2) {
        List<Friend> list = null;
        try {
            list = a((long) i, (long) i2, null, null, "create_time desc");
        } catch (Throwable e) {
            Log.e(b, "\u83b7\u53d6\u597d\u53cb\u5217\u8868\u5931\u8d25", e);
        }
        return list;
    }

    public boolean a(Friend friend) {
        return a((cn.com.smartdevices.bracelet.d.a.d) friend, new StringBuilder().append("user_id= ").append(friend.n).toString(), null) > 0;
    }

    public boolean b(long j) {
        return b(new StringBuilder().append("user_id=").append(j).toString(), null) >= 0;
    }

    public boolean b(Friend friend) {
        ContentValues b = friend.b();
        b.remove(Friend.k);
        boolean z = a(b, new StringBuilder().append("user_id= ").append(friend.n).toString(), null) > 0;
        return !z ? a((cn.com.smartdevices.bracelet.d.a.d) friend) : z;
    }

    public boolean c(Friend friend) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Friend.l, friend.x);
        return a(contentValues, new StringBuilder().append("user_id= ").append(friend.n).toString(), null) > 0;
    }
}

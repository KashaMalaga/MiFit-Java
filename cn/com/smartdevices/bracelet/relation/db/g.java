package cn.com.smartdevices.bracelet.relation.db;

import android.content.ContentValues;
import cn.com.smartdevices.bracelet.d.a.a;
import cn.com.smartdevices.bracelet.d.a.c;
import cn.com.smartdevices.bracelet.d.a.d;
import com.tencent.connect.common.Constants;
import java.sql.SQLDataException;
import java.util.List;

public class g extends a<f> {
    public g(c cVar) {
        super(cVar);
    }

    public f a(long j) {
        try {
            List a = a("from_user_id=? and type = ?", new String[]{com.xiaomi.e.a.f + j, Constants.VIA_RESULT_SUCCESS}, null, null, null, null);
            return (a == null || a.isEmpty()) ? null : (f) a.get(0);
        } catch (SQLDataException e) {
            return null;
        }
    }

    public boolean a(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.c, str);
        return a(contentValues, new StringBuilder().append("from_user_id= ").append(j).toString(), null) > 0;
    }

    public boolean a(f fVar) {
        return a((d) fVar, "from_user_id=? and type = ?", new String[]{new StringBuilder().append(com.xiaomi.e.a.f).append(fVar.q).toString(), Constants.VIA_RESULT_SUCCESS}) > 0;
    }

    public f b(long j) {
        try {
            List a = a("from_user_id=? and type = ?", new String[]{com.xiaomi.e.a.f + j, Constants.VIA_TO_TYPE_QQ_GROUP}, null, null, null, null);
            return (a == null || a.isEmpty()) ? null : (f) a.get(0);
        } catch (SQLDataException e) {
            return null;
        }
    }

    public boolean b(f fVar) {
        return a((d) fVar, "from_user_id=? and type = ?", new String[]{new StringBuilder().append(com.xiaomi.e.a.f).append(fVar.q).toString(), Constants.VIA_TO_TYPE_QQ_GROUP}) > 0;
    }

    public boolean c(long j) {
        return b("from_user_id=?", new String[]{new StringBuilder().append(com.xiaomi.e.a.f).append(j).toString()}) > 0;
    }

    public boolean c(f fVar) {
        boolean z = true;
        if (a((d) fVar, "from_user_id=? and type = ?", new String[]{com.xiaomi.e.a.f + fVar.q, fVar.t + com.xiaomi.e.a.f}) <= 0) {
            z = false;
        }
        return !z ? a((d) fVar) : z;
    }
}

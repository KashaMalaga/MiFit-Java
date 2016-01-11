package cn.com.smartdevices.bracelet.partner;

import android.content.ContentValues;
import android.database.Cursor;
import cn.com.smartdevices.bracelet.d.B;
import cn.com.smartdevices.bracelet.d.C0430g;
import cn.com.smartdevices.bracelet.push.f;
import com.amap.api.location.LocationManagerProxy;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import java.io.Serializable;

public class Partner implements Serializable {
    public static final int AUTHORIZED = 1;
    public static final String GOOGLE_FIT_ID = "google_fit";
    public static final String HEALTH_LINK_ID = "health_link";
    public static final String QQ_ID = "qq";
    public static final int UNAUTHORIZED = 0;
    public static final String WEIBO_HEALTH_ID = "weibo_health";
    public static final String WE_CHAT_ID = "we_chat";
    private static final long serialVersionUID = 4575743095201758611L;
    public int authorizeStatus = UNAUTHORIZED;
    public String color = a.f;
    public long expireTime = 0;
    public String icon = a.f;
    public String id = a.f;
    public String shareContent = a.f;
    public String subTitle = a.f;
    public String title = a.f;
    public String url = a.f;

    public static Partner fromCursor(Cursor cursor) {
        Partner partner = new Partner();
        partner.color = cursor.getString(cursor.getColumnIndex(f.n));
        partner.expireTime = cursor.getLong(cursor.getColumnIndex(C0430g.d));
        partner.url = cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_URL));
        partner.subTitle = cursor.getString(cursor.getColumnIndex(B.f));
        partner.shareContent = cursor.getString(cursor.getColumnIndex(B.g));
        partner.title = cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_TITLE));
        partner.id = cursor.getString(cursor.getColumnIndex(B.h));
        partner.icon = cursor.getString(cursor.getColumnIndex(cn.com.smartdevices.bracelet.relation.db.f.h));
        partner.authorizeStatus = cursor.getInt(cursor.getColumnIndex(LocationManagerProxy.KEY_STATUS_CHANGED));
        return partner;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Partner)) {
            return false;
        }
        return this.id != null && this.id.equals(((Partner) obj).id);
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstants.PARAM_URL, this.url);
        contentValues.put(f.n, this.color);
        contentValues.put(C0430g.d, Long.valueOf(this.expireTime));
        contentValues.put(B.h, this.id);
        contentValues.put(SocialConstants.PARAM_TITLE, this.title);
        contentValues.put(B.f, this.subTitle);
        contentValues.put(B.g, this.shareContent);
        contentValues.put(cn.com.smartdevices.bracelet.relation.db.f.h, this.icon);
        contentValues.put(LocationManagerProxy.KEY_STATUS_CHANGED, Integer.valueOf(this.authorizeStatus));
        return contentValues;
    }
}

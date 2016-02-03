package cn.com.smartdevices.bracelet.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.a.q;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.gps.c.a.i;
import cn.com.smartdevices.bracelet.gps.services.O;
import com.xiaomi.channel.relationservice.data.a;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class HeartRateItem {
    public static final int STATE_NOT_SYNCED = 0;
    public static final int STATE_SYNCED = 1;
    public static final int SYNC_FROMSERVER_COUNT = 100;
    private static final String TAG = "HeartRateItem";
    public static final int TYPE_AUTO = 1;
    public static final int TYPE_MANUAL = 2;
    public int hr;
    public int status;
    public long time;
    public int type;

    public HeartRateItem(int i, int i2, long j) {
        this.hr = i;
        this.type = i2;
        this.time = j;
    }

    public HeartRateItem(int i, int i2, long j, int i3) {
        this(i, i2, j);
        this.status = i3;
    }

    public static ArrayList<HeartRateItem> fromCursor2Items(Cursor cursor) {
        ArrayList<HeartRateItem> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(getHeartRateItem(cursor));
        }
        return arrayList;
    }

    @q
    private static HeartRateItem getHeartRateItem(Cursor cursor) {
        HeartRateItem heartRateItem = new HeartRateItem();
        int columnIndex = cursor.getColumnIndex(O.j);
        if (columnIndex != -1) {
            heartRateItem.hr = cursor.getInt(columnIndex);
        }
        columnIndex = cursor.getColumnIndex(g.f);
        if (columnIndex != -1) {
            heartRateItem.time = cursor.getLong(columnIndex);
        }
        columnIndex = cursor.getColumnIndex(a.h);
        if (columnIndex != -1) {
            heartRateItem.type = cursor.getInt(columnIndex);
        }
        return heartRateItem;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.h, Integer.valueOf(this.type));
        contentValues.put(O.j, Integer.valueOf(this.hr));
        contentValues.put(g.f, Long.valueOf(this.time));
        contentValues.put(i.d, Integer.valueOf(STATE_NOT_SYNCED));
        return contentValues;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(g.f, this.time);
            byte[] bArr = new byte[TYPE_AUTO];
            bArr[STATE_NOT_SYNCED] = (byte) this.hr;
            jSONObject.put("rate", Base64.encodeToString(bArr, TYPE_MANUAL));
            jSONObject.put(a.h, this.type);
        } catch (JSONException e) {
            C0596r.e(TAG, "toJSONObject:" + e.getMessage());
        }
        return jSONObject;
    }
}

package cn.com.smartdevices.bracelet.model.game;

import android.content.Context;
import cn.com.smartdevices.bracelet.Utils;
import com.c.a.a.b;
import com.tencent.open.SocialConstants;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class GameStage {
    @b(a = "stime")
    private long startTime;
    @b(a = "status")
    private int status;
    @b(a = "etime")
    private long stopTime;
    @b(a = "url")
    private String url;

    public static GameStage fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        GameStage gameStage = new GameStage();
        try {
            gameStage.startTime = jSONObject.getLong("stime");
            gameStage.stopTime = jSONObject.getLong("etime");
            gameStage.url = jSONObject.getString(SocialConstants.PARAM_URL);
            return gameStage;
        } catch (JSONException e) {
            e.printStackTrace();
            return gameStage;
        }
    }

    public static Date toDate(long j) {
        return new Date(1000 * j);
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public String getUrl(Context context) {
        return this.url + Utils.i(context);
    }

    public boolean isActive(int i) {
        return ((long) i) >= this.startTime && ((long) i) <= this.stopTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setStopTime(long j) {
        this.stopTime = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "GameStage: start=" + toDate(this.startTime) + ", stop=" + toDate(this.stopTime) + ", status =" + this.status + " url = " + this.url;
    }
}

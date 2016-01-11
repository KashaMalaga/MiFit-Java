package com.xiaomi.hm.health.dataprocess;

import org.json.JSONException;
import org.json.JSONObject;

public class SportIndex {
    public int lenght = 0;
    public int startIndex = 0;
    public int stopIndex = 0;

    public SportIndex(int i, int i2) {
        this.startIndex = i;
        this.stopIndex = i2;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startIndex", this.startIndex * 4);
            jSONObject.put("stopIndex", this.stopIndex * 4);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return "index:" + this.startIndex + "->" + this.stopIndex;
    }
}

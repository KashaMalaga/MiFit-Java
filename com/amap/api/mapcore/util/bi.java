package com.amap.api.mapcore.util;

import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

public class bi extends bu {
    private byte[] d;

    public bi(byte[] bArr) {
        this.d = (byte[]) bArr.clone();
    }

    private String a() {
        Object bytes = av.a.getBytes();
        byte[] bArr = new byte[(bytes.length + 50)];
        System.arraycopy(this.d, 0, bArr, 0, 50);
        System.arraycopy(bytes, 0, bArr, 50, bytes.length);
        return ab.a(bArr);
    }

    public HttpEntity getEntity() {
        return null;
    }

    public byte[] getEntityBytes() {
        return this.d;
    }

    public Map<String, String> getParams() {
        return null;
    }

    public Map<String, String> getRequestHead() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.d.length));
        return hashMap;
    }

    public String getURL() {
        return String.format(av.b, new Object[]{Constants.VIA_TO_TYPE_QQ_GROUP, Constants.VIA_TO_TYPE_QQ_GROUP, Constants.VIA_TO_TYPE_QQ_GROUP, "open", a()});
    }
}

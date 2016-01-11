package cn.com.smartdevices.bracelet.shoes.data.analyzer;

import cn.com.smartdevices.bracelet.shoes.model.DateRawData;
import com.xiaomi.hm.health.dataprocess.UserInfo;

public class ShoesDataAnalysis {
    static {
        try {
            System.loadLibrary("shoesDataProcess");
        } catch (Exception e) {
        }
    }

    public static native void processData(UserInfo userInfo, DateRawData dateRawData);
}

package cn.com.smartdevices.bracelet.weather;

import android.content.Context;
import com.huami.android.widget.share.m;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.f;
import com.xiaomi.hm.health.r;
import java.text.DateFormat;
import java.util.Date;
import kankan.wheel.widget.a;

public class WeatherInfo {
    public static final int[] AQI_LEVEL_1 = new int[]{0, 50};
    public static final int[] AQI_LEVEL_2 = new int[]{51, 100};
    public static final int[] AQI_LEVEL_3 = new int[]{100, a.ap};
    public static final int[] AQI_LEVEL_4 = new int[]{151, v.C};
    public static final int[] AQI_LEVEL_5 = new int[]{v.D, m.n};
    public static final int[] AQI_LEVEL_6 = new int[]{m.n, a.aB};
    private static String[] sWeatherCloudy = new String[]{"\u591a\u4e91"};
    private static String[] sWeatherFine = new String[]{"\u6674"};
    private static String[] sWeatherFog = new String[]{"\u96fe"};
    private static String[] sWeatherHaze = new String[]{"\u973e"};
    private static String[] sWeatherOvercast = new String[]{"\u9634"};
    private static String[] sWeatherRainSnows = new String[]{"\u96e8\u5939\u96ea"};
    private static String[] sWeatherRains = new String[]{"\u9635\u96e8", "\u96f7\u9635\u96e8", "\u5c0f\u96e8", "\u4e2d\u96e8", "\u5927\u96e8", "\u5927\u66b4\u96e8", "\u7279\u5927\u66b4\u96e8", "\u51bb\u96e8", "\u96f7\u9635\u96e8\u4f34\u6709\u51b0\u96f9"};
    private static String[] sWeatherSands = new String[]{"\u6d6e\u5c18", "\u626c\u6c99", "\u6c99\u5c18\u66b4", "\u5f3a\u6c99\u5c18\u66b4"};
    private static String[] sWeatherSnows = new String[]{"\u9635\u96ea", "\u5c0f\u96ea", "\u4e2d\u96ea", "\u5927\u96ea", "\u66b4\u96ea"};
    private int aqi = -1;
    private String aqiDescription;
    private int aqiLevel = 0;
    private long time;
    private String weather;
    private String weatherDescription;

    private static boolean has(String[] strArr, String str) {
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String toAqiDescription(Context context, int i) {
        return i > 0 ? context.getResources().getStringArray(f.weather_aqi_descriptions)[i - 1] : null;
    }

    public static int toAqiLevel(int i) {
        return (i < AQI_LEVEL_1[0] || i > AQI_LEVEL_1[1]) ? (i < AQI_LEVEL_2[0] || i > AQI_LEVEL_2[1]) ? (i < AQI_LEVEL_3[0] || i > AQI_LEVEL_3[1]) ? (i < AQI_LEVEL_4[0] || i > AQI_LEVEL_4[1]) ? (i < AQI_LEVEL_5[0] || i > AQI_LEVEL_5[1]) ? (i < AQI_LEVEL_6[0] || i > AQI_LEVEL_6[1]) ? 0 : 6 : 5 : 4 : 3 : 2 : 1;
    }

    public static String toWeatherDescription(Context context, String str) {
        return has(sWeatherRains, str) ? context.getString(r.weather_description_rain) : has(sWeatherRainSnows, str) ? context.getString(r.weather_description_rain_snow) : has(sWeatherSnows, str) ? context.getString(r.weather_description_snow) : has(sWeatherSands, str) ? context.getString(r.weather_description_sand) : has(sWeatherFine, str) ? context.getString(r.weather_description_fine) : has(sWeatherCloudy, str) ? context.getString(r.weather_description_cloudy) : has(sWeatherOvercast, str) ? context.getString(r.weather_description_overcast) : has(sWeatherFog, str) ? context.getString(r.weather_description_fog) : has(sWeatherHaze, str) ? context.getString(r.weather_description_haze) : null;
    }

    public int getAqi() {
        return this.aqi;
    }

    public String getAqiDescription() {
        return this.aqiDescription;
    }

    public int getAqiLevel() {
        return this.aqiLevel;
    }

    public long getTime() {
        return this.time;
    }

    public String getWeather() {
        return this.weather;
    }

    public String getWeatherDescription() {
        return this.weatherDescription;
    }

    public void setAqi(int i) {
        this.aqi = i;
    }

    public void setAqiDescription(String str) {
        this.aqiDescription = str;
    }

    public void setAqiLevel(int i) {
        this.aqiLevel = i;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setWeather(String str) {
        this.weather = str;
    }

    public void setWeatherDescription(String str) {
        this.weatherDescription = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append("Time : ").append(DateFormat.getTimeInstance().format(new Date(this.time)));
        stringBuilder.append("\n").append("Weather : ").append(this.weather);
        stringBuilder.append("\n").append("AQI : ").append(this.aqi);
        stringBuilder.append("\n").append("AQI Level : ").append(this.aqiLevel);
        stringBuilder.append("\n").append("AQI Description : ").append(this.aqiDescription);
        return stringBuilder.toString();
    }
}

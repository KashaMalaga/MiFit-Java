package cn.com.smartdevices.bracelet.ui;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.weather.WeatherInfo;
import cn.com.smartdevices.bracelet.weather.WeatherListener;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;

class C0744ct implements WeatherListener {
    final /* synthetic */ MainUIActivity a;

    C0744ct(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void onReceiveWeather(WeatherInfo weatherInfo) {
        CharSequence charSequence = a.f;
        if (!TextUtils.isEmpty(weatherInfo.getWeatherDescription())) {
            charSequence = charSequence + weatherInfo.getWeatherDescription();
        }
        if (!TextUtils.isEmpty(weatherInfo.getAqiDescription())) {
            charSequence = charSequence + " " + this.a.getString(R.string.weather_aqi, new Object[]{weatherInfo.getAqiDescription()});
        }
        if (!TextUtils.isEmpty(charSequence)) {
            C0401a.a(this.a.w.getContext(), C0401a.eB);
        }
        this.a.j.setText(charSequence);
        this.a.aA = weatherInfo.getAqiLevel();
    }
}

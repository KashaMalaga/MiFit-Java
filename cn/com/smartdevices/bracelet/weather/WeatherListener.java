package cn.com.smartdevices.bracelet.weather;

public interface WeatherListener {
    void onReceiveWeather(WeatherInfo weatherInfo);
}

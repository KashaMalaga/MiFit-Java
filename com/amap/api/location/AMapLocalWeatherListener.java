package com.amap.api.location;

public interface AMapLocalWeatherListener {
    void onWeatherForecaseSearched(AMapLocalWeatherForecast aMapLocalWeatherForecast);

    void onWeatherLiveSearched(AMapLocalWeatherLive aMapLocalWeatherLive);
}

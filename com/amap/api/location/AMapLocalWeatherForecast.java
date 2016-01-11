package com.amap.api.location;

import com.amap.api.location.core.AMapLocException;
import java.util.List;

public class AMapLocalWeatherForecast {
    private String a;
    private List<AMapLocalDayWeatherForecast> b;
    private AMapLocException c;

    void a(AMapLocException aMapLocException) {
        this.c = aMapLocException;
    }

    void a(String str) {
        this.a = str;
    }

    void a(List<AMapLocalDayWeatherForecast> list) {
        this.b = list;
    }

    public AMapLocException getAMapException() {
        return this.c;
    }

    public String getReportTime() {
        return this.a;
    }

    public List<AMapLocalDayWeatherForecast> getWeatherForecast() {
        return this.b;
    }
}

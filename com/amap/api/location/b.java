package com.amap.api.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.com.smartdevices.bracelet.gps.c.a.o;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.c;
import com.amap.api.location.core.d;
import com.amap.api.services.core.AMapException;
import com.b.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.l;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements AMapLocationListener {
    a a = null;
    AMapLocalWeatherListener b;
    a c;
    private Context d;
    private int e;
    private AMapLocalWeatherListener f;

    class a extends Handler {
        private WeakReference<b> a;

        a(b bVar, Looper looper) {
            super(looper);
            try {
                this.a = new WeakReference(bVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                final b bVar = (b) this.a.get();
                switch (message.what) {
                    case l.a /*1*/:
                        if (bVar.b != null) {
                            bVar.b.onWeatherLiveSearched((AMapLocalWeatherLive) message.obj);
                            return;
                        }
                        return;
                    case kankan.wheel.widget.a.k /*2*/:
                        if (bVar.b != null) {
                            bVar.b.onWeatherForecaseSearched((AMapLocalWeatherForecast) message.obj);
                            return;
                        }
                        return;
                    case kankan.wheel.widget.a.l /*3*/:
                        final AMapLocation aMapLocation = (AMapLocation) message.obj;
                        new Thread(this) {
                            final /* synthetic */ a c;

                            public void run() {
                                try {
                                    if (bVar.e == 1) {
                                        bVar.a(aMapLocation, "base", bVar.f);
                                    }
                                    if (bVar.e == 2) {
                                        bVar.a(aMapLocation, QQLogin.PERMISSION_ALL, bVar.f);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }.start();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    public b(a aVar, Context context) {
        this.d = context;
        this.c = aVar;
        this.a = new a(this, context.getMainLooper());
    }

    private AMapLocalWeatherLive a(String str, AMapLocation aMapLocation) {
        AMapLocalWeatherLive aMapLocalWeatherLive = new AMapLocalWeatherLive();
        try {
            d.a(str);
        } catch (AMapLocException e) {
            aMapLocalWeatherLive.a(e);
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("lives");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                String a = a(jSONObject, "weather");
                String a2 = a(jSONObject, "temperature");
                String a3 = a(jSONObject, "winddirection");
                String a4 = a(jSONObject, "windpower");
                String a5 = a(jSONObject, "humidity");
                String a6 = a(jSONObject, "reporttime");
                aMapLocalWeatherLive.a(a);
                aMapLocalWeatherLive.f(a6);
                aMapLocalWeatherLive.e(a5);
                aMapLocalWeatherLive.b(a2);
                aMapLocalWeatherLive.c(a3);
                aMapLocalWeatherLive.d(a4);
                aMapLocalWeatherLive.setCity(aMapLocation.getCity());
                aMapLocalWeatherLive.setCityCode(aMapLocation.getCityCode());
                aMapLocalWeatherLive.setProvince(aMapLocation.getProvince());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aMapLocalWeatherLive;
    }

    private String a() {
        return "http://restapi.amap.com/v3/weather/weatherInfo?";
    }

    private byte[] a(AMapLocation aMapLocation, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&ec=1").append("&extensions=" + str).append("&city=").append(aMapLocation.getAdCode());
        stringBuffer.append("&key=" + c.a());
        return com.amap.api.location.core.a.b(com.amap.api.location.core.a.a(stringBuffer.toString())).getBytes(kankan.wheel.widget.a.bO);
    }

    private AMapLocalWeatherForecast b(String str, AMapLocation aMapLocation) {
        AMapLocalWeatherForecast aMapLocalWeatherForecast = new AMapLocalWeatherForecast();
        try {
            d.a(str);
        } catch (AMapLocException e) {
            aMapLocalWeatherForecast.a(e);
            e.printStackTrace();
        }
        JSONArray jSONArray = new JSONObject(str).getJSONArray("forecasts");
        if (jSONArray != null && jSONArray.length() > 0) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(0);
            aMapLocalWeatherForecast.a(a(jSONObject, "reporttime"));
            JSONArray jSONArray2 = jSONObject.getJSONArray("casts");
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                List arrayList = new ArrayList();
                for (int i = 0; i < jSONArray2.length(); i++) {
                    AMapLocalDayWeatherForecast aMapLocalDayWeatherForecast = new AMapLocalDayWeatherForecast();
                    jSONObject = (JSONObject) jSONArray2.get(i);
                    String a = a(jSONObject, g.a);
                    String a2 = a(jSONObject, o.b);
                    String a3 = a(jSONObject, "dayweather");
                    String a4 = a(jSONObject, "nightweather");
                    String a5 = a(jSONObject, "daytemp");
                    String a6 = a(jSONObject, "nighttemp");
                    String a7 = a(jSONObject, "daywind");
                    String a8 = a(jSONObject, "nightwind");
                    String a9 = a(jSONObject, "daypower");
                    String a10 = a(jSONObject, "nightpower");
                    aMapLocalDayWeatherForecast.a(a);
                    aMapLocalDayWeatherForecast.b(a2);
                    aMapLocalDayWeatherForecast.c(a3);
                    aMapLocalDayWeatherForecast.d(a4);
                    aMapLocalDayWeatherForecast.e(a5);
                    aMapLocalDayWeatherForecast.f(a6);
                    aMapLocalDayWeatherForecast.g(a7);
                    aMapLocalDayWeatherForecast.h(a8);
                    aMapLocalDayWeatherForecast.i(a9);
                    aMapLocalDayWeatherForecast.j(a10);
                    aMapLocalDayWeatherForecast.setCity(aMapLocation.getCity());
                    aMapLocalDayWeatherForecast.setCityCode(aMapLocation.getCityCode());
                    aMapLocalDayWeatherForecast.setProvince(aMapLocation.getProvince());
                    arrayList.add(aMapLocalDayWeatherForecast);
                }
                aMapLocalWeatherForecast.a(arrayList);
            }
        }
        return aMapLocalWeatherForecast;
    }

    protected String a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return com.xiaomi.e.a.f;
        }
        String str2 = com.xiaomi.e.a.f;
        return (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) ? str2 : jSONObject.optString(str);
    }

    void a(int i, AMapLocalWeatherListener aMapLocalWeatherListener, AMapLocation aMapLocation) {
        try {
            this.e = i;
            this.f = aMapLocalWeatherListener;
            if (aMapLocation == null) {
                this.c.a(-1, 10.0f, (AMapLocationListener) this, LocationProviderProxy.AMapNetwork, true);
                return;
            }
            if (i == 1) {
                a(aMapLocation, "base", aMapLocalWeatherListener);
            }
            if (i == 2) {
                a(aMapLocation, QQLogin.PERMISSION_ALL, aMapLocalWeatherListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void a(AMapLocation aMapLocation, String str, AMapLocalWeatherListener aMapLocalWeatherListener) {
        this.b = aMapLocalWeatherListener;
        if (aMapLocation != null) {
            AMapLocException aMapLocException;
            byte[] a = a(aMapLocation, str);
            String a2 = a();
            AMapLocException aMapLocException2 = new AMapLocException();
            String str2 = null;
            try {
                str2 = aa.a().a(this.d, a2, a, "sea");
            } catch (AMapLocException e) {
                aMapLocException2 = e;
            }
            if ("base".equals(str)) {
                AMapLocalWeatherLive a3;
                if (str2 != null) {
                    aMapLocException = aMapLocException2;
                    a3 = a(str2, aMapLocation);
                } else {
                    a3 = new AMapLocalWeatherLive();
                    aMapLocException = new AMapLocException(AMapException.ERROR_CONNECTION);
                }
                a3.a(aMapLocException);
                a3.setCity(aMapLocation.getCity());
                a3.setCityCode(aMapLocation.getCityCode());
                a3.setProvince(aMapLocation.getProvince());
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = a3;
                this.a.sendMessage(obtain);
            } else {
                aMapLocException = aMapLocException2;
            }
            if (QQLogin.PERMISSION_ALL.equals(str)) {
                AMapLocalWeatherForecast b;
                if (str2 != null) {
                    b = b(str2, aMapLocation);
                } else {
                    b = new AMapLocalWeatherForecast();
                    aMapLocException = new AMapLocException(AMapException.ERROR_CONNECTION);
                }
                b.a(aMapLocException);
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                obtain2.obj = b;
                this.a.sendMessage(obtain2);
            }
        }
    }

    public void onLocationChanged(Location location) {
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        Message obtain;
        if (aMapLocation != null) {
            try {
                if (aMapLocation.getAMapException() != null && aMapLocation.getAMapException().getErrorCode() == 0 && aMapLocation.getAdCode() != null && aMapLocation.getAdCode().length() > 0) {
                    this.c.a((AMapLocationListener) this);
                    obtain = Message.obtain();
                    obtain.what = 3;
                    obtain.obj = aMapLocation;
                    this.a.sendMessage(obtain);
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.c.a((AMapLocationListener) this);
        obtain = Message.obtain();
        obtain.what = this.e;
        AMapLocException aMapLocException = new AMapLocException(AMapLocException.ERROR_FAILURE_LOCATION);
        if (1 == this.e) {
            AMapLocalWeatherLive aMapLocalWeatherLive = new AMapLocalWeatherLive();
            aMapLocalWeatherLive.a(aMapLocException);
            obtain.obj = aMapLocalWeatherLive;
            this.a.sendMessage(obtain);
        }
        if (2 == this.e) {
            AMapLocalWeatherForecast aMapLocalWeatherForecast = new AMapLocalWeatherForecast();
            aMapLocalWeatherForecast.a(aMapLocException);
            obtain.obj = aMapLocalWeatherForecast;
            this.a.sendMessage(obtain);
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}

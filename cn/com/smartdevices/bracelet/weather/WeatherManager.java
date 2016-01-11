package cn.com.smartdevices.bracelet.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.v4.content.v;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.a;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.k;
import cn.com.smartdevices.bracelet.location.Location;
import cn.com.smartdevices.bracelet.location.Location.Address;
import cn.com.smartdevices.bracelet.location.e;
import cn.com.smartdevices.bracelet.weather.OriginalCityInfos.CityInfo;
import cn.com.smartdevices.bracelet.weather.OriginalCityInfos.Name;
import com.c.a.C0993k;
import com.d.a.a.h;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.apache.http.Header;

public class WeatherManager {
    private static final String TAG = "WeatherManager";
    private static WeatherManager sManager;
    private Context mContext;
    private SharedPreferences mPrefs = this.mContext.getSharedPreferences(TAG, 0);
    private WeatherListener mWeatherListener;

    private WeatherManager(Context context) {
        this.mContext = context;
    }

    public static WeatherManager getManager(Context context) {
        if (sManager == null) {
            sManager = new WeatherManager(context);
        }
        return sManager;
    }

    private void readOrRequestCityCode(Location location) {
        Object obj = null;
        if (location.c() != null) {
            obj = readLastCityCode(location.c().j());
        }
        if (TextUtils.isEmpty(obj)) {
            requestCityByLocation(location);
        } else {
            readOrRequestWeather(obj);
        }
    }

    private void readOrRequestWeather(String str) {
        WeatherInfo readLastWeatherInfo = readLastWeatherInfo(str);
        if (readLastWeatherInfo != null) {
            int timeOffsetHours = timeOffsetHours(readLastWeatherInfo.getTime(), System.currentTimeMillis());
            C0596r.e(TAG, "Read Weather Time Offset Hours : " + timeOffsetHours);
            if (timeOffsetHours != 0 || this.mWeatherListener == null) {
                requestWeather(str);
                return;
            } else {
                this.mWeatherListener.onReceiveWeather(readLastWeatherInfo);
                return;
            }
        }
        requestWeather(str);
    }

    public static int timeOffsetHours(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? instance2.get(11) - instance.get(11) : 24;
    }

    public void cleanSavedWeatherInfo() {
        Editor edit = this.mPrefs.edit();
        edit.clear();
        edit.commit();
    }

    public Context getContext() {
        return this.mContext;
    }

    public String readLastCityCode(String str) {
        String string = this.mPrefs.getString(str, null);
        C0596r.e(TAG, "Read Last City Code : " + str + " , " + string);
        return string;
    }

    public WeatherInfo readLastWeatherInfo(String str) {
        String string = this.mPrefs.getString(str, null);
        C0596r.e(TAG, "Read Last Weather : " + str + " , " + string);
        return !TextUtils.isEmpty(string) ? (WeatherInfo) new C0993k().a(string, WeatherInfo.class) : null;
    }

    public void registerLocationChanged() {
        v.a(this.mContext).a(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                Location location = (Location) intent.getParcelableExtra(e.e);
                C0596r.e(WeatherManager.TAG, "Broadcast Receive Location : " + location);
                if (location != null) {
                    C0401a.a(WeatherManager.this.mContext, C0401a.eA);
                    WeatherManager.this.readOrRequestCityCode(location);
                }
            }
        }, new IntentFilter(e.d));
    }

    public void registerWeatherListener(WeatherListener weatherListener) {
        this.mWeatherListener = weatherListener;
    }

    public void requestCityByLocation(final Location location) {
        C0596r.e(TAG, "Request City : " + location);
        String encode = Uri.encode(RSACryptor.encode(String.valueOf(location.a())));
        String encode2 = Uri.encode(RSACryptor.encode(String.valueOf(location.b())));
        encode2 = String.format(k.a("URL_REQUEST_CITY"), new Object[]{encode, encode2});
        if (!encode.equals(String.valueOf(location.a()))) {
            encode2 = encode2 + "&encoded=latitude,longitude";
        }
        Address c = location.c();
        if (c != null) {
            if (c.b() != null) {
                encode2 = encode2 + "&countryCode=" + c.b();
            } else {
                encode2 = (encode2 + "&countryCode=CN") + "&language=zh_CN";
            }
            if (!TextUtils.isEmpty(c.c())) {
                encode2 = encode2 + "&adminArea=" + Uri.encode(c.c());
            }
            if (!TextUtils.isEmpty(c.e())) {
                encode2 = encode2 + "&locality=" + Uri.encode(c.e());
            }
            if (!TextUtils.isEmpty(c.f())) {
                encode2 = encode2 + "&subLocality=" + Uri.encode(c.f());
            }
            if (!TextUtils.isEmpty(c.g())) {
                encode2 = encode2 + "&thoroughfare=" + Uri.encode(c.g());
            }
        }
        C0401a.a(this.mContext, C0401a.ex);
        a.a(d.a, encode2, null, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                C0596r.b(WeatherManager.TAG, "Request CityInfos Failed!!", th);
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                CityInfo cityInfo;
                C0596r.e(WeatherManager.TAG, "Request CityInfos Successed!!");
                String str = new String(bArr);
                C0596r.e(WeatherManager.TAG, "Respone : " + str);
                try {
                    OriginalCityInfos originalCityInfos = (OriginalCityInfos) new C0993k().a(str, OriginalCityInfos.class);
                    C0596r.e(WeatherManager.TAG, "CityInfos : " + originalCityInfos.toString());
                    cityInfo = originalCityInfos.getCityInfos().size() > 0 ? (CityInfo) originalCityInfos.getCityInfos().get(0) : null;
                } catch (Exception e) {
                    C0596r.b(WeatherManager.TAG, "Parse CityInfos Error!!", e);
                    C0401a.a(WeatherManager.this.mContext, C0401a.eC, "City_" + location.d());
                    C0401a.a(WeatherManager.this.mContext, e);
                    cityInfo = null;
                }
                if (cityInfo != null) {
                    WeatherManager.this.requestCityCode(cityInfo, location);
                }
            }
        });
    }

    public void requestCityCode(CityInfo cityInfo, final Location location) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList names = cityInfo.getNames();
        if (names != null) {
            Iterator it = names.iterator();
            int i = 0;
            while (it.hasNext()) {
                Name name = (Name) it.next();
                stringBuilder.append(name.getName()).append(";");
                stringBuilder.append(name.getAffiliation()).append(";");
                stringBuilder.append(name.getLanguage()).append(";");
                stringBuilder.append(name.getShortName());
                int i2 = i + 1;
                if (i2 < names.size()) {
                    stringBuilder.append("|");
                }
                i = i2;
            }
        }
        C0596r.e(TAG, "Request City Code : " + stringBuilder);
        if (!TextUtils.isEmpty(stringBuilder.toString())) {
            String encode = Uri.encode(RSACryptor.encode(cityInfo.getMetaData().getX()));
            String encode2 = Uri.encode(RSACryptor.encode(cityInfo.getMetaData().getY()));
            encode2 = String.format(k.a("URL_REQUEST_CITY_CODE"), new Object[]{Uri.encode(stringBuilder.toString(), ";,"), encode, encode2, cityInfo.getMetaData().getPhoneCode(), cityInfo.getMetaData().getAreaCode()});
            if (!encode.equals(cityInfo.getMetaData().getX())) {
                encode2 = encode2 + "&encoded=latitude,longitude";
            }
            C0401a.a(this.mContext, C0401a.ey);
            encode = stringBuilder.toString();
            a.a(d.a, encode2, null, new h() {
                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    C0596r.b(WeatherManager.TAG, "Request CityCodes Failed!!", th);
                }

                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    OriginalCityCodes originalCityCodes;
                    C0596r.e(WeatherManager.TAG, "Request CityCodes Successed!!");
                    String str = new String(bArr);
                    C0596r.e(WeatherManager.TAG, "Respone : " + str);
                    try {
                        OriginalCityCodes originalCityCodes2 = (OriginalCityCodes) new C0993k().a(str, OriginalCityCodes.class);
                        C0596r.e(WeatherManager.TAG, "CityCodes : " + originalCityCodes2.toString());
                        originalCityCodes = originalCityCodes2;
                    } catch (Exception e) {
                        C0596r.b(WeatherManager.TAG, "Parse CityCodes Error!!", e);
                        C0401a.a(WeatherManager.this.mContext, C0401a.eC, "CityCode_" + encode);
                        C0401a.a(WeatherManager.this.mContext, e);
                        originalCityCodes = null;
                    }
                    if (originalCityCodes != null) {
                        str = originalCityCodes.getCityCode(OriginalCityCodes.TYPE_XIAOMI);
                        C0596r.e(WeatherManager.TAG, "Request Weather : " + str);
                        if (TextUtils.isEmpty(str)) {
                            str = originalCityCodes.getCityCode(OriginalCityCodes.TYPE_WEATHER_CHINA);
                            C0596r.e(WeatherManager.TAG, "Request Weather : " + str);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            if (location.c() != null) {
                                WeatherManager.this.saveCityCode(location.c().j(), str);
                            }
                            WeatherManager.this.readOrRequestWeather(str);
                        }
                    }
                }
            });
        }
    }

    public void requestWeather(final String str) {
        String format = String.format(k.a("URL_REQUEST_WEATHER"), new Object[]{str});
        C0401a.a(this.mContext, C0401a.ez);
        a.a(d.a, format, null, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                C0596r.b(WeatherManager.TAG, "Request Weather Failed!!", th);
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                WeatherInfo weatherInfo;
                C0596r.e(WeatherManager.TAG, "Request Weather Successed!!");
                String str = new String(bArr);
                C0596r.e(WeatherManager.TAG, "Respone : " + str);
                try {
                    OriginalWeatherInfo originalWeatherInfo = (OriginalWeatherInfo) new C0993k().a(str, OriginalWeatherInfo.class);
                    C0596r.e(WeatherManager.TAG, "WeatherInfo : " + originalWeatherInfo);
                    WeatherInfo weatherInfo2 = new WeatherInfo();
                    weatherInfo2.setTime(System.currentTimeMillis());
                    weatherInfo2.setWeather(originalWeatherInfo.getRealtime().getWeather());
                    weatherInfo2.setWeatherDescription(WeatherInfo.toWeatherDescription(WeatherManager.this.mContext, weatherInfo2.getWeather()));
                    Object aqi = originalWeatherInfo.getAqi().getAqi();
                    if (TextUtils.isEmpty(aqi) || "null".equals(aqi)) {
                        C0401a.a(WeatherManager.this.mContext, C0401a.eC, "Weather_NoAqi");
                    } else {
                        weatherInfo2.setAqi(Integer.valueOf(aqi).intValue());
                        weatherInfo2.setAqiLevel(WeatherInfo.toAqiLevel(weatherInfo2.getAqi()));
                        weatherInfo2.setAqiDescription(WeatherInfo.toAqiDescription(WeatherManager.this.mContext, weatherInfo2.getAqiLevel()));
                    }
                    weatherInfo = weatherInfo2;
                } catch (Exception e) {
                    C0596r.b(WeatherManager.TAG, "Parse WeatherInfo Error!!", e);
                    C0401a.a(WeatherManager.this.mContext, C0401a.eC, "Weather_" + str);
                    C0401a.a(WeatherManager.this.mContext, e);
                    weatherInfo = null;
                }
                if (weatherInfo != null) {
                    C0596r.e(WeatherManager.TAG, "Weather : " + weatherInfo);
                    WeatherManager.this.saveWeatherInfo(str, weatherInfo);
                    if (WeatherManager.this.mWeatherListener != null) {
                        WeatherManager.this.mWeatherListener.onReceiveWeather(weatherInfo);
                    }
                }
            }
        });
    }

    public void saveCityCode(String str, String str2) {
        C0596r.e(TAG, "Save Last City Code : " + str + " , " + str2);
        Editor edit = this.mPrefs.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public void saveWeatherInfo(String str, WeatherInfo weatherInfo) {
        String b = new C0993k().b((Object) weatherInfo);
        C0596r.e(TAG, "Save Last Weather : " + str + ", " + b);
        Editor edit = this.mPrefs.edit();
        edit.putString(str, b);
        edit.commit();
    }
}

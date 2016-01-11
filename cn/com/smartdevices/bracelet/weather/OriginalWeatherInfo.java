package cn.com.smartdevices.bracelet.weather;

public class OriginalWeatherInfo {
    private AQI aqi;
    private Realtime realtime;

    public class AQI {
        private String aqi;
        private String city;
        private String city_id;
        private String no2;
        private String pm10;
        private String pm25;
        private String pub_time;
        private String so2;
        private String spot;
        private String src;

        public String getAqi() {
            return this.aqi;
        }

        public String getCity() {
            return this.city;
        }

        public String getCity_id() {
            return this.city_id;
        }

        public String getNo2() {
            return this.no2;
        }

        public String getPm10() {
            return this.pm10;
        }

        public String getPm25() {
            return this.pm25;
        }

        public String getPub_time() {
            return this.pub_time;
        }

        public String getSo2() {
            return this.so2;
        }

        public String getSpot() {
            return this.spot;
        }

        public String getSrc() {
            return this.src;
        }

        public void setAqi(String str) {
            this.aqi = str;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public void setCity_id(String str) {
            this.city_id = str;
        }

        public void setNo2(String str) {
            this.no2 = str;
        }

        public void setPm10(String str) {
            this.pm10 = str;
        }

        public void setPm25(String str) {
            this.pm25 = str;
        }

        public void setPub_time(String str) {
            this.pub_time = str;
        }

        public void setSo2(String str) {
            this.so2 = str;
        }

        public void setSpot(String str) {
            this.spot = str;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public class AccuCC {
    }

    public class AccuF5 {
    }

    public class Alert {
    }

    public class Forecast {
    }

    public class Index {
    }

    public class Realtime {
        private String SD;
        private String WD;
        private String WS;
        private String WSE;
        private String city;
        private String cityId;
        private String isRadar;
        private String radar;
        private String temp;
        private String time;
        private String weather;

        public String getCity() {
            return this.city;
        }

        public String getCityId() {
            return this.cityId;
        }

        public String getIsRadar() {
            return this.isRadar;
        }

        public String getRadar() {
            return this.radar;
        }

        public String getSD() {
            return this.SD;
        }

        public String getTemp() {
            return this.temp;
        }

        public String getTime() {
            return this.time;
        }

        public String getWD() {
            return this.WD;
        }

        public String getWS() {
            return this.WS;
        }

        public String getWSE() {
            return this.WSE;
        }

        public String getWeather() {
            return this.weather;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public void setCityId(String str) {
            this.cityId = str;
        }

        public void setIsRadar(String str) {
            this.isRadar = str;
        }

        public void setRadar(String str) {
            this.radar = str;
        }

        public void setSD(String str) {
            this.SD = str;
        }

        public void setTemp(String str) {
            this.temp = str;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public void setWD(String str) {
            this.WD = str;
        }

        public void setWS(String str) {
            this.WS = str;
        }

        public void setWSE(String str) {
            this.WSE = str;
        }

        public void setWeather(String str) {
            this.weather = str;
        }
    }

    public class Today {
    }

    public class Yestoday {
    }

    public AQI getAqi() {
        return this.aqi;
    }

    public Realtime getRealtime() {
        return this.realtime;
    }

    public void setAqi(AQI aqi) {
        this.aqi = aqi;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }
}

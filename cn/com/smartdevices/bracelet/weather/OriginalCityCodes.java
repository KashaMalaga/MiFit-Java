package cn.com.smartdevices.bracelet.weather;

import java.util.ArrayList;
import java.util.Iterator;

public class OriginalCityCodes {
    public static String TYPE_ACCU = "accu";
    public static String TYPE_ACCU_MI = "AC_MI";
    public static String TYPE_WEATHER_CHINA = "weathercomcn";
    public static String TYPE_XIAOMI = "xiaomi";
    private ArrayList<DataSource> dataSources;

    public class DataSource {
        private String key;
        private String type;

        public String getKey() {
            return this.key;
        }

        public String getType() {
            return this.type;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key : ").append(this.key).append(", ");
            stringBuilder.append("Type : ").append(this.type);
            return stringBuilder.toString();
        }
    }

    public String getCityCode(String str) {
        if (!(str == null || this.dataSources == null)) {
            Iterator it = this.dataSources.iterator();
            while (it.hasNext()) {
                DataSource dataSource = (DataSource) it.next();
                if (str.equals(dataSource.getType())) {
                    return dataSource.getKey();
                }
            }
        }
        return null;
    }

    public ArrayList<DataSource> getDataSources() {
        return this.dataSources;
    }

    public void setDataSources(ArrayList<DataSource> arrayList) {
        this.dataSources = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.dataSources.iterator();
        while (it.hasNext()) {
            stringBuilder.append("\n\t").append((DataSource) it.next());
        }
        return stringBuilder.toString();
    }
}

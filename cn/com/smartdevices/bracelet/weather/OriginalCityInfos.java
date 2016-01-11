package cn.com.smartdevices.bracelet.weather;

import java.util.ArrayList;
import java.util.Iterator;

public class OriginalCityInfos {
    private ArrayList<CityInfo> cityInfos;

    public class CityInfo {
        private MetaData metaData;
        private ArrayList<Name> names;
        private int namesSize;

        public MetaData getMetaData() {
            return this.metaData;
        }

        public ArrayList<Name> getNames() {
            return this.names;
        }

        public int getNamesSize() {
            return this.namesSize;
        }

        public void setMetaData(MetaData metaData) {
            this.metaData = metaData;
        }

        public void setNames(ArrayList<Name> arrayList) {
            this.names = arrayList;
        }

        public void setNamesSize(int i) {
            this.namesSize = i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t").append("MetaData : ").append(this.metaData);
            stringBuilder.append("\n\t").append("Names : ");
            Iterator it = this.names.iterator();
            while (it.hasNext()) {
                stringBuilder.append((Name) it.next());
            }
            stringBuilder.append("\n\t").append("NamesSize : ").append(this.namesSize);
            return stringBuilder.toString();
        }
    }

    public class MetaData {
        private String altitude;
        private String areaCode;
        private String country;
        private String phoneCode;
        private String x;
        private String y;

        public String getAltitude() {
            return this.altitude;
        }

        public String getAreaCode() {
            return this.areaCode;
        }

        public String getCountry() {
            return this.country;
        }

        public String getPhoneCode() {
            return this.phoneCode;
        }

        public String getX() {
            return this.x;
        }

        public String getY() {
            return this.y;
        }

        public void setAltitude(String str) {
            this.altitude = str;
        }

        public void setAreaCode(String str) {
            this.areaCode = str;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public void setPhoneCode(String str) {
            this.phoneCode = str;
        }

        public void setX(String str) {
            this.x = str;
        }

        public void setY(String str) {
            this.y = str;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t\t").append("Altitude : ").append(this.altitude).append(", ");
            stringBuilder.append("\n\t\t").append("AreaCode : ").append(this.areaCode).append(", ");
            stringBuilder.append("\n\t\t").append("Country : ").append(this.country).append(", ");
            stringBuilder.append("\n\t\t").append("PhoneCode : ").append(this.phoneCode).append(", ");
            stringBuilder.append("\n\t\t").append("X : ").append(this.x).append(", ");
            stringBuilder.append("\n\t\t").append("Y : ").append(this.y);
            return stringBuilder.toString();
        }
    }

    public class Name {
        private String affiliation;
        private String father;
        private String language;
        private String name;
        private String shortName;

        public String getAffiliation() {
            return this.affiliation;
        }

        public String getFather() {
            return this.father;
        }

        public String getLanguage() {
            return this.language;
        }

        public String getName() {
            return this.name;
        }

        public String getShortName() {
            return this.shortName;
        }

        public void setAffiliation(String str) {
            this.affiliation = str;
        }

        public void setFather(String str) {
            this.father = str;
        }

        public void setLanguage(String str) {
            this.language = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setShortName(String str) {
            this.shortName = str;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t\t").append("Affiliation : ").append(this.affiliation).append(", ");
            stringBuilder.append("\n\t\t").append("Father : ").append(this.father).append(", ");
            stringBuilder.append("\n\t\t").append("Language : ").append(this.language).append(", ");
            stringBuilder.append("\n\t\t").append("Name : ").append(this.name).append(", ");
            stringBuilder.append("\n\t\t").append("ShortName : ").append(this.shortName);
            return stringBuilder.toString();
        }
    }

    public ArrayList<CityInfo> getCityInfos() {
        return this.cityInfos;
    }

    public void setCityInfos(ArrayList<CityInfo> arrayList) {
        this.cityInfos = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.cityInfos.iterator();
        while (it.hasNext()) {
            stringBuilder.append((CityInfo) it.next());
        }
        return stringBuilder.toString();
    }
}

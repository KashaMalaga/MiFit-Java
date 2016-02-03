package com.amap.api.services.core;

import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Cinema;
import com.amap.api.services.poisearch.Dining;
import com.amap.api.services.poisearch.Discount;
import com.amap.api.services.poisearch.Groupbuy;
import com.amap.api.services.poisearch.Hotel;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiItemDetail.DeepType;
import com.amap.api.services.poisearch.Scenic;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.tauth.AuthActivity;
import com.xiaomi.channel.relationservice.data.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
    public static Scenic a(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        Scenic scenic = new Scenic();
        scenic.setIntro(b(jSONObject, "intro"));
        scenic.setRating(b(jSONObject, "rating"));
        scenic.setDeepsrc(b(jSONObject, "deepsrc"));
        scenic.setLevel(b(jSONObject, "level"));
        scenic.setPrice(b(jSONObject, "price"));
        scenic.setSeason(b(jSONObject, "season"));
        scenic.setRecommend(b(jSONObject, a.B));
        scenic.setTheme(b(jSONObject, "theme"));
        scenic.setOrderWapUrl(b(jSONObject, "ordering_wap_url"));
        scenic.setOrderWebUrl(b(jSONObject, "ordering_web_url"));
        scenic.setOpentimeGDF(b(jSONObject, "opentime_GDF"));
        scenic.setOpentime(b(jSONObject, "opentime"));
        scenic.setPhotos(l(jSONObject));
        poiItemDetail.setDeepType(DeepType.SCENIC);
        poiItemDetail.setScenic(scenic);
        return scenic;
    }

    public static ArrayList<SuggestionCity> a(JSONObject jSONObject) {
        if (!jSONObject.has("cities")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("cities");
        ArrayList<SuggestionCity> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            arrayList.add(new SuggestionCity(b(jSONObject2, "name"), b(jSONObject2, "citycode"), b(jSONObject2, "adcode"), i(b(jSONObject2, "num"))));
        }
        return arrayList;
    }

    public static List<BusPath> a(JSONArray jSONArray) {
        List<BusPath> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            busPath.setCost(j(b(jSONObject, "cost")));
            busPath.setDuration(k(b(jSONObject, "duration")));
            busPath.setNightBus(l(b(jSONObject, "nightflag")));
            busPath.setWalkDistance(j(b(jSONObject, "walking_distance")));
            if (jSONObject.has("segments")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("segments");
                List arrayList2 = new ArrayList();
                float f = 0.0f;
                float f2 = 0.0f;
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    BusStep p = p(jSONArray2.getJSONObject(i2));
                    arrayList2.add(p);
                    if (p.getWalk() != null) {
                        f += p.getWalk().getDistance();
                    }
                    if (p.getBusLine() != null) {
                        f2 += p.getBusLine().getDistance();
                    }
                }
                busPath.setSteps(arrayList2);
                busPath.setBusDistance(f2);
                busPath.setWalkDistance(f);
            }
            arrayList.add(busPath);
        }
        return arrayList;
    }

    public static void a(Discount discount, JSONObject jSONObject) {
        discount.initPhotos(l(jSONObject));
    }

    public static void a(Groupbuy groupbuy, JSONObject jSONObject) {
        groupbuy.initPhotos(l(jSONObject));
    }

    public static void a(PoiItemDetail poiItemDetail, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (poiItemDetail.isGroupbuyInfo()) {
                b(poiItemDetail, jSONObject);
            }
            if (poiItemDetail.isDiscountInfo()) {
                c(poiItemDetail, jSONObject);
            }
        }
    }

    public static void a(DriveStep driveStep, JSONObject jSONObject) {
        if (jSONObject.has("cities")) {
            try {
                List arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("cities");
                for (int i = 0; i < jSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    routeSearchCity.setSearchCityName(b(jSONObject2, "name"));
                    routeSearchCity.setSearchCitycode(b(jSONObject2, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(b(jSONObject2, "adcode"));
                    a(routeSearchCity, jSONObject2);
                    arrayList.add(routeSearchCity);
                }
                driveStep.setRouteSearchCityList(arrayList);
            } catch (JSONException e) {
            }
        }
    }

    public static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) {
        if (jSONObject.has("districts")) {
            try {
                List arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("districts");
                for (int i = 0; i < jSONArray.length(); i++) {
                    District district = new District();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    district.setDistrictName(b(jSONObject2, "name"));
                    district.setDistrictAdcode(b(jSONObject2, "adcode"));
                    arrayList.add(district);
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
            }
        }
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            crossroad.setId(b(jSONObject, SyncShoesDataService.d));
            crossroad.setDirection(b(jSONObject, "direction"));
            crossroad.setDistance(j(b(jSONObject, cn.com.smartdevices.bracelet.relation.db.a.g)));
            crossroad.setCenterPoint(c(jSONObject, a.l));
            crossroad.setFirstRoadId(b(jSONObject, "first_id"));
            crossroad.setFirstRoadName(b(jSONObject, "first_name"));
            crossroad.setSecondRoadId(b(jSONObject, "second_id"));
            crossroad.setSecondRoadName(b(jSONObject, "second_name"));
            arrayList.add(crossroad);
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(m(jSONArray.getJSONObject(i)));
            }
            if (districtItem != null) {
                districtItem.setSubDistrict(arrayList);
            }
        }
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) {
        regeocodeAddress.setProvince(b(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(b(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(b(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(b(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(b(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(b(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(b(jSONObject.getJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(b(jSONObject.getJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject jSONObject2 = jSONObject.getJSONObject("streetNumber");
        streetNumber.setStreet(b(jSONObject2, "street"));
        streetNumber.setNumber(b(jSONObject2, "number"));
        streetNumber.setLatLonPoint(c(jSONObject2, a.l));
        streetNumber.setDirection(b(jSONObject2, "direction"));
        streetNumber.setDistance(j(b(jSONObject2, cn.com.smartdevices.bracelet.relation.db.a.g)));
        regeocodeAddress.setStreetNumber(streetNumber);
    }

    public static boolean a(String str) {
        try {
            if (str.equals(com.xiaomi.e.a.f)) {
                return false;
            }
            int parseInt = Integer.parseInt(str);
            return parseInt != 0 && parseInt == 1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return a(b(jSONObject.optJSONObject("biz_ext"), str));
    }

    public static BusRouteResult b(String str) {
        BusRouteResult busRouteResult = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                busRouteResult = new BusRouteResult();
                jSONObject = jSONObject.getJSONObject("route");
                busRouteResult.setStartPos(c(jSONObject, "origin"));
                busRouteResult.setTargetPos(c(jSONObject, "destination"));
                busRouteResult.setTaxiCost(j(b(jSONObject, "taxi_cost")));
                if (jSONObject.has("transits")) {
                    busRouteResult.setPaths(a(jSONObject.getJSONArray("transits")));
                }
            }
            return busRouteResult;
        } catch (JSONException e) {
            throw new AMapException(AMapException.ERROR_PROTOCOL);
        }
    }

    public static String b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return com.xiaomi.e.a.f;
        }
        String str2 = com.xiaomi.e.a.f;
        return (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) ? str2 : jSONObject.optString(str);
    }

    public static ArrayList<String> b(JSONObject jSONObject) {
        if (!jSONObject.has("keywords")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("keywords");
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static void b(PoiItemDetail poiItemDetail, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("groupbuys")) {
            JSONArray jSONArray = jSONObject.getJSONArray("groupbuys");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Groupbuy groupbuy = new Groupbuy();
                groupbuy.setTypeCode(b(jSONObject2, "typecode"));
                groupbuy.setTypeDes(b(jSONObject2, a.h));
                groupbuy.setDetail(b(jSONObject2, f.au));
                groupbuy.setStartTime(e.c(b(jSONObject2, "start_time")));
                groupbuy.setEndTime(e.c(b(jSONObject2, "end_time")));
                groupbuy.setCount(i(b(jSONObject2, "num")));
                groupbuy.setSoldCount(i(b(jSONObject2, "sold_num")));
                groupbuy.setOriginalPrice(j(b(jSONObject2, "original_price")));
                groupbuy.setGroupbuyPrice(j(b(jSONObject2, "groupbuy_price")));
                groupbuy.setDiscount(j(b(jSONObject2, "discount")));
                groupbuy.setTicketAddress(b(jSONObject2, "ticket_address"));
                groupbuy.setTicketTel(b(jSONObject2, "ticket_tel"));
                groupbuy.setUrl(b(jSONObject2, SocialConstants.PARAM_URL));
                groupbuy.setProvider(b(jSONObject2, "provider"));
                a(groupbuy, jSONObject2);
                poiItemDetail.addGroupbuy(groupbuy);
            }
        }
    }

    public static void b(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        Cinema cinema = new Cinema();
        cinema.setIntro(b(jSONObject, "intro"));
        cinema.setRating(b(jSONObject, "rating"));
        cinema.setDeepsrc(b(jSONObject, "deepsrc"));
        cinema.setParking(b(jSONObject, "parking"));
        cinema.setOpentimeGDF(b(jSONObject, "opentime_GDF"));
        cinema.setOpentime(b(jSONObject, "opentime"));
        cinema.setPhotos(l(jSONObject));
        if (k(jSONObject2)) {
            cinema.setSeatOrdering(a(jSONObject2, "seat_ordering"));
        }
        poiItemDetail.setDeepType(DeepType.CINEMA);
        poiItemDetail.setCinema(cinema);
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            regeocodeRoad.setId(b(jSONObject, SyncShoesDataService.d));
            regeocodeRoad.setName(b(jSONObject, "name"));
            regeocodeRoad.setLatLngPoint(c(jSONObject, a.l));
            regeocodeRoad.setDirection(b(jSONObject, "direction"));
            regeocodeRoad.setDistance(j(b(jSONObject, cn.com.smartdevices.bracelet.relation.db.a.g)));
            arrayList.add(regeocodeRoad);
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static LatLonPoint c(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str)) ? f(jSONObject.optString(str)) : null;
    }

    public static DriveRouteResult c(String str) {
        DriveRouteResult driveRouteResult = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                driveRouteResult = new DriveRouteResult();
                jSONObject = jSONObject.getJSONObject("route");
                driveRouteResult.setStartPos(c(jSONObject, "origin"));
                driveRouteResult.setTargetPos(c(jSONObject, "destination"));
                if (jSONObject.has("paths")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("paths");
                    List arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        DrivePath drivePath = new DrivePath();
                        jSONObject = jSONArray.getJSONObject(i);
                        drivePath.setDistance(j(b(jSONObject, cn.com.smartdevices.bracelet.relation.db.a.g)));
                        drivePath.setDuration(k(b(jSONObject, "duration")));
                        drivePath.setStrategy(b(jSONObject, "strategy"));
                        drivePath.setTolls(j(b(jSONObject, "tolls")));
                        drivePath.setTollDistance(j(b(jSONObject, "toll_distance")));
                        if (jSONObject.has("steps")) {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("steps");
                            List arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                DriveStep driveStep = new DriveStep();
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                                driveStep.setInstruction(b(jSONObject2, "instruction"));
                                driveStep.setOrientation(b(jSONObject2, "orientation"));
                                driveStep.setRoad(b(jSONObject2, "road"));
                                driveStep.setDistance(j(b(jSONObject2, cn.com.smartdevices.bracelet.relation.db.a.g)));
                                driveStep.setTolls(j(b(jSONObject2, "tolls")));
                                driveStep.setTollDistance(j(b(jSONObject2, "toll_distance")));
                                driveStep.setTollRoad(b(jSONObject2, "toll_road"));
                                driveStep.setDuration(j(b(jSONObject2, "duration")));
                                driveStep.setPolyline(d(jSONObject2, "polyline"));
                                driveStep.setAction(b(jSONObject2, AuthActivity.ACTION_KEY));
                                driveStep.setAssistantAction(b(jSONObject2, "assistant_action"));
                                a(driveStep, jSONObject2);
                                arrayList2.add(driveStep);
                            }
                            drivePath.setSteps(arrayList2);
                        }
                        arrayList.add(drivePath);
                    }
                    driveRouteResult.setPaths(arrayList);
                }
            }
            return driveRouteResult;
        } catch (JSONException e) {
            throw new AMapException(AMapException.ERROR_PROTOCOL);
        }
    }

    public static ArrayList<PoiItem> c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList<PoiItem> arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(d(optJSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static void c(PoiItemDetail poiItemDetail, JSONObject jSONObject) {
        if (jSONObject.has("discounts")) {
            JSONArray jSONArray = jSONObject.getJSONArray("discounts");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Discount discount = new Discount();
                discount.setTitle(b(jSONObject2, SocialConstants.PARAM_TITLE));
                discount.setDetail(b(jSONObject2, f.au));
                discount.setStartTime(e.c(b(jSONObject2, "start_time")));
                discount.setEndTime(e.c(b(jSONObject2, "end_time")));
                discount.setSoldCount(i(b(jSONObject2, "sold_num")));
                discount.setUrl(b(jSONObject2, SocialConstants.PARAM_URL));
                discount.setProvider(b(jSONObject2, "provider"));
                a(discount, jSONObject2);
                poiItemDetail.addDiscount(discount);
            }
        }
    }

    public static void c(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        Hotel hotel = new Hotel();
        hotel.setStar(b(jSONObject, "star"));
        hotel.setIntro(b(jSONObject, "intro"));
        hotel.setRating(b(jSONObject, "rating"));
        hotel.setLowestPrice(b(jSONObject, "lowest_price"));
        hotel.setDeepsrc(b(jSONObject, "deepsrc"));
        hotel.setFaciRating(b(jSONObject, "faci_rating"));
        hotel.setHealthRating(b(jSONObject, "health_rating"));
        hotel.setEnvironmentRating(b(jSONObject, "environment_rating"));
        hotel.setServiceRating(b(jSONObject, "service_rating"));
        hotel.setTraffic(b(jSONObject, "traffic"));
        hotel.setAddition(b(jSONObject, "addition"));
        hotel.setPhotos(l(jSONObject));
        poiItemDetail.setDeepType(DeepType.HOTEL);
        poiItemDetail.setHotel(hotel);
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            PoiItem poiItem = new PoiItem(b(jSONObject, SyncShoesDataService.d), c(jSONObject, a.l), b(jSONObject, "name"), com.xiaomi.e.a.f);
            poiItem.setDirection(b(jSONObject, "direction"));
            poiItem.setDistance(i(b(jSONObject, cn.com.smartdevices.bracelet.relation.db.a.g)));
            poiItem.setTel(b(jSONObject, "tel"));
            poiItem.setTypeDes(b(jSONObject, a.h));
            arrayList.add(poiItem);
        }
        regeocodeAddress.setPois(arrayList);
    }

    public static PoiItemDetail d(JSONObject jSONObject) {
        PoiItemDetail poiItemDetail = new PoiItemDetail(b(jSONObject, SyncShoesDataService.d), c(jSONObject, a.l), b(jSONObject, "name"), b(jSONObject, "address"));
        poiItemDetail.setAdCode(b(jSONObject, "adcode"));
        poiItemDetail.setProvinceName(b(jSONObject, "pname"));
        poiItemDetail.setCityName(b(jSONObject, "cityname"));
        poiItemDetail.setAdName(b(jSONObject, "adname"));
        poiItemDetail.setCityCode(b(jSONObject, "citycode"));
        poiItemDetail.setProvinceCode(b(jSONObject, "pcode"));
        if (jSONObject.has(cn.com.smartdevices.bracelet.relation.db.a.g)) {
            String string = jSONObject.getString(cn.com.smartdevices.bracelet.relation.db.a.g);
            if (!h(string)) {
                try {
                    poiItemDetail.setDistance(Integer.parseInt(string));
                } catch (NumberFormatException e) {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (poiItemDetail.getDistance() == 0) {
                    poiItemDetail.setDistance(-1);
                }
            }
        }
        poiItemDetail.setTel(b(jSONObject, "tel"));
        poiItemDetail.setTypeDes(b(jSONObject, a.h));
        poiItemDetail.setEnter(c(jSONObject, "entr_location"));
        poiItemDetail.setExit(c(jSONObject, "exit_location"));
        poiItemDetail.setWebsite(b(jSONObject, "website"));
        poiItemDetail.setPostcode(b(jSONObject, "citycode"));
        poiItemDetail.setEmail(b(jSONObject, f.Y));
        if (g(b(jSONObject, "groupbuy_num"))) {
            poiItemDetail.setGroupbuyInfo(false);
        } else {
            poiItemDetail.setGroupbuyInfo(true);
        }
        if (g(b(jSONObject, "discount_num"))) {
            poiItemDetail.setDiscountInfo(false);
        } else {
            poiItemDetail.setDiscountInfo(true);
        }
        if (g(b(jSONObject, "indoor_map"))) {
            poiItemDetail.setIndoorMap(false);
        } else {
            poiItemDetail.setIndoorMap(true);
        }
        return poiItemDetail;
    }

    public static WalkRouteResult d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("route");
                walkRouteResult.setStartPos(c(jSONObject2, "origin"));
                walkRouteResult.setTargetPos(c(jSONObject2, "destination"));
                if (!jSONObject2.has("paths")) {
                    return walkRouteResult;
                }
                JSONArray jSONArray = jSONObject2.getJSONArray("paths");
                List arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    WalkPath walkPath = new WalkPath();
                    jSONObject2 = jSONArray.getJSONObject(i);
                    walkPath.setDistance(j(b(jSONObject2, cn.com.smartdevices.bracelet.relation.db.a.g)));
                    walkPath.setDuration(k(b(jSONObject2, "duration")));
                    if (jSONObject2.has("steps")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("steps");
                        List arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            WalkStep walkStep = new WalkStep();
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            walkStep.setInstruction(b(jSONObject3, "instruction"));
                            walkStep.setOrientation(b(jSONObject3, "orientation"));
                            walkStep.setRoad(b(jSONObject3, "road"));
                            walkStep.setDistance(j(b(jSONObject3, cn.com.smartdevices.bracelet.relation.db.a.g)));
                            walkStep.setDuration(j(b(jSONObject3, "duration")));
                            walkStep.setPolyline(d(jSONObject3, "polyline"));
                            walkStep.setAction(b(jSONObject3, AuthActivity.ACTION_KEY));
                            walkStep.setAssistantAction(b(jSONObject3, "assistant_action"));
                            arrayList2.add(walkStep);
                        }
                        walkPath.setSteps(arrayList2);
                    }
                    arrayList.add(walkPath);
                }
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            } catch (JSONException e) {
                return walkRouteResult;
            }
        } catch (JSONException e2) {
            return null;
        }
    }

    public static ArrayList<LatLonPoint> d(JSONObject jSONObject, String str) {
        return jSONObject.has(str) ? e(jSONObject.getString(str)) : null;
    }

    public static void d(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        Dining dining = new Dining();
        dining.setCuisines(b(jSONObject, "cuisines"));
        dining.setTag(b(jSONObject, f.aC));
        dining.setIntro(b(jSONObject, "intro"));
        dining.setRating(b(jSONObject, "rating"));
        dining.setCpRating(b(jSONObject, "cp_rating"));
        dining.setDeepsrc(b(jSONObject, "deepsrc"));
        dining.setTasteRating(b(jSONObject, "taste_rating"));
        dining.setEnvironmentRating(b(jSONObject, "environment_rating"));
        dining.setServiceRating(b(jSONObject, "service_rating"));
        dining.setCost(b(jSONObject, "cost"));
        dining.setRecommend(b(jSONObject, a.B));
        dining.setAtmosphere(b(jSONObject, "atmosphere"));
        dining.setOrderingWapUrl(b(jSONObject, "ordering_wap_url"));
        dining.setOrderingWebUrl(b(jSONObject, "ordering_web_url"));
        dining.setOrderinAppUrl(b(jSONObject, "ordering_app_url"));
        dining.setOpentimeGDF(b(jSONObject, "opentime_GDF"));
        dining.setOpentime(b(jSONObject, "opentime"));
        dining.setAddition(b(jSONObject, "addition"));
        dining.setPhotos(l(jSONObject));
        if (k(jSONObject2)) {
            dining.setMealOrdering(a(jSONObject2, "meal_ordering"));
        }
        poiItemDetail.setDeepType(DeepType.DINING);
        poiItemDetail.setDining(dining);
    }

    public static ArrayList<LatLonPoint> e(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList();
        String[] split = str.split(";");
        for (String f : split) {
            arrayList.add(f(f));
        }
        return arrayList;
    }

    public static ArrayList<BusStationItem> e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList<BusStationItem> arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(f(optJSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static void e(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            String b = b(jSONObject, a.h);
            if (b.equalsIgnoreCase("hotel")) {
                c(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("dining")) {
                d(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("cinema")) {
                b(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("scenic")) {
                a(poiItemDetail, jSONObject, jSONObject2);
            }
        }
    }

    public static BusStationItem f(JSONObject jSONObject) {
        BusStationItem g = g(jSONObject);
        g.setAdCode(b(jSONObject, "adcode"));
        g.setCityCode(b(jSONObject, "citycode"));
        JSONArray jSONArray = jSONObject.getJSONArray("buslines");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(h(jSONArray.getJSONObject(i)));
        }
        g.setBusLineItems(arrayList);
        return g;
    }

    public static LatLonPoint f(String str) {
        if (str == null || str.equals(com.xiaomi.e.a.f) || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(com.xiaomi.mipush.sdk.f.i);
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    public static BusStationItem g(JSONObject jSONObject) {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(b(jSONObject, SyncShoesDataService.d));
        busStationItem.setLatLonPoint(c(jSONObject, a.l));
        busStationItem.setBusStationName(b(jSONObject, "name"));
        return busStationItem;
    }

    public static boolean g(String str) {
        return str == null || str.equals(com.xiaomi.e.a.f) || str.equals(Constants.VIA_RESULT_SUCCESS);
    }

    public static BusLineItem h(JSONObject jSONObject) {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(b(jSONObject, SyncShoesDataService.d));
        busLineItem.setBusLineType(b(jSONObject, a.h));
        busLineItem.setBusLineName(b(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(d(jSONObject, "polyline"));
        busLineItem.setCityCode(b(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(b(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(b(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static boolean h(String str) {
        return str == null || str.equals(com.xiaomi.e.a.f);
    }

    public static int i(String str) {
        int i = 0;
        if (!(str == null || str.equals(com.xiaomi.e.a.f) || str.equals("[]"))) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public static ArrayList<BusLineItem> i(JSONObject jSONObject) {
        ArrayList<BusLineItem> arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("buslines");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(j(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static float j(String str) {
        float f = 0.0f;
        if (!(str == null || str.equals(com.xiaomi.e.a.f) || str.equals("[]"))) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException e) {
            }
        }
        return f;
    }

    public static BusLineItem j(JSONObject jSONObject) {
        BusLineItem h = h(jSONObject);
        h.setFirstBusTime(e.d(b(jSONObject, "start_time")));
        h.setLastBusTime(e.d(b(jSONObject, "end_time")));
        h.setBusCompany(b(jSONObject, a.o));
        h.setDistance(j(b(jSONObject, cn.com.smartdevices.bracelet.relation.db.a.g)));
        h.setBasicPrice(j(b(jSONObject, "basic_price")));
        h.setTotalPrice(j(b(jSONObject, "total_price")));
        h.setBounds(d(jSONObject, "bounds"));
        JSONArray jSONArray = jSONObject.getJSONArray("busstops");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(g(jSONArray.getJSONObject(i)));
        }
        h.setBusStations(arrayList);
        return h;
    }

    public static long k(String str) {
        long j = 0;
        if (!(str == null || str.equals(com.xiaomi.e.a.f) || str.equals("[]"))) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static boolean k(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has("biz_ext");
    }

    public static List<Photo> l(JSONObject jSONObject) {
        List arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("photos");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    Photo photo = new Photo();
                    photo.setTitle(b(optJSONObject, SocialConstants.PARAM_TITLE));
                    photo.setUrl(b(optJSONObject, SocialConstants.PARAM_URL));
                    arrayList.add(photo);
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    public static boolean l(String str) {
        return (str == null || str.equals(com.xiaomi.e.a.f) || str.equals("[]") || str.equals(Constants.VIA_RESULT_SUCCESS) || !str.equals(Constants.VIA_TO_TYPE_QQ_GROUP)) ? false : true;
    }

    public static DistrictItem m(JSONObject jSONObject) {
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(b(jSONObject, "citycode"));
        districtItem.setAdcode(b(jSONObject, "adcode"));
        districtItem.setName(b(jSONObject, "name"));
        districtItem.setLevel(b(jSONObject, "level"));
        districtItem.setCenter(c(jSONObject, "center"));
        a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    public static ArrayList<GeocodeAddress> n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList<GeocodeAddress> arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            GeocodeAddress geocodeAddress = new GeocodeAddress();
            geocodeAddress.setFormatAddress(b(jSONObject2, "formatted_address"));
            geocodeAddress.setProvince(b(jSONObject2, DistrictSearchQuery.KEYWORDS_PROVINCE));
            geocodeAddress.setCity(b(jSONObject2, DistrictSearchQuery.KEYWORDS_CITY));
            geocodeAddress.setDistrict(b(jSONObject2, DistrictSearchQuery.KEYWORDS_DISTRICT));
            geocodeAddress.setTownship(b(jSONObject2, "township"));
            geocodeAddress.setNeighborhood(b(jSONObject2.getJSONObject("neighborhood"), "name"));
            geocodeAddress.setBuilding(b(jSONObject2.getJSONObject("building"), "name"));
            geocodeAddress.setAdcode(b(jSONObject2, "adcode"));
            geocodeAddress.setLatLonPoint(c(jSONObject2, a.l));
            geocodeAddress.setLevel(b(jSONObject2, "level"));
            arrayList.add(geocodeAddress);
        }
        return arrayList;
    }

    public static ArrayList<Tip> o(JSONObject jSONObject) {
        ArrayList<Tip> arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("tips");
        for (int i = 0; i < jSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            tip.setName(b(jSONObject2, "name"));
            tip.setDistrict(b(jSONObject2, DistrictSearchQuery.KEYWORDS_DISTRICT));
            tip.setAdcode(b(jSONObject2, "adcode"));
            arrayList.add(tip);
        }
        return arrayList;
    }

    public static BusStep p(JSONObject jSONObject) {
        BusStep busStep = new BusStep();
        if (jSONObject.has("walking")) {
            try {
                busStep.setWalk(q(jSONObject.getJSONObject("walking")));
            } catch (JSONException e) {
            }
        }
        if (jSONObject.has("bus")) {
            busStep.setBusLines(r(jSONObject.getJSONObject("bus")));
        }
        if (jSONObject.has("entrance")) {
            try {
                busStep.setEntrance(s(jSONObject.getJSONObject("entrance")));
            } catch (Exception e2) {
            }
        }
        if (jSONObject.has(NativeInterface.EXIT)) {
            try {
                busStep.setExit(s(jSONObject.getJSONObject(NativeInterface.EXIT)));
            } catch (JSONException e3) {
            }
        }
        return busStep;
    }

    public static RouteBusWalkItem q(JSONObject jSONObject) {
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(c(jSONObject, "origin"));
        routeBusWalkItem.setDestination(c(jSONObject, "destination"));
        routeBusWalkItem.setDistance(j(b(jSONObject, cn.com.smartdevices.bracelet.relation.db.a.g)));
        routeBusWalkItem.setDuration(k(b(jSONObject, "duration")));
        if (!jSONObject.has("steps")) {
            return routeBusWalkItem;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("steps");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(t(jSONArray.getJSONObject(i)));
        }
        routeBusWalkItem.setSteps(arrayList);
        return routeBusWalkItem;
    }

    public static List<RouteBusLineItem> r(JSONObject jSONObject) {
        List<RouteBusLineItem> arrayList = new ArrayList();
        if (!jSONObject.has("buslines")) {
            return arrayList;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("buslines");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(u(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static Doorway s(JSONObject jSONObject) {
        Doorway doorway = new Doorway();
        doorway.setName(b(jSONObject, "name"));
        doorway.setLatLonPoint(c(jSONObject, a.l));
        return doorway;
    }

    public static WalkStep t(JSONObject jSONObject) {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(b(jSONObject, "instruction"));
        walkStep.setOrientation(b(jSONObject, "orientation"));
        walkStep.setRoad(b(jSONObject, "road"));
        walkStep.setDistance(j(b(jSONObject, cn.com.smartdevices.bracelet.relation.db.a.g)));
        walkStep.setDuration(j(b(jSONObject, "duration")));
        walkStep.setPolyline(d(jSONObject, "polyline"));
        walkStep.setAction(b(jSONObject, AuthActivity.ACTION_KEY));
        walkStep.setAssistantAction(b(jSONObject, "assistant_action"));
        return walkStep;
    }

    public static RouteBusLineItem u(JSONObject jSONObject) {
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        if (jSONObject.has("departure_stop")) {
            routeBusLineItem.setDepartureBusStation(w(jSONObject.getJSONObject("departure_stop")));
        }
        if (jSONObject.has("arrival_stop")) {
            routeBusLineItem.setArrivalBusStation(w(jSONObject.getJSONObject("arrival_stop")));
        }
        routeBusLineItem.setBusLineName(b(jSONObject, "name"));
        routeBusLineItem.setBusLineId(b(jSONObject, SyncShoesDataService.d));
        routeBusLineItem.setBusLineType(b(jSONObject, a.h));
        routeBusLineItem.setDistance(j(b(jSONObject, cn.com.smartdevices.bracelet.relation.db.a.g)));
        routeBusLineItem.setDuration(j(b(jSONObject, "duration")));
        routeBusLineItem.setPolyline(d(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(e.d(b(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(e.d(b(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(i(b(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(v(jSONObject));
        return routeBusLineItem;
    }

    public static List<BusStationItem> v(JSONObject jSONObject) {
        List<BusStationItem> arrayList = new ArrayList();
        if (!jSONObject.has("via_stops")) {
            return arrayList;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("via_stops");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(w(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static BusStationItem w(JSONObject jSONObject) {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(b(jSONObject, "name"));
        busStationItem.setBusStationId(b(jSONObject, SyncShoesDataService.d));
        busStationItem.setLatLonPoint(c(jSONObject, a.l));
        return busStationItem;
    }
}

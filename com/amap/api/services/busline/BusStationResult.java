package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.core.c;
import java.util.ArrayList;
import java.util.List;

public final class BusStationResult {
    private int a;
    private ArrayList<BusStationItem> b;
    private BusStationQuery c;
    private List<String> d;
    private List<SuggestionCity> e;

    private BusStationResult(c cVar, ArrayList<?> arrayList) {
        this.c = (BusStationQuery) cVar.a();
        this.a = a(cVar.b());
        this.e = cVar.d();
        this.d = cVar.c();
        this.b = arrayList;
    }

    private int a(int i) {
        int pageSize = this.c.getPageSize();
        pageSize = ((i + pageSize) - 1) / pageSize;
        return pageSize > 30 ? 30 : pageSize;
    }

    static BusStationResult a(c cVar, ArrayList<?> arrayList) {
        return new BusStationResult(cVar, arrayList);
    }

    public List<BusStationItem> getBusStations() {
        return this.b;
    }

    public int getPageCount() {
        return this.a;
    }

    public BusStationQuery getQuery() {
        return this.c;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.d;
    }
}

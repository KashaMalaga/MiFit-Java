package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.core.c;
import java.util.ArrayList;
import java.util.List;

public final class BusLineResult {
    private int a;
    private ArrayList<BusLineItem> b;
    private BusLineQuery c;
    private List<String> d;
    private List<SuggestionCity> e;

    private BusLineResult(c cVar, ArrayList<?> arrayList) {
        this.c = (BusLineQuery) cVar.a();
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

    static BusLineResult a(c cVar, ArrayList<?> arrayList) {
        return new BusLineResult(cVar, arrayList);
    }

    public List<BusLineItem> getBusLines() {
        return this.b;
    }

    public int getPageCount() {
        return this.a;
    }

    public BusLineQuery getQuery() {
        return this.c;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.d;
    }
}

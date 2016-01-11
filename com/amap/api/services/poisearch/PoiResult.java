package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.core.r;
import com.amap.api.services.poisearch.PoiSearch.Query;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import java.util.ArrayList;
import java.util.List;

public final class PoiResult {
    private int a;
    private ArrayList<PoiItem> b;
    private r c;

    private PoiResult(r rVar, ArrayList<PoiItem> arrayList) {
        this.c = rVar;
        this.a = a(rVar.b());
        this.b = arrayList;
    }

    private int a(int i) {
        int a = this.c.a();
        a = ((i + a) - 1) / a;
        return a > 30 ? 30 : a;
    }

    static PoiResult a(r rVar, ArrayList<PoiItem> arrayList) {
        return new PoiResult(rVar, arrayList);
    }

    public SearchBound getBound() {
        return this.c.d();
    }

    public int getPageCount() {
        return this.a;
    }

    public ArrayList<PoiItem> getPois() {
        return this.b;
    }

    public Query getQuery() {
        return this.c.c();
    }

    public List<SuggestionCity> getSearchSuggestionCitys() {
        return this.c.f();
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.c.e();
    }
}

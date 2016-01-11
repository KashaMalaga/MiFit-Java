package android.support.v4.widget;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

class aC {
    aC() {
    }

    public static View a(Context context) {
        return new SearchView(context);
    }

    public static CharSequence a(View view) {
        return ((SearchView) view).getQuery();
    }

    public static Object a(aF aFVar) {
        return new aE(aFVar);
    }

    public static Object a(aG aGVar) {
        return new aD(aGVar);
    }

    public static void a(View view, int i) {
        ((SearchView) view).setMaxWidth(i);
    }

    public static void a(View view, ComponentName componentName) {
        SearchView searchView = (SearchView) view;
        searchView.setSearchableInfo(((SearchManager) searchView.getContext().getSystemService("search")).getSearchableInfo(componentName));
    }

    public static void a(View view, CharSequence charSequence) {
        ((SearchView) view).setQueryHint(charSequence);
    }

    public static void a(View view, CharSequence charSequence, boolean z) {
        ((SearchView) view).setQuery(charSequence, z);
    }

    public static void a(View view, boolean z) {
        ((SearchView) view).setIconified(z);
    }

    public static void a(Object obj, Object obj2) {
        ((SearchView) obj).setOnQueryTextListener((OnQueryTextListener) obj2);
    }

    public static void b(View view, boolean z) {
        ((SearchView) view).setSubmitButtonEnabled(z);
    }

    public static void b(Object obj, Object obj2) {
        ((SearchView) obj).setOnCloseListener((OnCloseListener) obj2);
    }

    public static boolean b(View view) {
        return ((SearchView) view).isIconified();
    }

    public static void c(View view, boolean z) {
        ((SearchView) view).setQueryRefinementEnabled(z);
    }

    public static boolean c(View view) {
        return ((SearchView) view).isSubmitButtonEnabled();
    }

    public static boolean d(View view) {
        return ((SearchView) view).isQueryRefinementEnabled();
    }
}

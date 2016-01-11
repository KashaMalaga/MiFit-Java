package cn.com.smartdevices.bracelet.notification;

import android.app.ListFragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import com.huami.android.view.b;
import com.xiaomi.hm.health.l;
import java.util.List;

public class e extends ListFragment implements LoaderCallbacks<List<c>>, OnQueryTextListener {
    d a;
    String b;

    public void a(Loader<List<c>> loader, List<c> list) {
        this.a.a(list);
        if (isResumed()) {
            setListShown(true);
        } else {
            setListShownNoAnimation(true);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyText("No applications");
        setHasOptionsMenu(true);
        this.a = new d(getActivity());
        setListAdapter(this.a);
        setListShown(false);
        getListView().setDivider(null);
        getListView().setDividerHeight(0);
        getLoaderManager().initLoader(0, null, this);
    }

    public Loader<List<c>> onCreateLoader(int i, Bundle bundle) {
        return new f(getActivity());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        MenuItem add = menu.add("Search");
        add.setIcon(17301583);
        add.setShowAsAction(9);
        View searchView = new SearchView(getActivity());
        searchView.setOnQueryTextListener(this);
        add.setActionView(searchView);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Log.i("LoaderCustom", "Item clicked: " + j);
        h a = h.a(getActivity());
        CheckBox checkBox = (CheckBox) view.findViewById(l.check);
        c cVar;
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            cVar = (c) this.a.getItem(i);
            cVar.g = true;
            a.a(cVar.a().packageName);
        } else if (a.b() == 50) {
            b.a(getActivity(), "\u6700\u591a\u53ef\u9009\u62e9\u4e09\u4e2a\u5e94\u7528", 0).show();
        } else {
            checkBox.setChecked(true);
            cVar = (c) this.a.getItem(i);
            cVar.g = true;
            a aVar = new a();
            aVar.a = cVar.a().packageName;
            a.a(aVar);
        }
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (List) obj);
    }

    public void onLoaderReset(Loader<List<c>> loader) {
        this.a.a(null);
    }

    public boolean onQueryTextChange(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.b = str;
        this.a.getFilter().filter(this.b);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        return true;
    }
}

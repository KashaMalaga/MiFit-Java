package kankan.wheel.widget.a;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public abstract class a implements f {
    private List<DataSetObserver> a;

    public View a(View view, ViewGroup viewGroup) {
        return null;
    }

    public void a(DataSetObserver dataSetObserver) {
        if (this.a == null) {
            this.a = new LinkedList();
        }
        this.a.add(dataSetObserver);
    }

    public void b(DataSetObserver dataSetObserver) {
        if (this.a != null) {
            this.a.remove(dataSetObserver);
        }
    }

    protected void e() {
        if (this.a != null) {
            for (DataSetObserver onChanged : this.a) {
                onChanged.onChanged();
            }
        }
    }

    protected void f() {
        if (this.a != null) {
            for (DataSetObserver onInvalidated : this.a) {
                onInvalidated.onInvalidated();
            }
        }
    }
}

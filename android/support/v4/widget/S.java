package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

public class S extends C0203a {
    private final ListView g;

    public S(ListView listView) {
        super(listView);
        this.g = listView;
    }

    public void a(int i, int i2) {
        ListView listView = this.g;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i2);
            }
        }
    }

    public boolean e(int i) {
        return false;
    }

    public boolean f(int i) {
        ListView listView = this.g;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}

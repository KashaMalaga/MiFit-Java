package android.support.v4.widget;

import android.view.View.OnTouchListener;
import android.widget.PopupMenu;

class C0213af {
    C0213af() {
    }

    public static OnTouchListener a(Object obj) {
        return ((PopupMenu) obj).getDragToOpenListener();
    }
}

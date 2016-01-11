package com.huami.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TypefaceTextView extends TextView {
    public TypefaceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f.a().a(this, context, attributeSet);
    }

    public void a(g gVar) {
        f.a().a((TextView) this, gVar);
    }
}

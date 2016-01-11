package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.xiaomi.e.a;

public class ClearEditText extends EditText implements TextWatcher, OnFocusChangeListener {
    private Drawable a;
    private boolean b;
    private boolean c;

    public ClearEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.a = getCompoundDrawables()[2];
        if (this.a == null) {
            this.a = getResources().getDrawable(17301560);
        }
        this.a.setBounds(0, 0, this.a.getIntrinsicWidth(), this.a.getIntrinsicHeight());
        a(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
        setLongClickable(false);
        setTextIsSelectable(false);
    }

    private void b() {
        boolean z = getText().length() > 0;
        if (this.c && z) {
            a(true);
        } else {
            a(false);
        }
    }

    protected void a(boolean z) {
        this.b = z;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.a : null, getCompoundDrawables()[3]);
    }

    public void afterTextChanged(Editable editable) {
        b();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onFocusChange(View view, boolean z) {
        this.c = z;
        b();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() == 1 && getCompoundDrawables()[2] != null) {
            if (motionEvent.getX() <= ((float) (getWidth() - getTotalPaddingRight())) || motionEvent.getX() >= ((float) (getWidth() - getPaddingRight()))) {
                z = false;
            }
            if (this.b && r0) {
                setText(a.f);
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}

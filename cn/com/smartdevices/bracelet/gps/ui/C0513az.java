package cn.com.smartdevices.bracelet.gps.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class C0513az implements TextWatcher {
    final /* synthetic */ C0510aw a;
    private int b = 0;
    private EditText c = null;

    public C0513az(C0510aw c0510aw, int i, EditText editText) {
        this.a = c0510aw;
        this.b = i;
        this.c = editText;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Editable text = this.c.getText();
        if (text.length() > this.b) {
            this.c.startAnimation(this.a.e);
            Object trim = text.toString().trim();
            int length = trim.length();
            if (length <= this.b) {
                this.c.setText(trim);
                this.c.setSelection(length);
                return;
            }
            this.c.setText(trim.substring(0, this.b));
            this.c.setSelection(this.b);
        }
    }
}

package cn.com.smartdevices.bracelet.lab.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class ai implements TextWatcher {
    final /* synthetic */ SportVoteOthersActivity a;
    private int b = 0;
    private EditText c = null;

    public ai(SportVoteOthersActivity sportVoteOthersActivity, int i, EditText editText) {
        this.a = sportVoteOthersActivity;
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
            this.c.startAnimation(this.a.d);
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

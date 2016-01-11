package cn.com.smartdevices.bracelet.lab.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class al implements OnFocusChangeListener {
    final /* synthetic */ StepsCountActivity a;

    al(StepsCountActivity stepsCountActivity) {
        this.a = stepsCountActivity;
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            EditText editText = (EditText) view;
            int length = editText.getText().toString().length();
            if (length > 0) {
                editText.setSelection(length);
            }
        }
    }
}

package cn.com.smartdevices.bracelet.weight;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;

class C0881s implements TextWatcher {
    EditText a;
    final /* synthetic */ RecordWeightActivity b;
    private boolean c = false;

    public C0881s(RecordWeightActivity recordWeightActivity, EditText editText) {
        this.b = recordWeightActivity;
        this.a = editText;
    }

    public void afterTextChanged(Editable editable) {
        if (!this.c) {
            Object obj;
            boolean z;
            String obj2 = editable.toString();
            if (obj2.isEmpty()) {
                this.b.j.setClickable(false);
                this.b.j.setTextColor(this.b.a.getResources().getColor(R.color.disable_text_color_dark));
            } else {
                this.b.j.setClickable(true);
                this.b.j.setTextColor(this.b.a.getResources().getColor(R.color.content_color));
            }
            this.c = true;
            int length = obj2.length() - 1;
            while (length >= 0) {
                if ('.' == obj2.charAt(length) && length == obj2.length() - 3) {
                    obj2 = obj2.substring(0, length + 2);
                    if (obj2.endsWith(".")) {
                        obj2 = obj2.substring(0, length + 1);
                    }
                    b.makeText(this.b.a, this.b.a.getResources().getText(R.string.only_one_decimal), 0).show();
                    obj = obj2;
                    z = true;
                    if (z) {
                        this.a.setText(obj);
                        this.a.setSelection(obj.length());
                    }
                    this.c = false;
                }
                length--;
            }
            String str = obj2;
            z = false;
            if (z) {
                this.a.setText(obj);
                this.a.setSelection(obj.length());
            }
            this.c = false;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}

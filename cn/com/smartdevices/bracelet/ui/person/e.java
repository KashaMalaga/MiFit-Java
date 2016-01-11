package cn.com.smartdevices.bracelet.ui.person;

import android.text.Editable;
import android.text.TextWatcher;
import cn.com.smartdevices.bracelet.C0596r;

class e implements TextWatcher {
    final /* synthetic */ PersonInfoSetNameActivity a;

    e(PersonInfoSetNameActivity personInfoSetNameActivity) {
        this.a = personInfoSetNameActivity;
    }

    public void afterTextChanged(Editable editable) {
        C0596r.e(PersonInfoSetNameActivity.c, "afterTextChanged");
        this.a.l = this.a.f.getText().toString();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C0596r.e(PersonInfoSetNameActivity.c, "onTextChanged " + charSequence.toString());
    }
}

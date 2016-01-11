package cn.com.smartdevices.bracelet.weight.family;

import android.text.Editable;
import android.text.TextWatcher;
import cn.com.smartdevices.bracelet.C0596r;

class d implements TextWatcher {
    final /* synthetic */ MemberInfoSetNameActivity a;

    d(MemberInfoSetNameActivity memberInfoSetNameActivity) {
        this.a = memberInfoSetNameActivity;
    }

    public void afterTextChanged(Editable editable) {
        C0596r.e("MemberInfoBaseActivity", "afterTextChanged");
        this.a.o = this.a.j.getText().toString();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C0596r.e("MemberInfoBaseActivity", "onTextChanged " + charSequence.toString());
    }
}

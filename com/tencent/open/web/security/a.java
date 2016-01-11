package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.a.f;

public class a extends InputConnectionWrapper {
    public static String a;
    public static boolean b = false;
    public static boolean c = false;

    public a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    public boolean commitText(CharSequence charSequence, int i) {
        c = true;
        a = charSequence.toString();
        f.b("CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            f.c("CaptureInputConnection", "sendKeyEvent");
            a = String.valueOf((char) keyEvent.getUnicodeChar());
            c = true;
            f.b("CaptureInputConnection", "s: " + a);
        }
        f.b("CaptureInputConnection", "-->sendKeyEvent: " + a);
        return super.sendKeyEvent(keyEvent);
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        c = true;
        a = charSequence.toString();
        f.b("CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }
}

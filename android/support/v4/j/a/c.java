package android.support.v4.j.a;

import android.speech.tts.UtteranceProgressListener;

final class c extends UtteranceProgressListener {
    final /* synthetic */ e a;

    c(e eVar) {
        this.a = eVar;
    }

    public void onDone(String str) {
        this.a.a(str);
    }

    public void onError(String str) {
        this.a.b(str);
    }

    public void onStart(String str) {
        this.a.c(str);
    }
}

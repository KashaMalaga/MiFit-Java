package android.support.v4.j.a;

import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;

final class d implements OnUtteranceCompletedListener {
    final /* synthetic */ e a;

    d(e eVar) {
        this.a = eVar;
    }

    public void onUtteranceCompleted(String str) {
        this.a.c(str);
        this.a.a(str);
    }
}

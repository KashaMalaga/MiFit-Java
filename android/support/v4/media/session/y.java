package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession.Callback;
import android.os.Bundle;
import android.os.ResultReceiver;

class y<T extends x> extends Callback {
    protected final T a;

    public y(T t) {
        this.a = t;
    }

    public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.a.a(str, bundle, resultReceiver);
    }

    public void onFastForward() {
        this.a.e();
    }

    public boolean onMediaButtonEvent(Intent intent) {
        return this.a.a(intent);
    }

    public void onPause() {
        this.a.b();
    }

    public void onPlay() {
        this.a.a();
    }

    public void onRewind() {
        this.a.f();
    }

    public void onSeekTo(long j) {
        this.a.a(j);
    }

    public void onSetRating(Rating rating) {
        this.a.a((Object) rating);
    }

    public void onSkipToNext() {
        this.a.c();
    }

    public void onSkipToPrevious() {
        this.a.d();
    }

    public void onStop() {
        this.a.g();
    }
}

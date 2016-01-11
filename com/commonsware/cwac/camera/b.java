package com.commonsware.cwac.camera;

import android.graphics.Bitmap;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;

public interface b extends AutoFocusCallback {
    Parameters a(Parameters parameters);

    Parameters a(m mVar, Parameters parameters);

    Size a(int i, int i2, int i3, Parameters parameters);

    Size a(int i, int i2, int i3, Parameters parameters, Size size);

    void a();

    void a(int i, MediaRecorder mediaRecorder);

    void a(c cVar);

    void a(m mVar, Bitmap bitmap);

    void a(m mVar, byte[] bArr);

    void a(Exception exception);

    Size b(m mVar, Parameters parameters);

    void b(int i, MediaRecorder mediaRecorder);

    void c(int i, MediaRecorder mediaRecorder);

    boolean c();

    void d();

    int e();

    k f();

    ShutterCallback g();

    boolean h();

    d i();

    boolean j();

    float k();
}

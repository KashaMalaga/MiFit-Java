package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import com.edmodo.cropper.CropImageView;
import com.f.a.b.a.f;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kankan.wheel.widget.a;

public class CropImageActivity extends SystemBarTintActivity implements OnClickListener {
    public static final String a = "CROPPED_FILE_PATH";
    private static final String b = "CropImageActivity";
    private static final int f = 1080;
    private static final int g = 1920;
    private final int c = 18;
    private CropImageView d;
    private Bitmap e;
    private View h;
    private View i;

    private void a(String str) {
        InputStream openInputStream;
        Bitmap bitmap = null;
        C0596r.e(b, "path = " + str);
        try {
            openInputStream = getContentResolver().openInputStream(Uri.parse(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Object obj = bitmap;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(openInputStream, bitmap, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        C0596r.e(b, "selected image, origin width=" + i + ", height=" + i2);
        if (i * i2 > 2073600) {
            if (i / i2 >= 1) {
                i2 = (i2 * f) / i;
                i = f;
            } else {
                i = (i * g) / i2;
                i2 = g;
            }
        }
        C0596r.e(b, "selected image, new width=" + i + ", height=" + i2);
        if (i <= 0 || i2 <= 0) {
            i2 = g;
            i = f;
        }
        try {
            bitmap = C0544h.a().a(str, new f(i, i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bitmap == null) {
            b.a((Context) this, (int) R.string.get_image_file_fail, 1).show();
            setResult(0);
            finish();
            return;
        }
        this.d.a(bitmap);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 18) {
            return;
        }
        if (intent != null) {
            a(intent.getDataString());
        } else {
            finish();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_button:
                setResult(0);
                finish();
                return;
            case R.id.right_button:
                this.e = this.d.a((int) a.by, (int) a.by);
                if (this.e == null) {
                    b.a((Context) this, (int) R.string.get_image_file_fail, 1).show();
                    setResult(0);
                    finish();
                    return;
                }
                String str = Utils.j(getApplicationContext()) + "/bracelet_icon.jpg";
                try {
                    OutputStream fileOutputStream = new FileOutputStream(str);
                    this.e.compress(CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Intent intent = new Intent();
                intent.putExtra(a, str);
                setResult(-1, intent);
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.crop_image_activity);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(intent, 18);
        this.d = (CropImageView) findViewById(R.id.CropImageView);
        this.h = findViewById(R.id.right_button);
        this.h.setOnClickListener(this);
        this.i = findViewById(R.id.left_button);
        this.i.setOnClickListener(this);
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.m);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.m);
    }
}

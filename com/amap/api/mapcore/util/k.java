package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.mapcore.ay.a;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

public class k extends l {
    private TileProvider e = null;

    public k(Context context, int i, int i2) {
        super(context, i, i2);
        a(context);
    }

    private void a(Context context) {
        b(context);
    }

    private void b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            o.a("ImageFetcher", "checkConnection - no connection found", 112);
        }
    }

    private Bitmap c(a aVar) {
        o.a("ImageFetcher", "processBitmap - " + aVar, 111);
        Bitmap bitmap = null;
        try {
            Tile tile = this.e.getTile(aVar.a, aVar.b, aVar.c);
            if (!(tile == null || tile == TileProvider.NO_TILE)) {
                bitmap = BitmapFactory.decodeByteArray(tile.data, 0, tile.data.length);
            }
        } catch (Throwable th) {
        }
        return bitmap;
    }

    protected Bitmap a(Object obj) {
        return c((a) obj);
    }

    public void a(TileProvider tileProvider) {
        this.e = tileProvider;
    }
}

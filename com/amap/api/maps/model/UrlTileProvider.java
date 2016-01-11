package com.amap.api.maps.model;

import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.amap.api.mapcore.util.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private final int a;
    private final int b;

    public UrlTileProvider(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    private static long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[ChartData.d];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    private static byte[] a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return NO_TILE;
        }
        o.a("UrlTileProvider", "url: " + tileUrl.toString(), 111);
        try {
            return new Tile(this.a, this.b, a(tileUrl.openStream()));
        } catch (IOException e) {
            return NO_TILE;
        }
    }

    public int getTileHeight() {
        return this.b;
    }

    public abstract URL getTileUrl(int i, int i2, int i3);

    public int getTileWidth() {
        return this.a;
    }
}

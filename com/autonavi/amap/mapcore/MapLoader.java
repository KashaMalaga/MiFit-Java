package com.autonavi.amap.mapcore;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.view.a.C0099a;
import android.support.v4.view.a.C0113o;
import com.amap.api.mapcore.n;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.o;
import com.amap.api.maps.MapsInitializer;
import com.f.a.b.d.a;
import com.sina.weibo.sdk.utils.AidTask;
import com.xiaomi.channel.b.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class MapLoader {
    long createtime;
    int datasource = 0;
    boolean mCanceled = false;
    BaseMapCallImplement mMapCallback;
    MapCore mMapCore;
    public ArrayList<MapSourceGridData> mapTiles = new ArrayList();
    int nextImgDataLength = 0;
    byte[] recievedDataBuffer;
    int recievedDataSize = 0;
    boolean recievedHeader = false;

    public MapLoader(BaseMapCallImplement baseMapCallImplement, MapCore mapCore, int i) {
        this.mMapCallback = baseMapCallImplement;
        this.datasource = i;
        this.mMapCore = mapCore;
        this.createtime = System.currentTimeMillis();
    }

    private void processRecivedData() {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (this.nextImgDataLength == 0) {
            if (this.recievedDataSize >= 8) {
                this.nextImgDataLength = Convert.getInt(this.recievedDataBuffer, 0) + 8;
                processRecivedData();
            }
        } else if (this.recievedDataSize >= this.nextImgDataLength) {
            int i = Convert.getInt(this.recievedDataBuffer, 0);
            int i2 = Convert.getInt(this.recievedDataBuffer, 4);
            if (i2 != 0) {
                try {
                    gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(this.recievedDataBuffer, 8, i));
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[C0113o.h];
                        while (true) {
                            int read = gZIPInputStream.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        processRecivedTileData(byteArrayOutputStream.toByteArray(), 0, i2);
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            az.a(th, "MapLoader", "processRecivedData");
                            th.printStackTrace();
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            Convert.moveArray(this.recievedDataBuffer, this.nextImgDataLength, this.recievedDataBuffer, 0, this.recievedDataSize - this.nextImgDataLength);
                            this.recievedDataSize -= this.nextImgDataLength;
                            this.nextImgDataLength = 0;
                            processRecivedData();
                        } catch (Throwable th3) {
                            th = th3;
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    gZIPInputStream = null;
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    throw th;
                }
            } else if (this.datasource == 2) {
                processRecivedTileDataBmp(this.recievedDataBuffer, 8, i + 8);
            } else if (this.datasource == 4) {
                processRecivedTileDataVTmc(this.recievedDataBuffer, 8, i + 8);
            } else if (this.datasource == 6) {
                processRecivedModels(this.recievedDataBuffer, 8, i + 8);
            } else {
                processRecivedTileData(this.recievedDataBuffer, 8, i + 8);
            }
            Convert.moveArray(this.recievedDataBuffer, this.nextImgDataLength, this.recievedDataBuffer, 0, this.recievedDataSize - this.nextImgDataLength);
            this.recievedDataSize -= this.nextImgDataLength;
            this.nextImgDataLength = 0;
            processRecivedData();
        }
    }

    public void OnException(int i) {
        if (this.datasource != 4 && this.datasource != 1) {
            this.mMapCallback.OnMapLoaderError(i);
        }
    }

    public void addReuqestTiles(MapSourceGridData mapSourceGridData) {
        this.mapTiles.add(mapSourceGridData);
    }

    public void destory() {
        this.mapTiles.clear();
        this.mapTiles = null;
        this.recievedDataBuffer = null;
        VTMCDataCache.vtmcHs.clear();
        VTMCDataCache.vtmcList.clear();
    }

    public void doRequest() {
        InputStream inputStream = null;
        int i = 0;
        if (!MapsInitializer.getNetWorkEnable()) {
            return;
        }
        if (isRequestValid()) {
            Proxy proxy;
            int i2;
            String str;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mMapCallback.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                proxy = null;
                i2 = 0;
                str = null;
            } else if (activeNetworkInfo.getType() == 1) {
                str = android.net.Proxy.getHost(this.mMapCallback.getContext());
                i2 = android.net.Proxy.getPort(this.mMapCallback.getContext());
                proxy = null;
            } else {
                str = android.net.Proxy.getDefaultHost();
                i2 = android.net.Proxy.getDefaultPort();
                proxy = str != null ? new Proxy(Type.HTTP, new InetSocketAddress(str, i2)) : null;
            }
            try {
                HttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, a.b);
                HttpConnectionParams.setSoTimeout(basicHttpParams, a.b);
                HttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                defaultHttpClient.getParams().setParameter("User-Agent", n.c);
                if (proxy != null) {
                    defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(str, i2));
                }
                String str2 = this.mMapCallback.getMapSvrAddress() + "/amapsrv/MPS?" + (com.xiaomi.e.a.f + getGridParma());
                o.a("amapv2", " getTile-->" + str2, 111);
                HttpResponse execute = defaultHttpClient.execute(new HttpGet(str2));
                if (v.C == execute.getStatusLine().getStatusCode()) {
                    inputStream = execute.getEntity().getContent();
                    onConnectionOpened(this);
                    byte[] bArr = new byte[C0113o.l];
                    while (true) {
                        i2 = inputStream.read(bArr);
                        if (i2 <= -1 || !isRequestValid() || this.mCanceled) {
                            break;
                        }
                        i += i2;
                        onConnectionRecieveData(this, 0, bArr, i2);
                    }
                } else {
                    OnException(AidTask.WHAT_LOAD_AID_API_ERR);
                }
                onConnectionOver(this);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        OnException(AidTask.WHAT_LOAD_AID_API_ERR);
                    }
                }
            } catch (IOException e2) {
                OnException(AidTask.WHAT_LOAD_AID_API_ERR);
                onConnectionOver(this);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        OnException(AidTask.WHAT_LOAD_AID_API_ERR);
                    }
                }
            } catch (Throwable th) {
                onConnectionOver(this);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        OnException(AidTask.WHAT_LOAD_AID_API_ERR);
                    }
                }
            }
        } else {
            onConnectionOver(this);
        }
    }

    public String getGridParma() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.mapTiles.size(); i++) {
            stringBuffer.append(((MapSourceGridData) this.mapTiles.get(i)).getGridName() + ";");
        }
        if (stringBuffer.length() <= 0) {
            return null;
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return this.datasource == 0 ? "t=VMMV3&cp=1&mesh=" + stringBuffer.toString() : this.datasource == 1 ? "t=VMMBLDV3&cp=1&mesh=" + stringBuffer.toString() : this.datasource == 2 ? "t=BMPBM&mesh=" + stringBuffer.toString() : this.datasource == 3 ? "t=BMTI&mesh=" + stringBuffer.toString() : this.datasource == 4 ? "t=TMCV&v=6.0.1&mesh=" + stringBuffer.toString() : this.datasource == 6 ? "t=VMMV3&type=mod&cp=0&mid=" + stringBuffer.toString() : null;
    }

    public boolean isRequestValid() {
        return this.mMapCallback.isGridsInScreen(this.mapTiles, this.datasource);
    }

    public void onConnectionError(MapLoader mapLoader, int i, String str) {
    }

    public void onConnectionOpened(MapLoader mapLoader) {
        this.recievedDataBuffer = new byte[C0099a.l];
        this.nextImgDataLength = 0;
        this.recievedDataSize = 0;
        this.recievedHeader = false;
    }

    public void onConnectionOver(MapLoader mapLoader) {
        this.recievedDataBuffer = null;
        this.nextImgDataLength = 0;
        this.recievedDataSize = 0;
        if (this.mMapCallback != null && this.mMapCallback.tileProcessCtrl != null && mapLoader != null && mapLoader.mapTiles != null) {
            for (int i = 0; i < mapLoader.mapTiles.size(); i++) {
                if (((MapSourceGridData) mapLoader.mapTiles.get(i)) != null) {
                    this.mMapCallback.tileProcessCtrl.a(((MapSourceGridData) mapLoader.mapTiles.get(i)).getKeyGridName());
                }
            }
        }
    }

    public void onConnectionRecieveData(MapLoader mapLoader, int i, byte[] bArr, int i2) {
        if (mapLoader != null && bArr != null) {
            System.arraycopy(bArr, 0, this.recievedDataBuffer, this.recievedDataSize, i2);
            this.recievedDataSize += i2;
            if (!this.recievedHeader) {
                if (this.recievedDataSize <= 7) {
                    return;
                }
                if (Convert.getInt(this.recievedDataBuffer, 0) != 0) {
                    mapLoader.mCanceled = true;
                    return;
                }
                Convert.moveArray(this.recievedDataBuffer, 8, this.recievedDataBuffer, 0, i2 - 8);
                this.recievedDataSize -= 8;
                this.nextImgDataLength = 0;
                this.recievedHeader = true;
                processRecivedData();
            }
            processRecivedData();
        }
    }

    void processRecivedModels(byte[] bArr, int i, int i2) {
        if (this.mMapCore.isMapEngineValid()) {
            System.arraycopy(bArr, i, new byte[(i2 - i)], 0, i2 - i);
            this.mMapCore.putMapData(bArr, i, i2 - i, this.datasource);
        }
    }

    void processRecivedTileData(byte[] bArr, int i, int i2) {
        if (this.mMapCore.isMapEngineValid()) {
            this.mMapCore.putMapData(bArr, i, i2 - i, this.datasource);
        }
    }

    void processRecivedTileDataBmp(byte[] bArr, int i, int i2) {
        if (this.mMapCore.isMapEngineValid()) {
            this.mMapCore.putMapData(bArr, i, i2 - i, this.datasource);
        }
    }

    void processRecivedTileDataVTmc(byte[] bArr, int i, int i2) {
        String str;
        int i3 = i + 4;
        int i4 = i3 + 1;
        byte b = bArr[i3];
        String str2 = com.xiaomi.e.a.f;
        try {
            str = new String(bArr, i4, b, kankan.wheel.widget.a.bO);
        } catch (Throwable e) {
            az.a(e, "MapLoader", "processRecivedTileDataVTmc");
            e.printStackTrace();
            str = str2;
        }
        if (this.mMapCore.isMapEngineValid()) {
            VTMCDataCache instance = VTMCDataCache.getInstance();
            Object obj = new byte[(i2 - i)];
            System.arraycopy(bArr, i, obj, 0, i2 - i);
            instance.putData(str, obj);
            this.mMapCore.putMapData(bArr, i, i2 - i, this.datasource);
        }
    }
}

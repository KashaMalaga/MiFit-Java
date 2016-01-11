package a.a.a;

import android.bluetooth.BluetoothDevice;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelUuid;
import java.util.List;

public interface C0007e extends IInterface {
    List<BluetoothDevice> a();

    void a(IBinder iBinder, String str, ParcelUuid parcelUuid);

    void a(IBinder iBinder, String str, ParcelUuid parcelUuid, h hVar);

    void a(String str, ParcelUuid parcelUuid);

    boolean a(String str);

    boolean a(String str, int i);

    boolean a(String str, ParcelUuid parcelUuid, int i, k kVar);

    boolean a(String str, ParcelUuid parcelUuid, int i, byte[] bArr);

    boolean a(String str, ParcelUuid parcelUuid, String str2);

    boolean a(String str, ParcelUuid parcelUuid, byte[] bArr);

    byte[] a(String str, ParcelUuid parcelUuid, int i);

    int b();

    void b(String str, ParcelUuid parcelUuid);

    boolean b(String str, ParcelUuid parcelUuid, int i);

    boolean b(String str, ParcelUuid parcelUuid, int i, k kVar);

    byte[] b(String str, ParcelUuid parcelUuid, byte[] bArr);

    int c(String str, ParcelUuid parcelUuid);

    boolean d(String str, ParcelUuid parcelUuid);
}

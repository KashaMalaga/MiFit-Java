package cn.com.smartdevices.bracelet.datasource;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.h.e;
import com.xiaomi.hm.health.bt.model.BraceletBtInfo;
import com.xiaomi.hm.health.bt.profile.Weight.WeightHwInfo;

public class DeviceSource {
    public static final int SRC_BRACELET = 0;
    public static final int SRC_SENSORHUB = 2;
    public static final int SRC_WEIGHT = 1;
    private static final String TAG = "DeviceSource";

    public static void bindBracelet(BraceletBtInfo braceletBtInfo) {
        Keeper.keepBraceletBtInfo(braceletBtInfo);
    }

    public static void bindSensorHub(e eVar) {
        Keeper.keepSensorHubInfo(eVar);
    }

    public static void bindWeight(WeightHwInfo weightHwInfo) {
        Keeper.keepWeightHwInfo(weightHwInfo);
    }

    public static int getDeviceCount() {
        return b.h().l.a.booleanValue() ? SRC_SENSORHUB : SRC_WEIGHT;
    }

    public static boolean hasBind1S() {
        return Keeper.readBraceletBtInfo().a == 4;
    }

    public static boolean hasBindBracelet() {
        BraceletBtInfo readBraceletBtInfo = Keeper.readBraceletBtInfo();
        return readBraceletBtInfo != null && BluetoothAdapter.checkBluetoothAddress(readBraceletBtInfo.b);
    }

    public static boolean hasBindDevice() {
        return hasBindBracelet() || hasBindSensorHub() || hasBindWeight() || cn.com.smartdevices.bracelet.shoes.data.b.b(BraceletApp.a());
    }

    public static boolean hasBindDevice(Context context) {
        return hasBindBracelet() || hasBindSensorHub() || hasBindWeight() || cn.com.smartdevices.bracelet.shoes.data.b.b(context);
    }

    public static boolean hasBindPeripheralDevice() {
        return hasBindBracelet() || hasBindShoesDevice();
    }

    public static boolean hasBindSensorHub() {
        e readSensorHubInfo = Keeper.readSensorHubInfo();
        return readSensorHubInfo != null && readSensorHubInfo.e();
    }

    public static boolean hasBindShoesDevice() {
        return cn.com.smartdevices.bracelet.shoes.data.b.b(BraceletApp.a());
    }

    public static boolean hasBindStepDevice(Context context) {
        return hasBindBracelet() || hasBindSensorHub() || cn.com.smartdevices.bracelet.shoes.data.b.b(context);
    }

    public static boolean hasBindWeight() {
        WeightHwInfo readWeightHwInfo = Keeper.readWeightHwInfo();
        return readWeightHwInfo != null && readWeightHwInfo.isValid();
    }

    public static void unbindBracelet() {
        Keeper.keepBraceletBtInfo(new BraceletBtInfo());
    }

    public static void unbindSensorHub() {
        Keeper.keepSensorHubInfo(new e());
    }

    public static void unbindWeight() {
        Keeper.keepWeightHwInfo(new WeightHwInfo());
    }
}

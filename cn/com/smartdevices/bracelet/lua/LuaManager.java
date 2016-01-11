package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.activeandroid.b;
import com.xiaomi.e.a;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaZipFile;
import de.greenrobot.daobracelet.LuaZipFileDao;
import de.greenrobot.daobracelet.LuaZipFileDao.Properties;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

public class LuaManager {
    private static String LOCAL_LUA_FILE_PATH = null;
    private static final String TAG = "LuaManager";
    private static boolean TEST = false;
    private static LuaManager __instance = null;
    private Context context = null;
    private LuaState mLuaState = null;

    private String getDBLuaFileByVersion(String str) {
        LuaZipFileDao c = C0563k.a().c();
        int count = (int) c.count();
        C0596r.e(TAG, "lzipDao.count:" + count);
        if (count > 0) {
            QueryBuilder queryBuilder = c.queryBuilder();
            queryBuilder.orderDesc(Properties.Version);
            queryBuilder.where(Properties.Version.eq(str), new WhereCondition[0]);
            LuaZipFile luaZipFile = (LuaZipFile) queryBuilder.listLazy().get(0);
            C0596r.e(TAG, "luaZipFile.version:" + luaZipFile.getVersion());
            return unzip(luaZipFile.getZipFile());
        }
        C0596r.a(TAG, "read DB zip failed,version:" + str);
        return null;
    }

    private String getDefaultLuaFileVersion() {
        InputStream open;
        try {
            open = this.context.getAssets().open("lua/luafile.lua");
        } catch (IOException e) {
            e.printStackTrace();
            open = null;
        }
        if (open == null) {
            return a.f;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
        try {
            String str = "__luaVersion=";
            str = a.f;
            do {
                str = bufferedReader.readLine();
                if (str == null) {
                    open.close();
                    return null;
                }
            } while (!str.trim().startsWith("__luaVersion="));
            String substring = str.substring("__luaVersion=".length());
            open.close();
            return substring.trim();
        } catch (IOException e2) {
            e2.printStackTrace();
            C0596r.a(TAG, "read res/raw/luafile.lua version error!!");
            return null;
        }
    }

    public static LuaManager getInstance() {
        return __instance == null ? null : __instance;
    }

    public static LuaManager getInstance(Context context) {
        if (__instance == null) {
            LuaManager luaManager = new LuaManager();
            luaManager.context = context;
            luaManager.resetLuaState();
            __instance = luaManager;
        }
        LOCAL_LUA_FILE_PATH = Utils.j(context);
        C0596r.e(TAG, "LOCAL_LUA_FILE_PATH = " + LOCAL_LUA_FILE_PATH);
        return __instance;
    }

    private void getLatestDBLuaFile() {
        LuaZipFileDao c = C0563k.a().c();
        int count = (int) c.count();
        C0596r.e(TAG, "lzipDao.count:" + count);
        if (count > 0) {
            QueryBuilder queryBuilder = c.queryBuilder();
            queryBuilder.orderDesc(Properties.Version);
            LuaZipFile luaZipFile = (LuaZipFile) queryBuilder.listLazy().get(0);
            String version = luaZipFile.getVersion();
            String defaultLuaFileVersion = getDefaultLuaFileVersion();
            if (!TEST) {
                if (version.compareTo(defaultLuaFileVersion) <= 0) {
                    C0596r.a(TAG, "version compare failed: version:" + version + " default version is:" + defaultLuaFileVersion);
                    return;
                }
                C0596r.e(TAG, "use latest script, version:" + version + " (default version is:" + defaultLuaFileVersion + ")");
            }
            try {
                unZipFolder(luaZipFile.getZipFile(), LOCAL_LUA_FILE_PATH);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        C0596r.a(TAG, "read DB zip file failed");
    }

    private void getLatestLuaZipFile() {
        l.c(cn.com.smartdevices.bracelet.e.a.f(this.context), new g(this));
    }

    private void getLatestLuaZipFileWithVersionCheck() {
        l.d(cn.com.smartdevices.bracelet.e.a.f(this.context), new f(this));
    }

    private String getSDCardLuaFile(String str) {
        C0596r.e(TAG, "LOCAL_LUA_FILE_PATH=" + LOCAL_LUA_FILE_PATH);
        String str2 = LOCAL_LUA_FILE_PATH + str;
        C0596r.e(TAG, "local lua path = " + str2);
        if (new File(str2).exists()) {
            C0596r.e(TAG, "file exists: " + str2);
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str2);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            C0596r.a(TAG, "read failed: " + str2);
            return null;
        }
    }

    private String getSDCardZipLuaFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(Environment.getExternalStorageDirectory().getPath() + "/cheneeispig_hm.zip");
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return unzip(bArr);
        } catch (Exception e) {
            C0596r.a(TAG, "read sdcard/strangeName.zip failed");
            return null;
        }
    }

    private boolean loadLocalLua() {
        boolean z = false;
        String sDCardLuaFile = getSDCardLuaFile("/localization_chinese.lua");
        String sDCardLuaFile2 = getSDCardLuaFile("/localization_english.lua");
        String sDCardLuaFile3 = getSDCardLuaFile("/localization_traditional_chinese.lua");
        String sDCardLuaFile4 = getSDCardLuaFile("/localization_indo.lua");
        String sDCardLuaFile5 = getSDCardLuaFile("/localization.lua");
        String sDCardLuaFile6 = getSDCardLuaFile("/luafile.lua");
        if (sDCardLuaFile5 == null || sDCardLuaFile == null || sDCardLuaFile2 == null) {
            AssetManager assets = this.context.getAssets();
            try {
                for (String sDCardLuaFile52 : assets.list(a.f)) {
                    C0596r.e(TAG, "path = " + sDCardLuaFile52);
                }
                Object list = assets.list(MiPushMessageReceiver.LUA);
                C0596r.e(TAG, "luaList=" + list);
                for (String sDCardLuaFile522 : list) {
                    sDCardLuaFile6 = readStream(assets.open("lua/" + sDCardLuaFile522));
                    C0596r.e(TAG, "luafile=" + sDCardLuaFile522);
                    this.mLuaState.LdoString(sDCardLuaFile6);
                }
                this.mLuaState.LdoString(readStream(assets.open("lua/localization.lua")));
                this.mLuaState.LdoString(readStream(assets.open("lua/luafile.lua")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.mLuaState.LdoString(sDCardLuaFile);
            this.mLuaState.LdoString(sDCardLuaFile2);
            this.mLuaState.LdoString(sDCardLuaFile3);
            this.mLuaState.LdoString(sDCardLuaFile4);
            this.mLuaState.LdoString(sDCardLuaFile522);
            this.mLuaState.LdoString(sDCardLuaFile6);
            z = true;
        }
        C0596r.e(TAG, "testLuaLoaded = " + z);
        return z;
    }

    private void loadScriptFile() {
        if (loadLocalLua()) {
            luaSendApkVersion();
        } else {
            luaSendApkVersion();
        }
    }

    private void luaSendApkVersion() {
        ConfigDynamicDataInfo instance = ConfigDynamicDataInfo.getInstance();
        String readApkVersion = Keeper.readApkVersion();
        this.mLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "setVersion");
        this.mLuaState.pushJavaObject(instance);
        this.mLuaState.pushString(readApkVersion);
        callLua(2, 0);
    }

    private String readStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int read = inputStream.read();
            while (read != -1) {
                byteArrayOutputStream.write(read);
                read = inputStream.read();
            }
            return byteArrayOutputStream.toString();
        } catch (IOException e) {
            C0596r.a(TAG, "read res/raw/luafile.lua failed");
            return a.f;
        }
    }

    public void callLua(int i, int i2) {
        int pcall = this.mLuaState.pcall(i, i2, 0);
        if (pcall != 0) {
            C0596r.a(TAG, "LuaERROR:(" + pcall + ") " + this.mLuaState.toString(-1));
        }
    }

    public void checkServerLua() {
        getInstance().getLatestLuaZipFileWithVersionCheck();
    }

    public LuaState getLuaState() {
        return this.mLuaState;
    }

    public void resetLuaState() {
        if (this.mLuaState != null) {
            this.mLuaState.close();
        }
        this.mLuaState = LuaStateFactory.newLuaState();
        this.mLuaState.openLibs();
        loadScriptFile();
    }

    public void unZipFolder(byte[] bArr, String str) {
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bArr));
        String str2 = a.f;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    new File(str + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                } else {
                    FileOutputStream fileOutputStream = null;
                    if (!TextUtils.isEmpty(str)) {
                        File file = new File(str + File.separator + name);
                        file.createNewFile();
                        fileOutputStream = new FileOutputStream(file);
                    }
                    byte[] bArr2 = new byte[b.a];
                    while (true) {
                        int read = zipInputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        } else if (!(TextUtils.isEmpty(str) || fileOutputStream == null)) {
                            fileOutputStream.write(bArr2, 0, read);
                            fileOutputStream.flush();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }

    public String unzip(byte[] bArr) {
        String str;
        Exception e;
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bArr));
            str = null;
            while (zipInputStream.getNextEntry() != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int read = zipInputStream.read(); read != -1; read = zipInputStream.read()) {
                        byteArrayOutputStream.write(read);
                    }
                    zipInputStream.closeEntry();
                    str = byteArrayOutputStream.toString();
                } catch (IOException e2) {
                    C0596r.a(TAG, e2.getMessage());
                    e2.printStackTrace();
                    return str;
                } finally {
                    zipInputStream.close();
                }
            }
            try {
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            Exception exception = e4;
            str = null;
            e = exception;
            C0596r.a(TAG, e.getMessage());
            e.printStackTrace();
            return str;
        }
        return str;
    }
}

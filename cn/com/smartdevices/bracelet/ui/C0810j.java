package cn.com.smartdevices.bracelet.ui;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.b;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;

public class C0810j extends c {
    public static final String a = "DOWNLOAD_ID_REF";
    public static final String b = "UPDATE_DATE_REF";
    private static final String c = "ApkUpgradeFragment";
    private String d;
    private String e;
    private String f;

    protected int inflateLayout() {
        return R.layout.apk_upgrade;
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        C0596r.d(c, "onCancel();");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        this.d = arguments.getString(Utils.h);
        this.e = arguments.getString(Utils.i);
        this.f = arguments.getString(Utils.g);
        ((TextView) onCreateView.findViewById(R.id.update_apk_content)).setText(this.f);
        return onCreateView;
    }

    protected void onEmptyAreaClicked() {
        super.onEmptyAreaClicked();
        C0596r.d(c, "onEmptyAreaClicked()");
    }

    protected void onLeftButtonClicked() {
        dismiss();
    }

    protected void onRightButtonClicked() {
        b.a(getActivity(), (int) R.string.start_download, 1).show();
        Request request = new Request(Uri.parse(this.e));
        request.setAllowedNetworkTypes(3);
        request.setAllowedOverRoaming(false);
        request.setMimeType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.e)));
        request.setShowRunningNotification(true);
        request.setVisibleInDownloadsUi(true);
        String str = getString(R.string.app_name) + ".apk";
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str);
                DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService("download");
                try {
                    Keeper.keepDownloadApkId(downloadManager.enqueue(request));
                } catch (Exception e) {
                    String str2 = Environment.getExternalStorageDirectory().getPath() + "/" + str;
                    try {
                        request.setDestinationUri(Uri.parse("file://" + str2));
                        Keeper.keepDownloadApkId(downloadManager.enqueue(request));
                    } catch (Exception e2) {
                        C0596r.d(c, "upgrade apk failed : path = " + str2 + ", error = " + e2.toString());
                    }
                }
                dismiss();
                return;
            }
            Toast.makeText(getActivity(), R.string.sdcarderror, 0).show();
        } catch (Exception e22) {
            Exception exception = e22;
            C0596r.d(c, new StringBuilder().append("setDestinationInExternalPublicDir = ").append(exception).toString() != null ? exception.toString() : a.f);
            exception.printStackTrace();
        }
    }
}

package cn.com.smartdevices.bracelet.crashreport;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CrashReportDialogActivity extends Activity {
    private static final int a = 17301543;
    private String b = null;
    private String c = null;
    private Bundle d;
    private final String e = "Package name : ";
    private final String f = "Version name : ";
    private final String g = "Version code : ";

    public static String a(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        if (file != null && file.exists()) {
            try {
                Reader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine + "\n");
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                System.gc();
            }
        }
        return stringBuilder.toString();
    }

    private void a() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{this.c});
            intent.putExtra("android.intent.extra.SUBJECT", this.d.getString(CrashReportingApplication.h));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b());
            stringBuilder.append("\n\n");
            stringBuilder.append(a(new File(this.b)));
            stringBuilder.append("\n\n");
            stringBuilder.append(this.d.getString(CrashReportingApplication.i));
            stringBuilder.append("\n\n");
            intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
            intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + this.b));
            intent.setType("text/plain");
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.gc();
        }
    }

    private String b() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Package name : ").append(getPackageName()).append("\n");
        if (packageInfo != null) {
            stringBuilder.append("Version name : ").append(packageInfo.versionName).append("\n");
            stringBuilder.append("Version code : ").append(packageInfo.versionCode).append("\n");
        }
        return stringBuilder.toString();
    }

    private void c() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getIntent().getStringExtra("REPORT_FILE_NAME");
        this.c = getIntent().getStringExtra("REPORT_EMAIL");
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            finish();
        }
        requestWindowFeature(3);
        CrashReportingApplication crashReportingApplication = (CrashReportingApplication) getApplication();
        this.d = crashReportingApplication.c();
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(10, 10, 10, 10);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        View scrollView = new ScrollView(this);
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        View textView = new TextView(this);
        textView.setText(this.d.getString(CrashReportingApplication.g));
        scrollView.addView(textView, -1, -1);
        scrollView = new LinearLayout(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        scrollView.setPadding(scrollView.getPaddingLeft(), 10, scrollView.getPaddingRight(), scrollView.getPaddingBottom());
        textView = new Button(this);
        textView.setText(this.d.getString(CrashReportingApplication.c));
        textView.setOnClickListener(new a(this));
        scrollView.addView(textView, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        textView = new Button(this);
        textView.setText(this.d.getString(CrashReportingApplication.b));
        textView.setOnClickListener(new b(this));
        scrollView.addView(textView, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        CharSequence string = this.d.getString(CrashReportingApplication.d);
        if (string != null && string.length() > 0) {
            View button = new Button(this);
            button.setText(string);
            button.setOnClickListener(new c(this, crashReportingApplication));
            scrollView.addView(button, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        }
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, -2));
        setContentView(linearLayout);
        setTitle(this.d.getString(CrashReportingApplication.f));
        int i = this.d.getInt(CrashReportingApplication.e);
        if (i != 0) {
            getWindow().setFeatureDrawableResource(3, i);
        } else {
            getWindow().setFeatureDrawableResource(3, a);
        }
    }
}

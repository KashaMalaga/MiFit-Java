package android.support.v4.content;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

class k implements j {
    private final String a;
    private final HashMap<String, File> b = new HashMap();

    public k(String str) {
        this.a = str;
    }

    public Uri a(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            Entry entry = null;
            for (Entry entry2 : this.b.entrySet()) {
                Entry entry22;
                String path = ((File) entry22.getValue()).getPath();
                if (!canonicalPath.startsWith(path) || (entry != null && path.length() <= ((File) entry.getValue()).getPath().length())) {
                    entry22 = entry;
                }
                entry = entry22;
            }
            if (entry == null) {
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            }
            String path2 = ((File) entry.getValue()).getPath();
            return new Builder().scheme(ParamKey.CONTENT).authority(this.a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }

    public File a(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int indexOf = encodedPath.indexOf(47, 1);
        String decode = Uri.decode(encodedPath.substring(1, indexOf));
        String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
        File file = (File) this.b.get(decode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        File file2 = new File(file, decode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (canonicalFile.getPath().startsWith(file.getPath())) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
        }
    }

    public void a(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        try {
            this.b.put(str, file.getCanonicalFile());
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
        }
    }
}

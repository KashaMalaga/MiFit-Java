package com.xiaomi.market.sdk;

public final class q implements p {
    public static final String b = "update_download";
    public static final String c = "package_name";
    public static final String d = "download_id";
    public static final String e = "version_code";
    public static final String f = "apk_url";
    public static final String g = "apk_hash";
    public static final String h = "diff_url";
    public static final String i = "diff_hash";
    public static final String j = "apk_path";
    public static final String k = "CREATE TABLE update_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_name TEXT,download_id INTEGER, version_code INTEGER, apk_url TEXT, apk_hash TEXT, diff_url TEXT, diff_hash TEXT, apk_path TEXT, UNIQUE(package_name));";
    public static final String[] l = new String[]{"update_download.package_name", "update_download.download_id", "update_download.version_code", "update_download.apk_url", "update_download.apk_hash", "update_download.diff_url", "update_download.diff_hash", "update_download.apk_path"};
}

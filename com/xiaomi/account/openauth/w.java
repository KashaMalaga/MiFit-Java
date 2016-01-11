package com.xiaomi.account.openauth;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import com.xiaomi.channel.gamesdk.b;

final class w extends AsyncTask<Void, Void, l> {
    Exception a;
    final /* synthetic */ i b;
    final /* synthetic */ String c;
    final /* synthetic */ Activity d;
    final /* synthetic */ int e;

    w(i iVar, String str, Activity activity, int i) {
        this.b = iVar;
        this.c = str;
        this.d = activity;
        this.e = i;
    }

    protected l a(Void... voidArr) {
        try {
            return (l) this.b.a();
        } catch (OperationCanceledException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            this.a = e2;
        } catch (Exception e22) {
            this.a = e22;
        }
        return null;
    }

    protected void a(l lVar) {
        int i;
        Bundle bundle = new Bundle();
        if (lVar == null) {
            if (this.a == null) {
                i = AuthorizeActivity.c;
                bundle.putInt(h.P, AuthorizeActivity.c);
                bundle.putString(h.Q, "canceled");
            } else {
                i = AuthorizeActivity.b;
                bundle.putInt(h.P, AuthorizeActivity.b);
                bundle.putString(h.Q, this.a.getMessage());
            }
        } else if (lVar.l()) {
            i = AuthorizeActivity.b;
            bundle.putInt(h.P, lVar.j());
            bundle.putString(h.Q, lVar.k());
        } else {
            i = AuthorizeActivity.a;
            if (b.a.equalsIgnoreCase(this.c)) {
                bundle.putString(b.a, lVar.i());
                bundle.putString(h.N, lVar.e());
                bundle.putString(h.O, lVar.f());
                bundle.putString(h.J, lVar.g());
                bundle.putString(h.K, lVar.h());
            } else {
                bundle.putString(h.I, lVar.b());
                bundle.putString(h.L, lVar.c());
                bundle.putString(h.M, lVar.d());
                bundle.putString(h.N, lVar.e());
                bundle.putString(h.O, lVar.f());
                bundle.putString(h.J, lVar.g());
                bundle.putString(h.K, lVar.h());
            }
        }
        this.d.startActivityForResult(AuthorizeActivity.a(this.d, i, bundle), this.e);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((l) obj);
    }
}

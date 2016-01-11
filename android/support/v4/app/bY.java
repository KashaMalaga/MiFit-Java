package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Bundle;

class bY {
    bY() {
    }

    static Bundle a(Intent intent) {
        return RemoteInput.getResultsFromIntent(intent);
    }

    static void a(ca[] caVarArr, Intent intent, Bundle bundle) {
        RemoteInput.addResultsToIntent(a(caVarArr), intent, bundle);
    }

    static RemoteInput[] a(ca[] caVarArr) {
        if (caVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[caVarArr.length];
        for (int i = 0; i < caVarArr.length; i++) {
            ca caVar = caVarArr[i];
            remoteInputArr[i] = new Builder(caVar.a()).setLabel(caVar.b()).setChoices(caVar.c()).setAllowFreeFormInput(caVar.d()).addExtras(caVar.e()).build();
        }
        return remoteInputArr;
    }

    static ca[] a(RemoteInput[] remoteInputArr, cb cbVar) {
        if (remoteInputArr == null) {
            return null;
        }
        ca[] b = cbVar.b(remoteInputArr.length);
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInput remoteInput = remoteInputArr[i];
            b[i] = cbVar.b(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
        }
        return b;
    }
}

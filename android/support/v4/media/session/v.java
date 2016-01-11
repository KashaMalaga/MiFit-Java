package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.Token;

final class v implements Creator<Token> {
    v() {
    }

    public Token a(Parcel parcel) {
        return new Token(parcel.readParcelable(null));
    }

    public Token[] a(int i) {
        return new Token[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}

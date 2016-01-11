package com.amap.api.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.mapcore.ai;
import com.amap.api.mapcore.t;
import com.amap.api.mapcore.x;
import com.amap.api.maps.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment {
    private AMap a;
    private x b;

    public static SupportMapFragment newInstance() {
        return newInstance(new AMapOptions());
    }

    public static SupportMapFragment newInstance(AMapOptions aMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", aMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    public AMap getMap() {
        x mapFragmentDelegate = getMapFragmentDelegate();
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            t a = mapFragmentDelegate.a();
            if (a == null) {
                return null;
            }
            if (this.a == null) {
                this.a = new AMap(a);
            }
            return this.a;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    protected x getMapFragmentDelegate() {
        if (this.b == null) {
            this.b = new ai();
        }
        this.b.a(getActivity());
        return this.b;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return getMapFragmentDelegate().a(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        try {
            getMapFragmentDelegate().e();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        try {
            getMapFragmentDelegate().d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate().a(activity, new AMapOptions(), bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        try {
            getMapFragmentDelegate().f();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onPause() {
        super.onPause();
        try {
            getMapFragmentDelegate().c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        try {
            getMapFragmentDelegate().b();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().b(bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            getMapFragmentDelegate().a(0);
        } else {
            getMapFragmentDelegate().a(8);
        }
    }
}

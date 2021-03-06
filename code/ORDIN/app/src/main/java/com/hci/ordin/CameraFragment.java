package com.hci.ordin;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {


    public CameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_camera, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        FragmentManager mFragmentManager = getFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager
                .beginTransaction();

        Camera2BasicFragment newFrag = Camera2BasicFragment.newInstance();

        // Replace whatever is in the content view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        mFragmentTransaction.replace(R.id.camera_container, newFrag);

        // Commit the transaction
        mFragmentTransaction.commit();
    }

}

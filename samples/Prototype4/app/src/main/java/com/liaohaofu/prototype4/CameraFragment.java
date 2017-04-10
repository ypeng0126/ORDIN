package com.liaohaofu.prototype4;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        Fragment currentFrag = mFragmentManager.findFragmentById(R.id.camera_container);
        if (currentFrag == null || !(currentFrag instanceof Camera2BasicFragment)) {
            Camera2BasicFragment newFrag = Camera2BasicFragment.newInstance();

            // Replace whatever is in the content view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            mFragmentTransaction.replace(R.id.camera_container, newFrag);

            // Commit the transaction
            mFragmentTransaction.commit();
        }
    }

}

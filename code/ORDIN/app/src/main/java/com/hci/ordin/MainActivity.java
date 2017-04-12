package com.hci.ordin;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        getSupportActionBar().setTitle(Html.fromHtml(
                "<font color=" + String.format(
                        "#%06X", 0xFFFFFF & R.color.ordin_gray
                ) + ">Mange Faces</font>"
        ));
        FragmentManager mFragmentManager = getFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager
                .beginTransaction();
        Fragment currentFrag = mFragmentManager.findFragmentById(R.id.container_main);

        if (currentFrag == null|| !(currentFrag instanceof ManageFragment)) {
            ManageFragment newFrag = new ManageFragment();

            // Replace whatever is in the content view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            mFragmentTransaction.replace(R.id.container_main, newFrag);

            // Commit the transaction
            mFragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager mFragmentManager = getFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager
                .beginTransaction();

        if (id == R.id.nav_manage) {
            getSupportActionBar().setTitle(Html.fromHtml(
                    "<font color=" + String.format(
                            "#%06X", 0xFFFFFF & R.color.ordin_gray
                    ) + ">Mange Faces</font>"
            ));
            ManageFragment newFrag = new ManageFragment();

            // Replace whatever is in the content view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            mFragmentTransaction.replace(R.id.container_main, newFrag);

            // Commit the transaction
            mFragmentTransaction.commit();
        } else if (id == R.id.nav_register) {
            getSupportActionBar().setTitle(Html.fromHtml(
                    "<font color=" + String.format(
                            "#%06X", 0xFFFFFF & R.color.ordin_gray
                    ) + ">Register Face</font>"
            ));
            CameraFragment newFrag = new CameraFragment();

            // Replace whatever is in the content view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            mFragmentTransaction.replace(R.id.container_main, newFrag);

            // Commit the transaction
            mFragmentTransaction.commit();

        } else if (id == R.id.nav_settings) {
            getSupportActionBar().setTitle(Html.fromHtml(
                    "<font color=" + String.format(
                            "#%06X", 0xFFFFFF & R.color.ordin_gray
                    ) + ">Settings</font>"
            ));
            // Create a new fragment only when no setting fragment exists
            SettingsFragment newFragment = new SettingsFragment();

            mFragmentTransaction.replace(R.id.container_main, newFragment);

            mFragmentTransaction.commit();
        } else if (id == R.id.nav_sign_out) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

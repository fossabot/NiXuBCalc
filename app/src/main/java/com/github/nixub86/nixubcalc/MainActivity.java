package com.github.nixub86.nixubcalc;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.widget.TextView;
import android.os.Build;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //String mPhoneNumber;
    //Context mContext;
    TextView WelcomeTextView;
    String username;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WelcomeTextView = (TextView) findViewById(R.id.WelcomeTextView);

        /*if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) {
            mPhoneNumber = tMgr.getLine1Number();
        }*/

        /*Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);*/
        //sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //username = sharedPreferences.getString("PREF_USERNAME", "Guest");
        //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        //username = sharedPref.getString("PREF_USERNAME", "Guest");
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);



        //System.out.println(getPhoneNumber());
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        username = sharedPref.getString("PREF_USERNAME", "Guest");
        WelcomeTextView.setText("Здраствуй, " + username + "!");
        super.onResume();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent shennon = new Intent(this, ShennonActivity.class);
        Intent settings = new Intent(this, SettingsActivity.class);
        Intent arctan = new Intent(this, ArctanActivity.class);
        Intent combination = new Intent(this, Combination.class);

        if (id == R.id.nav_shennon) {
            startActivity(shennon);
        } else if (id == R.id.nav_settings) {
            startActivity(settings);
        } else if (id == R.id.nav_arctan) {
            startActivity(arctan);
        } else if (id == R.id.nav_combination){
            startActivity(combination);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public String getPhoneNumber() {
        String n = "";

        TelephonyManager tMgr;
        tMgr = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {

                n = tMgr.getLine1Number();
            }
        }
        if (n == null) {
            n = "";
        }
        return n != null && n.length() > 2 ? n.substring(2) : null;
    }
}

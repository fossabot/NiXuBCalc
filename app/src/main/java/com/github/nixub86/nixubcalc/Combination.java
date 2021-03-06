package com.github.nixub86.nixubcalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Combination extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText editTextKCombination;
    EditText editTextNCombination;
    Button ButtonCalculateCombination;
    TextView textViewOutputCombination;
    String editK;
    String editN;
    String output;
    Integer K;
    Integer N;
    double C;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editK = "";
        editN = "";
        output = "";

        editTextKCombination = (EditText) findViewById(R.id.editTextKCombination);
        editTextNCombination = (EditText) findViewById(R.id.editTextNCombination);
        textViewOutputCombination = (TextView) findViewById(R.id.textViewOutputCombination);

        ButtonCalculateCombination = (Button) findViewById(R.id.ButtonCalculateCombination);
        ButtonCalculateCombination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editK = editTextKCombination.getText().toString();
                editN = editTextNCombination.getText().toString();
                editK = editK.replaceAll("[^0-9]","");
                editN = editN.replaceAll("[^0-9]","");
                K = Integer.parseInt(editK);
                System.out.println(K);
                N = Integer.parseInt(editN);
                System.out.println(N);
                System.out.println(NXBMathUtils.factorial(K));
                System.out.println(NXBMathUtils.factorial(N));
                System.out.println(NXBMathUtils.factorial(N-K));
                C = (double) NXBMathUtils.factorial(N)/(NXBMathUtils.factorial(K)*NXBMathUtils.factorial(N-K));
                System.out.println(C);
                //output = "" + String.format("%.12f" ,C);
                output = "" + NXBMathUtils.niceDoubleOutput(C);
                System.out.println(output);
                textViewOutputCombination.setText(output);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.combination, menu);
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
}

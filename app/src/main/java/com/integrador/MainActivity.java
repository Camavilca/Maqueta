package com.integrador;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        ImageView photoImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_profile);

        TextView fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText("Orlando Camavilca Chavez");

        TextView emailText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);
        emailText.setText("orlando.camavilca@tecsup.edu.pe");
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_home:
//                        Toast.makeText(MainActivity.this, "Go calendar...", Toast.LENGTH_SHORT).show();
                        detalle();
                    case R.id.nav_calendar:
                        Toast.makeText(MainActivity.this, "Go calendar...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_gallery:
                        Toast.makeText(MainActivity.this, "Go gallery...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(MainActivity.this, "Go settings...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(MainActivity.this, "Do logout...", Toast.LENGTH_SHORT).show();
                        break;
                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void detalle(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment detalle = new RegistrarFragment();
        fragmentManager.beginTransaction().replace(R.id.main_content,detalle).commit();
    }
}

package com.student.kevin.navigationviewdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle("Kevin");
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_layout_open, R.string.drawer_layout_close);
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setStatusBarBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        View headerView = mNavigationView.getHeaderView(0);
        headerView.setOnClickListener(this);
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//                    default:
//                        Snackbar.make(mDrawerLayout, "This is from Kevin", Snackbar.LENGTH_SHORT).show();
//                        break;
//                Snackbar.make(mDrawerLayout, item.getItemId() + "", Snackbar.LENGTH_SHORT).show();
                Log.i("Kevin", item.getGroupId() + "");
                Log.e("Kevin", item.getItemId() + "");
                Log.d("Kevin", R.id.item_one + "");
                switch (item.getGroupId()) {
                    case R.id.item_one:
                        showSnack(mDrawerLayout, "Home");
                        break;
                    case R.id.item_two:
                        showSnack(mDrawerLayout, "News");
                        break;
                    case R.id.item_three:
                        showSnack(mDrawerLayout, "Favorite");
                        break;
                    case R.id.item_four:
                        showSnack(mDrawerLayout, "Settins");
                        break;
                }
                return true;
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }

    @Override
    public void onClick(View view) {

        Snackbar.make(mDrawerLayout, "This is headerView", Snackbar.LENGTH_SHORT).show();
    }

    private void showSnack(View view, String text) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.amber_500));
        snackbar.show();
    }
}

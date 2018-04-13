package com.example.miroslav.a08_material_desing_fragments;


import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;


    //Asset Manager
//    private AssetManager aseAssetManager = getAssets();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bottom Navigation View - bottom_nav
        toolbar = findViewById(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        activateBottomNavigationView();

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.primary_menu, menu);
        return true;

    }

    /*   private void bottomNavMenuItems(){
            try {
                InputStream is = aseAssetManager.open("xxxhdpi/add.png");
                Bitmap bitmap = BitmapFactory.decodeStream(is);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    */
    private void activateBottomNavigationView() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_feed:
                        item.setIcon(R.drawable.feed_1);

//                        item.setIcon(R.drawable.scanner_0);
//                        item.setIcon(R.drawable.gifts_0);
//                        item.setIcon(R.drawable.profile_0);
                        Toast.makeText(MainActivity.this, "Action Feed Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.item_scanner:
//                        item.setIcon(R.drawable.feed_0);
                        item.setIcon(R.drawable.scanner_1);
//                        item.setIcon(R.drawable.gifts_0);
//                        item.setIcon(R.drawable.profile_0);
                        Toast.makeText(MainActivity.this, "Action Scanner Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.item_gifts:
//                        item.setIcon(R.drawable.feed_0);
//                        item.setIcon(R.drawable.scanner_0);
                        item.setIcon(R.drawable.gifts_1);
//                        item.setIcon(R.drawable.profile_0);
                        Toast.makeText(MainActivity.this, "Action Gifts Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.item_profile:
//                        item.setIcon(R.drawable.feed_0);
//                        item.setIcon(R.drawable.scanner_0);
                        //item.setIcon(R.drawable.gifts_0);
                        item.setIcon(R.drawable.profile_1);
                        Toast.makeText(MainActivity.this, "Action Profile Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

//                item.setIcon(R.drawable.feed_0);
//                item.setIcon(R.drawable.scanner_0);
//                item.setIcon(R.drawable.gifts_0);
//                item.setIcon(R.drawable.profile_0);
                return true;
            }
        });
    }
}

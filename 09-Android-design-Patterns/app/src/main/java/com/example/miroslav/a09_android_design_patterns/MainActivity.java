package com.example.miroslav.a09_android_design_patterns;

import android.app.SearchManager;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;


import com.example.miroslav.a09_android_design_patterns.adapters.ProductListAdapter;
import com.example.miroslav.a09_android_design_patterns.data.AppDatabase;
import com.example.miroslav.a09_android_design_patterns.data.Product;
import com.example.miroslav.a09_android_design_patterns.services.APIClient;
import com.example.miroslav.a09_android_design_patterns.services.ProductService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProducts = findViewById(R.id.lv_listview);

        AppDatabase db = Room.databaseBuilder(this,
                AppDatabase.class, "product.db").allowMainThreadQueries().build();

//        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "database-name").build();
        Product product= new Product();
        product.setCode("122");
        product.setProductName("test");
        product.setIngredientsText("test Again");
        db.productDao().insertAll(product);

        List<Product> productList = db.productDao().getAll();

        for ( Product product1: productList
                ) {

            Log.e("TAG", product1.toString());

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view_menu, menu);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search_view).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ProductService productService = APIClient.getClient().create(ProductService.class);
                Call call = productService.search(query);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        List<Product> products = (List<Product>) response.body();
                        ProductListAdapter productListAdapter = new ProductListAdapter(getApplicationContext(),  products);
                        listViewProducts.setAdapter(productListAdapter);
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
}

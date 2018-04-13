package com.example.miroslav.a09_android_design_patterns.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.miroslav.a09_android_design_patterns.R;
import com.example.miroslav.a09_android_design_patterns.entities.Product;


import java.util.List;

public class ProductListAdapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> products;


    public ProductListAdapter(Context context, List<Product> products) {
        super(context, R.layout.product_list_layout, products);
        this.context = context;
        this.products = products;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.product_list_layout, parent, false);

        Product product = products.get(position);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        textViewName.setText(product.getProductName());

        TextView textViewContent = convertView.findViewById(R.id.textviewContent);
        textViewContent.setText((CharSequence) product.getIngredientsText());
        return convertView;
    }
}

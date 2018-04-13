package com.example.miroslav.a09_android_design_patterns.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Product {
    @PrimaryKey
    @NonNull
    private String code;

    @ColumnInfo(name = "product_name")
    private String productName;

    @ColumnInfo(name = "ingredients_text")
    private String ingredientsText;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIngredientsText() {
        return ingredientsText;
    }

    public void setIngredientsText(String ingredientsText) {
        this.ingredientsText = ingredientsText;
    }

    @Override
    public String toString() {
        return "code: " + getCode() + "\n"
                + "productname: " + getProductName() + "\n"
                + "ingredientsText" + getIngredientsText();
    }
}

package com.example.miroslav.a09_android_design_patterns.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable{

    @SerializedName("codeId")
    private String codeId;

    @SerializedName("productName")
    private String productName;

    @SerializedName("ingredientsText")
    private String ingredientsText;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
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
}

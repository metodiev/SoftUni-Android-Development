package com.example.miroslav.a09_android_design_patterns.data;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<Product> getAll();

    @Query("SELECT * FROM product WHERE code IN (:codeId)")
    List<Product> loadAllByIds(int[] codeId);

    @Query("SELECT * FROM product WHERE product_name LIKE :prName AND "
            + "ingredients_text LIKE :ingText LIMIT 1")
    Product findByProductName(String prName, String ingText);

    @Insert
    void insertAll(Product... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProduct(Product... users);

    @Delete
    void delete(Product product);
}

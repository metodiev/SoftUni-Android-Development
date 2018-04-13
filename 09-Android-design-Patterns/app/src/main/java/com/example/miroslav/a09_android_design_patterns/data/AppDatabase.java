package com.example.miroslav.a09_android_design_patterns.data;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.miroslav.a09_android_design_patterns.data.Product;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
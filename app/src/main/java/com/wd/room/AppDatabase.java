package com.wd.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
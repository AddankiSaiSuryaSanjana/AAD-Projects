package com.sanjana.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = StudentEntity.class, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase INSTANCE;
    public abstract StudentDAO studentDAO();
    public static synchronized StudentDatabase getDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, StudentDatabase.class, "sam").allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();

        }
        return INSTANCE;
    }

}

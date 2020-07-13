package com.sanjana.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    public void insertData(StudentEntity studentEntity);
    @Update
    public void updateData(StudentEntity studentEntity);
    @Delete
    public void deleteData(StudentEntity studentEntity);
    //for live data
    @Query("Select * FROM Student_Table")
    public LiveData<List<StudentEntity>> retrieveData(); //Normal Data


}

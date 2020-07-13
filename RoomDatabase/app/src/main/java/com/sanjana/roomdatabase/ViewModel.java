package com.sanjana.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    StudentRepo studentRepo;
    LiveData<List<StudentEntity>> listLiveDataModel;
    public ViewModel(@NonNull Application application) {
        super(application);
        studentRepo = new StudentRepo(application);
        listLiveDataModel = studentRepo.listLiveData;
    }
    public void insert(StudentEntity studentEntity) {
        studentRepo.insert(studentEntity);
    }
    public void update(StudentEntity studentEntity) {
        studentRepo.update(studentEntity);
    }
    public void delete(StudentEntity studentEntity) {
        studentRepo.delete(studentEntity);
    }
    public LiveData<List<StudentEntity>> liveData(){

        return  listLiveDataModel;
    }
}

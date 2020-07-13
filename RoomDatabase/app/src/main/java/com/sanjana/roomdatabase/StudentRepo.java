package com.sanjana.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class StudentRepo {
    LiveData<List<StudentEntity>> listLiveData;
    StudentDatabase studentDatabase;

    public StudentRepo(Application application) {
        studentDatabase = StudentDatabase.getDatabase(application);
        listLiveData = studentDatabase.studentDAO().retrieveData();
    }

    public void update(StudentEntity studentEntity) {
        new MyAsyncTaskForUpdate().execute(studentEntity);
    }

    //for live data inserting
    public class MyAsyncTaskForInsert extends AsyncTask<StudentEntity, Void, Void> {

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDatabase.studentDAO().insertData(studentEntities[0]);
            return null;
        }
    }
    public class MyAsyncTaskForUpdate extends AsyncTask<StudentEntity, Void, Void> {

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDatabase.studentDAO().updateData(studentEntities[0]);
            return null;
        }
    }
    public class MyAsyncTaskForDelete extends AsyncTask<StudentEntity, Void, Void> {

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDatabase.studentDAO().deleteData(studentEntities[0]);
            return null;
        }
    }
    public void insert(StudentEntity studentEntity) {
        new MyAsyncTaskForInsert().execute(studentEntity);
    }
    public void delete(StudentEntity studentEntity) {
        new MyAsyncTaskForDelete().execute(studentEntity);
    }
}

package com.example.noteur;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Note.class},version = 1)
public abstract class NoteData extends RoomDatabase {

    private  static  NoteData instance;

    public  abstract  NoteDao noteDao();

    public  static  synchronized  NoteData getInstance(Context context){

        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    NoteData.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack).build();

        }


        return instance;



    }
private  static RoomDatabase.Callback roomCallBack =new RoomDatabase.Callback(){
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);

      //  new PopulateDbAsynTask(instance).execute();

        NoteDao noteDao= instance.noteDao();
        ExecutorService executorService= Executors.newSingleThreadExecutor();


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.insert(new Note("Title 1","Description 1"));
                noteDao.insert(new Note("Title 2","Description 2"));
                noteDao.insert(new Note("Title 3","Description 3"));
                noteDao.insert(new Note("Title 4","Description 4"));
                noteDao.insert(new Note("Title 5","Description 5"));
            }
        });
    }
};
/*
    private static class PopulateDbAsynTask extends AsyncTask<Void,Void,Void>{

private NoteDao noteDao;
private PopulateDbAsynTask(NoteData database){

    noteDao= database.noteDao();




}
        @Override
        protected Void doInBackground(Void... voids) {

    noteDao.insert(new Note("note","Title 1","Description 1"));
    noteDao.insert(new Note("note","Title 2","Description 2"));
    noteDao.insert(new Note("note","Title 3","Description 3"));
    noteDao.insert(new Note("note","Title 4","Description 4"));
    noteDao.insert(new Note("note","Title 5","Description 5"));

            return null;
        }
    }
*/



}

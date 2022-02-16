package com.audiovideoplayer.mediaplayer.notificationexample;



import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class AudioActivity extends AppCompatActivity {
    RecyclerView audio_recycler;
    AudioAdapter audioAdapter;
    ArrayList<AudioModel> modelArrayList;
    private Object Uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        audio_recycler = findViewById(R.id.audio_recycler);
        MusicAudios();

    }

    private  void  MusicAudios(){


    String[] projection = new String[] {
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DISPLAY_NAME,
            MediaStore.Video.Media.DURATION,
            MediaStore.Video.Media.SIZE
    };
    String selection = MediaStore.Video.Media.DURATION +
            " >= ?";
    String[] selectionArgs = new String[] {
            String.valueOf(TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES))
    };

    String sortOrder = MediaStore.Video.Media.DISPLAY_NAME + " ASC";
        Uri collection;
        try (Cursor cursor = getApplicationContext().getContentResolver().query(
                Uri,
            projection,
            selection,
            selectionArgs,
            sortOrder)) {
        // Cache column indices.
        int idColumn = ((Cursor) cursor).getColumnIndexOrThrow(MediaStore.Video.Media._ID);
        int nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME);
        int durationColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION);
        int sizeColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE);

        while (cursor.moveToNext()) {
            // Get values of columns for a given video.
            long id = cursor.getLong(idColumn);
            String name = cursor.getString(nameColumn);
            int duration = cursor.getInt(durationColumn);
            int size = cursor.getInt(sizeColumn);

            Uri contentUri = ContentUris.withAppendedId(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);

            // Stores column values and the contentUri in a local object
            // that represents the media file.
            modelArrayList.add(new AudioModel(contentUri, name, duration, size));
        }
    }
}
}



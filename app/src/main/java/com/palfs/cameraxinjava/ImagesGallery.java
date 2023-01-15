package com.palfs.cameraxinjava;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class ImagesGallery {

    public  static ArrayList<String> listOfImages(Context context){

        Cursor cursor, cursor2;
        int column1, column2;
        ArrayList<String> listOfAllImages = new ArrayList<>();
        String ablosutePathOfImage,ablosutePathOfImage2;

        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;


        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Video.Media.BUCKET_DISPLAY_NAME};

        String orderBy = MediaStore.Images.Media.DATE_TAKEN;
        String orderBy2 = MediaStore.Video.Media.DATE_TAKEN;


        cursor=context.getContentResolver().query(uri2,projection,null,
                null,orderBy+ " DESC");
        cursor2=context.getContentResolver().query(uri,projection,null,
                null,orderBy2+" DESC");


        column1= cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATA);
        column2 = cursor2.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.DATA);



       // Cursor cursorall = new MergeCursor(new Cursor[]{cursor, cursor2});

        while (cursor.moveToNext()){
            ablosutePathOfImage = cursor.getString(column1);


            listOfAllImages.add(ablosutePathOfImage);


        }
        while (cursor2.moveToNext()){
         ablosutePathOfImage2 = cursor2.getString(column2);


            listOfAllImages.add(ablosutePathOfImage2);

        }

        cursor.close();
        return listOfAllImages;

    }


}

package cn.edu.bistu.cs.cnse.edu.bistu.cs.se.exercise_19;
import android.os.Environment;
import android.util.Log;
import java.io.File;
/*
 * Created by dream high on 2016/9/7.
 */
public class Ui {
    public static boolean isExternalStorageWritable(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
    public static boolean isExternalStorageReadable(){
        String state=Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state)||Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }
    public static File getAlbumStorageDir(String albumName){
        File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),albumName);
      if(!file.mkdirs()) {
          Log.e("myFile","Directory not created");
      }
        return file;
    }

}

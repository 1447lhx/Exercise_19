package cn.edu.bistu.cs.cnse.edu.bistu.cs.se.exercise_19;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
   private EditText editText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button read=(Button)findViewById(R.id.btn_read);
        Button write=(Button)findViewById(R.id.btn_write);
        read.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                InputStream in=null;
                try{
                    if(Ui.isExternalStorageReadable()){
                        File file= Environment.getExternalStorageDirectory();
                        File myfile=new File(file.getCanonicalPath()+"/myfile");
                        FileInputStream fileInputStream=new FileInputStream(myfile);
                        in=new BufferedInputStream(fileInputStream);
                        int c;
                        StringBuilder stringBuilder=new StringBuilder("");
                        while((c=in.read())!=-1){
                            stringBuilder.append((char)c);
                        }
                        Toast.makeText(MainActivity.this,stringBuilder.toString(),Toast.LENGTH_SHORT).show();
                        in.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        });
        write.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                OutputStream out=null;
                try{
                    if(Ui.isExternalStorageWritable()){
                        File file= Environment.getExternalStorageDirectory();
                        File myfile=new File(file.getCanonicalPath()+"/myfile");
                        FileOutputStream fileOutputStream=new FileOutputStream(myfile);
                        out=new BufferedOutputStream(fileOutputStream);
                       String content=editText.getText()+"";
                       out.write(content.getBytes(StandardCharsets.UTF_8));
                        out.flush();
                        out.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

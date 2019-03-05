package com.example.animalsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class GameActivity extends AppCompatActivity {



    private ImageView img;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private int ans = 0;
    private int score = 0;

    private final String mFileName = "Score.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        refresh();

        img = (ImageView) findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(ans == 1){score++; Toast.makeText(GameActivity.this,"Right!",Toast.LENGTH_SHORT).show();}
            else {score--;Toast.makeText(GameActivity.this,"Wrong!",Toast.LENGTH_SHORT).show();}
            if(score<0)score = 0;
            save(score+"");
            refresh();
            }
        });

        img2 = (ImageView) findViewById(R.id.imageView2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans == 2){score++; Toast.makeText(GameActivity.this,"Right!",Toast.LENGTH_SHORT).show();}
                else {score--;Toast.makeText(GameActivity.this,"Wrong!",Toast.LENGTH_SHORT).show();}
                if(score<0)score = 0;
                save(score+"");
                refresh();
            }
        });

        img3 = (ImageView) findViewById(R.id.imageView3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans == 3){score++; Toast.makeText(GameActivity.this,"Right!",Toast.LENGTH_SHORT).show();}
                else {score--;Toast.makeText(GameActivity.this,"Wrong!",Toast.LENGTH_SHORT).show();}
                if(score<0)score = 0;
                save(score+"");
                refresh();
            }
        });

        img4 = (ImageView) findViewById(R.id.imageView4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans == 4){score++; Toast.makeText(GameActivity.this,"Right!",Toast.LENGTH_SHORT).show();}
                else {score--;Toast.makeText(GameActivity.this,"Wrong!",Toast.LENGTH_SHORT).show();}
                if(score<0)score = 0;
                save(score+"");
                refresh();
            }
        });
    }
    public void refresh()
    {
        Random r=new Random();
        int k, k2, k3, k4;
        k =  r.nextInt(15);
        k2 =   r.nextInt(15);
        while(k2==k) k2 = r.nextInt(15);
        k3 =  r.nextInt(15);
        while(k3==k||k3==k2) k3 = r.nextInt(15);
        k4 =  r.nextInt(15);
        while(k4==k||k4==k2||k4==k3) k4 = r.nextInt(15);
        int[] Da= {R.drawable.honey ,R.drawable.flower,R.drawable.bird,R.drawable.fish,R.drawable.cat,R.drawable.wolf,R.drawable.leo,R.drawable.lion,R.drawable.kangaroo,R.drawable.pig,R.drawable.rhino,R.drawable.tiger,R.drawable.bear,R.drawable.hypo,R.drawable.giraffe,R.drawable.elephant};
        ((ImageView) findViewById(R.id.imageView)).setImageDrawable(getResources().getDrawable(Da[k]));
        ((ImageView) findViewById(R.id.imageView2)).setImageDrawable(getResources().getDrawable(Da[k2]));
        ((ImageView) findViewById(R.id.imageView3)).setImageDrawable(getResources().getDrawable(Da[k3]));
        ((ImageView) findViewById(R.id.imageView4)).setImageDrawable(getResources().getDrawable(Da[k4]));
        int Pans = Math.max(Math.max(Math.max(k,k2),k3),k4);
        if(Pans == k)ans = 1;
        else if(Pans == k2)ans = 2;
        else if(Pans == k3)ans = 3;
        else ans = 4;

        ((TextView) findViewById(R.id.textView2)).setText("Score: "+score+"");
    }

    public void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        }   catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileOutputStream != null){
                try{
                    fileOutputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while((len = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        }   catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

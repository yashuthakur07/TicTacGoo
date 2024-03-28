package com.example.tictacgoo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "MyChannel";
    private static final int NOTIFICATION_ID = 100;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int count,flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void check() {
        check(null);
    }

    public void check(View view) {
        Button btnCurent = (Button) view;
        if (btnCurent.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                btnCurent.setText("X");
                btnCurent.setTextColor(getResources().getColor(R.color.colorX));
                flag = 1;
            } else {
                btnCurent.setText("O");
                btnCurent.setTextColor(getResources().getColor(R.color.colorO));
                flag = 0;
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    Toast.makeText(this, "Winnner is:" + b1, Toast.LENGTH_SHORT).show();
                     restart();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    Toast.makeText(this, "Winnner is:" + b4, Toast.LENGTH_SHORT).show();
                    restart();
                } else if (b7.equals(b8) && b8.equals(b9) && !b8.equals("")) {
                    Toast.makeText(this, "Winnner is:" + b8, Toast.LENGTH_SHORT).show();
                    restart();
                } else if (b1.equals(b4) && b4.equals(b7) && !b7.equals("")) {
                    Toast.makeText(this, "Winnner is:" + b4, Toast.LENGTH_SHORT).show();
                    restart();
                } else if (b2.equals(b5) && b5.equals(b8) && !b8.equals("")) {
                    Toast.makeText(this, "Winnner is:" + b5, Toast.LENGTH_SHORT).show();
                    restart();
                } else if (b3.equals(b6) && b6.equals(b9) && !b6.equals("")) {
                    Toast.makeText(this, "Winnner is:" + b6, Toast.LENGTH_SHORT).show();
                    restart();
                } else if (b1.equals(b5) && b5.equals(b9) && !b5.equals("")) {
                    Toast.makeText(this, "Winnner is:" + b5, Toast.LENGTH_SHORT).show();
                    restart();
                } else if (b3.equals(b5) && b5.equals(b7) && !b7.equals("")) {
                    Toast.makeText(this, "Winnner is:" + b5, Toast.LENGTH_SHORT).show();
                    restart();
                }
                else if (!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") &&
                         !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("")
                            && !b9.equals(""))
                {
                    Toast.makeText(this, "Game Is Drawn", Toast.LENGTH_SHORT).show();
                    restart();}


            }
        }
    }
    public void restart(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count=0;
        flag=0;
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.icon5,null);
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        Bitmap LargeIcon = bitmapDrawable.getBitmap();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE) ;
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
              notification = new Notification.Builder(this)
                    .setLargeIcon(LargeIcon)
                    .setSmallIcon(R.drawable.icon5)
                    .setContentText("new Message")
                    .setSubText("Message from Ram Ji")
                    .setChannelId(CHANNEL_ID)
                    .build();
              nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));
        }else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(LargeIcon)
                    .setSmallIcon(R.drawable.icon5)
                    .setContentText("new Message")
                    .setSubText("Message from Ram Ji")
                    .build();
        }
        nm.notify(NOTIFICATION_ID, notification);
    }
        }


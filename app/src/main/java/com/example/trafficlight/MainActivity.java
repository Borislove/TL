package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout b_1, b_2, b_3;
    private Button button;
    private boolean start_stop = false;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_1 = findViewById(R.id.bulb_1);
        b_2 = findViewById(R.id.bulb_2);
        b_3 = findViewById(R.id.bulb_3);

        button = findViewById(R.id.button);
    }

    public void onClickStart(View view) {
        if (!start_stop) {
            button.setText("Stop");
            start_stop = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (start_stop) {
                        counter++;
                        switch (counter) {
                            case 1:
                                //    b_1.setBackgroundColor(Color.GREEN);
                                b_1.setBackgroundColor(getResources().getColor(R.color.teal_700));
                                b_2.setBackgroundColor(getResources().getColor(R.color.grey));
                                b_3.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 2:
                                b_1.setBackgroundColor(getResources().getColor(R.color.grey));
                                b_2.setBackgroundColor(getResources().getColor(R.color.orange));
                                b_3.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 3:
                                b_1.setBackgroundColor(getResources().getColor(R.color.grey));
                                b_2.setBackgroundColor(getResources().getColor(R.color.grey));
                                b_3.setBackgroundColor(getResources().getColor(R.color.red));
                                counter = 0;
                                break;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } else {
            button.setText("Start");
            start_stop = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}

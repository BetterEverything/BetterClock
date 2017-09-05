package io.github.bettereverything.betterclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView ClockText = (TextView) findViewById(R.id.clock_view);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ClockText.post(new Runnable() {
                    @Override
                    public void run() {
                        ClockText.setText(DateFormat.getTimeInstance().format(new Date()));
                    }
                });
            }
        }, 1000l, 1000l, TimeUnit.MILLISECONDS);
    }
}

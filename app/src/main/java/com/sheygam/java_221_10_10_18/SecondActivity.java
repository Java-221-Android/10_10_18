package com.sheygam.java_221_10_10_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView titleTxt = findViewById(R.id.title_txt);
        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
//        if (extras != null) {
//            String name = extras.getString("NAME");
//            titleTxt.setText(name);
//        }

        String name = intent.getStringExtra("NAME");
        titleTxt.setText(name);

        findViewById(R.id.close_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("MSG","My msg!");
                        setResult(RESULT_OK,intent);
                        finish();
//                        Intent intent  = new Intent(SecondActivity.this,MainActivity.class);
//                        startActivity(intent);
                    }
                });

    }

}

package com.sheygam.java_221_10_10_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MY_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next_btn){
            //Start next activity
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("NAME","Vasya");
//            startActivity(intent);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult() called with: requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");
        if(resultCode == RESULT_OK){
            if(requestCode == 1 && data != null && data.getExtras() != null){
                TextView titleTxt = findViewById(R.id.title_txt);
                titleTxt.setText(data.getStringExtra("MSG"));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}

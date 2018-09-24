package com.cfbrownweb.chrisbrown.menuexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Bundle data = getIntent().getExtras();
        if(data != null){
            //Get passed along infomation with string key 'message'
            TextView textView = findViewById(R.id.settings_text);
            textView.setText(data.getString("message"));
        }
    }
}

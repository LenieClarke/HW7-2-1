package com.example.hw7_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText addresExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addresExample = findViewById(R.id.addresExample);
        Button searchBtn = findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String onTextChangedString = onTextChanged();
                Uri uri = Uri.parse(onTextChangedString);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }

    private String onTextChanged() {
        String string = addresExample.getText().toString();
        char[] chars = string.toCharArray();
        boolean addres = true;
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                //Uri uri = Uri.parse("geo:?q=" + string);
                //intent.setData(uri);
                addres = false;
                break;
            }
        }
        if (addres) {
            //Uri uri = Uri.parse("geo:" + string);
            //intent.setData(uri);
            return "geo:" + string;
        }
        return "geo:?q=" + string;
    }
}
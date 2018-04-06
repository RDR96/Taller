package com.rdr.rodrigocorvera.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editText= findViewById(R.id.editId);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent sendIntent  = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());

                if ( !editText.getText().equals("") ){
                    if (sendIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(sendIntent);
                    }
                }else{
                    
                }


            }
        });

    }
}

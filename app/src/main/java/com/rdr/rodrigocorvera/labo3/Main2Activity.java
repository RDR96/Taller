package com.rdr.rodrigocorvera.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView text;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.texto);
        boton = findViewById(R.id.botonHome);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null ){
            if (intentType.equals("text/plain")){
                handleReceivedText(callingIntent);
            }
        }

        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent returningHomeIntent = new Intent(getApplicationContext() , MainActivity.class );
                startActivity(returningHomeIntent);
            }
        });
    }

    public void handleReceivedText(Intent intent){
        String textoRecibido = intent.getStringExtra(intent.EXTRA_TEXT);

        if ( textoRecibido != null ){
            text.setText(textoRecibido);
        }

    }
}

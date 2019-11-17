package upeu.edu.pe.rest2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private EditText edtn,edtap,edtuser,edtclave;
    private ListView lvdatos;
    private Button boton1, boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void java(View view){
        Intent intent = new Intent(getApplicationContext(), Java.class);
        startActivity(intent);
    }
    public void python(View view){
        Intent intent = new Intent(getApplicationContext(), Python.class);
        startActivity(intent);
    }
    public void php(View view){
        Intent intent = new Intent(getApplicationContext(), PHP.class);
        startActivity(intent);
    }
    public void nodejs(View view){
        Intent intent = new Intent(getApplicationContext(), NodeJS.class);
        startActivity(intent);
    }
}

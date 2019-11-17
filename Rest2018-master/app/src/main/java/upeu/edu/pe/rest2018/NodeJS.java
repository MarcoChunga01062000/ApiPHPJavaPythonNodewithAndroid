package upeu.edu.pe.rest2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class NodeJS extends AppCompatActivity {
    private EditText edtn,edtap,edtuser;
    private ListView lvdatos;
    private Button boton1, boton2;
    String ip = "192.168.56.110";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_js);
        edtn = (EditText)findViewById(R.id.nombres);
        edtap = (EditText)findViewById(R.id.apellidos);
        edtuser = (EditText)findViewById(R.id.user);
        boton1 = (Button)findViewById(R.id.btncalcular);
        boton2 = (Button)findViewById(R.id.btnlimpiar);
        edtn.requestFocus();
    }
    public void reset(View view){
        limpiar();
    }
    public void save(View view){
        String nombres = edtn.getText().toString();
        String apellidos = edtap.getText().toString();
        String usuario = edtuser.getText().toString();
        String url = "http://" + ip + ":3002/users/insert?";
        datosUsuarios(nombres,apellidos,usuario,url);
    }
    public void datosUsuarios(String nombres, String apellidos, String usuario, String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        String parametros = "name=" + nombres + "&correo=" + apellidos + "&pass=" + usuario;
        String urlParameter = parametros.replace(" ","%20");
        client.post(url + urlParameter, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String resultado = new String(responseBody);
                    Toast.makeText(NodeJS.this, "Registro Guardado correctamente...! " + resultado, Toast.LENGTH_LONG).show();
                    limpiar();
                    Intent intent = new Intent(getApplicationContext(), ListarActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(NodeJS.this, "No se Registro", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("ERROR AQUI" + error);
                Toast.makeText(NodeJS.this, "Mal: " + error, Toast.LENGTH_LONG).show();
            }
        });
        finish();
    }
    public void limpiar(){
        edtn.setText("");
        edtap.setText("");
        edtuser.setText("");
        edtn.requestFocus();
    }
}

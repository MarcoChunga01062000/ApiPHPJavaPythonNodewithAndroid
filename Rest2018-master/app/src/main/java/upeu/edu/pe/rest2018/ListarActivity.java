package upeu.edu.pe.rest2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.jackrutorial.androidretrofit2crud.remote.APIUtils;
import com.jackrutorial.androidretrofit2crud.remote.UserService;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import upeu.edu.pe.rest2018.Usuario;

public class ListarActivity extends AppCompatActivity {

    ListView lvdatos;

    UserService userService;
    List<Usuario> list = new ArrayList<Usuario>();
    private String ip = "192.168.56.110";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        setTitle("Lista de Usuarios");

        lvdatos = (ListView) findViewById(R.id.listView);
        userService = APIUtils.getUserService();
        lvdatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuario = (Usuario) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(),UserActivity.class);
                intent.putExtra("ID", String.valueOf(usuario.getIdusuario()));
                intent.putExtra("NAME", usuario.getNombres());
                intent.putExtra("CORREO", usuario.getCorreo());
                intent.putExtra("PASS", usuario.getPass());
                intent.putExtra("ORIGEN", usuario.getOrigen());
                startActivity(intent);
            }
        });
    }

    public void phpA(View view){
        String url = "http://" + ip + ":82/rest/ListaUsuarios.php";
        listarUsuarios(url);
    }

    public void javaA(View view){
        String url = "http://" + ip + ":9090/usuarios/list";
        listarUsuarios(url);
    }
    public void pythonA(View view){
        String url = "http://" + ip + ":5000/users";
        listarUsuarios(url);
    }
    public void nodeA(View view){
        String url = "http://" + ip + ":3002/users";
        listarUsuarios(url);
    }

    public void listarUsuarios(String url){
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    cargarLisview(getJson(new String(responseBody)));
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void cargarLisview(ArrayList<Usuario> datos){
        lvdatos.setAdapter(null);
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this,android.R.layout.simple_list_item_1,datos);
        lvdatos.setAdapter(adapter);
    }

    public ArrayList<Usuario> getJson(String response){
        ArrayList<Usuario> listaS = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(response);
            for(int i=0; i<array.length();i++){
                Usuario usuario = new Usuario();
                usuario.setIdusuario(array.getJSONObject(i).getInt("idusuario"));
                usuario.setNombres(array.getJSONObject(i).getString("name"));
                usuario.setCorreo(array.getJSONObject(i).getString("correo"));
                usuario.setPass(array.getJSONObject(i).getString("pass"));
                usuario.setOrigen(array.getJSONObject(i).getString("origen"));
                listaS.add(usuario);
                //Toast.makeText(this, "Lista:" + listaS, Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaS;
    }
}
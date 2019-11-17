package upeu.edu.pe.rest2018;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

    public class UserAdapter extends ArrayAdapter<Usuario> {

    private Context context;
    private List<Usuario> users;

    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Usuario> objects) {
        super(context, resource, objects);
        this.context = context;
        this.users = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_user, parent, false);

        TextView txtUserId = (TextView) rowView.findViewById(R.id.txtUserId);
        TextView txtUsername = (TextView) rowView.findViewById(R.id.txtUsername);

        txtUserId.setText(String.format("#ID: %d", users.get(pos).getIdusuario()));
        txtUsername.setText(String.format("USER NAME: %s", users.get(pos).getNombres()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("idusuario", String.valueOf(users.get(pos).getIdusuario()));
                intent.putExtra("nombres", users.get(pos).getNombres());
                intent.putExtra("apellidos", users.get(pos).getCorreo());
                intent.putExtra("usuario", users.get(pos).getPass());
                intent.putExtra("clave", users.get(pos).getOrigen());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
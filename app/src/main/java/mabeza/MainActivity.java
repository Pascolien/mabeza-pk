package mabeza;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidtutorialshub.loginregister.R;

import mabeza.activities.LoginActivity;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    private Button button;
    private Button buttonMaps;
    private Button buttonRegister;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonCall);
        buttonMaps = (Button) findViewById(R.id.buttonMaps);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        etPhone = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String phnum = etPhone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phnum));

                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    startActivity(callIntent);
                }
    startActivity(callIntent);
            }

        });
        buttonMaps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),MapsActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(myIntent);
            }

        });
    }


}

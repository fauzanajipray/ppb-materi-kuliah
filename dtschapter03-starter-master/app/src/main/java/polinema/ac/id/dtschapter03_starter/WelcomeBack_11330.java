package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class WelcomeBack_11330 extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back_11330);

        editTextEmail = findViewById(R.id.edt_txt_email);
        editTextPassword = findViewById(R.id.edt_txt_password);
    }

    public void postLogin(View view) {

        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())
                && TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email tidak boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else if (!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email tidak valid", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(WelcomeBack_11330.this, SuccesActivity_11330.class);
            startActivity(i);
        }
    }

    public void clickForgot(View view) {
        Intent i = new Intent(WelcomeBack_11330.this, ForgotPasword_11330.class);
        startActivity(i);
    }

    public static boolean isValidEmail (CharSequence email) {
        return  (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
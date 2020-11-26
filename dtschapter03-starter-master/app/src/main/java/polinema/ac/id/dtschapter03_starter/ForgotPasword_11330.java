package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasword_11330 extends AppCompatActivity {

    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pasword_11330);

        editTextEmail = findViewById(R.id.edt_txt_email);
    }

    public void postSentRequest(View view) {

        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else if (!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email tidak valid", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(ForgotPasword_11330.this, ResetPassword_11330.class);
            startActivity(i);
        }
    }

    public static boolean isValidEmail (CharSequence email) {
        return  (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
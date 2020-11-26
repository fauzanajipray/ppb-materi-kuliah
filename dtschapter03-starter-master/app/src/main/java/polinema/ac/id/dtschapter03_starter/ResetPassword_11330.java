package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword_11330 extends AppCompatActivity {

    EditText editTextReset, editTextNewPassword, editTextConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_11330);

        editTextReset = findViewById(R.id.edt_reset_code);
        editTextNewPassword = findViewById(R.id.edt_new_password);
        editTextConfirmPassword = findViewById(R.id.edt_confirm_password);
    }

    public void postChangePassword(View view) {
        String newPass = editTextNewPassword.getText().toString().trim();
        String confirmPass = editTextConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(editTextReset.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Reset tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(editTextNewPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "New Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(editTextConfirmPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Confirm Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else if (newPass.length() <= 15){
            Toast.makeText(view.getContext(), "Password Harus lebih dari 15 karakter", Toast.LENGTH_SHORT).show();
        }
        else if (!isNumeric(editTextReset.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Reset Code harus angka", Toast.LENGTH_SHORT).show();
        }
        else if (!newPass.equals(confirmPass)){
            Toast.makeText(view.getContext(), "Confirm Password tidak sama", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(ResetPassword_11330.this, WelcomeBack_11330.class);
            startActivity(i);
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
package com.example.demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    //    Password validate
    private static final Pattern PASSWORD_PATTEN =
            Pattern.compile("^" +
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 6 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        binding.loginscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    public void registerUser(View view) {
        ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");
        if(!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() ){
            return;
        }
        progressDialog.show();
        auth.createUserWithEmailAndPassword
                (binding.regEmail.getText().toString(), binding.regPassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                         UserHelperClass user = new UserHelperClass (binding.regName.getText().toString(),
                                    binding.regEmail.getText().toString(),
                                    binding.regPhone.getText().toString(),
                                    binding.regPassword.getText().toString());

                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);

                            Toast.makeText(RegisterActivity.this, "User Create Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


    private boolean validateEmail() {
        String val = binding.regEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            binding.regEmail.setError("Please enter your correct E-mail!!");
            return false;
        }
        else if(!val.matches(emailPattern)){
            binding.regEmail.setError("Invalid E-mail address");
            return false;
        }
        else{
            binding.regEmail.setError(null);
            return true;
        }
    }

    private boolean validatePhoneNo() {
        String val = binding.regPhone.getText().toString();

        if(val.length()>10 || val.isEmpty()){
            binding.regPhone.setError("Please enter your 10 digits phone number!!");
            return true;
        }
        else{
            binding.regPhone.setError(null);
            return true;
        }


    }

    private boolean validatePassword(){
            String val = binding.regPassword.getText().toString().trim();
            if(val.isEmpty()){
                binding.regPassword.setError("Please enter strong password!!");
                return false;
            }
            else if (!PASSWORD_PATTEN.matcher(val).matches()){
                binding.regPassword.setError("Password is too weak!!");
                return false;
            }
            else{
                binding.regPassword.setError(null);
                return true;
            }
    }

    private boolean validateName() {
        String val = binding.regName.getText().toString();

        if(val.isEmpty()){
            binding.regName.setError("Please enter your name!!");
            return false;
        }
        else{
            binding.regName.setError(null);
            return true;
        }
    }
}
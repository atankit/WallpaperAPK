package com.example.demo;

import static android.service.controls.ControlsProviderService.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class ForgetPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button forgetPasswordBtn;
    private EditText newemail;
    private Button newEmailBtn;
    FirebaseAuth auth;
    private EditText inputEmail;
    private ProgressBar progressBar;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
//
////        Hooks
////        emailEditText = (EditText) findViewById(R.id.forgetEmail);
//        forgetPasswordBtn = (Button) findViewById(R.id.forgetPasswordbtn);
//        newemail = (EditText) findViewById(R.id.textInputEditText);
//        newEmailBtn = (Button) findViewById(R.id.newEmailbtn);
////        progressBar = (ProgressBar) findViewById(R.id.progressBar);
//        inputEmail = (EditText) findViewById(R.id.forgetEmail);
//
//        auth = FirebaseAuth.getInstance();
////------------------------------------ProfilePaeActivity m paste  edit txt k bdle current email fetch kr k nre email
//        newEmailBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String nemail = newemail.getText().toString().trim();
//
//                if (user != null && !newemail.getText().toString().trim().equals("")) {
//                    user.updateEmail(newemail.getText().toString().trim())
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        Toast.makeText(ForgetPasswordActivity.this, "Email address is updated. Please sign in with new email!", Toast.LENGTH_LONG).show();
//                                        auth.signOut();
////                                        progressBar.setVisibility(View.GONE);
//                                    } else {
//                                        Toast.makeText(ForgetPasswordActivity.this, "Failed to update email!", Toast.LENGTH_LONG).show();
////                                        progressBar.setVisibility(View.GONE);
//                                    }
//                                }
//                            });
//                } else if (newemail.getText().toString().trim().equals("")) {
//                    newemail.setError("Enter email");
////                    progressBar.setVisibility(View.GONE);
//                }
//            }
//        });
//
////        -------------------------------------------------------
//
//       forgetPasswordBtn.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//               String email = inputEmail.getText().toString().trim();
//
//               if (TextUtils.isEmpty(email)) {
//                   Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
//                   return;
//               }
//
////               progressBar.setVisibility(View.VISIBLE);
//               auth.sendPasswordResetEmail(email)
//                       .addOnCompleteListener(new OnCompleteListener<Void>() {
//                           @Override
//                           public void onComplete(@NonNull Task<Void> task) {
//                               if (task.isSuccessful()) {
//                                   Toast.makeText(ForgetPasswordActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
//                               } else {
//                                   Toast.makeText(ForgetPasswordActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
//                               }
//
////                               progressBar.setVisibility(View.GONE);
//                           }
//                       });
//           }
//       });


    }


}

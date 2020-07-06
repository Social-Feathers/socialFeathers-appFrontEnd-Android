package com.example.socialfeathers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.TrueError;
import com.truecaller.android.sdk.TrueProfile;
import com.truecaller.android.sdk.TruecallerSDK;
import com.truecaller.android.sdk.TruecallerSdkScope;

public class MainActivity extends AppCompatActivity {

    private LoginButton login_fb;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // facebook login start
        login_fb = findViewById(R.id.loginfb);
        callbackManager = CallbackManager.Factory.create();
        final int RC_SIGN_IN = 0;

        // truecaller sdk start

        (findViewById(R.id.login_with_truecaller)).setOnClickListener((View v) -> {
            //check if Truecaller SDK is usable
            if (TruecallerSDK.getInstance().isUsable()) {
                TruecallerSDK.getInstance().getUserProfile(MainActivity.this);
            } else {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
                dialogBuilder.setMessage("Truecaller App not installed.");

                dialogBuilder.setPositiveButton("OK", (dialog, which) -> {
                            Log.d( "Message:", "onClick: Closing dialog");

                            dialog.dismiss();
                        }
                );

                dialogBuilder.setIcon(R.drawable.com_truecaller_icon);
                dialogBuilder.setTitle(" ");

                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });


        TruecallerSdkScope trueScope = new TruecallerSdkScope.Builder(this, new ITrueCallback() {
            @Override
            public void onSuccessProfileShared(@NonNull TrueProfile trueProfile) {
                Log.i("Message:", trueProfile.firstName + " " + trueProfile.lastName);
                launchHome(trueProfile);
            }

            @Override
            public void onFailureProfileShared(@NonNull TrueError trueError) {
                Log.i("Error: ", trueError.toString());
            }

            @Override
            public void onVerificationRequired() {
                Log.i("Message: ", "onVerificationRequired");
            }
        })
                .consentMode(TruecallerSdkScope.CONSENT_MODE_POPUP)
                .consentTitleOption(TruecallerSdkScope.SDK_CONSENT_TITLE_VERIFY)
                .footerType(TruecallerSdkScope.FOOTER_TYPE_SKIP).build();
        TruecallerSDK.init(trueScope);
        // truecaller sdk end
        login_fb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//                info.setText("User id:" + loginResult.getAccessToken().getUserId());
//                String imgURL = "https://graph.facebook.com/" + loginResult.getAccessToken().getUserId() + "/picture?return_ssl_resources=1";
//                Picasso.get().load(imgURL).into(profile);
                  Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                  startActivity(intent);

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        TruecallerSDK.getInstance().onActivityResultObtained(this, resultCode, data);
        }// facebook login end
    private void launchHome(TrueProfile trueProfile) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
        finish();
    }

}
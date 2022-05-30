package com.example.sintrabel.activitiy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sintrabel.R;
import com.example.sintrabel.util.RESTapi.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    RetrofitClient retrofitClient;
    private initMyApi initMyApi;

    EditText usernameText;
    EditText passwordText;
    EditText nicknameText;
    Button btn_singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameText = (EditText)findViewById(R.id.signup_username);
        passwordText = findViewById(R.id.signup_password);
        nicknameText = findViewById(R.id.sigup_nickname);
        btn_singup = (Button) findViewById(R.id.but_signup);


        btn_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = usernameText.getText().toString();
                String pw = passwordText.getText().toString();
                String nickname = nicknameText.getText().toString();
                hideKeyboard();

                //로그인 정보 미입력 시
                if (id.trim().length() == 0 || pw.trim().length() == 0 || id == null || pw == null || nickname == null) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                    builder.setTitle("알림")
                            .setMessage("로그인 정보를 입력바랍니다.")
                            .setPositiveButton("확인", null)
                            .create()
                            .show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else {
                    //로그인 통신
                    SignupResponse();
                }
            }
        });
    }

    public void SignupResponse() {
        String username = usernameText.getText().toString().trim();
        String userPassword = passwordText.getText().toString().trim();
        String nickname = nicknameText.getText().toString().trim();

        //loginRequest에 사용자가 입력한 id와 pw를 저장
        SignupRequest signupRequest = new SignupRequest(username, userPassword, nickname);

        //retrofit 생성
        retrofitClient = RetrofitClient.getInstance();
        initMyApi = RetrofitClient.getRetrofitInterface();

        //loginRequest에 저장된 데이터와 함께 init에서 정의한 getLoginResponse 함수를 실행한 후 응답을 받음
        initMyApi.getSingupResponse(signupRequest).enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {

                Log.d("retrofit", "Data fetch success");

                //통신 성공
                if (response.isSuccessful() && response.body() != null) {

                    //response.body()를 result에 저장
                    SignupResponse result = response.body();

                    //받은 코드 저장
                    String resultCode = result.getResultCode();

                    String success = "200"; //회원가입 성공
                    String error = "300"; //회원가입 실패


                    if (resultCode.equals(success)) {
                        String nickname = nicknameText.getText().toString();

                        //다른 통신을 하기 위해 token 저장
//                        setPreference(token,token);

                        Toast.makeText(SignupActivity.this, nickname + "님 환영합니다.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                        intent.putExtra("userId", nickname);
                        startActivity(intent);
                        SignupActivity.this.finish();

                    } else if (resultCode.equals(error)) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                        builder.setTitle("알림")
                                .setMessage("회원가입에 실패했습니다.\n 고객센터에 문의바랍니다.")
                                .setPositiveButton("확인", null)
                                .create()
                                .show();
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                        builder.setTitle("알림")
                                .setMessage("예기치 못한 오류가 발생하였습니다.\n 고객센터에 문의바랍니다.")
                                .setPositiveButton("확인", null)
                                .create()
                                .show();

                    }
                }
            }

            //통신 실패
            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setTitle("알림")
                        .setMessage("통신 오류가 발생하였습니다.\n 고객센터에 문의바랍니다.")
                        .setPositiveButton("확인", null)
                        .create()
                        .show();
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(usernameText.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(passwordText.getWindowToken(), 0);
    }
}
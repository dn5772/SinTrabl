package com.example.sintrabel.activitiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ContentValues;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import com.example.sintrabel.R;
import com.example.sintrabel.util.*;

public class LoginActivity extends AppCompatActivity {
    public static String email, password;
    private TextView tv_outPut;
    private EditText edit_email,edit_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_outPut = (TextView) findViewById(R.id.tv_outPut);
        edit_email= (EditText) findViewById(R.id.edit_email);
        edit_password= (EditText) findViewById(R.id.edit_password);
    }

    public void clickLogin(View v){
        Intent intent = new Intent(this, testActivity.class);
        startActivity(intent);
    }

    public void clickSignup(View v){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            tv_outPut.setText(s);
        }
    }

}
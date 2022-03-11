package com.example.estudo.mvp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estudo.mvp.R;
import com.example.estudo.mvp.model.User;
import com.example.estudo.mvp.mvp.LoginContrato;
import com.example.estudo.mvp.presenter.HomeActivity;
import com.example.estudo.mvp.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginContrato.View {

    private LoginContrato.Presenter presenter;
    EditText loginInput;
    EditText passwordInput;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        presenter = new LoginPresenter(this);
        presenter.start();
    }

    @Override
    public void setPresenter(LoginContrato.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindViews() {
        loginInput = findViewById(R.id.editLogin);
        passwordInput = findViewById(R.id.editPassword);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            presenter.isLoginValid(loginInput.getText().toString(), passwordInput.getText().toString());
        });
    }

    @Override
    public void displayErrorMessage() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displaySucessToast() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
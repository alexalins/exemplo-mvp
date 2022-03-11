package com.example.estudo.mvp.presenter;

import com.example.estudo.mvp.mvp.LoginContrato;
import com.example.estudo.mvp.util.LoginUtil;

public class LoginPresenter implements LoginContrato.Presenter {

    private LoginContrato.View view;

    public LoginPresenter(LoginContrato.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.bindViews();
    }

    @Override
    public void isLoginValid(String user, String password) {
        if(user.isEmpty() || password.isEmpty()) {
            view.displayErrorMessage();
        } else {
            if(password.equals(LoginUtil.getPASSWORD()) && user.equals(LoginUtil.getUSERNAME())) {
                view.displaySucessToast();
                view.startHomeActivity();
            }else {
                view.displayErrorMessage();
            }
        }
    }
}

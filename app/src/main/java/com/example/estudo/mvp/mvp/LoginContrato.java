package com.example.estudo.mvp.mvp;

import com.example.estudo.mvp.model.User;

public interface LoginContrato {
    interface View extends BaseContrato.BaseView<Presenter> {
        void displayErrorMessage();
        void displaySucessToast();
        void startHomeActivity();
    }

    interface Presenter extends BaseContrato.BasePresenter {
        void isLoginValid(String user, String password);
    }
}

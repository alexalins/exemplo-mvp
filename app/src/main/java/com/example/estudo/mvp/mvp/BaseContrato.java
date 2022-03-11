package com.example.estudo.mvp.mvp;

public interface BaseContrato {
    interface BaseView<T> {
        void setPresenter(T presenter);
        void bindViews();
    }

    interface BasePresenter {
        void start();
    }
}

package com.example.thear.ecampus20.dagger;

import com.example.thear.ecampus20.dagger.module.NavigatorModule;
import com.example.thear.ecampus20.dagger.module.ServiceModule;
import com.example.thear.ecampus20.dagger.module.SharedPreferencesModule;
import com.example.thear.ecampus20.presentation.presenter.main.BulletinsPresenter;
import com.example.thear.ecampus20.presentation.presenter.main.LoginPresenter;
import com.example.thear.ecampus20.presentation.presenter.main.MainPresenter;
import com.example.thear.ecampus20.presentation.presenter.main.SplashPresenter;
import com.example.thear.ecampus20.ui.activity.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by aleks on 12.05.2017.
 */
@Singleton
@Component(modules = {NavigatorModule.class, SharedPreferencesModule.class, ServiceModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
    void inject(MainPresenter presenter);
    void inject(LoginPresenter presenter);
    void inject(SplashPresenter presenter);
    void inject(BulletinsPresenter presenter);
}

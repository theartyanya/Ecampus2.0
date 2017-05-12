package com.example.thear.ecampus20.dagger;

import com.example.thear.ecampus20.dagger.module.NavigatorModule;
import com.example.thear.ecampus20.dagger.module.SharedPreferencesModule;
import com.example.thear.ecampus20.presentation.presenter.initial.InitialPresenter;
import com.example.thear.ecampus20.ui.activity.initial.InitialActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by aleks on 12.05.2017.
 */
@Singleton
@Component(modules = {NavigatorModule.class, SharedPreferencesModule.class})
public interface AppComponent {

    void inject(InitialActivity activity);

    void inject(InitialPresenter presenter);
}

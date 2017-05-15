package com.example.thear.ecampus20;

import android.app.Application;

import com.example.thear.ecampus20.dagger.AppComponent;
import com.example.thear.ecampus20.dagger.DaggerAppComponent;
import com.example.thear.ecampus20.dagger.module.ModeModule;
import com.example.thear.ecampus20.dagger.module.NavigatorModule;
import com.example.thear.ecampus20.dagger.module.ServiceModule;
import com.example.thear.ecampus20.dagger.module.SharedPreferencesModule;
import com.example.thear.ecampus20.dagger.module.TokenModule;

/**
 * Created by aleks on 12.05.2017.
 */

public class CampusApplication extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .navigatorModule(new NavigatorModule())
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .serviceModule(new ServiceModule())
                .tokenModule(new TokenModule())
                .modeModule(new ModeModule())
                .build();
    }


}

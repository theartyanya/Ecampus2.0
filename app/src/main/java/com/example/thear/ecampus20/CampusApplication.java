package com.example.thear.ecampus20;

import android.app.Application;

import com.example.thear.ecampus20.dagger.AppComponent;
import com.example.thear.ecampus20.dagger.DaggerAppComponent;
import com.example.thear.ecampus20.dagger.module.NavigatorModule;
import com.example.thear.ecampus20.dagger.module.SharedPreferencesModule;

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
                .build();
    }


}
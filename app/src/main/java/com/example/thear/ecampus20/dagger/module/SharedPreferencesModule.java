package com.example.thear.ecampus20.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.thear.ecampus20.commons.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aleks on 12.05.2017.
 */
@Module
public class SharedPreferencesModule {
    private SharedPreferences preferences;

    public SharedPreferencesModule(Context context) {
        this.preferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return preferences;
    }
}

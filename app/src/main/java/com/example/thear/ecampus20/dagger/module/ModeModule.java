package com.example.thear.ecampus20.dagger.module;

import com.example.thear.ecampus20.dagger.holder.ModeHolder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aleks on 16.05.2017.
 */
@Module
public class ModeModule {
    private ModeHolder modeHolder;

    public ModeModule() {
        this.modeHolder = new ModeHolder();
    }

    @Provides
    ModeHolder provideModeHolder() {
        return this.modeHolder;
    }
}

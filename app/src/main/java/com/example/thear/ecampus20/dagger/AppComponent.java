package com.example.thear.ecampus20.dagger;

import com.example.thear.ecampus20.dagger.module.ModeModule;
import com.example.thear.ecampus20.dagger.module.NavigatorModule;
import com.example.thear.ecampus20.dagger.module.ServiceModule;
import com.example.thear.ecampus20.dagger.module.SharedPreferencesModule;
import com.example.thear.ecampus20.dagger.module.TokenModule;
import com.example.thear.ecampus20.presentation.presenter.BulletinsPresenter;
import com.example.thear.ecampus20.presentation.presenter.CreditFilterPresenter;
import com.example.thear.ecampus20.presentation.presenter.CreditPresenter;
import com.example.thear.ecampus20.presentation.presenter.DisciplineFilterPresenter;
import com.example.thear.ecampus20.presentation.presenter.DisciplinePresenter;
import com.example.thear.ecampus20.presentation.presenter.LoginPresenter;
import com.example.thear.ecampus20.presentation.presenter.MainPresenter;
import com.example.thear.ecampus20.presentation.presenter.ModuleChoicePresenter;
import com.example.thear.ecampus20.presentation.presenter.NpFilterPresenter;
import com.example.thear.ecampus20.presentation.presenter.RnPresenter;
import com.example.thear.ecampus20.presentation.presenter.RnpDetailPresenter;
import com.example.thear.ecampus20.presentation.presenter.RnpFilterPresenter;
import com.example.thear.ecampus20.presentation.presenter.RnpPresenter;
import com.example.thear.ecampus20.presentation.presenter.SplashPresenter;

import com.example.thear.ecampus20.presentation.presenter.discipline_choice.DisciplineChoicePresenter;
import com.example.thear.ecampus20.presentation.presenter.discipline_choice.DisciplineSemestrPresenter;
import com.example.thear.ecampus20.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NavigatorModule.class,
        SharedPreferencesModule.class,
        ServiceModule.class,
        TokenModule.class,
        ModeModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
    void inject(MainPresenter presenter);
    void inject(LoginPresenter presenter);
    void inject(SplashPresenter presenter);
    void inject(BulletinsPresenter presenter);
    void inject(DisciplineChoicePresenter presenter);
    void inject(DisciplineSemestrPresenter presenter);
    void inject(RnPresenter presenter);
    void inject(NpFilterPresenter presenter);
    void inject(ModuleChoicePresenter presenter);
    void inject(RnpFilterPresenter presenter);
    void inject(RnpPresenter presenter);
    void inject(RnpDetailPresenter presenter);
    void inject(DisciplineFilterPresenter presenter);
    void inject(DisciplinePresenter presenter);
    void inject(CreditFilterPresenter presenter);
    void inject(CreditPresenter presenter);
}

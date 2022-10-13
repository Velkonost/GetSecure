package com.get.secure.ui

import androidx.lifecycle.ViewModel
import com.get.secure.di.scope.ViewModelKey
import com.get.secure.vm.BaseViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CommonViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    fun baseViewModel(m: BaseViewModel): ViewModel

}
package org.vfongmala.kmpsample.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.vfongmala.kmpsample.viewmodel.AppViewModel
import org.vfongmala.kmpsample.repository.SampleRepository
import org.vfongmala.kmpsample.repository.SampleRepositoryImpl

val appModule = module {
    singleOf(::SampleRepositoryImpl) { bind<SampleRepository>() }
    viewModelOf(::AppViewModel)
}
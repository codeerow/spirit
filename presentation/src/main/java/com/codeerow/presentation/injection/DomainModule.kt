package com.codeerow.presentation.injection

import com.codeerow.presentation.data.usecases.RandomizedUseCase
import org.koin.dsl.module


val useCaseModule = module {
    factory { RandomizedUseCase() }
}

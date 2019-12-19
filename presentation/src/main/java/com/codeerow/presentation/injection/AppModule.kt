package com.codeerow.presentation.injection


val app = listOf(
        useCaseModule, // Domain
        viewModels, errorHandling, executors // Presentation
)

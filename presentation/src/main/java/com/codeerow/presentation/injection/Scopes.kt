package com.codeerow.presentation.injection

import javax.inject.Scope


/* Specifies that the lifespan of updateList dependency be the same as that of an Activity instead of the entire Application */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity


/* Specifies that the lifespan of updateList dependency be the same as that of an Fragment instead of the entire Application */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment


/* Specifies that the lifespan of updateList dependency be the same as that of an ChildFragment instead of the entire Application */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerChildFragment
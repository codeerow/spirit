# Model-View-ViewModel library for android

Spirit is the Android library for easily implementing MVVM architecture.
Library based on new Android Architecture Components (ViewModel and LiveData) and RxJava.
Inside repo you can find some complicated and not workflows that easily
handled with Spirit.

Spirit offers the following features:

* MVVM structure out of box.
* Navigation core that makes even hard navigation easy.
* UIConfiguration core with ready to use ToolbarConfiguration and BottomNavigationConfiguration
  that makes managing application UI easy.
* Some usefull extensions.


## ProGuard
Spirit is completely without reflection! No special ProGuard rules required.


## Installation

Gradle is the only supported build configuration.

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Step 2. Add the dependency
```groovy
dependencies {
        implementation 'com.github.codeerow:spirit:1.3.0'
}
```
The latest version of Spirit is [![](https://jitpack.io/v/codeerow/spirit.svg)](https://jitpack.io/#codeerow/spirit)

package com.codeerow.presentation

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.codeerow.presentation.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, true, false)


    @Test
    @Throws(Exception::class)
    fun navigateThroughApp() {
        activityRule.launchActivity(null)

        onView(withId(R.id.tvTitle)).check(matches(withText("A")))

        onView(withId(R.id.btnNavigateB)).perform(click())
        onView(withId(R.id.tvTitle)).check(matches(withText("B")))

        onView(withId(R.id.btnNavigateC)).perform(click())
        onView(withId(R.id.tvTitle)).check(matches(withText("C")))

        onView(withId(R.id.btnNavigateD)).perform(click())
        onView(withId(R.id.tvTitle)).check(matches(withText("D")))

        onView(withId(R.id.btnNavigateA)).perform(click())
        onView(withId(R.id.tvTitle)).check(matches(withText("A")))
    }

}
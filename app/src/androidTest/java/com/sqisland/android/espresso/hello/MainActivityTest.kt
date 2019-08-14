package com.sqisland.android.espresso.hello

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)//means all tests in this class are android tests
class MainActivityTest {
    // activity test rule:tell espresso which activity to launch before run its test method
    @Rule //means that this is a Junit test rule
    @JvmField // a Kotlin specific fix --to make the test rule work
    var activityRule = ActivityTestRule<MainActivity>(
            MainActivity::class.java
    )

    @Test
    fun greet() {
        //onView tells espresso we are looking for a view
        //onView will wait till the app is idle
        onView(withId(R.id.greeting))//withId tells which id to view
                .check(matches(withText("")))

        onView(withId(R.id.greet_button))
                .perform(click())
                .check(matches(not(isEnabled())))//not comes from Hamcrest library

        onView(withId(R.id.greeting))//withId tells which id to view
                .check(matches(withText(R.string.hello)))//string resources: checking the value inside a string resource
    }
}
package com.kevcar.uitestdemo

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @JvmField
    @Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAdd() {
        mainActivity {
            matchCounterText("0")
            tapAdd()
            matchCounterText("1")
            tapAdd()
            tapAdd()
            matchCounterText("3")
        }
    }
    
    @Test
    fun testSubtract() {
        mainActivity {
            matchCounterText("0")
            tapSubtract()
            matchCounterText("-1")
            tapSubtract()
            tapSubtract()
            matchCounterText("-3")
        }
    }
    
    @Test
    fun testAddAndSubtract() {
        mainActivity {
            matchCounterText("0")
            tapAdd()
            tapSubtract()
            matchCounterText("0")
            tapSubtract()
            tapSubtract()
            matchCounterText("-2")
            tapAdd()
            matchCounterText("-1")
        }
    }

    private class MainActivityRobot {
        fun tapAdd() = onView(withId(R.id.add)).perform(click())
        fun tapSubtract() = onView(withId(R.id.subtract)).perform(click())
        fun matchCounterText(text: String) = onView(withId(R.id.counter_text)).check(matches(withText(text)))
    }

    private fun mainActivity(func: MainActivityRobot.() -> Unit) = MainActivityRobot().apply(func)
}

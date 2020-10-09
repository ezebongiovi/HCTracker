package com.weekendwars.hc.`object`

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.weekendwars.hc.R
import com.weekendwars.hc.view.activity.HomeActivity
import junit.framework.Assert.assertEquals

class HomeActivityObject {

    fun launch(): HomeActivityObject {
        launchActivity<HomeActivity>()

        return this
    }

    fun clickButton(): HomeActivityObject {
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())

        return this
    }

    fun validate(expectedValue: Int) {
        Espresso.onView(ViewMatchers.withText(expectedValue.toString()))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
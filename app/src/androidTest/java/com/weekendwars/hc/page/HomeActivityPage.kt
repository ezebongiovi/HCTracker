package com.weekendwars.hc.page

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.weekendwars.hc.KoinTestApp
import com.weekendwars.hc.R
import com.weekendwars.hc.`object`.HomeActivityObject
import com.weekendwars.hc.view.activity.HomeActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class HomeActivityPage {

    private lateinit var koinApp: KoinTestApp
    private lateinit var scenario: ActivityScenario<HomeActivity>

    @Before
    fun setup() {
        koinApp = ApplicationProvider.getApplicationContext()

        koinApp.setUpModule(module {

        })
    }

    @After
    fun shutDown() {
        koinApp.closeKoin()
    }

    @Test
    fun test() {
        HomeActivityObject()
            .launch()
            .clickButton()
            .validate(1)
    }
}
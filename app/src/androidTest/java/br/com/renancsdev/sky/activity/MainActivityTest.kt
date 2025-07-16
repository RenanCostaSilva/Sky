package br.com.renancsdev.sky.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.presentation.ui.activity.MainActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("br.com.renancsdev.sky", appContext.packageName)
    }

    @get:Rule
    val main = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testeRecyclerViewCliqueMain(){

        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.rv_sky_filmes)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                ViewActions.click()
            )
        )

    }

}
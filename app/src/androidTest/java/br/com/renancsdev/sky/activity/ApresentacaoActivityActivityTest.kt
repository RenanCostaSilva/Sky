package br.com.renancsdev.sky.activity

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.presentation.ui.activity.ApresentacaoActivity
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ApresentacaoActivityActivityTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("br.com.renancsdev.sky", appContext.packageName)
    }

    @get:Rule
    val detalhe = ActivityScenarioRule(ApresentacaoActivity::class.java)

    @Test
    fun testeExibicaoTelaApresentacao(){
        Espresso.onView(ViewMatchers.withText(R.string.label_nome_app))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.withText(""))))
        Espresso.onView(ViewMatchers.withText(R.string.label_app_mensagem))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.withText(""))))
    }

}
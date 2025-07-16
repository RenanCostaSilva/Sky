package br.com.renancsdev.sky.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.presentation.ui.activity.DetalheFilmesActivity
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DetalheFilmesActivityActivityTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("br.com.renancsdev.sky", appContext.packageName)
    }

    @get:Rule
    val detalhe = ActivityScenarioRule(DetalheFilmesActivity::class.java)

    @Test
    fun testarExibicaoDasImagensEmDetalhe(){
        // Detalhe item selecionado eventos

        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.rv_sky_filmes)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                ViewActions.click()
            )
        )

        //Imagem
        Espresso.onView(ViewMatchers.withId(R.id.detalhe_video_thumb))
            .check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.detalhe_video_wallpapper))
            .check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))
    }

    @Test
    fun testarExibicaoDosTextosEmDetalhe(){
        // Detalhe item selecionado eventos

        //Texto
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.rv_sky_filmes)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withText(R.string.texto_nome_filme))
            .check(ViewAssertions.doesNotExist())
        Espresso.onView(ViewMatchers.withText(R.string.texto_descricao_filme))
            .check(ViewAssertions.doesNotExist())
        Espresso.onView(ViewMatchers.withId(R.id.detalhe_video_nome))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.withText(""))))
        Espresso.onView(ViewMatchers.withId(R.id.detalhe_video_descricao))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.withText(""))))

    }

}
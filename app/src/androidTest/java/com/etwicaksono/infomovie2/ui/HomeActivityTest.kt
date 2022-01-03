package com.etwicaksono.infomovie2.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.utils.DataDummy
import com.etwicaksono.infomovie2.utils.getRuntime
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val dummyMovie = DataDummy.getAllMovies()
    private val dummyTvShow = DataDummy.getAllTvShows()

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<HomeActivity> = ActivityTestRule(HomeActivity::class.java)


    @Test
    fun loadMovie() {
        onView(allOf(withId(R.id.rv_film), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }


    @Test
    fun loadDetailMovie() {
        onView(allOf(withId(R.id.rv_film), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )
        onView(withId(R.id.tv_header)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(context.resources.getString(R.string.detail_movie))))
        }
        onView(withId(R.id.tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie[0].title)))
        }
        onView(withId(R.id.tv_genre)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie[0].genres)))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie[0].releaseDate)))
        }
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie[0].director)))
        }
        onView(withId(R.id.tv_actors)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie[0].actors)))
        }
        onView(withId(R.id.tv_runtime)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie[0].runtime?.let {
                getRuntime(
                    it.toInt()
                )
            })))
        }
        onView(withId(R.id.tv_plot)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie[0].plot)))
        }
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTVShow() {
        onView(allOf(withId(R.id.rv_film), isDisplayed()))
        onView(withId(R.id.view_pager)).perform(ViewActions.swipeLeft())
        sleep(1000)
        onView(allOf(withId(R.id.rv_film), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(allOf(withId(R.id.rv_film), isDisplayed()))
        onView(withId(R.id.view_pager)).perform(ViewActions.swipeLeft())
        sleep(1000)
        onView(allOf(withId(R.id.rv_film), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )
        onView(withId(R.id.tv_header)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(context.resources.getString(R.string.detail_tv_show))))
        }
        onView(withId(R.id.tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow[0].title)))
        }
        onView(withId(R.id.tv_genre)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow[0].genres)))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow[0].releaseDate)))
        }
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow[0].director)))
        }
        onView(withId(R.id.tv_actors)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow[0].actors)))
        }
        onView(withId(R.id.tv_runtime)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow[0].runtime?.let {
                getRuntime(
                    it.toInt()
                )
            })))
        }
        onView(withId(R.id.tv_plot)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow[0].plot)))
        }
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
    }
}
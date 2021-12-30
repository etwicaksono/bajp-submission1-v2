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
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val dummyMovie = DataDummy.getAllMovies()
    private val dummyTvShow = DataDummy.getAllTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadTVShow() {
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()))
        onView(withId(R.id.view_pager)).perform(ViewActions.swipeRight())
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_header)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_header)).check(matches(withText(context.resources.getString(R.string.detail_movie))))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovie[0].genres)))
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtime)).check(matches(withText(dummyMovie[0].runtime)))
        onView(withId(R.id.tv_plot)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_plot)).check(matches(withText(dummyMovie[0].plot)))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.view_pager)).perform(ViewActions.swipeRight())
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_header)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_header)).check(matches(withText(context.resources.getString(R.string.detail_tv_show))))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyTvShow[0].genres)))
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyTvShow[0].releaseDate)))
        onView(withId(R.id.tv_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtime)).check(matches(withText(dummyTvShow[0].runtime)))
        onView(withId(R.id.tv_plot)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_plot)).check(matches(withText(dummyTvShow[0].plot)))
    }
}
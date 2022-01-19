package com.etwicaksono.infomovie2.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.utils.DataDummy
import com.etwicaksono.infomovie2.utils.EspressoIdlingResource
import com.etwicaksono.infomovie2.utils.Helper.getRuntime
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.Thread.sleep

class HomeActivityTest {
    private val dummyListMovie = DataDummy.getAllMoviesDummy()
    private val dummyListTvShow = DataDummy.getAllTvShowsDummy()
    private val dummyMovie = DataDummy.getMovieDummy()
    private val dummyTvShow = DataDummy.getTvShowDummy()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }


    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.rv_film), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyListMovie.size
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
        onView(withId(R.id.tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyListMovie[0].title)))
        }
        onView(withId(R.id.tv_genre)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie.genres)))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie.releaseDate)))
        }
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie.runtime?.let {
                getRuntime(
                    it.toInt()
                )
            })))
        }
        onView(withId(R.id.tv_plot)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyMovie.overview)))
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
                dummyListTvShow.size
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
        onView(withId(R.id.tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow.title)))
        }
        onView(withId(R.id.tv_genre)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow.genres)))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow.releaseDate)))
        }
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow.runtime?.let {
                getRuntime(
                    it.toInt()
                )
            })))
        }
        onView(withId(R.id.tv_plot)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dummyTvShow.overview)))
        }
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
    }
}

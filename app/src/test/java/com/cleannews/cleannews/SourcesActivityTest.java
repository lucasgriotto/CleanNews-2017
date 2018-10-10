package com.cleannews.cleannews;

import com.cleannews.cleannews.ui.sourcelist.SourcesActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import retrofit2.Retrofit;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by lucas on 11/3/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)

public class SourcesActivityTest {

    private SourcesActivity activity;
    //private MockWebServer mMockServer = new MockWebServer();
    @Inject
    private Retrofit retrofit;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(SourcesActivity.class)
                .create()
                .start()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveFragment() throws Exception {
        assertNotNull(activity.getSupportFragmentManager().findFragmentById(R.id.fragmentContainer));
    }

    @Test
    public void testMockResponse() throws Exception {
        //String url = mMockServer.url("/").toString();
//        InputStream inputStream = activity.getResources().openRawResource(R.raw.sources);
       //InputStream inputStream = this.getClass().getResourceAsStream("sources");

        //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/test/sources");
        //InputStream inputStream = activity.getResources().openRawResource(com.cleannews.cleannews.test.R.);
       // String res = TestUtil.inputStreamToString(inputStream);
//        server.enqueue(new MockResponse().setResponseCode(200).setBody(res));
//        Intent intent = new Intent();
//        activityTestRule.launchActivity(intent);
//        // Check RecyclerView has one item
//        onView(withId(R.id.list_sources)).check(new RecyclerViewItemCountAssertion(1));
    }

}

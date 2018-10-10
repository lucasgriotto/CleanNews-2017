package com.cleannews.cleannews;

import com.cleannews.cleannews.data.api.SourceArticleService;
import com.cleannews.cleannews.data.repository.remote.SourceArticleRemoteDataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by lucas on 10/11/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)

public class SourceArticleRemoteDataSourceTest {

    @Mock
    SourceArticleService sourceArticleService;

    private SourceArticleRemoteDataSource sourceArticleRemoteDataSource;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.sourceArticleRemoteDataSource = new SourceArticleRemoteDataSource(sourceArticleService);
    }

    @Test
    public void testEmptyListResponse() throws Exception {
        // given
        //when(sourceArticleService.getSources()).thenReturn();
        // when

    }

}

package com.cleannews.cleannews.repository;

import com.cleannews.cleannews.BuildConfig;
import com.cleannews.cleannews.data.api.SourceArticleService;
import com.cleannews.cleannews.data.api.response.ArticlesResponse;
import com.cleannews.cleannews.data.api.response.SourcesResponse;
import com.cleannews.cleannews.data.repository.remote.SourceArticleRemoteDataSource;
import com.cleannews.cleannews.di.CleanNewsApplicationTest;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static io.reactivex.Observable.just;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lucas on 10/31/17.
 */

@Config(constants = BuildConfig.class, application = CleanNewsApplicationTest.class)
@RunWith(RobolectricTestRunner.class)
//@RunWith(MockitoJUnitRunner.class)
public class SourceArticleRemoteDataSourceTest {

    private SourceArticleRemoteDataSource sourceArticleRemoteDataSource;

    @Inject
    private SourceArticleService sourceArticleService;

    private Source source;

    @Before
    public void setUp() {
        sourceArticleRemoteDataSource = new SourceArticleRemoteDataSource(sourceArticleService);

        source = new Source();
        List<String> sort = new ArrayList<>();
        sort.add("");
        source.setSortBysAvailable(sort);
        source.setId("");
    }

    @Test
    public void testGetArticlesBySourceFromApi() {
        ArticlesResponse fakeArticleResponse = new ArticlesResponse();
        Observable<ArticlesResponse> fakeObservable = just(fakeArticleResponse);
        given(sourceArticleService.getArticlesBySource(anyString(), anyString())).willReturn(fakeObservable);
        sourceArticleRemoteDataSource.getArticlesBySource(source);
        verify(sourceArticleService).getArticlesBySource(anyString(),anyString());
    }

    @Test
    public void testGetSourcesFromApi() {
        SourcesResponse fakeSourcesResponse = new SourcesResponse();
        Observable<SourcesResponse> fakeObservable = just(fakeSourcesResponse);
        given(sourceArticleService.getSources()).willReturn(fakeObservable);
        sourceArticleRemoteDataSource.getSources();
        verify(sourceArticleService).getSources();

        TestObserver<List<Source>> testObserver = sourceArticleRemoteDataSource.getSources().test();
    }

    @Test
    public void testGetMockSourcesFromApi() {
        SourcesResponse fakeSourcesResponse = new SourcesResponse();
        Observable<SourcesResponse> fakeObservable = just(fakeSourcesResponse);
        when(sourceArticleService.getSources()).thenReturn(fakeObservable);
        TestObserver<List<Source>> testObserver = sourceArticleRemoteDataSource.getSources().test();
        testObserver.awaitTerminalEvent();
//        testObserver
//                .assertNoErrors()
//                .assertValue();

    }



}

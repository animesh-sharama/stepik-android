package org.stepik.android.data.search.source

import io.reactivex.Single
import org.stepic.droid.web.QueriesResponse
import org.stepic.droid.web.SearchResultResponse

interface SearchRemoteDataSource {
    fun getSearchResultsCourses(page: Int, rawQuery: String?): Single<SearchResultResponse>
    fun getSearchQueries(query: String): Single<QueriesResponse>
}
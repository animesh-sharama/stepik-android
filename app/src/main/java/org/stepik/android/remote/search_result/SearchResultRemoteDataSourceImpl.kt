package org.stepik.android.remote.search_result

import io.reactivex.Single
import org.stepic.droid.util.PagedList
import org.stepik.android.data.search_result.source.SearchResultRemoteDataSource
import org.stepik.android.domain.search_result.model.SearchResultQuery
import org.stepik.android.model.SearchResult
import org.stepik.android.remote.base.mapper.toPagedList
import org.stepik.android.remote.search_result.mapper.SearchResultQueryMapper
import org.stepik.android.remote.search_result.model.SearchResultResponse
import org.stepik.android.remote.search_result.service.SearchResultService
import javax.inject.Inject

class SearchResultRemoteDataSourceImpl
@Inject
constructor(
    private val searchResultService: SearchResultService,
    private val searchResultQueryMapper: SearchResultQueryMapper
) : SearchResultRemoteDataSource {
    override fun getSearchResults(searchResultQuery: SearchResultQuery): Single<PagedList<SearchResult>> =
        searchResultService
            .getSearchResults(searchResultQueryMapper.mapToQueryMap(searchResultQuery))
            .map { it.toPagedList(SearchResultResponse::searchResultList) }
}
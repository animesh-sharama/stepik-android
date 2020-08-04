package org.stepik.android.data.analytic.repository

import io.reactivex.Completable
import org.stepik.android.cache.analytic.model.AnalyticLocalEvent
import org.stepik.android.data.analytic.mapper.AnalyticBatchMapper
import org.stepik.android.data.analytic.source.AnalyticCacheDataSource
import org.stepik.android.data.analytic.source.AnalyticRemoteDataSource
import org.stepik.android.domain.analytic.repository.AnalyticRepository
import javax.inject.Inject

class AnalyticRepositoryImpl
@Inject
constructor(
    private val analyticBatchMapper: AnalyticBatchMapper,
    private val analyticRemoteDataSource: AnalyticRemoteDataSource,
    private val analyticCacheDataSource: AnalyticCacheDataSource
) : AnalyticRepository {
    override fun logEvent(analyticEvent: AnalyticLocalEvent): Completable =
        analyticCacheDataSource.logEvent(analyticEvent)

    override fun flushEvents(): Completable =
        analyticCacheDataSource
            .getEvents()
            .takeUntil { it.isEmpty() }
            .flatMapCompletable { events ->
                val batchEvents = analyticBatchMapper.mapLocalToBatchEvents(events)
                analyticRemoteDataSource
                    .flushEvents(batchEvents)
                    .andThen(analyticCacheDataSource.clearEvents(events))
            }
}
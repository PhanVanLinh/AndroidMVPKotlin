package vn.linh.androidmvp.data.source.remote.api

import io.reactivex.Single
import vn.linh.androidmvp.data.model.Image
import vn.linh.androidmvp.data.source.local.ImageLocalDataSource
import vn.linh.androidmvp.data.source.remote.ImageRemoteDataSource
import javax.inject.Inject

class ImageRepository @Inject constructor(private val localDataSource: ImageLocalDataSource,
                                          private val remoteDataSource: ImageRemoteDataSource
) {
    fun getImage(): Single<List<Image>> {
        return remoteDataSource.getImage().map{ it.images }
    }
}

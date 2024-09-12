package com.example.general.day.ui.core.utils

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.collections.MarkerManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ZoneClusterManager @AssistedInject constructor(
    @Assisted googleMap: GoogleMap,
    context: Context,
) : ClusterManager<ZoneClusterItem>(context, googleMap, MarkerManager(googleMap))


@AssistedFactory
interface ZoneClusterManagerFactory {
    fun create(
        @Assisted googleMap: GoogleMap
    ): ZoneClusterManager
}
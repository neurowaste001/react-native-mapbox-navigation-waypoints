package com.mapboxnavigation

import android.view.View
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.uimanager.SimpleViewManager

abstract class MapboxNavigationViewManagerSpec<T : View> : SimpleViewManager<T>() {
  abstract fun setWaypoints(view: T?, value: ReadableArray)
  abstract fun setDirectionUnit(view: T?, value: String?)
  abstract fun setLocal(view: T?, language: String?)
  abstract fun setMute(view: T?, value: Boolean)
  abstract fun setShowCancelButton(view: T?, value: Boolean)
  abstract fun setTravelMode(view: T?, value: String?)
  abstract fun setOverlap(view: T?, value: Int)
  abstract fun setBatchSize(view: T?, value: Int)
  abstract fun setPreloadTriggerLeg(view: T?, value: Int)
}

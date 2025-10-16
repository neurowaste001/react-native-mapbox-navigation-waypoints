package com.mapboxnavigation

import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.mapbox.api.directions.v5.models.DirectionsWaypoint
import com.mapbox.geojson.Point

@ReactModule(name = MapboxNavigationViewManager.NAME)
class MapboxNavigationViewManager(private var reactContext: ReactApplicationContext): MapboxNavigationViewManagerSpec<MapboxNavigationView>() {
  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): MapboxNavigationView {
    return MapboxNavigationView(context)
  }

  override fun onDropViewInstance(view: MapboxNavigationView) {
    view.onDropViewInstance()
    super.onDropViewInstance(view)
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Map<String, String>> {
    return MapBuilder.of(
      "onLocationChange", MapBuilder.of("registrationName", "onLocationChange"),
      "onError", MapBuilder.of("registrationName", "onError"),
      "onCancelNavigation", MapBuilder.of("registrationName", "onCancelNavigation"),
      "onArrive", MapBuilder.of("registrationName", "onArrive"),
      "onRouteProgressChange", MapBuilder.of("registrationName", "onRouteProgressChange"),
    )
  }

  @ReactProp(name = "distanceUnit")
  override fun setDirectionUnit(view: MapboxNavigationView?, value: String?) {
    if (value != null)  {
      view?.setDirectionUnit(value)
    }
  }

  @ReactProp(name = "waypoints")
  override fun setWaypoints(view: MapboxNavigationView?, value: ReadableArray) {
    val waypoints: List<Point> = value.toArrayList().mapIndexedNotNull { index, item ->
      val map = item as? Map<*, *>
      val latitude = map?.get("latitude") as? Double
      val longitude = map?.get("longitude") as? Double
      if (latitude != null && longitude != null) {
        Point.fromLngLat(longitude, latitude)
      } else {
        null
      }
    }
    view?.setWaypoints(waypoints)
  }

  @ReactProp(name = "language")
  override fun setLocal(view: MapboxNavigationView?, language: String?) {
    if (language !== null) {
      view?.setLocal(language)
    }
  }

  @ReactProp(name = "showCancelButton")
  override fun setShowCancelButton(view: MapboxNavigationView?, value: Boolean) {
    view?.setShowCancelButton(value)
  }

  @ReactProp(name = "mute")
  override fun setMute(view: MapboxNavigationView?, value: Boolean) {
    view?.setMute(value)
  }

  @ReactProp(name = "travelMode")
  override fun setTravelMode(view: MapboxNavigationView?, value: String?) {
    if (value != null)  {
      view?.setTravelMode(value)
    }
  }

  @ReactProp(name = "overlap")
  override fun setOverlap(view: MapboxNavigationView?, value: Int) {
    view?.setOverlap(value)
  }

  @ReactProp(name = "batchSize")
  override fun setBatchSize(view: MapboxNavigationView?, value: Int) {
    view?.setBatchSize(value)
  }

  @ReactProp(name = "preloadTriggerLeg")
  override fun setPreloadTriggerLeg(view: MapboxNavigationView?, value: Int) {
    view?.setPreloadTriggerLeg(value)
  }

  companion object {
    const val NAME = "MapboxNavigationView"
  }
}

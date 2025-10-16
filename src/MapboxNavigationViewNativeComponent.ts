import type { HostComponent, ViewProps } from 'react-native';

import type { Double } from 'react-native/Libraries/Types/CodegenTypes';
import type { NativeEventsProps } from './types';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import { requireNativeComponent } from 'react-native';

interface NativeProps extends ViewProps {
  mute?: boolean;
  distanceUnit?: string;
  waypoints: {
    latitude: Double;
    longitude: Double;
    name?: string;
  }[];
  language?: string;
  showCancelButton?: boolean;
  shouldSimulateRoute?: boolean;
  showsEndOfRouteFeedback?: boolean;
  hideStatusView?: boolean;
  travelMode?: string;
  overlap?: number;
  batchSize?: number;
  preloadTriggerLeg?: number;
}

let component;
try {
  component = codegenNativeComponent<NativeProps>('MapboxNavigationView');
} catch (e) {
  component = requireNativeComponent<NativeProps>('MapboxNavigationView');
}
export default component as HostComponent<NativeProps & NativeEventsProps>;

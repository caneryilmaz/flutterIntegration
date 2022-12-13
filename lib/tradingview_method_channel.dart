import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'tradingview_platform_interface.dart';

/// An implementation of [TradingviewPlatform] that uses method channels.
class MethodChannelTradingview extends TradingviewPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('tradingview');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}

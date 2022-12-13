import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'tradingview_method_channel.dart';

abstract class TradingviewPlatform extends PlatformInterface {
  /// Constructs a TradingviewPlatform.
  TradingviewPlatform() : super(token: _token);

  static final Object _token = Object();

  static TradingviewPlatform _instance = MethodChannelTradingview();

  /// The default instance of [TradingviewPlatform] to use.
  ///
  /// Defaults to [MethodChannelTradingview].
  static TradingviewPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [TradingviewPlatform] when
  /// they register themselves.
  static set instance(TradingviewPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}

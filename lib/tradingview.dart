
import 'tradingview_platform_interface.dart';

class Tradingview {
  Future<String?> getPlatformVersion() {
    return TradingviewPlatform.instance.getPlatformVersion();
  }
}

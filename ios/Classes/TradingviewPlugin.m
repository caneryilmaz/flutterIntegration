#import "TradingviewPlugin.h"
#if __has_include(<tradingview/tradingview-Swift.h>)
#import <tradingview/tradingview-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "tradingview-Swift.h"
#endif

@implementation TradingviewPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftTradingviewPlugin registerWithRegistrar:registrar];
}
@end

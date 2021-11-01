#import "SendbroadcastPlugin.h"
#if __has_include(<sendbroadcast/sendbroadcast-Swift.h>)
#import <sendbroadcast/sendbroadcast-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "sendbroadcast-Swift.h"
#endif

@implementation SendbroadcastPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftSendbroadcastPlugin registerWithRegistrar:registrar];
}
@end

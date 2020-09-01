//
//  ImageView.m
//  liveDetectDemo
//
//  Created by D先生 on 2020/8/25.
//

#import <Foundation/Foundation.h>
#import <React/RCTImageViewManager.h>

@interface RNTImageView : RCTImageViewManager
@end

@implementation RNTImageView

RCT_EXPORT_MODULE(RNTImageView)

- (UIView *)view
{
  return [[UIImageView alloc] init];
}

@end

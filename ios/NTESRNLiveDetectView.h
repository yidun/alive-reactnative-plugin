//
//  NTESRNLiveDetecrView.h
//  liveDetectDemo
//
//  Created by 罗礼豪 on 2020/8/25.
//

#import <UIKit/UIKit.h>
#import <React/RCTComponent.h>

NS_ASSUME_NONNULL_BEGIN

@interface NTESRNLiveDetectView : UIImageView

@property (nonatomic, copy) RCTBubblingEventBlock onActionChange;
@property (nonatomic, copy) RCTBubblingEventBlock onWarnChange;
@property (nonatomic, copy) RCTBubblingEventBlock onStepChange;
@property (nonatomic, copy) RCTBubblingEventBlock onResultChange;

@end

NS_ASSUME_NONNULL_END

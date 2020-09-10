# iOS 环境搭建
### 1.CocoaPods
###### CocoaPods是用 Ruby 编写的包管理器。从 0.60 版本开始 react native 的 iOS 版本需要使用 CocoaPods 来管理依赖。你可以使用下面的命令来安装 cocoapods。当然安装可能也不顺利，请尝试翻墙或寻找一些国内可用的镜像源。
```
   通过执行 sudo gem install cocoapods安装
   或者可以使用 brew 来安装 brew install cocoapods
   安装完 cocoapods 之后，通过 pod install 或者 pod update 下载第三方依赖包。
```

### 2. 编译并运行 React Native 应用
###### 在你的项目目录中运行yarn ios或者yarn react-native run-ios：
```
  cd   project。 
  yarn ios
  或者 yarn react-native run-ios
  ```
# Android 环境搭建

### 1.编译并运行 React Native 应用

###### 确保你先运行了模拟器或者连接了真机，然后在你的项目目录中运行yarn android或者yarn react-native run-android：
```
   cd  project
   yarn android 
   或者 yarn react-native run-android
  ```
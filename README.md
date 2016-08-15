# CocoaToast

A iOS-like toast for Android

# Screenshot

<p align="center">
<img src="art/sample_normal.png" width="240px">
<img src="art/sample_icon.png" width="240px">
<img src="art/sample_text.png" width="240px">
</p>

# Use

[![](https://jitpack.io/v/twiceyuan/CocoaToast.svg)](https://jitpack.io/#twiceyuan/CocoaToast)

Normal(has default icon)
```java
CocoaToast.show("Submit Success");
```

Only Icon
```java
CocoaToast.showIconOnly(R.drawable.better_toast_ic_done_white);
```

Only Text
```java
CocoaToast.showTextOnly("Submit Success");
```

Init
```java
CocoaToast.init(getApplicationContext());

// or
Config config = ...;
CocoaToast.init(getApplicationContext(), config);
```

Config
```groovy
repositories {
	...
	maven { url "https://jitpack.io" }
}

dependencies {
  compile 'com.github.twiceyuan:CocoaToast:1.0'
}
```

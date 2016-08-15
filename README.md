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

# License

```
MIT License

Copyright (c) 2016 twiceYuan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

[ ![Download](https://api.bintray.com/packages/xrubioj/securecontrols/com.xrubio.securecontrols%3Asecurecontrols/images/download.svg) ](https://bintray.com/xrubioj/securecontrols/com.xrubio.securecontrols%3Asecurecontrols/_latestVersion)

# SecureControls
Implementation of Android views that detect screen overlays.

# Download

Download via Maven:

```xml
<dependency>
  <groupId>com.xrubio.securecontrols</groupId>
  <artifactId>securecontrols</artifactId>
  <version>0.5.0</version>
  <type>pom</type>
</dependency>
```

or Gradle:

```groovy
compile 'com.xrubio.securecontrols:securecontrols:0.5.0'
```

# Usage

Currently there are implementations for `SecureButton` and `SecureImageButton`.
These are drop-in replacement for `Button` and `ImageButton` with the addition
of `windowObscuredTouchEvent`.

If the function invoked returns `true, processing of the event continues, and
the `onClickListener` is invoked normally.

```xml
<com.xrubio.securecontrols.SecureButton
    android:id="@+id/secure_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/secure_button" />
```

```kotlin
val secureButton = findViewById<SecureButton>(R.id.secure_button)
secureButton.windowObscuredTouchEvent = { _, _ ->
    Toast.makeText(this, "Screen overlay detected", Toast.LENGTH_LONG).show()
    false
}
secureButton.setOnClickListener {
    Toast.makeText(this, "Click succeeded!", Toast.LENGTH_LONG).show()
}
```

Java example:
```java
SecureButton secureButton = findViewById(R.id.secure_button);
secureButton.setWindowObscuredTouchEvent((view, motionEvent) -> {
    Toast.makeText(this, "Screen overlay detected", Toast.LENGTH_LONG).show();
    return false;
});
secureButton.setOnClickListener(view -> {
    Toast.makeText(this, "Click succeeded!", Toast.LENGTH_LONG).show();
});
```

# Contributors

Contributors are welcomed! Get in touch through Twitter at [@teknik_tdr](https://twitter.com/teknik_tdr).

## Upload to jcentral

Make sure you have the following variables in your global `gradle.properties`:

```
bintrayUser=XXX
bintrayApiKey=1234567890ABCDEF
```

Do a clean build, and after checking no errors or lint warnings are present,
upload to Bintray / jcentral: 
```
./gradlew clean build  
./gradlew bintrayUpload --info
```

# License

This workflow is licensed under Apache License 2.0. See [LICENSE](LICENSE) for more details.

```
Copyright 2017 Xavier Rubio Jansana

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

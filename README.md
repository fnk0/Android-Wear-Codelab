Android-Wear-Codelab
====================

###### Android Wear codelab for the GDG OSU Stillwater
This codelab was developed by Marcus Gabilheri to be used in the GDG OSU Stillwater I/O Extended event.
Feel free to use or modify this codelab for your own purpose.

###### Necessary Software
1. JDK - Java Development Kit
2. Android Studio
3. [Device with the Android Wear Preview beta app installed](https://play.google.com/store/apps/details?id=com.google.android.wearablepreview.app)
4. [wearable-preview-support.jar] (https://drive.google.com/file/d/0B06g43ltjGbwQUlCdXR4X2Ftcjg/edit?usp=sharing) 
5. Android Wear Emulator 

###### Installing Necessary SDK Packages
![SDK Manager] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/SDK%20Manager%20Screenshot.png)

###### Creating a new Android Wear Emulator
![Create Emulator] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Screenshot%202014-06-22%2022.09.12.png)

###### Starting the Emulator

1. Start the Emulator with the AVD Manager
2. Start the Android Wear App on your device and click in connect.
3. Navigate to android-studio/sdk/platform-tools folder and use the following command: adb -d forward tcp:5601 tcp:5601

<img src="https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/android-wear-app.png" alt="Android Wear Preview App" style="width:100px;height:150px">

<font color='red'> Not Connected :( </font>

![Not connected] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Screenshot%202014-06-22%2022.22.47.png)

<font color='red'> Connected :) </font>

![Connected] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Screenshot%202014-06-22%2022.24.08.png)

#### Creating a New Project

###### 1 - Give a name and a Package Name:

![newProject1] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Screenshot%202014-06-22%2022.36.33.png)

###### 2 - Select the Minimum SDK 15 - Android Wear 4.0 and above:

![newProject2] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Screenshot%202014-06-22%2022.36.42.png)

###### 3 - Select Blank Activity:

![blankActivity] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Screenshot%202014-06-22%2022.36.50.png)

###### 4 - Name the Activity:

![nameActivity] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Screenshot%202014-06-22%2022.37.15.png)

###### Add the necessary Libraries:

![add-libs] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Adding-libs-folder.png)

###### Add the necessary dependencies to the build.gradle file:
![dependencies] (https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/tutorial-assets/Screenshot%202014-06-22%2023.04.15.png)

<pre style="background:rgba(238,238,238,0.92);color:#000">
```java

dependencies {
    compile 'com.android.support:support-v4:19.1.+' // Support libraries
    compile fileTree(dir: 'libs', include: ['*.jar']) // This compiles all the .jar inside libs folder
}

```
</pre>

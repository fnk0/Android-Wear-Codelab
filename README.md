Android-Wear-Codelab
====================

###### Android Wear codelab for the GDG OSU Stillwater
This codelab was developed by Marcus Gabilheri to be used in the GDG OSU Stillwater I/O Extended event.
Feel free to use or modify this codelab for your own purpose.

###### Necessary Software
1. JDK - Java Development Kit
2. Android Studio
3. [Device with the Android Wear Preview beta app installed](https://play.google.com/store/apps/details?id=com.google.android.wearablepreview.app)
4. [wearable-preview-support.jar](https://drive.google.com/file/d/0B06g43ltjGbwQUlCdXR4X2Ftcjg/edit?usp=sharing) 
5. Android Wear Emulator 

###### Installing Necessary SDK Packages
![SDK Manager](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/SDK%20Manager%20Screenshot.png)

###### Creating a new Android Wear Emulator
![Create Emulator](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.09.12.png)

###### Starting the Emulator

1. Start the Emulator with the AVD Manager
2. Start the Android Wear App on your device and click in connect.
3. Navigate to android-studio/sdk/platform-tools folder and use the following command: adb -d forward tcp:5601 tcp:5601

<img src="https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/android-wear-app.png" alt="Android Wear Preview App" style="width:100px;height:150px">

<font color='red'> Not Connected :( </font>

![Not connected](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.22.47.png)

<font color='red'> Connected :) </font>

![Connected](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.24.08.png)

#### Creating a New Project

###### 1 - Give a name and a Package Name:

![newProject1](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.36.33.png)

###### 2 - Select the Minimum SDK 15 - Android Wear 4.0 and above:

![newProject2](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.36.42.png)

###### 3 - Select Blank Activity:

![blankActivity](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.36.50.png)

###### 4 - Name the Activity:

![nameActivity](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.37.15.png)

###### Add the necessary Libraries:

![add-libs](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Adding-libs-folder.png)

###### Add the necessary dependencies to the build.gradle file:
![dependencies](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2023.04.15.png)

```groovy
dependencies {
    compile 'com.android.support:support-v4:19.1.+' // Support libraries
    compile fileTree(dir: 'libs', include: ['*.jar']) // This compiles all the .jar inside libs folder
}
```

#### Creating the Notification ICON:

###### 1. Right-Click on the res folder and select new->image_asset
![add-asset](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/add-asset.png)
 
###### 2. Select "Notification Icons" from the dropdown menu and give it a resource name
![add-asset2](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/add-asset2.png)

###### 3. Check that your name and the destination is right and click in Finish. Android studio will generate all the necessary sizes for the notificiation icon as well the necessary folders.
![add-asset3](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/add-asset3.png)

#### Changing our App Icon:

The android wear notifications by default have an icon embed to it. So let's change the icon so our notifications are even more unique! 

* Grab the app icon from from [here](https://github.com/fnk0/Android-Wear-Codelab/blob/master/assets/wear-codelab-icon.png) our use any other image you want. 
* Repeat the same process of adding the notification Icon but this time select Launcher Icons. Ps: Do not change the name this time. If we leave ic_launcher as the name it will override our standard icon.
* Click in Finish and now we are all set!

#### Creating the Main Activity XML-Layout

So this might be a big chunk of code... if you alredy know Android XML layout feel free to copy and paste it. If not take a moment to go through each one of the elements! 

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity"
    android:orientation="vertical"
    android:background="#34495e"
    >
    <Button
        android:id="@+id/simpleNotification"
        android:text="Simple Notification"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/activity_vertical_margin"
        android:onClick="sendNotification"
    />
    <Button
        android:id="@+id/bigNotification"
        android:text="Big View Notification"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/activity_vertical_margin"
        android:onClick="sendNotification"
    />
    <Button
        android:id="@+id/bigNotificationWithAction"
        android:text="Big Notification With Action"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/activity_vertical_margin"
        android:onClick="sendNotification"
    />
    <TextView
        android:text="Custom Notification"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/activity_vertical_margin"
        />
    <EditText
        android:id="@+id/notificationTitle"
        android:hint="Notification Title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/activity_vertical_margin"
        />
    <EditText
        android:id="@+id/notificationMessage"
        android:hint="Notification Message"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/activity_vertical_margin"
    />
    <RadioGroup
        android:id="@+id/iconGroup"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="@dimen/activity_vertical_margin">
        <RadioButton
            android:id="@+id/icon1"
            android:drawableRight="@drawable/ic_wear_notification"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="@dimen/activity_horizontal_margin"
        />
        <RadioButton
            android:id="@+id/icon2"
            android:drawableRight="@drawable/ic_notification_2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="@dimen/activity_horizontal_margin"
        />
        <RadioButton
            android:id="@+id/icon3"
            android:drawableRight="@drawable/ic_notification3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="@dimen/activity_horizontal_margin"
            />
    </RadioGroup>
    <RadioGroup
        android:id="@+id/hideIconGroup"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="@dimen/activity_vertical_margin"
        >
        <RadioButton
            android:id="@+id/hideIcon"
            android:text="Hide Icon"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="@dimen/activity_horizontal_margin"
            />
        <RadioButton
            android:id="@+id/showIcon"
            android:text="Show Icon"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="@dimen/activity_horizontal_margin"
            />
    </RadioGroup>
    <Button
        android:id="@+id/sendCustomNotification"
        android:text="Send Custom Notification"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="sendNotification"
    />
</LinearLayout>
```
###### Your layout should look similar (or identitical) to this.
![app-screenshot](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/app-screenshot2.png)

#### Getting our hands into the coding (fun) part of the project.

Android wear let's us extend the experience of our applications by sending a notification to the wear device.
The Notifications API also let's us add Actions to the notification.
Example: In a TODO app we could send a notification to the user that is time for the task to be done and add actions such as "View Map" , "Complete Task", "Snooze", etc.. We can add a "unlimited" (try to limit your actions to a reasonable number of 3 or 4 maximum, you don't want your user to scroll forever to get to an action...) number of actions. 

######So enough has been said let's get our hands dirty!

In our XML buttons we defined the ```xml android:onClick="sendNotification" ``` method. 
So in our **MainActivity** let's define the sendNotificationMethod:

```java
public void sendNotification(View view) {
    //Now let's add a switch to catch the button that has been clicked
    // We also add a case for each of the buttons.
    switch(view.getId()) {
        case R.id.simpleNotification:
            break;
            
        case R.id.bigNotification:
            break;
            
        case R.id.bigNotificationWithAction:
            break;
            
        case R.id.sendCustomNotification:
            break;
    }
}
```

###### Adding the RadioGroups and Other UI Elements.

Add the following instance variables to your class.

```java
public class MainActivity extends Activity {
    private EditText mCustomTitle, mCustomMessage; // Edit text boxes for the custom notification
    private RadioGroup mCustomIconGroup, showHideIconGroup; // Radiogroups with the Icon and settings for the custom notification
    private int mCustomIcon; // The variable that will hold the ID of the custom icon to show
    private boolean showIcon = false; // boolean that will tell if wear should show the app icon or not
    private String LOG_TAG = "WEAR"; // Our LogCat tag for debugging purposes
    ...
```

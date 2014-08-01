Android-Wear-Codelab
====================

Last Updated AT FRIDAY - AUGUST 01 / 2014
###### Android Wear codelab for the GDG OSU Stillwater
This codelab was developed by Marcus Gabilheri to be used in the GDG OSU Stillwater I/O Extended event.
Feel free to use or modify this codelab for your own purpose.
If you find a bug leave an issue and I will fix as soon as possible. The code works but in the tutorial I might have left something.

###### Necessary Software
1. JDK - Java Development Kit
2. Android Studio 0.8.x Beta installed
3. [Device with the Android Wear app installed](https://play.google.com/store/apps/details?id=com.google.android.wearable.app)
4. Android 4.4W API 20
5. Android Wear Emulator 

###### Installing Necessary SDK Packages
![SDK Manager](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/WearSDK20.png)

###### Creating a new Android Wear Emulator
Android Studio Beta 0.8.2 Already come with some pre-built in emulator definitions that we will use as a base for our own emulators. 
![Device Defaults](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab-Preview/master/screenshots/device_defaults.png)

![Creating the emulator](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab-Preview/master/screenshots/new_device_screen.png)

![Visualizing all emulators](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab-Preview/master/screenshots/all_emulators.png)


###### Starting the Emulator

1. Start the Emulator with the AVD Manager
2. Start the Android Wear App on your device and click in connect.
3. Navigate to android-studio/sdk/platform-tools folder and use the following command: 
```adb -d forward tcp:5601 tcp:5601``` (This command should be used every time you connect your phone to the computer. Or every time you restart the emulator). If for some reason you still can not connect both devices try using ```adb devices``` and ensure that both devices are connected. 

![android-wear-app](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab-Preview/master/screenshots/phone_wear_app.fw.png)

<font style="color:'red';"> Not Connected :( </font>

![Not connected](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab-Preview/master/screenshots/wear.png)

<font color='red'> Connected :) </font>

![Connected](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab-Preview/master/screenshots/wear_connected.png)

#### Creating a New Project

###### 1 - Give a name and a Package Name:

![newProject1](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.36.33.png)

###### 2 - Select the Minimum SDK 15 - Android Wear 4.0 and above:

![newProject2](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.36.42.png)

###### 3 - Select Blank Activity:

![blankActivity](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.36.50.png)

###### 4 - Name the Activity:

![nameActivity](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/Screenshot%202014-06-22%2022.37.15.png)

###### Adding a Android Wear Module



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
![app-screenshot](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/resized-screenshot1.png)

If your layout doesn't looks like this is because of the Style. Open the file res/values/styles.xml and change:

```xml
<style name="AppTheme" parent="android:Theme.Holo.Light.DarkActionBar">
```

To... :
```xml
<style name="AppTheme" parent="android:Theme.Holo">
```

#### Getting our hands into the coding (fun) part of the project.

Android wear let's us extend the experience of our applications by sending a notification to the wear device.
The Notifications API also let's us add Actions to the notification.
Example: In a TODO app we could send a notification to the user that is time for the task to be done and add actions such as "View Map" , "Complete Task", "Snooze", etc.. We can add a "unlimited" (try to limit your actions to a reasonable number of 3 or 4 maximum, you don't want your user to scroll forever to get to an action...) number of actions. 

######So enough has been said let's get our hands dirty!

In our XML buttons we defined the ```xml android:onClick="sendNotification" ``` method. 
So in our **MainActivity** let's define the sendNotificationMethod:

```java
// Define the method to send the notifications with the same name from the Android onClick from the XML Layout
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

###### Adding the RadioGroups and Other UI Elements:
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
###### Instantiating the instance Variables and Retrieving RadioGroup input:
Inside onCreate we instantiate our UI elements and add retrieve information about which element is checked.
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Custom Title and Message for custom Notification
        mCustomTitle = (EditText) findViewById(R.id.notificationTitle);
        mCustomMessage = (EditText) findViewById(R.id.notificationMessage);
        
        // RadioGroup for the customIcon
        mCustomIconGroup = (RadioGroup) findViewById(R.id.iconGroup);
        mCustomIconGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // The name of the ICONS will change based on how you named it....
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.icon1:
                        mCustomIcon = R.drawable.ic_wear_notification;
                        break;
                    case R.id.icon2:
                        mCustomIcon = R.drawable.ic_notification_2;
                        break;
                    case R.id.icon3:
                        mCustomIcon = R.drawable.ic_notification3;
                        break;
                }
            }
        });
        
        // RadioGroup to determine if App Icons should be shown or not.
        showHideIconGroup = (RadioGroup) findViewById(R.id.hideIconGroup);
        showHideIconGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.showIcon:
                        showIcon = true;
                        break;
                    case R.id.hideIcon:
                        showIcon = false;
                        break;
                }
            }
        });
    }
```
###### Let's send some notifications to our users!!
Let's visit our ```java sendNotification()``` method again and some common code for our notifications. 
We will add this before the switch so all the variables can be shared between the notifications.
```java
// Define the method to send the notifications with the same name from the Android onClick from the XML Layout
public void sendNotification(View view) {

    // Common elements for all our notifications
    int notificationId = 001; // id- An identifier for this notification unique within your application.
    String eventTitle = "Sample Notification"; // Title for the notificaiton
    String eventText = "Text for the notification."; // Text for the notificaiton
    String intentExtra = "This is an extra String!"; // Extra String to be passed to a intent
    // A large String to be used by the BigStyle
    String eventDescription = "This is supposed to  be a content that will not fit the normal content screen"
            + " usually a bigger text, by example a long text message or email."; 

    // Build intent for notification content - This will take us to our MainActivity
    Intent viewIntent = new Intent(this, MainActivity.class);
    PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, viewIntent, 0);

    // Specify the 'big view' content to display the long
    // event description that may not fit the normal content text.
    NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
    
    // We instantiate as null because they will be changing based on which button is pressed
    NotificationCompat.Builder mBuilder = null; 
    Notification mNotification = null;

    // Get an instance of the NotificationManager service
    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

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

#### Building the Notifications: 
Now it's time to build the notification we want to display based on the user input.
You can use anything you want to build and send notifications. Can be game scores, alarm clocks, etc.. 
Let's keep it simple for this codelab and get input directly from the user.

Let's modify our switch cases for each one of our base cases.

###### 1. Simple Notification
This is the simplest form of a notification with 4 elements.
1. A drawable for the notification. We use one of the drawables created by the asset manager.
2. A title for the notification
3. A message to be displayed
4. The intent that should be opened by this notification.
```java
case R.id.simpleNotification:
    mBuilder = new NotificationCompat.Builder(this) // Instantiate the builder with our context.
            .setSmallIcon(R.drawable.ic_wear_notification) // set the icon
            .setContentTitle(eventTitle) // set the title
            .setContentText(eventText) // set the text
            .setAutoCancel(true)  // This flag makes the notification disappear when the user clicks on it!
            .setContentIntent(viewPendingIntent); // and finally the intent to be used
    break;
```

Now after the switch we add the following code to display or notification:
```java
// This code goes after the switch because is common to all our notifications.
// Build the notification and issues it with notification manager.
notificationManager.notify(notificationId, mBuilder.build());
Log.d(LOG_TAG, "Normal Notification");
```

* Now let's try it out!! Runt he App and click on the first button.
The notification should be displayed on your phone like this:

![firstNotification](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/sample-notification.png)

* The notifications should also appear on the device like this:

![wearNotification](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/simple_not.png)

* The intent will be displayed with a Open Button:

![wearNotification2](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/simple_not2.png)

###### 2. Big View Notification
Most of the contents of the big notification are the same. 
There are a few different things to pay attention here.

1. the Large Icon. The large icon is displayed behind the notificaiton as a background. The difference to the small icon is that we will be using BitmapFactory.decodeResource() decode a png file.
2. The setContentTitle and setContentText will be overriden by the bigStyle.bigText and bigStyle.setBigContentTitle.
```java
case R.id.bigNotification:
    bigStyle.bigText(eventDescription); // bigText will override setContentText
    bigStyle.setBigContentTitle("Override Title"); // bigContentTitle Override the contentTitle
    mBuilder = new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_wear_notification)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_sample_codelab))
        .setContentTitle(eventTitle) // This is unnecessary for the big notification if you use bigText
        .setContentText(eventText) // Unnecessary if setBigContentTitle is Overriden
        .setContentIntent(viewPendingIntent)
        .setAutoCancel(true)
        .setStyle(bigStyle);
    break;
```

The notification in the wear device should look somewhat like this:

![bigNot1](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/big-not.png)

Since the text is set as a big text it can now expand itself to allow the user to scroll and read the text inside.
![bigNot2](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/big-not3.png)

###### 3. BigView notification with an Action button:
For this Action we will create another activity. Our goal is to start another activity from the intent and set a message + show the picture that is set as the largeIcon.

1. Create the new Activity:
  * Right click any folder inside your app package -> New -> Activity -> Blank Activity
  * Give it a name : SecondActivity
  * Set up the XML layout elements:
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:background="#34495e"
    android:orientation="vertical"
    tools:context="myawesomepackagename.codelabandroidwear.SecondActivity">

    <TextView
        android:id="@+id/extraMessage"
        android:text="@string/hello_world"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <ImageView
        android:id="@+id/extraPhoto"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        />
</LinearLayout>
```
2. Instantiate the XML elements in your activity.
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    TextView mTextView = (TextView) findViewById(R.id.extraMessage); // TextView to retrieve the message
    ImageView mImageView = (ImageView) findViewById(R.id.extraPhoto); // ImageView to retrieve the picture
}
```
3. Get the intent information and set the data for the elements
```java
// Get the intent information
Intent extraIntent = getIntent();

// Get the intent information based on the names passed by your notificaiton "message" and 
mTextView.setText(extraIntent.getStringExtra("message")); // Retrieve the text and set it to our TextView
mImageView.setImageResource(extraIntent.getIntExtra("photo", 0)); // The zero is a default value in case the intent extra is empty.
```
4. Now that our Second Activity is set and ready to receive some data we procede to build our notificaiton.
```java
case R.id.bigNotificationWithAction:
    // Create the new intent that is gonna receive the information from our action.
    Intent photoIntent = new Intent(this, SecondActivity.class); // Intent pointing to our second activity
    photoIntent.putExtra("message", intentExtra); // Set the extra message that will open in the next activity
    photoIntent.putExtra("photo", R.drawable.ic_sample_codelab); // Send the photo to the next activity
    
    PendingIntent photoPending = PendingIntent.getActivity(this, 0, photoIntent, 0); // set a new pending intent
    bigStyle.setBigContentTitle("Mr. Flowers"); // title for the Big Text
    bigStyle.bigText("Check out this picture!! :D"); // Message in the Big Text
    mBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.ic_wear_notification) // Small icon for our notification
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_sample_codelab)) // The PNG picture
            .setContentIntent(viewPendingIntent) // This will be the default OPEN button.
            .addAction(R.drawable.ic_photo, "See Photo", photoPending) // This is our extra action. With an Extra Icon and pointing to the other PendingIntent
            .setAutoCancel(true)
            .setStyle(bigStyle); // Add the bigStyle
    break;
```

The Action button with our Custom Icon to view the photo:

![bigNotAction](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/big-not5.png)

And this is how the same notification looks in the cellphone

![mr-flowers](https://raw.githubusercontent.com/fnk0/Android-Wear-Codelab/master/screenshots/mr-flowers.png)

###### Creating our custom notification.
Our custom notification will let the user set a title, a message, select the Icon to display in the notification and will give an option if the user wants to show or not the App Icon.
```java
case R.id.sendCustomNotification:
    // We instantiate the builder again
    mBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(mCustomIcon) // This time we set the icon to be whenever icon is selected by the user 
            .setContentTitle(mCustomTitle.getText().toString()) // We set the contentTitle to the text in the EditText
            .setAutoCancel(true)
            .setContentText(mCustomMessage.getText().toString()) // We set the contentText to the message set by the user
            .setContentIntent(viewPendingIntent); // set an intent to receive the Open action.

    // This is an example of the NEW WearableNotification SDK.
    // The WearableNotification has special functionality for wearable devices
    // By example the setHintHideIcon hides the APP ICON from the notification.
    mNotification = new WearableNotifications.Builder(mBuilder)
            .setHintHideIcon(!showIcon) // This will determine if we should show or not the Icon of the app
            .build();
    break;
```
Now that we have another type of notification to display we need to add a case to our notify call.
After the switch replace the code that is already there with:
```java
// This check will allow us to display the normal notification or the Wearable notification if the
// notification is a CustomNotification
if(view.getId() != R.id.sendCustomNotification) {
    // Build the notification and issues it with notification manager.
    notificationManager.notify(notificationId, mBuilder.build());
    Log.d(LOG_TAG, "Normal Notification");
} else {
    // Use the Wearable Notification Builder
    notificationManager.notify(notificationId, mNotification);
    Log.d(LOG_TAG, "Wear Notification");
}
```

Give it a try now and play with the different notifications!!!

###### Thanks for doing this tutorial. I hope you enjoy it!!
Any questions, suggestions email me! marcusandreog@gmail.com

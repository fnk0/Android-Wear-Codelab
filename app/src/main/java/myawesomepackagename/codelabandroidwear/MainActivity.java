package myawesomepackagename.codelabandroidwear;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preview.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * The MIT License (MIT)

 Copyright (c) Copyright (c) 2014 Marcus Gabilheri

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */

/**
 * @author Marcus Gabilheri
 * @version 1.0
 * @since June 23rd, 2014
 *
 * This codelab was developed to the GDG OSU Stillwater.
 * Anyone can use this or modify for it's own purpose
 */
public class MainActivity extends Activity {

    private EditText mCustomTitle, mCustomMessage; // Edit text boxes for the custom notification
    private RadioGroup mCustomIconGroup, showHideIconGroup; // Radiogroups with the Icon and settings for the custom notification
    private int mCustomIcon; // The variable that will hold the ID of the custom icon to show
    private boolean showIcon = false; // boolean that will tell if wear should show the app icon or not
    private String LOG_TAG = "WEAR";  // Our LogCat tag for debugging purposes

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Define the method to send the notifications with the same name from the Android onClick from the XML Layout
    public void sendNotification(View view) {
        // id- An identifier for this notification unique within your application.
        int notificationId = 001;

        // Common elements for all our notifications
        String eventTitle = "Sample Notification";
        String eventText = "Text for the notification.";
        String intentExtra = "This is an extra String!";
        String eventDescription = "This is supposed to  be a content that will not fit the normal content screen"
                + " usually a bigger text, by example a long text message or email.";

        // Build intent for notification content
        Intent viewIntent = new Intent(this, MainActivity.class);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);

        // Specify the 'big view' content to display the long
        // event description that may not fit the normal content text.
        NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();

        NotificationCompat.Builder mBuilder = null;
        NotificationCompat mNotification = null;

        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        switch (view.getId()) {
            case R.id.simpleNotification:
                mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_wear_notification)
                        .setContentTitle(eventTitle)
                        .setContentText(eventText)
                        .setAutoCancel(true)  // This flag makes the notification disappear when the user clicks on it!
                        .setContentIntent(viewPendingIntent);
                break;
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
            case R.id.bigNotificationWithAction:
                Intent photoIntent = new Intent(this, SecondActivity.class); // Intent pointing to our second activity
                photoIntent.putExtra("message", intentExtra); // Set the extra message that will open in the next activity
                photoIntent.putExtra("photo", R.drawable.ic_sample_codelab); // Send the photo to the next activity

                PendingIntent photoPending = PendingIntent.getActivity(this, 0, photoIntent, 0); // set a new pending intent
                bigStyle.setBigContentTitle("Mr. Flowers");
                bigStyle.bigText("Check out this picture!! :D");
                mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_wear_notification)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_sample_codelab))
                        .setContentIntent(viewPendingIntent) // This will be the default OPEN button.
                        .addAction(R.drawable.ic_photo, "See Photo", photoPending) // This is our extra action. With an Extra Icon and pointing to the other PendingIntent
                        .setAutoCancel(true)
                        .setStyle(bigStyle);
                break;
            case R.id.sendCustomNotification:
                mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(mCustomIcon)
                        .setContentTitle(mCustomTitle.getText().toString())
                        .setContentText(mCustomMessage.getText().toString())
                        .setAutoCancel(true)
                        .setContentIntent(viewPendingIntent);

                // This is an example of the NEW WearableNotification SDK.
                // The WearableNotification has special functionality for wearable devices
                // By example the setHintHideIcon hides the APP ICON from the notification.
                // This code is now Up to date thanks to Romin Irani!! Thanks!
                NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender(mBuilder.build());
                wearableExtender.setHintHideIcon(!showIcon);
                wearableExtender.extend(mBuilder);
                break;
        }
        notificationManager.notify(notificationId, mBuilder.build());
    }
}

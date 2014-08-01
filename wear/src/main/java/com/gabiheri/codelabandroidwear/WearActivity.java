package com.gabiheri.codelabandroidwear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;

import com.gabiheri.codelabandroidwear.gridAdapter.GridPagerAdapter;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 8/1/14.
 */
public class WearActivity extends Activity {

    private GridViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);
        mPager = (GridViewPager) findViewById(R.id.gridPager);
        mPager.setAdapter(new GridPagerAdapter(this, getFragmentManager()));
    }
}

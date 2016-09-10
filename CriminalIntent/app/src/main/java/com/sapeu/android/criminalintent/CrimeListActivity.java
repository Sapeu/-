package com.sapeu.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Sapeu on 2016/9/10.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}

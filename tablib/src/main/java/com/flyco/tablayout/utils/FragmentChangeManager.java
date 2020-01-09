package com.flyco.tablayout.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.flyco.tablayout.R;

import java.util.ArrayList;

public class FragmentChangeManager {
    private FragmentManager mFragmentManager;
    private int mContainerViewId;
    /** Fragment切换数组 */
    private ArrayList<Fragment> mFragments;
    /** 当前选中的Tab */
    private int mCurrentTab;

    /** 切换tab时是否支持Fragment动画 */
    private boolean mNeedFragmentSwitchAnimation;

    public FragmentChangeManager(FragmentManager fm, int containerViewId, ArrayList<Fragment> fragments) {
        this.mFragmentManager = fm;
        this.mContainerViewId = containerViewId;
        this.mFragments = fragments;
        initFragments();
    }

    /** 初始化fragments */
    private void initFragments() {
        for (Fragment fragment : mFragments) {
            mFragmentManager.beginTransaction().add(mContainerViewId, fragment).hide(fragment).commitAllowingStateLoss();
        }

        setFragments(0);
    }

    public void setFragmentSwitchAnimation(boolean needAnimation) {
        mNeedFragmentSwitchAnimation = needAnimation;
    }

    /** 界面切换控制 */
    public void setFragments(int index) {
        for (int i = 0; i < mFragments.size(); i++) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();

            if (mNeedFragmentSwitchAnimation) {
                ft.setCustomAnimations(R.anim.translate_into, R.anim.translate_out);
            }

            Fragment fragment = mFragments.get(i);
            if (i == index) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            ft.commitAllowingStateLoss();
        }
        mCurrentTab = index;
    }

    public int getCurrentTab() {
        return mCurrentTab;
    }

    public Fragment getCurrentFragment() {
        return mFragments.get(mCurrentTab);
    }
}
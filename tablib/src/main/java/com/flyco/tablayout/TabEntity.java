package com.flyco.tablayout;

import com.flyco.tablayout.listener.CustomTabEntity;

public class TabEntity implements CustomTabEntity {

    private String tabTitle;
    private int tabSelectedIcon;
    private int tabUnSelectedIcon;

    public TabEntity(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public TabEntity(String tabTitle, int tabSelectedIcon, int tabUnSelectedIcon) {
        this.tabTitle = tabTitle;
        this.tabSelectedIcon = tabSelectedIcon;
        this.tabUnSelectedIcon = tabUnSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return tabTitle;
    }

    @Override
    public int getTabSelectedIcon() {
        return tabSelectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return tabUnSelectedIcon;
    }
}

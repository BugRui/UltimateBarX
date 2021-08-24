package com.zackratos.ultimatebarx.sample;

import android.graphics.Color;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXKt;

/**
 * @Author : zhangwenchao
 * @Date : 2020/7/8  2:57 PM
 * @email : 869649338@qq.com
 * @Describe :
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> fragments;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragments = new SparseArray<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragments.get(position);
        if (fragment != null) {
            return fragment;
        }
        switch (position) {
            case 0:
                fragment = TextFragment2
                        .Companion
                        .newInstance(Color.RED, "Android", Color.WHITE, f -> {
                            UltimateBarXKt.statusBar(f, barConfig -> {
                                barConfig.setFitWindow(true);
                                barConfig.setColor(Color.RED);
                                return null;
                            });
                            return null;
                        });
                break;
            case 1:
                fragment = ImageTextFragment
                        .Companion
                        .newInstance(R.drawable.yurisa__001, f -> {
                            UltimateBarXKt.statusBar(f, barConfig -> {
                                barConfig.setFitWindow(false);
                                barConfig.setColorRes(R.color.alphaWhite);
                                barConfig.setLight(true);
                                barConfig.setLvlColorRes(R.color.alphaBlack);
                                return null;
                            });
                            return null;
                        });
                break;
            case 2:
                fragment = ImageTextFragment
                        .Companion
                        .newInstance(R.drawable.yurisa__006, f -> {
                            UltimateBarXKt.statusBar(f, barConfig -> {
                                barConfig.transparent();
                                return null;
                            });
                            return null;
                        });
                break;
            case 3:
                fragment = TextFragment2
                        .Companion
                        .newInstance(Color.YELLOW, "Camera", Color.BLACK, f -> {
                            UltimateBarXKt.statusBar(f, barConfig -> {
                                barConfig.setFitWindow(true);
                                barConfig.setColor(Color.YELLOW);
                                barConfig.setLight(true);
                                barConfig.setLvlDrawableRes(R.drawable.bg_yellow_alpha_black);
                                return null;
                            });
                            return null;
                        });
                break;
            default:
                fragment = new Fragment();
                break;
        }
        fragments.put(position, fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

package com.example.xyzreader.data;

import android.app.Fragment;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.SparseArray;

import com.example.xyzreader.ui.ArticleDetailFragment;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<SparseArray<Fragment>> selected = new MutableLiveData<SparseArray<Fragment>>();
    private SparseArray<Fragment> mRegisteredFragments;

    public void firstStart() {
        if (mRegisteredFragments == null) {
            mRegisteredFragments = new SparseArray<>();
        }

        selected.setValue(mRegisteredFragments);
    }

    public void select(SparseArray<Fragment> item) {
        mRegisteredFragments = item;
        selected.setValue(item);
    }

    public void putItem(ArticleDetailFragment fragment, int id) {
        mRegisteredFragments.put(id, fragment);
        selected.setValue(mRegisteredFragments);
    }

    public LiveData<SparseArray<Fragment>> getSelected() {
        return selected;
    }
}

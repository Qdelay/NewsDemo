package com.deli.newsdemo.ui.mine;

import android.os.Bundle;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.ui.main.MainActivity;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class MineFragment extends BaseFrameFragment<MinePresenter, MineModel>
        implements MineContract.View {

    public static final String TAG = "MineFragment";
    MainActivity mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mine);
        setFragmentId(R.id.container);
    }

    @Override
    public void initData() {
        super.initData();
        mCallback = (MainActivity) getActivity();
        Bundle bundle = new Bundle();
        bundle.putString(TAG, "hello im minefragment");
        mCallback.onMessage(bundle);
    }

    @Override
    public void initView() {
        super.initView();
    }
}

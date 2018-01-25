package com.deli.newsdemo.ui.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.ui.main.MainActivity;
import com.deli.newsdemo.ui.newsdetails.NewsDetailsFragment;
import com.deli.newsdemo.widget.button.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class MineFragment extends BaseFrameFragment<MinePresenter, MineModel>
        implements MineContract.View {

    @BindView(R.id.btn_to_details)
    Button btn_to_details;

    public static final String TAG = "MineFragment";
    private MainActivity mCallback;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mine);
        unbinder = ButterKnife.bind(this, getContentView());
        setFragmentId(R.id.container);
    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    public void initView() {
        super.initView();
        btn_to_details.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                mCallback = (MainActivity) getActivity();
                NewsDetailsFragment mNewsDetailsFragment = new NewsDetailsFragment();
                mCallback.toFragment(mNewsDetailsFragment);
                mCallback.setCurrFragment(mNewsDetailsFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}

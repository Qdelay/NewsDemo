package com.deli.newsdemo.ui.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.ui.main.FragmentMessageCallback;
import com.deli.newsdemo.ui.main.MainActivity;
import com.deli.newsdemo.widget.button.NoDoubleClickListener;
import com.deli.newsdemo.widget.header.HeadBanner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.deli.newsdemo.ui.main.MainActivity.ADD_NEWS_PAGE;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class MineFragment extends BaseFrameFragment<MinePresenter, MineModel>
        implements MineContract.View {

    @BindView(R.id.btn_to_details)
    Button btn_to_details;
    @BindView(R.id.head_banner)
    HeadBanner mHeadBanner;

    public static final String TAG = "MineFragment";
    private FragmentMessageCallback mCallback;
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
                mCallback.onMessage(null, ADD_NEWS_PAGE);
            }
        });
        mHeadBanner.getBtn_left().setVisibility(View.GONE);
        mHeadBanner.getBtn_right().setVisibility(View.GONE);
        mHeadBanner.setTitle(getString(R.string.mine));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}

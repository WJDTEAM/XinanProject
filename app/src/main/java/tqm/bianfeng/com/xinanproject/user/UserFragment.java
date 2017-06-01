package tqm.bianfeng.com.xinanproject.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import tqm.bianfeng.com.xinanproject.Base.BaseFragment;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/22.
 */

public class UserFragment extends BaseFragment {
    @BindView(R.id.user_circle_img)
    CircleImageView userCircleImg;
    @BindView(R.id.user_phong_num_edi)
    EditText userPhongNumEdi;
    @BindView(R.id.user_login_registered_btn)
    Button userLoginRegisteredBtn;
    @BindView(R.id.user_top_rel)
    RelativeLayout userTopRel;
    @BindView(R.id.collection_img)
    ImageView collectionImg;
    @BindView(R.id.user_collection_num)
    TextView userCollectionNum;
    @BindView(R.id.bank_collection_lin)
    LinearLayout bankCollectionLin;
    @BindView(R.id.focuse_img)
    ImageView focuseImg;
    @BindView(R.id.user_fouces_num)
    TextView userFoucesNum;
    @BindView(R.id.bank_focuse_lin)
    LinearLayout bankFocuseLin;
    @BindView(R.id.read_img)
    ImageView readImg;
    @BindView(R.id.user_read_num)
    TextView userReadNum;
    @BindView(R.id.bank_browse_lin)
    LinearLayout bankBrowseLin;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.user_feedback_lin)
    LinearLayout userFeedbackLin;

    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.bank_collection_lin, R.id.bank_focuse_lin, R.id.bank_browse_lin, R.id.user_feedback_lin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bank_collection_lin:
                break;
            case R.id.bank_focuse_lin:
                break;
            case R.id.bank_browse_lin:
                break;
            case R.id.user_feedback_lin:
                startActivity(new Intent(getActivity(),UserFeedbackActivity.class));
                break;
        }
    }
}

package tqm.bianfeng.com.xinanproject.zxing.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tqm.bianfeng.com.xinanproject.Activity.HotNewsActivity;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.zxing.decode.DecodeThread;

public class ResultActivity extends BaseActivity {

    @BindView(R.id.result_image)
    ImageView mResultImage;
    @BindView(R.id.result_text)
    TextView mResultText;
    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        setToolbar(toolbar,"扫描结果",true,R.color.colorPrimary);
        toolbar.setBackgroundResource(R.color.colorPrimary);

        Bundle extras = getIntent().getExtras();

        if (null != extras) {
            int width = extras.getInt("width");
            int height = extras.getInt("height");

            LayoutParams lps = new LayoutParams(width, height);
            lps.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
            lps.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
            lps.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());

            mResultImage.setLayoutParams(lps);

            result = extras.getString("result");
            mResultText.setText(result);

            Bitmap barcode = null;
            byte[] compressedBitmap = extras.getByteArray(DecodeThread.BARCODE_BITMAP);
            if (compressedBitmap != null) {
                barcode = BitmapFactory.decodeByteArray(compressedBitmap, 0, compressedBitmap.length, null);
                // Mutable copy:
                barcode = barcode.copy(Bitmap.Config.RGB_565, true);
            }

            mResultImage.setImageBitmap(barcode);
        }
    }

    Intent intent;

    @OnClick(R.id.commit)
    public void onClick() {
        intent = new Intent(ResultActivity.this, HotNewsActivity.class);
        intent.putExtra("url", result);
        startActivity(intent);
        finish();
    }
}

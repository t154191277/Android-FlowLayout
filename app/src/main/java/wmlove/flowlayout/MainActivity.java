package wmlove.flowlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    private FlowLayout mFlowLayout;
    private String [] datas = {"Hello World","Hello","What Love","Add my","Love",
            "World","Hello","What my","Add my","Love My",
            "Hello World","Hello","What my Love","Add my","Love You",
            "Hello Java","Hello","What my Love","Add","Love",
            "Hello World","Hello","What Love","Add my","Love"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mFlowLayout = (FlowLayout) findViewById(R.id.flowlayout);
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        for(int i=0;i<datas.length;i++){
//            Button mButton = new Button(MainActivity.this);
//            mButton.setPadding(20,5,20,5);
//            mButton.setBackgroundResource(R.drawable.rd_btn);
//            mButton.setText(datas[i]);
//
//            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
//                    , ViewGroup.LayoutParams.WRAP_CONTENT);
//
//            mFlowLayout.addView(mButton,lp);
            TextView tv = (TextView) inflater.inflate(R.layout.flag,mFlowLayout,false);
            tv.setText(datas[i]);
            mFlowLayout.addView(tv);
        }

    }


}

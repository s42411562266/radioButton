package com.example.myapplication;
/* import相关class */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2 extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 加载main.xml Layout */
        setContentView(R.layout.next);
        Bundle bnde = this.getIntent().getExtras();
        /* 取得Bundle对象中的数据 */
        String sex = bnde.getString("sex");
        double height = bnde.getDouble("height");
        /*判断性别 */
        String sexText="";
        if(sex.equals("M"))  {
            sexText = "Male";
        } else {
            sexText = "Female";
        }
        /* 取得标准体重 */
        String weight = this.getWeight (sex, height);
        /* 设定输出文字 */
        TextView tv1=(TextView) findViewById(R.id.text1);
        tv1.setText("你是一位"+sexText+"\n你的身高是"+height+
                "cm\n你的標準體重是"+weight+"公斤");
        tv1.setTextSize(35);
    }
    /* 四舍五入的method */
    private String format (double num)   {
        NumberFormat formatter = new DecimalFormat("0.00");
        String s = formatter.format(num);
        return s;
    }

    /* 以findViewById()取得Button对象，onClickListener */
    private String getWeight (String sex, double height)    {
        String weight="";
        if(sex.equals("M")) {
            weight = format((height-80)*0.7);
        } else     {
            weight = format((height-70)*0.6);
        }
        return weight;
    }
}

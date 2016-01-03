package cn.uhei.usingdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //简单的确定,取消对话框
    public void click1(View view){
        //使用AlertDialog的子类uilder来创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置标题
        builder.setTitle("天龙八部");
        //设置对话框图标
        builder.setIcon(android.R.drawable.alert_light_frame);
        //设置正文
        builder.setMessage("杨过和小龙女的故事");
        //设置确定按钮，
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"感谢观看",Toast.LENGTH_SHORT).show();
            }
        });
        //设置取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"烂片不看了",Toast.LENGTH_SHORT).show();
            }
        });
        //使用创建器生成一个对话框
//        AlertDialog ad = builder.create();
//        ad.show();
        //使用创建器生成一个对话框 简写版
        builder.show();

    }

    //单选对话框
    public void click2(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("你的性别");

        //项目
        final String[] items = new String[]{
                "男",
                "女"
        };
        //items:数组项目
        //-1：默认都不选中
        //确定事件监听器
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            //dialog:触发这个方法的对话框
            //which:用户所选项目的下标
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"你的性别是："+ items[which],Toast.LENGTH_SHORT).show();
                //关闭对话框
                dialog.dismiss();
            }
        });
        //显示对话框
        builder.show();
    }

//    多选对话框
    public void click3(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("你认为谁最帅");

       //项目
        final String[] items = new String[]{
                "刘德华",
                "古巨基",
                "古天乐",
                "黄晓明"
        };

        //默认选择状态
        final boolean[] checkedItems = new boolean[]{
                true,
                true,
                false,
                false

        };

        //设置多选条目
            //条目
            //默认选择状态
            //多选监听
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //记录选择状态
                checkedItems[which] = isChecked;

            }
        });
        //确定按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //记录用户选中的结果
                String text = "";
                for (int i = 0; i <4 ; i++) {
                    //如果checkedItems[i]结果是true，items[i]赋值给text,
                    text += checkedItems[i] ? items[i] + ",":"";
                }
                //抛出结果
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
                //关闭对话框
                dialog.dismiss();
            }
        });
        //显示对话框
        builder.show();

    }
}

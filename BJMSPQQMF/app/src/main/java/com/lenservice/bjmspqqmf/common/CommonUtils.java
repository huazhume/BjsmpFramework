package com.lenservice.bjmspqqmf.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

/**
 * Created by len on 16/12/27.
 */

public class CommonUtils {
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

    public static void alertView(Context context, String title, String content, String centerBtntitle) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        //  alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage(content);
        alertDialog.setNeutralButton(centerBtntitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

    public static void toastView(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
    public static void progressBarStyleLarge(Context context,  LinearLayout ll){

//        ProgressDialog progressBar = new ProgressDialog(context);
//        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//       // progressBar.setLayoutParam(new LinearLayout.LayoutParams(65, 5, Gravity.CENTER_VERTICAL) );
//        progressBar.setCanceledOnTouchOutside(false);
//        progressBar.show();
    }

    public final static int getWindowsWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public final static int getWindowsHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }


    /**
     * @param list	当前集合
     * @param pageSize	每页显示数据条数
     * @return	下一页的索引值
     * @author xuhui.han
     */
    public static <T> int getRecordNextPageIndex(List<T> list, int pageSize){
        if(list == null || list.size() == 0){
            return 1;
        }else{
            return (list.size()-1)/pageSize + 2;
        }
    }

    /**
     * 隐藏软键盘
     */
    @SuppressWarnings("static-access")
    public static void hideSoftInput(Activity activity){
        InputMethodManager imm = ((InputMethodManager)activity.getSystemService(activity.INPUT_METHOD_SERVICE));
        imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}

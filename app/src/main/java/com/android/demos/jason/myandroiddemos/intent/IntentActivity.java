package com.android.demos.jason.myandroiddemos.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.demos.jason.myandroiddemos.R;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent3);


        String jsonstr = "{\"date\":\"2016-07-27\",\"days\":65,\"tips\":{\"tips\":\"「绿色」日期可预约购买，开售自动抢票\",\"style\":[{\"color\":\"#06c1ae\",\"index\":[0,3]}]},\"buyRange\":[{\"start\":\"2016-07-27\",\"finish\":\"2016-09-24\"}],\"reserveRange\":[{\"start\":\"2016-09-25\",\"finish\":\"2016-09-29\"}],\"callback\":\"HBNB_CALLBACK_1469620325954_7\"}";
        JsonObject jsonObject = new JsonParser().parse(jsonstr).getAsJsonObject();
//        String tipsText = jsonObject.has("tips") && !jsonObject.get("tips").isJsonNull() ? jsonObject.get("tips").getAsString() : "";
        String tipsText = getTipsText(jsonObject);


        String jsonstr2 = "{\"date\":\"2016-07-27\",\"days\":65,\"tips\":\"「绿色」日期可预约购买，开售自动抢票\",\"buyRange\":[{\"start\":\"2016-07-27\",\"finish\":\"2016-09-24\"}],\"reserveRange\":[{\"start\":\"2016-09-25\",\"finish\":\"2016-09-29\"}],\"callback\":\"HBNB_CALLBACK_1469620325954_7\"}";
        JsonObject jsonObject2 = new JsonParser().parse(jsonstr2).getAsJsonObject();
        String tipsText2 = getTipsText(jsonObject2);
    }

    private String getTipsText(JsonObject jsonObject) {
        if (!jsonObject.has("tips")) {
            return "";
        }

        JsonElement jsonElement = jsonObject.get("tips");
        if (jsonElement == null) {
            return "";
        }

        if (jsonElement.isJsonObject()) {
            JsonObject tipsObject = jsonElement.getAsJsonObject();
            return tipsObject.toString();
        } else {
            return jsonElement.getAsString();
        }
    }

    /**
     * 显式跳转 1
     */
    public void explicitJump(View view) {
        startActivity(new Intent(this, IntentNextActivity.class));
    }

    /**
     * 显式跳转 2
     */
    public void explicitJump2(View view) {
        Intent i = new Intent();
        ComponentName componentName = new ComponentName(this, IntentNextActivity.class);
        i.setComponent(componentName);
        startActivity(new Intent(this, IntentNextActivity.class));
    }

    /**
     * 打开网页
     */
    public void openWebsite(View view) {
        Uri uri = Uri.parse("http://www.baidu.com");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }

    /**
     * 开启拨号页面
     */
    public void dialNumber(View view) {
        Uri uri = Uri.parse("tel:15912345678");
        Intent i = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(i);
    }

    /**
     * 展示电话本中标识为1的联系人
     */
    public void viewFirstContact(View view) {
        Uri uri = Uri.parse("content://contacts/people/1");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }

    /**
     * 编辑电话本中标识为1的联系人
     */
    public void editFirstContact(View view) {
        Uri uri = Uri.parse("content://contacts/people/1");
        Intent i = new Intent(Intent.ACTION_EDIT, uri);
        startActivity(i);
    }

    /**
     * 自定义action
     */
    public void askForSinger(View view) {
        Intent i = new Intent("com.android.demos.jason.myandroiddemo.SING");
        i.putExtra("name", "god bless american");
        startActivity(i);
    }

    /**
     * 通过data中的Uri来隐式跳转
     */
    public void askForSinger2(View view) {
        Uri uri = Uri.parse("sing://com.demos.myandroiddemo");
        Intent i = new Intent();
        i.setData(uri);
        startActivity(i);
    }

    /**
     * 通过data中的Uri来隐式跳转
     */
    public void askForSingerWithMimeType(View view) {
        Uri uri = Uri.parse("sing://com.demos.myandroiddemo");
        Intent i = new Intent();
        i.setDataAndType(uri, "play/folkSong");
        startActivity(i);
    }

    public void askForSingerWithMimeTypeForRockSong(View view) {
        Uri uri = Uri.parse("sing://com.demos.myandroiddemo");
        Intent i = new Intent();
        i.setDataAndType(uri, "play/rockSong");
        startActivity(i);
    }
}

package com.ys.ts.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Parcel;
import android.provider.Browser;
import android.provider.Settings;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ys.ts.R;

import java.util.ArrayList;
import java.util.List;

/**自定义圆角图片
 * Created by ys on 2015/2/28.
 */
public class MyCostomActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String a="This is a page with lots of URLs. <a href=\"http://droidyue.com\">droidyue.com</> " +
                "This left is a very good blog. There are so many great blogs there. You can find what" +
                "you want in that blog."
                + "The Next Link is <a href=\"http://www.google.com.hk\">Google HK</a>";
        TextView textView=new TextView(this);
        String url1="<br>官网:<a href=\"http://www.aqgj.cn\">http://www.aqgj.cn</><br>微博/微信:安全管家<br>客服邮箱:kefu@anguanjia.com<br>客服QQ群:93473095,103520577<br><br>u00A92011 北京安管佳 版权所有";
        setContentView(textView);
        textView.setAutoLinkMask(Linkify.ALL);
        String url=getResources().getString(R.string.copyright);
        textView.setText(getClickableHtml(url1));
//        Spannable spannable= (Spannable) textView.getText();
//        ClickableSpan[] links = (spannable.getSpans(textView.getSelectionStart(),
//                textView.getSelectionEnd(), URLSpan.class));
//        spannable.setSpan();
//        if (links.length > 0) {
//            List<Integer> list = new ArrayList<Integer>();
//            for (int i = 0;i<links.length;i++){
//                if (links[i] instanceof URLSpan){
//                    list.add(i);
//                }
//            }
//            for (Integer i:list){
//                links[i]=new MyURLSpan(((URLSpan) links[i]).getURL());
//            }
//        }
//        ClickableSpan[] links2 = (spannable.getSpans(textView.getSelectionStart(),
//                textView.getSelectionEnd(), URLSpan.class));
//
//        Intent checkBrowser = new Intent(Intent.ACTION_VIEW);
//        checkBrowser.setData(Uri.parse("http://www.grumpycat.com"));
//        List<ResolveInfo> info = getApplicationContext().getPackageManager().queryIntentActivities(checkBrowser,0);
//        if(info.size() > 0){
//            textView.setAutoLinkMask(Linkify.WEB_URLS);
//        }
        Button button=new Button(this);
        button.setText("go");
        addContentView(button,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="http://www.aqgj.cn";
                uri=uri.trim();
                Intent newIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
                newIntent.putExtra(Browser.EXTRA_APPLICATION_ID, getPackageName());
                ComponentName comp = new ComponentName("android", "com.android.internal.app.ResolverActivity");
                newIntent.setComponent(comp);
                startActivity(newIntent);
//                Uri uri = Uri
//                        .parse("http://www.aqgj.cn");
//                Intent it = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(it);
            }
        });
    }
    public class MyURLSpan extends URLSpan{

        public MyURLSpan(String url) {
            super(url);
        }

        public MyURLSpan(Parcel src) {
            super(src);
        }

        @Override
        public void onClick(View widget) {
            Uri uri = Uri.parse(getURL());
            Context context = widget.getContext();
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            ComponentName comp = new ComponentName("android", "com.android.internal.app.ResolverActivity");
            intent.setComponent(comp);
            intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
            context.startActivity(intent);
        }
    }
    private void setLinkClickable(final SpannableStringBuilder clickableHtmlBuilder,
                                  final URLSpan urlSpan) {
        int start = clickableHtmlBuilder.getSpanStart(urlSpan);
        int end = clickableHtmlBuilder.getSpanEnd(urlSpan);
        int flags = clickableHtmlBuilder.getSpanFlags(urlSpan);
        ClickableSpan clickableSpan = new ClickableSpan() {
            public void onClick(View view) {
                //Do something with URL here.
                Uri uri = Uri.parse(urlSpan.getURL());
//                Context context = widget.getContext();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                ComponentName comp = new ComponentName("android", "com.android.internal.app.ResolverActivity");
                intent.setComponent(comp);
//                intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
                startActivity(intent);
            }
        };
        clickableHtmlBuilder.setSpan(clickableSpan, start, end, flags);
    }

    private CharSequence getClickableHtml(String html) {
        Spanned spannedHtml = Html.fromHtml(html);
        SpannableStringBuilder clickableHtmlBuilder = new SpannableStringBuilder(spannedHtml);
        URLSpan[] urls = clickableHtmlBuilder.getSpans(0, spannedHtml.length(), URLSpan.class);
        for(final URLSpan span : urls) {
            setLinkClickable(clickableHtmlBuilder, span);
        }
        return clickableHtmlBuilder;
    }
}

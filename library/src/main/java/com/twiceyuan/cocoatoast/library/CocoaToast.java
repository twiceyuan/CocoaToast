package com.twiceyuan.cocoatoast.library;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.twiceyuan.bettertoast.library.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by twiceYuan on 8/15/16.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 *
 * 类似 iOS 提示框风格的 Toast
 */
@SuppressWarnings("unused")
public class CocoaToast {

    private static Config sConfig;
    private static Context sContext;

    public static void init(Context context) {
        sConfig = new Config();
        sContext = context;
    }

    public static void init(Context context, @NonNull Config defaultConfig) {
        sConfig = defaultConfig;
        sContext = context;
    }

    public static void show(CharSequence text) {
        show(text, sConfig);
    }

    public static void show(CharSequence text, @DrawableRes int iconId) {
        show(text, iconId, sConfig);
    }

    public static void show(CharSequence text, @DrawableRes int iconId, Config config) {
        Toast toast = new Toast(getContext());

        ToastHolder holder = getContentView(config);

        holder.mTextView.setText(text);
        holder.mImageView.setImageResource(iconId);

        toast.setView(holder.mRootView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showIconOnly(@DrawableRes int iconId) {
        showIconOnly(iconId, sConfig);
    }

    public static void showIconOnly(@DrawableRes int iconId, Config config) {
        Toast toast = new Toast(getContext());
        ToastHolder holder = getContentView(config);
        holder.mTextView.setVisibility(View.GONE);
        holder.mImageView.setImageResource(iconId);
        toast.setView(holder.mRootView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void show(CharSequence text, Config config) {
        Toast toast = new Toast(getContext());
        ToastHolder holder = getContentView(config);
        holder.mTextView.setText(text);
        toast.setView(holder.mRootView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(config.duration);
        toast.show();
    }

    public static void showTextOnly(CharSequence text) {
        showTextOnly(text, sConfig);
    }

    public static void showTextOnly(CharSequence text, Config config) {
        Toast toast = new Toast(getContext());
        ToastHolder holder = getContentView(config);

        holder.mTextView.setText(text);
        holder.mImageView.setVisibility(View.GONE);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.mTextView.getLayoutParams();
        layoutParams.topMargin = 0;

        toast.setView(holder.mRootView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(config.duration);
        toast.show();
    }

    static ToastHolder getContentView(Config config) {
        LinearLayout toastRoot = new LinearLayout(getContext());
        LinearLayout.LayoutParams rootParams = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        toastRoot.setLayoutParams(rootParams);

        LinearLayout container = new LinearLayout(getContext());
        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams(DP.dp2px(config.width), DP.dp2px(config.height));

        container.setLayoutParams(containerParams);
        container.setOrientation(LinearLayout.VERTICAL);

        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(DP.dp2px(72), DP.dp2px(72)));
        imageView.setImageResource(config.defaultIcon);

        TextView textView = new TextView(getContext());

        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);

        textParams.topMargin = DP.dp2px(4);

        textView.setLayoutParams(textParams);
        textView.setTextColor(config.defaultTextColor);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, config.defaultTextSize);
        textView.setGravity(Gravity.CENTER);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(config.defaultBackground);

        int radius = config.cornerRadius;
        drawable.setCornerRadii(new float[]{radius, radius, radius, radius, radius, radius, radius, radius});

        //noinspection deprecation
        container.setBackgroundDrawable(drawable);

        container.setGravity(Gravity.CENTER);
        container.addView(imageView);
        container.addView(textView);

        toastRoot.addView(container);

        return new ToastHolder(toastRoot, textView, imageView);
    }

    static Context getContext() {
        if (sContext == null) {
            throw new IllegalStateException("请在使用 BetterToast 之前进行初始化（建议在 Application 中进行）");
        }
        return sContext;
    }

    static class ToastHolder {
        View mRootView;
        TextView mTextView;
        ImageView mImageView;

        public ToastHolder(View rootView, TextView textView, ImageView imageView) {
            mRootView = rootView;
            mTextView = textView;
            mImageView = imageView;
        }
    }

    public static class Config {
        @DrawableRes
        int defaultIcon = R.drawable.better_toast_ic_done_white;

        int defaultTextSize = 16;

        @ColorInt
        int defaultTextColor = 0xFFFFFFFF;

        @ColorInt
        int defaultBackground = 0xC0000000;

        int cornerRadius = 24;

        @Duration
        int duration = Toast.LENGTH_SHORT;

        int width = 128;

        int height = 128;

        public void setDefaultIcon(int defaultIcon) {
            this.defaultIcon = defaultIcon;
        }

        public void setDefaultTextColor(int defaultTextColor) {
            this.defaultTextColor = defaultTextColor;
        }

        public void setDefaultTextSize(int defaultTextSize) {
            this.defaultTextSize = defaultTextSize;
        }

        public void setDefaultBackground(int defaultBackground) {
            this.defaultBackground = defaultBackground;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public void setCornerRadius(int cornerRadius) {
            this.cornerRadius = cornerRadius;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Toast.LENGTH_LONG, Toast.LENGTH_LONG})
    public @interface Duration {
    }
}

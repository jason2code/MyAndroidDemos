package com.android.demos.jason.myandroiddemos.spanableString;

import java.util.List;

/**
 * Created by xude1 on 16/7/25.
 */
public class CalendarTip {
    private String tips;
    private List<StyleBean> style;

    public String getTips() {
        return tips;
    }

    public CalendarTip setTips(String tips) {
        this.tips = tips;
        return this;
    }

    public List<StyleBean> getStyle() {
        return style;
    }

    public CalendarTip setStyle(List<StyleBean> style) {
        this.style = style;
        return this;
    }

    public static class StyleBean {
        private String color;
        private int[] index;

        public String getColor() {
            return color;
        }

        public StyleBean setColor(String color) {
            this.color = color;
            return this;
        }

        public int[] getIndex() {
            return index;
        }

        public StyleBean setIndex(int[] index) {
            this.index = index;
            return this;
        }
    }
}

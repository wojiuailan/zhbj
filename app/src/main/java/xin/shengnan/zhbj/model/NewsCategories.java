package xin.shengnan.zhbj.model;

import java.util.ArrayList;

/**
 * Created by ${Li} on 2018/6/8.
 */

public class NewsCategories {
    public int retcode;

    public ArrayList<MenuListItem> data;

    public class MenuListItem {
        public int id;
        public int type;
        public String title;
        public String url;
        public String url1;

        public ArrayList<ItemChild> children;

        public class ItemChild {
            public int id;
            public int type;
            public String title;
            public String url;

            @Override
            public String toString() {
                return "ItemChild{" +
                        "title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "MenuListItem{" +
                    "title='" + title + '\'' +
                    ", children=" + children +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsCategories{" +
                "data=" + data +
                '}';
    }
}

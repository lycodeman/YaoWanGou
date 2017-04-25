package com.example.yaowangou.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22/022.
 */

public class Icon {
    /**
     * datas : {"datas":[{"title":"茶楼预订","url":"","type":"category"},{"title":"商品分类","url":"","type":"goods"},{"title":"包邮专区","url":"","type":"goods"},{"title":"活动专区","url":"http://www.yaowangou.com/wap/tmpl/app_active/newActivity.html","type":"url"},{"title":"礼品商城","url":"http://","type":"url"}]}
     * code : 200
     * status : 200
     * info :
     */

    private DatasBeanX datas;
    private String code;
    private String status;
    private String info;

    public DatasBeanX getDatas() {
        return datas;
    }

    public void setDatas(DatasBeanX datas) {
        this.datas = datas;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static class DatasBeanX {
        private List<DatasBean> datas;

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * title : 茶楼预订
             * url :
             * type : category
             */

            private String title;
            private String url;
            private String type;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}

package com.example.yaowangou.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public class Teas {

    /**
     * datas : {"datas":[{"url":"1300","type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/8f46ef66b620bdcf2820.png"},{"url":"1380","type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/9c8e927a9d79b3073691.png"},{"url":"1076","type":"goods","image":"http://www.yaowangou.com/data/upload/shop/rec_position/468e92f3cd1c9eff9672.png"},{"url":"1100","type":"goods","image":"http://www.yaowangou.com/data/upload/shop/rec_position/996e28d91ec2a0d82193.png"}]}
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
             * url : 1300
             * type : category
             * image : http://www.yaowangou.com/data/upload/shop/rec_position/8f46ef66b620bdcf2820.png
             */

            private String url;
            private String type;
            private String image;

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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}

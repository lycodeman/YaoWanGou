package com.example.yaowangou.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public class RightClass {


    /**
     * datas : {"datas":[{"gc_id":1297,"gc_name":"绾稿肪","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1297.jpg?v=1493109185"},{"gc_id":1318,"gc_name":"鍨冨溇琚�","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1318.jpg?v=1493109185"},{"gc_id":1321,"gc_name":"鐑熺伆缂�","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1321.jpg?v=1493109185"},{"gc_id":1291,"gc_name":"鍨冨溇妗�","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1291.jpg?v=1493109185"},{"gc_id":1293,"gc_name":"绾稿肪鐩掓灦","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1293.jpg?v=1493109185"},{"gc_id":1296,"gc_name":"鍚哥鎼呮","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1296.jpg?v=1493109185"},{"gc_id":1288,"gc_name":"鑼跺彾缃�","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1288.jpg?v=1493109185"},{"gc_id":1382,"gc_name":"鏉灚","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1382.jpg?v=1493109185"},{"gc_id":1320,"gc_name":"鏋滅洏","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1320.jpg?v=1493109185"},{"gc_id":1339,"gc_name":"鍐扮硸纰�","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1339.jpg?v=1493109185"},{"gc_id":1340,"gc_name":"鐗欑鐩�","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1340.jpg?v=1493109185"},{"gc_id":1354,"gc_name":"鐗欑","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1354.jpg?v=1493109185"},{"gc_id":1385,"gc_name":"闄ゅ懗鐢ㄥ搧","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1385.jpg?v=1493109185"},{"gc_id":1319,"gc_name":"娓呮礂鐢ㄥ搧","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1319.jpg?v=1493109185"},{"gc_id":1386,"gc_name":"鏉�铏敤鍝�","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1386.jpg?v=1493109185"},{"gc_id":1407,"gc_name":"鍔熻兘鐢ㄥ搧","gc_image":"http://ccclsc.com/data/upload/shop/common/category-pic-1407.jpg?v=1493109185"}]}
     * code : 200
     * status : 200
     * info :
     */

    private DatasBeanX datas;
    private int code;
    private int status;
    private String info;

    @Override
    public String toString() {
        return "RightClass{" +
                "datas=" + datas +
                ", code=" + code +
                ", status=" + status +
                ", info='" + info + '\'' +
                '}';
    }

    public DatasBeanX getDatas() {
        return datas;
    }

    public void setDatas(DatasBeanX datas) {
        this.datas = datas;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

        @Override
        public String toString() {
            return "DatasBeanX{" +
                    "datas=" + datas +
                    '}';
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            @Override
            public String toString() {
                return "DatasBean{" +
                        "gc_id=" + gc_id +
                        ", gc_name='" + gc_name + '\'' +
                        ", gc_image='" + gc_image + '\'' +
                        '}';
            }

            /**
             * gc_id : 1297
             * gc_name : 绾稿肪
             * gc_image : http://ccclsc.com/data/upload/shop/common/category-pic-1297.jpg?v=1493109185
             */

            private int gc_id;
            private String gc_name;
            private String gc_image;

            public int getGc_id() {
                return gc_id;
            }

            public void setGc_id(int gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }

            public String getGc_image() {
                return gc_image;
            }

            public void setGc_image(String gc_image) {
                this.gc_image = gc_image;
            }
        }
    }
}

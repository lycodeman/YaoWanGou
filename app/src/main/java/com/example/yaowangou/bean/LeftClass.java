package com.example.yaowangou.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public class LeftClass {

    @Override
    public String toString() {
        return "LeftClass{" +
                "datas=" + datas +
                ", code=" + code +
                ", status=" + status +
                ", info='" + info + '\'' +
                '}';
    }

    /**
     * datas : {"datas":[{"gc_id":1299,"gc_name":"棋牌用品"},{"gc_id":1076,"gc_name":"茶叶饮品"},{"gc_id":1061,"gc_name":"茶厨用品"},{"gc_id":1388,"gc_name":"杯壶用品"},{"gc_id":1283,"gc_name":"茶艺家具"},{"gc_id":1088,"gc_name":"茶楼电器"},{"gc_id":1142,"gc_name":"户外用品"},{"gc_id":1298,"gc_name":"茶楼软装"},{"gc_id":1100,"gc_name":"定制商品"},{"gc_id":1085,"gc_name":"软装家具"},{"gc_id":1155,"gc_name":"茶楼硬装"},{"gc_id":1304,"gc_name":"酒水用品"},{"gc_id":1308,"gc_name":"智能产品"},{"gc_id":1315,"gc_name":"特色食品"}]}
     * code : 200
     * status : 200
     * info :
     */

    private DatasBeanX datas;
    private int code;
    private int status;
    private String info;

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
                        '}';
            }

            /**
             * gc_id : 1299
             * gc_name : 棋牌用品
             */

            private int gc_id;
            private String gc_name;

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
        }
    }
}

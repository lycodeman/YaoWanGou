package com.example.yaowangou.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public class Hot {


    /**
     * datas : {"datas":[{"goods_commonid":"101169","goods_name":"绿延新料加厚环保批发加厚特厚背带垃圾袋","goods_id":"105171","goods_image":"http://www.yaowangou.com/data/upload/shop/store/goods/1/1_05180058086886676_360.jpg","goods_salenum":"3","goods_price":"1.75","currency":"","common_currency":"","gc_id":"1318","yaowanbi":1},{"goods_commonid":"101768","goods_name":"纯棉毛巾白色小方巾酒店擦手巾","goods_id":"107168","goods_image":"http://www.yaowangou.com/data/upload/shop/store/goods/1/1_05283898264850894_360.jpg","goods_salenum":"0","goods_price":"2.50","currency":"","common_currency":"20","gc_id":"1407","yaowanbi":1},{"goods_commonid":"100779","goods_name":"金富鑫一次性可弯曲饮料塑料彩色艺术吸管","goods_id":"102722","goods_image":"http://www.yaowangou.com/data/upload/shop/store/goods/1/1_05186960262958783_360.jpg","goods_salenum":"123","goods_price":"2.50","currency":"","common_currency":"20","gc_id":"1296","yaowanbi":1},{"goods_commonid":"100820","goods_name":"亦菲高档亚克力纸巾盒餐桌抽纸巾架立式餐巾纸盒","goods_id":"102934","goods_image":"http://www.yaowangou.com/data/upload/shop/store/goods/1/1_05170550660952165_360.jpg","goods_salenum":"47","goods_price":"3.80","currency":"","common_currency":"20","gc_id":"1293","yaowanbi":1},{"goods_commonid":"101771","goods_name":"青苹果玻璃水杯带把茶杯啤酒杯","goods_id":"107311","goods_image":"http://www.yaowangou.com/data/upload/shop/store/goods/1/1_05309654610060425_360.jpg","goods_salenum":"0","goods_price":"4.50","currency":"","common_currency":"","gc_id":"1400","yaowanbi":0},{"goods_commonid":"101678","goods_name":"新金博保温水壶大容量热水瓶保温瓶保温水壶暖壶","goods_id":"106709","goods_image":"http://www.yaowangou.com/data/upload/shop/store/goods/1/1_05271006005064079_360.jpg","goods_salenum":"2","goods_price":"18.00","currency":"","common_currency":"10","gc_id":"1391","yaowanbi":2}]}
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
        return "Hot{" +
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
                        "goods_commonid='" + goods_commonid + '\'' +
                        ", goods_name='" + goods_name + '\'' +
                        ", goods_id='" + goods_id + '\'' +
                        ", goods_image='" + goods_image + '\'' +
                        ", goods_salenum='" + goods_salenum + '\'' +
                        ", goods_price='" + goods_price + '\'' +
                        ", currency='" + currency + '\'' +
                        ", common_currency='" + common_currency + '\'' +
                        ", gc_id='" + gc_id + '\'' +
                        ", yaowanbi=" + yaowanbi +
                        '}';
            }

            /**
             * goods_commonid : 101169
             * goods_name : 绿延新料加厚环保批发加厚特厚背带垃圾袋
             * goods_id : 105171
             * goods_image : http://www.yaowangou.com/data/upload/shop/store/goods/1/1_05180058086886676_360.jpg
             * goods_salenum : 3
             * goods_price : 1.75
             * currency :
             * common_currency :
             * gc_id : 1318
             * yaowanbi : 1
             */

            private String goods_commonid;
            private String goods_name;
            private String goods_id;
            private String goods_image;
            private String goods_salenum;
            private String goods_price;
            private String currency;
            private String common_currency;
            private String gc_id;
            private int yaowanbi;

            public String getGoods_commonid() {
                return goods_commonid;
            }

            public void setGoods_commonid(String goods_commonid) {
                this.goods_commonid = goods_commonid;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(String goods_salenum) {
                this.goods_salenum = goods_salenum;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getCommon_currency() {
                return common_currency;
            }

            public void setCommon_currency(String common_currency) {
                this.common_currency = common_currency;
            }

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public int getYaowanbi() {
                return yaowanbi;
            }

            public void setYaowanbi(int yaowanbi) {
                this.yaowanbi = yaowanbi;
            }
        }
    }
}

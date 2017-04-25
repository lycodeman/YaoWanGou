package com.example.yaowangou.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public class Banner {


    /**
     * datas : {"datas":[{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/ea52f4870b5382f82600.jpg","type_value":"1300"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/6d344687b5173fab3821.jpg","type_value":"1297"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/c3b24b6d0cb3ece73542.jpg","type_value":"1380"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/ec15c279547ffdfe9633.jpg","type_value":"1318"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/cbe5094dd9a8c5a87374.jpg","type_value":"1400"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/51db840c07facc692855.jpg","type_value":"1391"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/63f9da30d67171cf4556.jpg","type_value":"1301"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/7966df7af854e3148357.jpg","type_value":"1302"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/04abc40f6c4725f19728.jpg","type_value":"1077"},{"type":"category","image":"http://www.yaowangou.com/data/upload/shop/rec_position/8d9b505c74d4ea2b8209.jpg","type_value":"1166"}]}
     * code : 200
     * status : 200
     * info :
     */

    private DatasBeanX datas;
    private String code;
    private String status;
    private String info;

    @Override
    public String toString() {
        return "Banner{" +
                "datas=" + datas +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

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
                        "type='" + type + '\'' +
                        ", image='" + image + '\'' +
                        ", type_value='" + type_value + '\'' +
                        '}';
            }

            /**
             * type : category
             * image : http://www.yaowangou.com/data/upload/shop/rec_position/ea52f4870b5382f82600.jpg
             * type_value : 1300
             */

            private String type;
            private String image;
            private String type_value;

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

            public String getType_value() {
                return type_value;
            }

            public void setType_value(String type_value) {
                this.type_value = type_value;
            }
        }
    }
}

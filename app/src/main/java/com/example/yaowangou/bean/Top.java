package com.example.yaowangou.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public class Top {

    /**
     * datas : {"datas":[{"title":"App首页广告位","url":"1380","type":"url","image":"http://www.yaowangou.com/data/upload/shop/rec_position/8d22d662376207274640.jpg","images":"http://www.yaowangou.com/data/upload/shop/rec_position/8d22d662376207274640.jpg","type_value":"1380","mark":"顶部banner","width":"320","height":"130"},{"title":"App首页广告位","url":"","type":"goods","image":"http://www.yaowangou.com/data/upload/shop/rec_position/6fbf04e8b22bab0a6771.jpg","images":"http://www.yaowangou.com/data/upload/shop/rec_position/6fbf04e8b22bab0a6771.jpg","type_value":"","mark":"顶部banner","width":"320","height":"130"},{"title":"App首页广告位","url":"","type":"goods","image":"http://www.yaowangou.com/data/upload/shop/rec_position/89a267762cdb15e63002.jpg","images":"http://www.yaowangou.com/data/upload/shop/rec_position/89a267762cdb15e63002.jpg","type_value":"","mark":"顶部banner","width":"320","height":"130"}]}
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
        return "Top{" +
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
                        "title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", type='" + type + '\'' +
                        ", image='" + image + '\'' +
                        ", images='" + images + '\'' +
                        ", type_value='" + type_value + '\'' +
                        ", mark='" + mark + '\'' +
                        ", width='" + width + '\'' +
                        ", height='" + height + '\'' +
                        '}';
            }

            /**
             * title : App首页广告位
             * url : 1380
             * type : url
             * image : http://www.yaowangou.com/data/upload/shop/rec_position/8d22d662376207274640.jpg
             * images : http://www.yaowangou.com/data/upload/shop/rec_position/8d22d662376207274640.jpg
             * type_value : 1380
             * mark : 顶部banner
             * width : 320
             * height : 130
             */

            private String title;
            private String url;
            private String type;
            private String image;
            private String images;
            private String type_value;
            private String mark;
            private String width;
            private String height;

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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getType_value() {
                return type_value;
            }

            public void setType_value(String type_value) {
                this.type_value = type_value;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }
        }
    }
}

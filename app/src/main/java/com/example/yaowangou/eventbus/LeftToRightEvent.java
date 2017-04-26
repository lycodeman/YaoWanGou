package com.example.yaowangou.eventbus;

import com.example.yaowangou.bean.LeftClass;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public class LeftToRightEvent {

    public LeftClass.DatasBeanX.DatasBean datasBean;

    public LeftToRightEvent(LeftClass.DatasBeanX.DatasBean datasBean) {
        this.datasBean = datasBean;
    }

    public LeftClass.DatasBeanX.DatasBean getDatasBean() {
        return datasBean;
    }

    public void setDatasBean(LeftClass.DatasBeanX.DatasBean datasBean) {
        this.datasBean = datasBean;
    }
}

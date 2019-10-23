package com.example.popwidget;

public class ResPopItem extends BaseSelect{

    private String title;
    private int type;

    public ResPopItem(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public ResPopItem(String title, int type , boolean select){
        this.title = title;
        this.type = type;
        setSelect(select);
    }

    public ResPopItem(String title, int type, boolean enable, boolean select) {
        this.title = title;
        this.type = type;
        setSelect(select);
        setEnable(enable);
    }

    public ResPopItem(String title, int type, boolean enable, boolean select, boolean special) {
        this.title = title;
        this.type = type;
        setSelect(select);
        setEnable(enable);
        setSpecial(special);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    String toSetName() {
        return getTitle();
    }

    @Override
    String toSetCode() {
        return String.valueOf(getType());
    }
}

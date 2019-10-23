package com.example.popwidget;

public abstract class BaseSelect {

    private boolean enable = false;
    private boolean select = false;
    private boolean special = false;

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getName() {
        return toSetName();
    }

    public String getCode() {
        return toSetCode();
    }

    abstract String toSetName();
    abstract String toSetCode();
}

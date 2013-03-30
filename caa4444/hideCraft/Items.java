package caa4444.hideCraft;

public enum Items {
    GLOVES(29, "Gloves"),
    BOOTS(33, "Boots"),
    BODY(37, "Bodies"),
    SHIELD(41, "Shields");

    private final int WIDGET_ID;
    private final String ITEM_NAME;

    Items(int wid, String name) {
        this.WIDGET_ID = wid;
        this.ITEM_NAME = name;
    }

    public int getWIDGET_ID() {
        return WIDGET_ID;
    }

    public String getITEM_NAME() {
        return ITEM_NAME;
    }
}

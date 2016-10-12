package com.gettyimages.searchimages;

/**
 * Created by jsantos on 9/29/16.
 */
public enum AssetFamily {

    CREATIVE("creative"),
    EDITORIAL("editorial"),
    BLENDED("blended");

    private String assetFamily;

    AssetFamily(String assetFamily) {

        this.assetFamily = assetFamily;
    }
    public String getAssetFamily() {
        return assetFamily;
    }

    @Override
    public String toString() {
        return assetFamily;
    }
}

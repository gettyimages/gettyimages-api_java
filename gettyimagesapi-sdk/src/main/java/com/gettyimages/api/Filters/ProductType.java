package com.gettyimages.api.Filters;

public enum ProductType {
    EASYACCESS("easyaccess"),
    EDITORIALSUBSCRIPTION("editorialsubscription"),
    IMAGEPACK("imagepack"),
    PREMIUMACCESS("premiumaccess"),
    ROYALTYFREESUBSCRIPTION("royaltyfreesubscription"),
    CREDITPACK("creditpack");

    private String productType;

    ProductType(String productType) {

        this.productType = productType;
    }

    @Override
    public String toString() {
        return productType;
    }
}

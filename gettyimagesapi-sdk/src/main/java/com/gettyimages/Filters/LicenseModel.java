package com.gettyimages.Filters;

public enum LicenseModel
{
    NONE("none"),
    RIGHTS_MANAGED("rights_managed"),
    ROYALTY_FREE("royalty_free");

    /**
     * Used for query parameter naming during the REST call.
     */
    private String val;

    LicenseModel(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}

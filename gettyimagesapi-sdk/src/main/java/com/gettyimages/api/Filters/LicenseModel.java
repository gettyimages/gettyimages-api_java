package com.gettyimages.api.Filters;

public enum LicenseModel
{
    NONE("none"),
    RIGHTS_MANAGED("rightsmanaged"),
    ROYALTY_FREE("royaltyfree");

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

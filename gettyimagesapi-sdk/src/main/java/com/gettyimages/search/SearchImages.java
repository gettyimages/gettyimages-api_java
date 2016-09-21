package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class SearchImages extends BaseSearchImages implements IBlendedImagesSearch {

    private SearchImages(Credentials credentials, String baseUrl) {
        super(credentials, baseUrl, new Hashtable());
    }

    public static SearchImages GetInstance(Credentials credentials, String baseUrl) {
        return new SearchImages(credentials, baseUrl);
    }

    @Override
    public String ExecuteAsync() throws SdkException {
        return super.executeAsync();
    }

    @Override
    public IBlendedImagesSearch WithPage(int val) {
        super.withPage(val);
        return this;
    }

    @Override
    public IBlendedImagesSearch WithPageSize(int val) {
        super.withPageSize(val);
        return this;
    }

    @Override
    public IBlendedImagesSearch WithPhrase(String val) {
        super.withPhrase(val);
        return this;
    }

    @Override
    public IBlendedImagesSearch WithSortOrder(String val) {
        super.withSortOrder(val);
        return this;
    }

    @Override
    public IBlendedImagesSearch WithEmbedContentOnly(boolean val) {
        super.withEmbedContentOnly(val);
        return this;
    }

    @Override
    public IBlendedImagesSearch WithExcludeNudity(boolean val) {
        super.withExcludeNudity(val);
        return this;
    }

    @Override
    public IBlendedImagesSearch WithResponseField(String val) {
        super.withResponseField(val);
        return this;
    }

    @Override
    public IBlendedImagesSearch WithGraphicalStyle(GraphicalStyles val) {
        super.withGraphicalStyle(val);
        return this;
    }

    @Override
    public IBlendedImagesSearch WithOrientation(Orientation val) {
        super.withOrientation(val);
        return this;
    }

    public IBlendedImagesSearch WithLicenseModel(LicenseModel val) {
        super.withLicenseModel(val);
        return this;
    }

    public ICreativeImagesSearch Creative() {
        super.creative();
        return new CreativeSearchImages(credentials, baseUrl, map);
    }

    public IEditorialImagesSearch Editorial() {
        super.editorial();
        return new EditorialSearchImages(credentials, baseUrl, map);
    }
}

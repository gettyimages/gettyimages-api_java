package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;

import java.util.Map;

public class CreativeSearchImages extends BaseSearchImages implements ICreativeImagesSearch {
    public CreativeSearchImages(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    @Override
    public String ExecuteAsync() throws SdkException {
        return super.executeAsync();
    }

    @Override
    public ICreativeImagesSearch WithPage(int val) {
        super.withPage(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithPageSize(int val) {
        super.withPageSize(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithPhrase(String val) {
        super.withPhrase(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithSortOrder(String val) {
        super.withSortOrder(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithEmbedContentOnly(boolean val) {
        super.withEmbedContentOnly(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithExcludeNudity(boolean val) {
        super.withExcludeNudity(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithResponseField(String val) {
        super.withResponseField(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithGraphicalStyle(GraphicalStyles val) {
        super.withGraphicalStyle(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithOrientation(Orientation val) {
        super.withOrientation(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch WithLicenseModel(LicenseModel val) {
        super.withLicenseModel(val);
        return this;
    }

    @Override
    public ICreativeImagesSearch Creative() {
        super.creative();
        return new CreativeSearchImages(credentials, baseUrl, map);
    }

    @Override
    public IEditorialImagesSearch Editorial() {
        super.editorial();
        return new EditorialSearchImages(credentials, baseUrl, map);
    }
}

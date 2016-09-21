package com.gettyimages.connectsdk.search;

import com.gettyimages.connectsdk.Credentials;
import com.gettyimages.connectsdk.SdkException;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class EditorialSearchImages extends BaseSearchImages implements IEditorialImagesSearch {

    public EditorialSearchImages(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    @Override
    public String ExecuteAsync() throws SdkException {
        return super.executeAsync();
    }

    @Override
    public IEditorialImagesSearch WithPage(int val) {
        super.withPage(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithPageSize(int val) {
        super.withPageSize(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithPhrase(String val) {
        super.withPhrase(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithSortOrder(String val) {
        super.withSortOrder(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithEmbedContentOnly(boolean val) {
        super.withEmbedContentOnly(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithExcludeNudity(boolean val) {
        super.withExcludeNudity(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithResponseField(String val) {
        super.withResponseField(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithGraphicalStyle(GraphicalStyles val) {
        super.withGraphicalStyle(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithOrientation(Orientation val) {
        super.withOrientation(val);
        return this;
    }

    @Override
    public IEditorialImagesSearch WithEditorialSegment(EditorialSegment seg) {
        super.withEditorialSegment(seg);
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

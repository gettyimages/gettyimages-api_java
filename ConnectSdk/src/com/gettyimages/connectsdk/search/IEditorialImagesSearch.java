package com.gettyimages.connectsdk.search;

import com.gettyimages.connectsdk.SdkException;

public interface IEditorialImagesSearch {
    String ExecuteAsync() throws SdkException;

    IEditorialImagesSearch WithPage(int val);

    IEditorialImagesSearch WithPageSize(int val);

    IEditorialImagesSearch WithPhrase(String val);

    IEditorialImagesSearch WithSortOrder(String val);

    IEditorialImagesSearch WithEmbedContentOnly(boolean val);

    IEditorialImagesSearch WithExcludeNudity(boolean val);

    IEditorialImagesSearch WithResponseField(String val);

    IEditorialImagesSearch WithGraphicalStyle(GraphicalStyles val);

    IEditorialImagesSearch WithOrientation(Orientation val);

    IEditorialImagesSearch WithEditorialSegment(EditorialSegment val);

    ICreativeImagesSearch Creative();

    IEditorialImagesSearch Editorial();
}

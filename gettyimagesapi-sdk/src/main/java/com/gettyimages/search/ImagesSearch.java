package com.gettyimages.search;

import com.gettyimages.SdkException;
import com.gettyimages.search.filters.*;

public interface ImagesSearch<T> {

    String executeAsync() throws SdkException;

    T withAgeOfPeople(AgeOfPeople ageOfPeople);

    T withArtists(String artists);

    T withCollectionCodes(String collectionCodes);

    T withCollectionsFilterType(boolean includeCollectionsFilterType);

    T withColor(String color);

    T withComposition(Compositions composition);

    T withEmbedContentOnly(boolean embedContentOnly);

    T withEthnicity(Ethnicity ethnicity);

    T withFileType(FileType fileTypes);

    T withNumberOfPeople(NumberOfPeople numberOfPeople);
}

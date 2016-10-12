package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.search.filters.*;

import java.util.EnumSet;
import java.util.Map;

public abstract class AbstractImagesSearch extends AbstractAssetSearch<AbstractImagesSearch> implements ImagesSearch<AbstractImagesSearch> {

    AbstractImagesSearch(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    @Override
    public AbstractImagesSearch withAgeOfPeople(AgeOfPeople ageOfPeople) {
        EnumSet<AgeOfPeople> ageOfPeoples;

        if (map.containsKey(AgeOfPeopleParameterName)) {
            ageOfPeoples = (EnumSet<AgeOfPeople>) map.get(AgeOfPeopleParameterName);
        } else {
            ageOfPeoples = EnumSet.noneOf(AgeOfPeople.class);
        }
        if (ageOfPeople != AgeOfPeople.NONE) {
            ageOfPeoples.add(ageOfPeople);
        }

        map.put(AgeOfPeopleParameterName, ageOfPeoples);
        return this;
    }

    @Override
    public AbstractImagesSearch withArtists(String artists) {
        map.put(ArtistParameterName, artists);
        return this;
    }

    @Override
    public AbstractImagesSearch withCollectionCodes(String collectionCodes) {
        map.put(CollectionCodesParameterName, collectionCodes);
        return this;
    }

    @Override
    public AbstractImagesSearch withCollectionsFilterType(boolean includeCollectionsFilterType) {
        String collectionsFilterType;
        if (includeCollectionsFilterType) {
            collectionsFilterType = "include";
        } else {
            collectionsFilterType = "exclude";
        }
        map.put(CollectionsFilterTypeParameterName, collectionsFilterType);
        return this;
    }

    @Override
    public AbstractImagesSearch withColor(String color) {
        map.put(ColorParameterName, color);
        return this;
    }

    @Override
    public AbstractImagesSearch withComposition(Compositions composition) {
        EnumSet<Compositions> compositions;
        if (map.containsKey(CompositionsParameterName)) {
            compositions = (EnumSet<Compositions>) map.get(CompositionsParameterName);
        } else {
            compositions = EnumSet.noneOf(Compositions.class);
        }
        if (composition != Compositions.NONE) {
            compositions.add(composition);
        }

        map.put(CompositionsParameterName, compositions);
        return this;
    }

    @Override
    public AbstractImagesSearch withEmbedContentOnly(boolean embedContentOnly) {
        map.put(EmbedContentOnlyParameterName, embedContentOnly);
        return this;
    }

    @Override
    public AbstractImagesSearch withEthnicity(Ethnicity ethnicity) {
        EnumSet<Ethnicity> ethnicities;

        if (map.containsKey(EthnicityParameterName)) {
            ethnicities = (EnumSet<Ethnicity>) map.get(AgeOfPeopleParameterName);
        } else {
            ethnicities = EnumSet.noneOf(Ethnicity.class);
        }

        ethnicities.add(ethnicity);

        map.put(EthnicityParameterName, ethnicities);
        return this;
    }

    @Override
    public AbstractImagesSearch withFileType(FileType fileType) {
        EnumSet<FileType> fileTypes;
        if (map.containsKey(FileTypeParameterName)) {
            fileTypes = (EnumSet<FileType>) map.get(FileTypeParameterName);
        } else {
            fileTypes = EnumSet.noneOf(FileType.class);
        }
        fileTypes.add(fileType);

        map.put(FileTypeParameterName, fileTypes);
        return this;
    }

    @Override
    public AbstractImagesSearch withNumberOfPeople(NumberOfPeople numberOfPeople) {
        EnumSet<NumberOfPeople> numberOfPeoples;
        if (map.containsKey(NumberOfPeopleParameterName)) {
            numberOfPeoples = (EnumSet<NumberOfPeople>) map.get(NumberOfPeopleParameterName);
        } else {
            numberOfPeoples = EnumSet.noneOf(NumberOfPeople.class);
        }
        numberOfPeoples.add(numberOfPeople);

        map.put(NumberOfPeopleParameterName, numberOfPeoples);
        return this;
    }
}

package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;
import com.gettyimages.StringHelper;
import com.gettyimages.WebHelper;
import com.gettyimages.search.filters.*;
import com.gettyimages.search.filters.Orientation;

import java.util.*;

public abstract class AbstractAssetSearch<T extends AssetSearch<T>> implements AssetSearch<T> {

    static final String GraphicalStylesString = "graphical_styles";
    static final String AgeOfPeopleParameterName = "age_of_people";
    static final String AssetTypeString = "asset_type";
    static final String CompositionsParameterName = "compositions";
    static final String EmbedContentOnlyParameterName = "embed_content_only";
    static final String ColorParameterName = "color";
    static final String EthnicityParameterName = "ethnicity";
    static final String ArtistParameterName = "artists";
    static final String CollectionCodesParameterName = "collection_codes";
    static final String CollectionsFilterTypeParameterName = "collections_filter_type";
    static final String EndDateParameterName = "date_to";
    static final String StartDateParameterName = "date_from";
    static final String FileTypeParameterName = "file_types";
    static final String NumberOfPeopleParameterName = "number_of_people";
    static final String PrestigeContentOnlyParameterName = "prestige_content_only";
    static final String SpecificPeopleParameterName = "specific_people";
    static final String EventIdsParameterName = "event_ids";
    static final String LicenseModelsParameterName = "license_models";
    private final String V3SearchImagesPath = "/search/images";
    private final String SpaceString = " ";
    private final String FieldsString = "fields";
    private final String EditorialSegmentsParameterName = "editorial_segments";
    private final String OrientationsParameterName = "orientations";
    private final String PageParameterName = "page";
    private final String PageSizeString = "page_size";
    private final String PhraseParameterName = "phrase";
    private final String SortOrderParameterName = "sort_order";
    private final String ExcludeNudityParameterName = "exclude_nudity";
    private final String KeywordIdsParameterName = "keyword_ids";
    private final String ProductTypeParameterName = "product_types";
    protected String baseUrl;
    protected Credentials credentials;
    protected Map map;

    public AbstractAssetSearch(Credentials credentials, String baseUrl, Map map) {
        this.credentials = credentials;
        this.baseUrl = baseUrl;
        this.map = map;
    }

    String executeAsync(Map<String, String> queryParams) throws SdkException {
        String path;

        String assetType = getAssetType();
        if (assetType == null || assetType.length() == 0) {
            path = V3SearchImagesPath;
        } else {
            path = V3SearchImagesPath + "/" + assetType;
        }

        if (queryParams == null) {
            queryParams = new Hashtable<>();
        }

        if (getResponseFields() != null) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (String item : getResponseFields()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(FieldsString, sb.toString());
        }
        if (!getEditorialSegments().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (EditorialSegment item : getEditorialSegments()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(EditorialSegmentsParameterName, sb.toString());
        }
        if (!getLicenseModels().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (LicenseModel item : getLicenseModels()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(LicenseModelsParameterName, sb.toString());
        }
        if (!getAgeOfPeople().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (AgeOfPeople item : getAgeOfPeople()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(AgeOfPeopleParameterName, sb.toString());
        }
        if (!getOrientations().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Orientation item : getOrientations()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(OrientationsParameterName, sb.toString());
        }
        if (!getEthnicity().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Ethnicity item : getEthnicity()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(EthnicityParameterName, sb.toString());
        }
        if (!getCompositions().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Compositions item : getCompositions()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(CompositionsParameterName, sb.toString());
        }
        if (!getFileTypes().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (FileType item : getFileTypes()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(FileTypeParameterName, sb.toString());
        }
        if (!getNumberOfPeople().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (NumberOfPeople item : getNumberOfPeople()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(NumberOfPeopleParameterName, sb.toString());
        }
        if (!getProductTypes().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (ProductType item : getProductTypes()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(ProductTypeParameterName, sb.toString());
        }
        if (getPage() > 0) {
            queryParams.put(PageParameterName, String.valueOf(getPage()));
        }
        if (getPageSize() > 0) {
            queryParams.put(PageSizeString, String.valueOf(getPageSize()));
        }

        setBooleanQueryParameter(EmbedContentOnlyParameterName, queryParams);
        setBooleanQueryParameter(ExcludeNudityParameterName, queryParams);
        setStringQueryParameter(PhraseParameterName, queryParams);
        setStringQueryParameter(SortOrderParameterName, queryParams);
        setStringQueryParameter(ArtistParameterName, queryParams);
        setStringQueryParameter(CollectionsFilterTypeParameterName, queryParams);
        setStringQueryParameter(ColorParameterName, queryParams);
        setStringQueryParameter(CollectionCodesParameterName, queryParams);
        setStringQueryParameter(KeywordIdsParameterName, queryParams);

        WebHelper helper = new WebHelper(credentials, baseUrl);
        return helper.Get(queryParams, path);
    }

    public T withExcludeNudity(boolean val) {
        map.put(ExcludeNudityParameterName, val);
        return (T) this;
    }

    public T withPage(int val) {
        map.put(PageParameterName, val);
        return (T) this;
    }

    public T withPageSize(int val) {
        map.put(PageSizeString, val);
        return (T) this;
    }

    public T withPhrase(String val) {
        map.put(PhraseParameterName, val);
        return (T) this;
    }

    public T withSortOrder(String val) {
        map.put(SortOrderParameterName, val);
        return (T) this;
    }

    public T withKeywordIds(String keywordIds) {
        map.put(KeywordIdsParameterName, keywordIds);
        return (T) this;
    }

    public T withResponseField(String val) {
        List<String> fields;

        if (map.containsKey(FieldsString)) {
            fields = (List<String>) map.get(FieldsString);
        } else {
            fields = new ArrayList<>();
        }
        fields.add(val);

        map.put(FieldsString, fields);
        return (T) this;
    }

    public void withOrientation(Orientation val) {
        EnumSet<Orientation> orientations;

        if (map.containsKey(OrientationsParameterName)) {
            orientations = (EnumSet<Orientation>) map.get(OrientationsParameterName);
        } else {
            orientations = EnumSet.noneOf(Orientation.class);
        }
        if (val != Orientation.NONE) {
            orientations.add(val);
        }

        map.put(OrientationsParameterName, orientations);
    }

    public T withEditorialSegment(EditorialSegment seg) {
        EnumSet<EditorialSegment> segments;
        if (map.containsKey(EditorialSegmentsParameterName)) {
            segments = (EnumSet<EditorialSegment>) map.get(EditorialSegmentsParameterName);
        } else {
            segments = EnumSet.noneOf(EditorialSegment.class);
        }
        if (seg != EditorialSegment.NONE) {
            segments.add(seg);
        }

        map.put(EditorialSegmentsParameterName, segments);
        return (T) this;
    }

    public T withProductType(ProductType productType) {
        EnumSet<ProductType> productTypes;

        if (map.containsKey(ProductTypeParameterName)) {
            productTypes = (EnumSet<ProductType>) map.get(ProductTypeParameterName);
        } else {
            productTypes = EnumSet.noneOf(ProductType.class);
        }
        productTypes.add(productType);
        map.put(ProductTypeParameterName, productTypes);
        return (T) this;
    }

    EnumSet<GraphicalStyles> getGraphicalStyles() {
        if (!map.containsKey(GraphicalStylesString)) {
            return EnumSet.noneOf(GraphicalStyles.class);
        }
        return (EnumSet<GraphicalStyles>) map.get(GraphicalStylesString);
    }

    void setBooleanQueryParameter(String queryParamName, Map<String, String> queryParams) {
        if (getBooleanValue(queryParamName)) {
            queryParams.put(queryParamName, String.valueOf(getBooleanValue(queryParamName)));
        }
    }

    void setStringQueryParameter(String queryParamName, Map<String, String> queryParams) {
        if (!StringHelper.isNullOrWhitespace(getString(queryParamName))) {
            queryParams.put(queryParamName, getString(queryParamName));
        }
    }

    private EnumSet<Ethnicity> getEthnicity() {
        if (!map.containsKey(EthnicityParameterName)) {
            return EnumSet.noneOf(Ethnicity.class);
        }
        return (EnumSet<Ethnicity>) map.get(EthnicityParameterName);
    }

    private EnumSet<EditorialSegment> getEditorialSegments() {
        if (!map.containsKey(EditorialSegmentsParameterName)) {
            return EnumSet.noneOf(EditorialSegment.class);
        }

        return (EnumSet<EditorialSegment>) map.get(EditorialSegmentsParameterName);
    }

    private EnumSet<LicenseModel> getLicenseModels() {
        if (!map.containsKey(LicenseModelsParameterName)) {
            return EnumSet.noneOf(LicenseModel.class);
        }

        return (EnumSet<LicenseModel>) map.get(LicenseModelsParameterName);
    }

    private EnumSet<AgeOfPeople> getAgeOfPeople() {
        if (!map.containsKey(AgeOfPeopleParameterName)) {
            return EnumSet.noneOf(AgeOfPeople.class);
        }

        return (EnumSet<AgeOfPeople>) map.get(AgeOfPeopleParameterName);
    }

    private EnumSet<Orientation> getOrientations() {
        if (!map.containsKey(OrientationsParameterName)) {
            return EnumSet.noneOf(Orientation.class);
        }

        return (EnumSet<Orientation>) map.get(OrientationsParameterName);
    }

    private String getString(String key) {
        if (!map.containsKey(key)) {
            return null;
        }

        return (String) map.get(key);
    }

    private int getInt(String key) {
        if (!map.containsKey(key)) {
            return 0;
        }

        return Integer.parseInt(map.get(key).toString());
    }

    private boolean getBooleanValue(String key) {
        if (!map.containsKey(key)) {
            return false;
        }

        Object obj = map.get(key);
        String str = obj.toString();
        return Boolean.parseBoolean(str);
    }

    private EnumSet<Compositions> getCompositions() {
        if (!map.containsKey(CompositionsParameterName)) {
            return EnumSet.noneOf(Compositions.class);
        }

        return (EnumSet<Compositions>) map.get(CompositionsParameterName);
    }

    private EnumSet<NumberOfPeople> getNumberOfPeople() {
        if (!map.containsKey(NumberOfPeopleParameterName)) {
            return EnumSet.noneOf(NumberOfPeople.class);
        }

        return (EnumSet<NumberOfPeople>) map.get(NumberOfPeopleParameterName);
    }

    private EnumSet<FileType> getFileTypes() {
        if (!map.containsKey(FileTypeParameterName)) {
            return EnumSet.noneOf(FileType.class);
        }

        return (EnumSet<FileType>) map.get(FileTypeParameterName);
    }

    private EnumSet<ProductType> getProductTypes() {
        if (!map.containsKey(ProductTypeParameterName)) {
            return EnumSet.noneOf(ProductType.class);
        }

        return (EnumSet<ProductType>) map.get(ProductTypeParameterName);
    }

    private String getAssetType() {
        return getString(AssetTypeString);
    }

    private int getPage() {
        return getInt(PageParameterName);
    }

    private int getPageSize() {
        return getInt(PageSizeString);
    }

    private List<String> getResponseFields() {
        if (!map.containsKey(FieldsString)) {
            return null;
        }

        return (List<String>) map.get(FieldsString);
    }
}

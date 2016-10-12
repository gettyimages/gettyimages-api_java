package com.gettyimages.searchimages;

import com.gettyimages.SdkException;
import com.gettyimages.SharedContext;
import com.gettyimages.search.BlendedImagesSearchService;
import com.gettyimages.search.CreativeImagesSearchService;
import com.gettyimages.search.EditorialImagesSearchService;
import com.gettyimages.search.AbstractImagesSearch;
import com.gettyimages.search.filters.EditorialGraphicalStyles;
import com.gettyimages.search.filters.GraphicalStyles;
import com.gettyimages.search.filters.LicenseModel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.fail;

/**
 * Context class for search images scenarios
 */
public class Context {

    private AbstractImagesSearch imagesSearch;
    private JSONObject searchResult;
    private long resultCount;
    private JSONArray resultImages;
    private AssetFamily imageFamily;
    private Context(){}

    private static class ContextHelper {
        private static final Context INSTANCE = new Context();
    }

    public static Context getInstance() {
        return ContextHelper.INSTANCE;
    }

    public void search() {
        try {
            String result = imagesSearch.executeAsync();
            setSearchResult(new JSONObject(result));
        } catch (SdkException e) {
            fail("search is supposed to successfully execute, but instead received: " + e.getLocalizedMessage());
        }
    }
    
    public void searchByPhrase(String phrase) {
        imagesSearch.withPhrase(phrase);
        search();
    }

    public void withLicenseModel(String modelStr) {
        LicenseModel model;
        switch(modelStr.toLowerCase()) {
            case "rightsmanaged" : {
                model = LicenseModel.RIGHTS_MANAGED;
                break;
            }
            case "royaltyfree" : {
                model = LicenseModel.ROYALTY_FREE;
                break;
            }
            default:
                model = LicenseModel.NONE;
                break;
        }
        switch (imageFamily) {
            case BLENDED:
                ((BlendedImagesSearchService)imagesSearch).withLicenseModel(model);
                break;
            case CREATIVE:
                ((CreativeImagesSearchService)imagesSearch).withLicenseModel(model);
                break;
        }
    }

    public void withCollectionFilterType(String filterType) {
        Boolean includeCollectionFilterType = null;
        switch(filterType.toLowerCase()) {
            case "exclude" : {
                includeCollectionFilterType = false;
                break;
            }
            case "include" : {
                includeCollectionFilterType = true;
                break;
            }
        }
        imagesSearch.withCollectionsFilterType(includeCollectionFilterType);
    }

    public void withEndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());

        switch (imageFamily) {
            case BLENDED:
                ((BlendedImagesSearchService) imagesSearch).withEndDate(date);
                break;
            case EDITORIAL:
                ((EditorialImagesSearchService) imagesSearch).withEndDate(date);
                break;
        }
    }

    void withStartDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DATE, -7);
        String date = sdf.format(cal.getTime());

        switch (imageFamily) {
            case BLENDED:
                ((BlendedImagesSearchService) imagesSearch).withStartDate(date);
                break;
            case EDITORIAL:
                ((EditorialImagesSearchService) imagesSearch).withStartDate(date);
                break;
        }
    }

    public AbstractImagesSearch getImagesSearch() {
        return imagesSearch;
    }

    public void setImagesSearch(String imageFamily) {
        this.imageFamily = AssetFamily.valueOf(imageFamily.toUpperCase());
        this.imagesSearch = createImageSearchController();
    }

    public JSONObject getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(JSONObject searchResult) {
        this.searchResult = searchResult;
    }

    public long getResultCount() {
        return resultCount;
    }

    public void setResultCount(long resultCount) {
        this.resultCount = resultCount;
    }

    public JSONArray getResultImages() {
        return resultImages;
    }

    public void setResultImages(JSONArray resultImages) {
        this.resultImages = resultImages;
    }

    private AbstractImagesSearch createImageSearchController() {
        switch (imageFamily) {
            case CREATIVE: {
                return SharedContext.GetApiClientWithResourceOwnerCredentials()
                        .search()
                        .images()
                        .creative();
            }
            case EDITORIAL: {
                return SharedContext.GetApiClientWithResourceOwnerCredentials()
                        .search()
                        .images()
                        .editorial();
            }
            case BLENDED: {
                return SharedContext.GetApiClientWithResourceOwnerCredentials()
                        .search()
                        .images();
            }
            default:
                throw new IllegalArgumentException("Invalid image family: " + imageFamily);
        }
    }

    public void searchWithGraphicalStyle(String style) {
        switch (imageFamily) {
            case BLENDED:
                ((BlendedImagesSearchService)imagesSearch).withGraphicalStyle(GraphicalStyles.valueOf(style.toUpperCase()));
                break;
            case CREATIVE:
                ((CreativeImagesSearchService)imagesSearch).withGraphicalStyle(GraphicalStyles.valueOf(style.toUpperCase()));
                break;
            case EDITORIAL:
                ((EditorialImagesSearchService)imagesSearch).withGraphicalStyle(EditorialGraphicalStyles.valueOf(style.toUpperCase()));
                break;
        }
    }

    public void withPrestigeContentOnly() {
        switch (imageFamily) {
            case BLENDED:
                ((BlendedImagesSearchService)imagesSearch).withPrestigeContentOnly(true);
                break;
            case CREATIVE:
                ((CreativeImagesSearchService)imagesSearch).withPrestigeContentOnly(true);
                break;
        }
    }

    public void withSpecificPeople() {
        switch (imageFamily) {
            case BLENDED:
                ((BlendedImagesSearchService)imagesSearch).withSpecificPeople("dog");
                break;
            case EDITORIAL:
                ((EditorialImagesSearchService)imagesSearch).withSpecificPeople("dog");
                break;
        }
    }

    public void withEventId() {
        switch (imageFamily) {
            case BLENDED:
                ((BlendedImagesSearchService)imagesSearch).withEventIds("488068931");
                break;
            case EDITORIAL:
                ((EditorialImagesSearchService)imagesSearch).withEventIds("488068931");
                break;
        }
    }

    public void withKeywordId() {
        imagesSearch.withKeywordIds("62361"); // keyword id for dog
    }
}

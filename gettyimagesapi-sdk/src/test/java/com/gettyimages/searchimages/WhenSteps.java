package com.gettyimages.searchimages;

import com.gettyimages.search.AbstractImagesSearch;
import com.gettyimages.search.filters.*;
import cucumber.api.java.en.When;

/**
 * When steps for image-search.feature
 */
public class WhenSteps {

    private Context context;

    public WhenSteps() {
        context = Context.getInstance();
    }

    @When("^I configure my search for (.*) images$")
    public void i_configure_my_search_for_an_image_family(String imageFamily) throws Throwable {
        context.setImagesSearch(imageFamily);
    }

    @When("^I specify that I only want to return (.*) with my search results$")
    public void i_specify_that_I_only_want_to_return_a_response_field_with_my_search_results(String responseField) throws Throwable {
        imagesSearch().withResponseField(responseField);
    }

    @When("^I specify (.*) editorial segment$")
    public void I_specify_an_editorial_segment(EditorialSegment segment) throws Throwable {
        imagesSearch().withEditorialSegment(segment);
    }

    @When("^I search for (.*)")
    public void i_search_for_a_phrase(String phrase) throws Throwable {
        context.searchByPhrase(phrase);
    }

    @When("^I specify a graphical (.*)$")
    public void I_specify_a_graphical_style(String style) throws Throwable {
        context.searchWithGraphicalStyle(style);
    }

    @When("^I specify I want only embeddable images$")
    public void I_specify_I_want_only_embeddable_images() throws Throwable {
        imagesSearch().withEmbedContentOnly(true);
    }

    @When("^I specify I want to exclude images containing nudity$")
    public void I_specify_I_want_to_exclude_images_containing_nudity() throws Throwable {
        imagesSearch().withExcludeNudity(true);
    }

    @When("^I specify a license model (.*)$")
    public void I_specify_a_license_model(String model) throws Throwable {
        context.withLicenseModel(model);
    }

    @When("^I specify an orientation (.*)$")
    public void I_specify_an_orientation_value(Orientation orientation) throws Throwable {
        imagesSearch().withOrientation(orientation);
    }

    @When("^I specify a (.*) age of people$")
    public void i_specify_age_of_people(String ageOfPeople) throws Throwable {
        imagesSearch().withAgeOfPeople(AgeOfPeople.convert(ageOfPeople));
    }

    @When("^I specify an artist$")
    public void i_specify_an_artist() throws Throwable {
        imagesSearch().withArtists("man");
    }

    @When("^I specify a collection code$")
    public void i_specify_a_collection_code() throws Throwable {
        imagesSearch().withCollectionCodes("arf");
    }

    @When("^I specify a (.*) collection code$")
    public void i_specify_a_collection_code(String collectionCode) throws Throwable {
        imagesSearch().withCollectionCodes(collectionCode);
    }

    @When("^I specify a (.*) collection filter type$")
    public void i_specify_a_collection_filter_type(String filterType) throws Throwable {
        context.withCollectionFilterType(filterType);
    }

    @When("^I specify a (.*) composition$")
    public void i_specify_a_composition(Compositions compositions) throws Throwable {
        imagesSearch().withComposition(compositions);
    }

    @When("^I specify an end date$")
    public void i_specify_an_end_date() throws Throwable {
        context.withEndDate();
    }

    @When("^I specify an start date$")
    public void i_specify_an_start_date() throws Throwable {
        context.withStartDate();
    }

    @When("^I specify an (.*) ethnicity$")
    public void i_specify_an_ethnicity(String ethnicity) throws Throwable {
        imagesSearch().withEthnicity(Ethnicity.valueOf(ethnicity.toUpperCase()));
    }

    @When("^I specify a (.*) file type$")
    public void i_specify_a_file_type(String fileType) throws Throwable {
        imagesSearch().withFileType(FileType.valueOf(fileType.toUpperCase()));
    }

    @When("^I specify a keyword id$")
    public void i_specify_a_keyword_id() throws Throwable {
        context.withKeywordId();
    }

    @When("^I search$")
    public void i_search() throws Throwable {
        context.search();
    }

    @When("^I specify a (.*) number of people in image$")
    public void i_specify_a_one_number_of_people_in_image(String numberOfPeople) throws Throwable {
        imagesSearch().withNumberOfPeople(NumberOfPeople.valueOf(numberOfPeople.toUpperCase()));
    }

    @When("^I specify a (.*) product type$")
    public void i_specify_a_product_type(String productType) throws Throwable {
        imagesSearch().withProductType(ProductType.valueOf(productType.toUpperCase()));
    }

    @When("^I specify I want only prestige images$")
    public void i_specify_I_want_only_prestige_images() throws Throwable {
        context.withPrestigeContentOnly();
    }

    @When("^I specify a specific person$")
    public void i_specify_a_specific_person() throws Throwable {
        context.withSpecificPeople();
    }

    @When("^I specify a event id$")
    public void i_specify_a_event_id() throws Throwable {
        context.withEventId();
    }
    private AbstractImagesSearch imagesSearch() {
        return context.getImagesSearch();
    }
}

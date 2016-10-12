package com.gettyimages.searchimages;

import cucumber.api.java.en.Then;
import org.json.JSONObject;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Then steps for image-search.feature
 */
public class ThenSteps {

    private Context context;

    public ThenSteps() {
        context = Context.getInstance();
    }

    @Then("^I get a response back that has my images$")
    public void i_get_a_response_back_that_has_my_images() throws Throwable {
        assertNotNull(searchResult());
        context.setResultCount(searchResult().getLong("result_count"));
        context.setResultImages(searchResult().getJSONArray("images"));
        assertNotNull("Expected response to include a result count", context.getResultCount());
        if(context.getResultCount() > 0) {
            assertTrue("Expected image count to b greater than zero", context.getResultImages().length() > 0);
        }
    }

    @Then("^only required return fields plus (.*) are returned$")
    public void only_required_return_fields_plus_response_field_are_returned(String responseField) throws Throwable {
        String responseFieldValue = context.getResultImages().getJSONObject(0).getString(responseField);
        assertTrue(responseFieldValue != null && responseFieldValue.length() > 0);
    }

    private JSONObject searchResult() {
        return context.getSearchResult();
    }
}

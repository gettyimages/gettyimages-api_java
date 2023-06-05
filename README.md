# Getty Images API Java SDK

## Introduction
This SDK makes using the Getty Images [API](http://developers.gettyimages.com) easy. It handles credential management, makes HTTP requests and is written with a fluent style in mind. For more info about the API, see the [Documentation](https://developers.gettyimages.com/api/).

* Search for images and videos from our extensive creative and editorial catalogs.
* Get image and video metadata.
* Download files using your Getty Images products (e.g., Editorial subscriptions, Easy Access, Thinkstock Subscriptions, and Image Packs).
* Custom Request functionality that allows user to call any endpoint.

## Help & Support

* [Getty Images API](http://developers.gettyimages.com/)
* [Issue Tracker](https://github.com/gettyimages/gettyimages-api_java/issues)

## Minimum Requirements

* You have Java JDK 8 or above installed.
* You have [Maven](https://maven.apache.org/) installed

## Getting Started

### Obtain an API Key

If you don't already have an API key, fill out and submit the [contact form](http://engage.gettyimages.com/api-contact) to be connected to our Sales team.

### Installing the package

The SDK is available on [maven central repository](https://search.maven.org/). 
Include the following dependency in your pom.xml file:
```sh
<dependency>
    <groupId>com.gettyimages</groupId>
    <artifactId>gettyimagesapi-sdk</artifactId>
    <version>X.X.X</version>
</dependency>
```

Install in your workspace with:
```sh
$ mvn install
```

## Examples

### Search creative images with phrase, age of people, and page

```java
String apiKey = "API Key";
String apiSecret = "API Secret";

ApiClient client = ApiClient.GetApiClientWithClientCredentials(apiKey, apiSecret);

try {
    SearchImagesCreative search = client.searchimagescreative()
            .withPhrase("cat")
            .withAgeOfPeople(EnumSet.of(AgeOfPeople.CHILD, AgeOfPeople.BABY,AgeOfPeople.ADULT))
            .withPage(3);
    String result = search.executeAsync();
    System.out.print(result);

} catch (SdkException e) {
    System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
    System.exit(-1);
}
```

### Search editorial videos with phrase, fields, format available, and exclude nudity

```java
String apiKey = "API Key";
String apiSecret = "API Secret";

ApiClient client = ApiClient.GetApiClientWithClientCredentials(apiKey, apiSecret);

try {
    SearchVideosEditorial search = client.searchvideoseditorial()
            .withPhrase("cat")
            .withResponseFields(Arrays.asList("allowed_use","caption"))
            .withFormatAvailable(FormatAvailable.HD)
            .withExcludeNudity(true);
    String result = search.executeAsync();
    System.out.print(result);

} catch (SdkException e) {
    System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
    System.exit(-1);
}
```

### Search creative images with phrase, custom parameter, and customer header
```java
String apiKey = "API Key";
String apiSecret = "API Secret";

ApiClient client = ApiClient.GetApiClientWithClientCredentials(apiKey, apiSecret);

try {
    SearchImagesCreative search = client.searchimagescreative()
            .withPhrase("cat")
            .withCustomParameter("safe_search", "true")
            .withCustomHeader("gi-country-code", "CAN");
    String result = search.executeAsync();
    System.out.print(result);

} catch (SdkException e) {
    System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
    System.exit(-1);
}
```

### Custom Request to search images with phrase, fields, and age of people

```java
String apiKey = "API Key";
String apiSecret = "API Secret";

ApiClient client = ApiClient.GetApiClientWithClientCredentials(apiKey, apiSecret);

 Map params = new HashMap();
 params.put("phrase", "cat");
 params.put("fields", Arrays.asList("artist", "id"));
 params.put("age_of_people", EnumSet.of(AgeOfPeople.NEWBORN,AgeOfPeople.BABY,AgeOfPeople.CHILD));

 try {
     CustomRequest search = client.customrequest()
             .withMethod("GET")
             .withRoute("/search/images")
             .withQueryParameters(params);
     String result = search.executeAsync();
     System.out.print(result);

 } catch (SdkException e) {
     System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
     System.exit(-1);
 }
```

For more examples, see unittests package.

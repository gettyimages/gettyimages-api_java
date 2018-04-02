# Getty Images API SDK

Seamlessly integrate Getty Images' expansive digital content, powerful search technology, and rich metadata into your publishing tools, products and services!

* Search for images and videos from our extensive creative and editorial catalogs.
* Get image and video metadata.
* Download files using your Getty Images products (e.g., Editorial subscriptions, Easy Access, Thinkstock Subscriptions, and Image Packs).
* Custom Request functionality that allows user to call any endpoint.

## Minimum Requirements

* You have Java JDK 8 or above installed.
* You have [IntelliJ IDEA](https://www.jetbrains.com/idea/) installed
* You have [Maven](https://maven.apache.org/) installed

## Import the SDK to your project via IntelliJ+Maven

Import the module into your project

```text
File | New | Module from Existing Sources...
Point to the *gettyimagesapi-sdk* folder
Select *Maven* via *Import module from external model* window
Click on Next, Next, then click Finish
```

## Examples

### Search creative images with phrase, age of people, and page

```java
        String apiKey = "API Key";
        String apiSecret = "API Secret";
        String userName = "Username";
        String userPassword = "Password";

        ApiClient client = ApiClient.GetApiClientWithResourceOwnerCredentials(apiKey, apiSecret, userName, userPassword);

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
        String userName = "Username";
        String userPassword = "Password";

        ApiClient client = ApiClient.GetApiClientWithResourceOwnerCredentials(apiKey, apiSecret, userName, userPassword);

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

### Custom Request to search images with phrase, fields, and age of people

```java
        String apiKey = "API Key";
        String apiSecret = "API Secret";
        String userName = "Username";
        String userPassword = "Password";

        ApiClient client = ApiClient.GetApiClientWithResourceOwnerCredentials(apiKey, apiSecret, userName, userPassword);

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

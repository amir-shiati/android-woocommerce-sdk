[![woocommerce android sdk](https://i.postimg.cc/g272TpwM/image-1.png "woocommerce android sdk")](https://i.postimg.cc/g272TpwM/image-1.png "woocommerce android sdk")

[![](https://jitpack.io/v/amir-shiati/android-woocommerce-sdk.svg)](https://jitpack.io/#amir-shiati/android-woocommerce-sdk)
# Implementation
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```bash
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```
Step 2. Add the dependency
```bash
  implementation 'com.github.amir-shiati:android-woocommerce-sdk:lastes_version'

```

# Usage
### Initialize WooSDK
```java
        WooSDK wooSDK = new WooSDK(
                context,
                "ck_key",
                "cs_key",
                "domain"
        );
```
### To get a list of products:
```java
        wooSDK.getProducts()
                .setPage(3)
                .setPerPage(25)
                .search("Hoodie")
                .setOrder(Order.ASC)
                .setOrderBy(OrderBy.SLUG)

                .addCallBack(new OnGetProductsFinished() {
                    @Override
                    public void onSuccess(ArrayList<Product> products) {
                        for (Product product : products)
                            Log.i(TAG, product.getName());
                    }

                    @Override
                    public void onFail(String message) {
                        Log.i(TAG, message);
                    }
                })

                .start();

    }
```

### To get a list of categories:
```java
        wooSDK.getCategories()
                .setPage(1)
                .setPerPage(100)
                .setExclude(new int[200])
                .setExclude(new int[]{201})
                .setParent(323)
                .setOrder(Order.DESC)
                .hideEmpty(true)
                .addGetCategoriesCallBack(new OnGetCategoriesFinished() {
                    @Override
                    public void onSuccess(ArrayList<Category> categories) {
                        for (Category category : categories)
                            Log.i(TAG, category.getName());
                    }

                    @Override
                    public void onFail(String message) {
                        Log.i(TAG, message);
                    }
                })
                .start();
```


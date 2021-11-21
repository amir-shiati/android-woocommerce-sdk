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
        ProductBuilder productBuilder = new ProductBuilder()
                .page(3)
                .perPage(25)
                .search("Hoodie")
                .orderSort(OrderSort.ASC)
                .orderBy(OrderBy.SLUG);

        wooSDK.getProducts(productBuilder, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<Product> products = (ArrayList<Product>) object;
                for (Product product : products)
                    Log.i(TAG, String.valueOf(product.getName()));
            }

            @Override
            public void onFail(String err) {
                Log.i(TAG, err);
            }
        });
```

### To get a list of orders:

```java
        ParamBuilder paramBuilder = new OrderBuilder()
                .page(1)
                .perPage(100)
                .orderBy(OrderBy.DATE)
                .include(new int[]{102})
                .exclude(new int[]{22});

        wooSDK.getOrders(paramBuilder, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<Order> orders = (ArrayList<Order>) object;
                for (Order order : orders)
                    Log.i(TAG, String.valueOf(order.getId()));
            }

            @Override
            public void onFail(String err) {
                Log.i(TAG, err);
            }
        });
```

### To get a list of categories:

```java
        CategoryBuilder categoryBuilder = new CategoryBuilder()
                .setPage(1)
                .setPerPage(100)
                .setExclude(new int[200])
                .setExclude(new int[]{201})
                .setParent(323)
                .setOrderSort(OrderSort.DESC)
                .hideEmpty(true);
        wooSDK.getCategories(categoryBuilder, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<Category> categories = (ArrayList<Category>) object;
                for (Category category : categories)
                    Log.i(TAG, String.valueOf(category.getName()));
            }

            @Override
            public void onFail(String err) {
                Log.i(TAG, err);
            }
        });
```
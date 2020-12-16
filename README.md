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
It's really simple:
```java
        WooSDK wooSDK = new WooSDK(
                this,
                "ck_key",
                "cs_key",
                "domain"
        );

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

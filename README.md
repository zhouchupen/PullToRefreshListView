# PullToRefreshListView
仿简书自带下拉刷新和分页加载功能的ListView

![](http://upload-images.jianshu.io/upload_images/2746415-c80e832c19c9380c.gif?imageMogr2/auto-orient/strip)

## Installing

Users of your library will need add the jitpack.io repository:

```gradle
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```

and:

```gradle
dependencies {
    compile 'com.github.zhouchupen:PullToRefreshListView:v1.0'
}
```

Note: do not add the jitpack.io repository under `buildscript` 

## Adding a sample app 

If you add a sample app to the same repo then your app needs to depend on the library. To do this in your app/build.gradle add a dependency in the form:

```gradle
dependencies {
    compile project(':library')
}
```

where 'library' is the name of your library module.

## Using

You may need this to use the listview.  Put this into your xml file:
```xml
<com.scnu.zhou.library.PullToRefreshListView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

</com.scnu.zhou.library.PullToRefreshListView>
```
And put this into your activity file:
```java
pullToRefreshListView.setOnPullToRefreshListener(new PullToRefreshListView.OnPullToRefreshListener() {
      @Override
      public void onRefresh() {

          // TODO something to refesh

          pullToRefreshListView.onRefreshCompleted();  // please use it when you finish refreshing.
      }

      @Override
      public void onLoadMore() {

          // TODO something to load more

          pullToRefreshListView.onLoadMoreCompleted();  // please use it when you finish loading.
          pullToRefreshListView.onLoadMoreAllCompleted();  // please use it when you finish all loading.
      }

      @Override
      public void onOutOfTime() {

          // TODO something to warning of being out of time
      }
});
```

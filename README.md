# MVVM demo with Retrofit 2, RxJava 2 and SharedPreference 

This project shows the basic structure of the MVVM architecture.
  
  Google developers doc :  https://developer.android.com/jetpack/docs/guide . https://proandroiddev.com/mvvm-architecture-viewmodel-and-livedata-part-1-604f50cda1 you can check out other blogs too.
 


# Project Structure

  
 1. Data :
    - Api : All API related stuffs are done here.
      - ApiHelper Interface : Helper interface for api calls
      - ApiService Interface : Interface declaring all the methods for the api call
      - AppApiHelper class : It implements ApiHelper . This is the api provider for Data manager class. Retrofit is initialized here.
    - Models : 
      - UserResponse class: Response class for the network call.
    - Prefs :
      - PreferencesHelper Interface : class implementing the PreferencesHelper. Shared Preferences is initialized here.
      - AppPreferencesHelper class : interface for shared Preferences.
    - AppDataManager  : DataManager class for the app .   It combines the api service and the shared preferences.
    - DataManagerHelper : Datamanager interface.
 2. Retrofit 
    -RetrofitClient : Retrofit is declared here. 
 3. Ui-main:
    -Adapter: RecyclerViewAdapter
    -MainActivity : Single activity of the app.
 4. ViewModel :   It is the class where all the business logic of the app is done. 
 
 
 
 # Libraries used : 
   
   - Butterknife : Android ButterKnife library is a view injection library that injects views into android activity / fragments using annotations. For example, @BindView annotation avoids using findViewById() method by automatically type casting the view element. https://github.com/JakeWharton/butterknife
   - ViewModel : The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
   Check out https://developer.android.com/topic/libraries/architecture/viewmodel
   - Retrofit 2 : Retrofit is a REST Client for Java and Android. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice.
   For more info check out https://square.github.io/retrofit/
   - RxJava 2 : RxJava is a library that lets you create applications in the reactive programming style. At its core, reactive programming provides a clean, efficient way of processing and reacting to streams of real-time data, including data with dynamic values.
   You don't need to deep dive into rxjava 2 . You can explore basic Rxjava by following this link https://code.tutsplus.com/tutorials/getting-started-with-rxjava-20-for-android--cms-28345
   - Shared Preferences : If you have a relatively small collection of key-values that you'd like to save, you should use the SharedPreferences APIs. A SharedPreferences object points to a file containing key-value pairs and provides simple methods to read and write them. Each SharedPreferences file is managed by the framework and can be private or shared.
   Check out https://developer.android.com/training/data-storage/shared-preferences
   
   

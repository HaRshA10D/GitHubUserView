### GitHub User Viewer
A android application to view github user profile and explore repos.

#### Dev environment
The repo uses gradle for dependencies, please add the following lines to include the libraries in `build.gradle` file in app folder.
* Android studio `3.1.4`
* Dagger `2.13`
```
implementation 'com.google.dagger:dagger:2.13'
annotationProcessor 'com.google.dagger:dagger-compiler:2.13'
kapt 'com.google.dagger:dagger-compiler:2.13'
```
* Retrofit `2.4.0`
```
implementation 'com.google.code.gson:gson:2.8.5'
implementation 'com.squareup.retrofit2:retrofit:2.4.0'
implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
implementation "com.squareup.retrofit2:adapter-rxjava2:2.4.0"
```
* RxJava `2.2.3`
```
implementation 'io.reactivex.rxjava2:rxjava:2.2.3'
```
* RxAndroid `2.1.0`
```
implementation 'io.reactivex.rxjava2:rxandroid:2.1.0'
```
* RxKotlin `2.2.0`
```
implementation 'io.reactivex.rxjava2:rxkotlin:2.2.0'
```

#### Install Instruction
```
$ ./gradlew installDebug
```

#### Author
D Harsha Vardhan | harsha.hd@go-jek.com